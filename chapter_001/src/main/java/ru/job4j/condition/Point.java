package ru.job4j.condition;

public class Point {
    public static double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow((x2-x1),2);
        double second = Math.pow((y2-y1),2);
        return Math.sqrt(first+second);
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        System.out.println("result (0,0) to (2,0): " + result);
        result = distance(0, 0, 3, 4);
        System.out.println("result (0,0) to (3,4): " + result);
        result = distance(1, 1, 5, 2);
        System.out.println("result (1,1) to (5,2): " + result);
        result = distance(2, 2, 4, 7);
        System.out.println("result (2,2) to (4,7): " + result);
        result = distance(0, 1, 6, 6);
        System.out.println("result (0,1) to (6,6): " + result);
        result = distance(-10, 1, 6, 6);
        System.out.println("result (-10,1) to (6,6): " + result);
        result = distance(-10, 1, -6, 6);
        System.out.println("result (-10,1) to (-6,6): " + result);
    }
}
