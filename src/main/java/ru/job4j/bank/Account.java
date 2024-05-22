package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета пользователя
 *
 * @author Emil Mustafaev
 * @version 1.0
 */
public class Account {
    /**
     * Хранение реквизитов банковского счета пользователя
     * осуществляется в поле типа String
     */
    private String requisite;
    /**
     * Хранение баланса счёта осуществляется в
     * поле типа double
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счета пользователя
     *
     * @return возвращает значение поля requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет изменить реквизиты счёта пользователя
     *
     * @param requisite новые реквизиты которые мы хотим задать
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс счета пользователя
     *
     * @return значение поля balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет изменить баланс счета пользователя
     *
     * @param balance принимает новое значение баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод проверяет, является ли данный счет равным другому банковского счёту.
     * Сначала проверяется, являются ли оба объекта одинаковыми ссылками.
     * Затем проверяется, что объект не равен null и что они относятся к одному и тому же классу.
     * В конце сравниваются значения реквизитов обоих счетов.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод возвращает хэш-код для текущего объекта, который используется
     * для хранения объекта в коллекции типа List,
     * которая в качестве значения будет хранится в коллекции типа HashMap
     *
     * @return хэш-код переданного объекта по полю requisite
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
