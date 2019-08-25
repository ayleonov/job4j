package ru.job4j.exam;

public class Cofemachine {
    public int[] changes(int value, int price) {
        int[] deltacoins = new int[10];
        int[] result;
        int position = 0;
        int deltatotal = value - price;
        int[] coins = {1, 2, 5, 10};
        int indexcoins = coins.length - 1;

        while (deltatotal > 0) {
            if (deltatotal >= coins[indexcoins]) {
                deltacoins[position] = coins[indexcoins];
                if (deltatotal > coins[indexcoins]) {
                    deltatotal -= coins[indexcoins];
                } else {
                    deltatotal = 0;
                }
            }
            if (deltatotal <= coins[indexcoins]) {
                indexcoins--;
            }
            position++;
        }

        result = new int[position];
        System.arraycopy(deltacoins, 0, result, 0, position);

        return result;
    }

    public static void main(String[] args) {

        int[] output = new Cofemachine().changes(70, 35);
        for (int i : output) {
            System.out.println(i);
        }
    }
}
