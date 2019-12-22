package ru.job4j.calculator.interact.view;

public class ViewEng extends View{
    @Override
    public void showMenu() {
        System.out.println("   \"+\" (сложение)                         \"-\"  (вычитание)\"");
        System.out.println("   \"*\"  (умножение)                       \"/\"  (деление)\"");
        System.out.println("   \"sin\" (sin(X), X-угол в градусах)      \"cos\" (cos(X))\"");
        System.out.println("   \"sq\" (квадратный корень)               \"cb\" (кубич.корень)\"");
        System.out.println("                \"выход\" (выход из программы):");
    }
}
