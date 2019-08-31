package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {

        if (finish == 2) {
            return 1;
        } else {
            int count = 1;
            for (int i = 3; i <= finish; i++) {
                int temp = 0;
                for (int j = 2; j < i; j++) {
                    if (i % j != 0) {
                        continue;
                    }
                    temp = 1;
                    break;
                }
                if (temp != 1) {
                    count++;
                }
            }
            return count;
        }
    }
}
