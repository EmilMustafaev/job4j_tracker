package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка
 *
 * @author Emil Mustafaev
 * @version 1.0
 */
public class User {
    /**
     * Поле типа String содержит в себе информацию
     * о номере паспорта пользователя
     */
    private String passport;
    /**
     * Поле типа String хранит в себе ФИО пользователя
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает номер паспорта пользователя
     *
     * @return значения поля passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет изменить номер паспорта пользователя
     *
     * @param passport новый номер паспорта который мы хотим задать
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить ФИО пользователя
     *
     * @return значение поля username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет изменить ФИО пользователя
     *
     * @param username ФИО пользователя которое мы хотим задать
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод проверяет, является ли текущий пользователь равным другому .
     * Сначала проверяется, являются ли оба объекта одинаковыми ссылками.
     * Затем проверяется, что объект не равен null и что они относятся к одному и тому же классу.
     * В конце сравниваются значения номера паспорта обоих пользователей.
     *
     * @param o объект для сравнения с текущим объектом.
     * @return true, если объекты равны; false в противном случае.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хэш-код объекта, для хранения в коллекции типа HashMap в качестве ключа
     * Хэш-код вычисляется на основе паспорта пользователя.
     *
     * @return хэш-код для текущего объекта по passport.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
