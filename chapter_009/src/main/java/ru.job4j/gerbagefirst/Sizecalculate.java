package ru.job4j.gerbagefirst;

public class Sizecalculate {

    public int calculate(String field) {
/**
 partFirst (variable, not dependence of fields size)
 */
    int headingObject = 16;
        /**
         * fields of string Class (3 fields * 4 bytes (type int))
         */
        int fieldOfString = 12;

        int referenceArrayChars = 4;

        int partFirst = 32;
/**
 *  heading - heading of char array in string field (8 + 4).
 *  nchars  - length of char array (length of string).
 *  memorychars  - memory of chars (as parts of string).
 *  res - varying part of calculating string's memory.
 */
        int heading = 12;
        int nchars = field.length();
        int memorychars = 2 * nchars;
        int varyable = heading + memorychars;
        while (varyable % 8 != 0){
            varyable++;
        }
            return partFirst + varyable;
    }

    public static void main(String[] args) {
        // длина 60-символьной строки = 168
        System.out.println(new Sizecalculate().calculate("111111111122222222223333333333444444444455555555556666666666"));
        // длина 1-символьной строки = 48
        System.out.println(new Sizecalculate().calculate("a"));
        // длина 2-символьной строки = 48
        System.out.println(new Sizecalculate().calculate("aa"));
    }
}
