package ru.job4j.calculator.interact.view;

public class View {


    public int showScoreboard(int currentNumber) {
        System.out.println();
        System.out.println("Табло: " + currentNumber);
        System.out.println();
        return currentNumber;
    }

    public void showMenu() {
        System.out.println("   \"+\" (сложение)");
        System.out.println("   \"-\" (вычитание)");
        System.out.println("   \"*\" (умножение)");
        System.out.println("   \"/\" (деление)");
        System.out.println("   \"выход\" (выход из программы):");
    }

    public void print(String text) {
        System.out.println(text);
    }
}
