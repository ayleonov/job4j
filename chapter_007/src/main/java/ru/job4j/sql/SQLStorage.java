package ru.job4j.sql;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;


public class SQLStorage {
    private static final Logger log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/work3";
        String user = "postgres";
        String password = "password";
        String sql = "select*from product";

         Connection conn = null;
         PreparedStatement stat = null;
         ResultSet rs = null;

            try {
                conn = DriverManager.getConnection(url, user, password);
                stat = conn.prepareStatement("update product set price = ? where id = ? ");
                stat.setInt(1,60);
                stat.setInt(2,34);
                stat.executeUpdate();
                lookDatabase(conn);

            } catch (SQLException e) {
                e.printStackTrace();
            }

       // добавление данных с получение данных о внесенном продукте
        /*Connection conn = null;
        PreparedStatement stat= null;
        ResultSet keys = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stat = conn.prepareStatement("insert into product (name, type_id, expired_date, quantity) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stat.setString(1, "мороженое Лакомка");
            stat.setInt(2, 6);
            DateFormat df = new SimpleDateFormat("yyyy:MM:dd");
            Timestamp ts = new Timestamp(df.parse("2020:05:01").getTime());
            stat.setTimestamp(3, ts);
            stat.setInt(4, 10);
            stat.executeUpdate();
            keys = stat.getGeneratedKeys();
            if (keys.next()) {
                System.out.println(keys.getInt(1));
            }

            lookDatabase(conn);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

*/
        // delete
        /*
        Connection conn;

        try {
            conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement("delete from product where (product.name = ?)");
            ps.setString(1, "мороженое лакомка");
            int deletedName = ps.executeUpdate();
            System.out.println(deletedName);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                System.out.println(String.format("%s %s", rs.getString("name"),rs.getInt("type_id") ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


         */
        // ИЗМЕНЕНИЕ ДАННЫХ
      /*
        Connection conn;

        try {
            conn = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = conn.prepareStatement("insert into product (name,type_id,expired_date, quantity) values (?,?,?,?)");
            preparedStatement.setString(1,"мороженое лакомка");
            preparedStatement.setInt(2,6);
            preparedStatement.setTimestamp(3,null);
            preparedStatement.setInt(4,35);
            preparedStatement.executeUpdate();

            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(String.format("%s %s", resultSet.getString("name"), resultSet.getInt("type_id")));
            }
            resultSet.close();
            st.close();
            ResultSet resultSet2 = preparedStatement.getGeneratedKeys() ;
            if (resultSet2.next()){
                System.out.println(String.format("результат: %d",resultSet2.getInt(1)));
            }


        }   catch (Exception e ){
            e.printStackTrace();
        }



    }

*/


        // ВЫБОР 2
        /*Connection conn;

        try {
            conn = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from product as p where p.id in(?,?,?)");
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2,2);
            preparedStatement.setInt(3,3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(String.format("%s %s", resultSet.getString("name"), resultSet.getString("expired_date")));
            }
            //conn.close();
            //preparedStatement.close();
            //resultSet.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


*/

//    ВЫБОР
        /*
            Connection conn = null;

            try {

                conn = DriverManager.getConnection(url, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    System.out.println(String.format("%s,%s", resultSet.getString("name"), resultSet.getString("expired_date")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

*/


/*

                      try {
                          conn.close();
                      } catch (SQLException e) {
                          e.printStackTrace();
                          //log.error(e.getMessage(),e);
                      }
                  }

              }

*/

finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs !=null)
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void lookDatabase(Connection conn) {
        String sql = "select*from product";
        ResultSet rs = null;
        try {
            rs = conn.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(String.format("%d %s %s", rs.getInt("id"), rs.getString("name"), rs.getInt("type_id")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
