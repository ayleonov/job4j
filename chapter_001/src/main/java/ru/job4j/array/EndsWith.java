package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class EndsWith {
    /**
     * Проверяет, что слово заканчивается на заданный постфикс.
     *
     * @param word    проверяемое слово
     * @param postfix постфикс
     * @return true/false заканчивается ли слово заданным постфиксом
     */
    public boolean endsWith(String word, String postfix) {
        char[] pfx = postfix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i = 0; i < pfx.length; i++) {
            if (pfx[pfx.length - 1 - i] != wrd[wrd.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}