package ru.job4j.condition;

public class Triangle {

    /**
     * Метод вычисления полупериметра по длине сторон.
     *
     * Формула.
     *
     * (a + b + c) / 2
     * @param a расстояние между точками a и b
     * @param b расстояние между точками a и b
     * @param c расстояние между точками a и b
     * @return полупериметр.
     */
    public double period(double a, double b, double c){

        return (a + b + c)/2;
    }

    /**
     * Метод проверки возможности существования
     * треугольника с заданными длинами сторон.
     *
     *
     * @param a расстояние между точками a и b
     * @param b расстояние между точками a и b
     * @param c расстояние между точками a и b
     * @return   может существовать/ не может
     */
    public boolean exist(double a, double b, double c){
        return (((a+b)>c)&&((a+c)>b)&&((c+b)>a))?true:false;
    }

    /**
     * Метод вычисляет площадь треугольника.
     * Формула.
     *   _________________________
     * V p * (p-a) * (p-b) * (p-c)
     *
     * @return площадь если треугольник существует или -1.
     *
     */
    public double area(int x1, int y1, int x2, int y2, int x3, int y3){
        double a = new Point().distance(x1,y1 ,x2 ,y2 );
        double b = new Point().distance(x1,y1 ,x3 ,y3 );
        double c = new Point().distance(x2,y2 ,x3 ,y3 );

        if (this.exist(a,b ,c )){
        double poluperimetr = period(a, b, c);
        double underSqrt = poluperimetr*(poluperimetr-a)*(poluperimetr-b)*(poluperimetr-c);
        return Math.sqrt(underSqrt);
        }   else
        return -1;
    }




}
