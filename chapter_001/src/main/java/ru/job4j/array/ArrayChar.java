package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    /**
     * Проверяет, что слово начинается с префикс.
     *
     * @param word   проверяемое слово
     * @param prefix префикс
     * @return true/false начинается ли слово с префикса
     */
    public boolean startsWith(String word, String prefix) {
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i = 0; i < pref.length; i++) {
            if (pref[i] != wrd[i]) {
                return false;
            }
        }
        return true;
    }
}
