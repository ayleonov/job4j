package ru.job4j.calculator;

public class Fit {
    public static  double manWeight(double height){
        return (height - 100)*1.15;
    }

    public static  double womanWeight(double height){
        return (height - 110)*1.15;
    }

    public static void main(String[] args) {
        double man = manWeight(190);
        System.out.println("The perfect weight of man (with height : 190 sm) is: " + man + " kg");
        double woman = womanWeight(170);
        System.out.println("The perfect weight of woman (with height : 170 sm) is: " + woman + " kg");

    }
}
