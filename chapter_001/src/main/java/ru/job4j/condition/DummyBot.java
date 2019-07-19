package ru.job4j.condition;

/**
 * @author Aleksey Leonov (allesh002@mail.ru)
 * @version $Id$
 * @since  0.1
 */
public class DummyBot {
    /**
     *  Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer (String question){
    String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
    if (question.equals("Привет, Бот.")){
    rsl = "Привет, умник.";
    }   else if (question.equals("Пока.")){
        rsl = "До скорой встречи.";
    }
    return rsl;
}
}
