package ru.job4j.array;

public class Turn {
    // общий случай для четного и нечетного числа элементов
    public int[] back(int[] array){
        int temp;
        for (int i=0;(array.length-i-i>1);i++){
            temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
        return array;
    }

    // вариант для нечетного числа элементов массива
    public int[] backEven(int[] array){
        int temp;
        for (int i=0;(array.length-i-i>1);i++){
            temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
        return array;
    }

    // вариант для четного числа элементов массива
    public int[] backOdd(int[] array){
        int temp;
        for (int i=0;(array.length-i-i>0);i++){
            temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
        return array;
    }

}
