package ru.job4j.sql;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Properties;


public class SQLStorage {
    private static final Logger log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/work3";
        String user = "postgres";
        String password = "password";
        Connection conn = null;
              try{
                conn = DriverManager.getConnection(url, user, password);
                  Statement statement = conn.createStatement();
                 // ResultSet rs = statement.executeQuery("Select product.name, type.name from product inner join type on type_id = type.id");
                 // ResultSet rs = statement.executeQuery("Select p.name, t.name from product as p inner join type as t on type_id = t.id");
                  ResultSet rs = statement.executeQuery("Select name, expired_date  from product");
                 // --SELECT p.name, t.name, p.quantity FROM product as p
                  //--INNER JOIN type as t on t.id = type_id ;

                  while (rs.next()){
                      System.out.println(String.format("%s %s", rs.getString("name"), rs.getString("expired_date")));
                      //System.out.println(String.format("%s %s", rs.getString("p.name"), rs.getString("t.name")));
                    //  System.out.println(String.format("%s %s", rs.getString("name"), rs.getString("type_id")));
                  }
                rs.close();
                  statement.close();
        }   catch (Exception e) {
                  e.printStackTrace();
                  //log.error(e.getMessage(),e);
        }   finally {

                  if (conn !=null) {
                      try {
                          conn.close();
                      } catch (SQLException e) {
                          e.printStackTrace();
                          //log.error(e.getMessage(),e);
                      }
                  }

              }






        Properties props = new Properties();
        props.setProperty("user","fred");
        props.setProperty("password","secret");
        props.setProperty("ssl","true");


        //String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
        //Connection conn = DriverManager.getConnection(url);
    }
}
