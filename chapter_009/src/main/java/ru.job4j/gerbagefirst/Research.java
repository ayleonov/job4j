package ru.job4j.gerbagefirst;

public class Research {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize2");
    }

    public static void main(String[] args) {
        Sizecalculate sc = new Sizecalculate();

        // "РУЧНОЙ" подсчет размера памяти на объект User1
        String field1 = "name1";
        String field2 = "surname1";
        int field3 = 25;
        String field4 = "Russia, Moscow, 111111, ul.KirpichnoyVyemki 8 - 16";
        int fieldMemory1 = sc.calculate(field1);
        int fieldMemory2 = sc.calculate(field2);
        int fieldMemory3 = 4;
        int fieldMemory4 = sc.calculate(field4);

        int headingObject = 16;
        //если употребить посимвольный подсчет размера занимаемой памяти объектом user1:
        int res = headingObject + fieldMemory1 + fieldMemory2 + fieldMemory3 + fieldMemory4;
        System.out.println("результат полуручного подсчета памяти объекта: " + res);
        // результат 260 b
        info();
        User user1 = new User(field1, field2, field3, field4);
        User user2 = new User(field1, field2, field3, field4);
        User user3 = new User(field1, field2, field3, field4);
        User user4 = new User(field1, field2, field3, field4);
        User user5 = new User(field1, field2, field3, field4);

        // System.out.println("====================");

        user1 = null;
        user2 = null;
        user3 = null;
        user4 = null;
        user5 = null;

        info();

    }

    public static void info() {
        int mb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        System.out.println("Used Memory:" + (rt.totalMemory() - rt.freeMemory()));
        System.out.println("Free Memory:" + (rt.freeMemory()));
        System.out.println("Total Memory:" + (rt.totalMemory()));
    }


}
