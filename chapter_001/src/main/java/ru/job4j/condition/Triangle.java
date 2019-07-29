package ru.job4j.condition;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;


    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * Метод вычисления полупериметра по длине сторон.
     * <p>
     * Формула.
     * <p>
     * (ab + bc + ca) / 2
     *
     * @param ab расстояние между точками a и b
     * @param bc расстояние между точками b и c
     * @param ca расстояние между точками c и a
     * @return полупериметр.
     */
    public double period(double ab, double bc, double ca) {
        return (ab + bc + ca) / 2;
    }

    /**
     * Метод проверки возможности существования
     * треугольника с заданными длинами сторон.
     *
     * @param ab расстояние между точками a и b
     * @param bc расстояние между точками b и c
     * @param ca расстояние между точками c и a
     * @return может существовать/ не может
     */
    public boolean exist(double ab, double bc, double ca) {
        return ((ab + bc) > ca) && ((ab + ca) > bc) && ((ca + bc) > ab);
    }

    /**
     * Метод вычисляет площадь треугольника.
     * Формула.
     * _________________________
     * V p * (p-a) * (p-b) * (p-c)
     *
     * @return площадь если треугольник существует или -1.
     */
    public double area() {
        double a = first.distance(second);
        double b = second.distance(third);
        double c = third.distance(first);

        if (this.exist(a, b, c)) {
            double poluperimetr = period(a, b, c);
            double podkorennoe = poluperimetr * (poluperimetr - a) * (poluperimetr - b) * (poluperimetr - c);
            return Math.sqrt(podkorennoe);
        } else
            return -1;
    }

}
