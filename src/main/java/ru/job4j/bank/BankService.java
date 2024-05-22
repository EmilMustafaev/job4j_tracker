package ru.job4j.bank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский сервис, в котором есть возможность:
 * Регистрировать пользователя
 * Удалять пользователя из системы
 * Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов
 * Переводить деньги с одного банковского счета на другой счет
 *
 * @author Emil Mustafaev
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей с списком их счетов осущетсвляется в коллекции
     * типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить в систему нового пользователя с пустым списком счетов по умолчанию.
     *
     * @param user новый пользователь которого мы хотим добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод производит удаление пользователя из карты пользователей.
     *
     * @param passport номер паспорта пользователя которого мы хотим удалить
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод позволяет добавить к списку банковских счетов пользовател дополнительный счёт.
     * Внутри вызывается метод findByPassport, он возвращает найденного пользователя или null
     * если пользователь отсутсвует в системе.
     * После чего мы извлекаем список счетов пользователя с помощью метода getAccounts и далее
     * проверяем что счета который мы хотим добавить, еще нет у пользователя.
     *
     * @param passport номер паспорта пользователя которому мы ходим добавить счет,
     * @param account  новый счет который мы хотим добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод осущетсвляет поиск пользователя по номеру его паспорта
     * Изначально мы задаем в результирующее поле что пользователь не найден (null).
     * Далее проходим по номерам паспортов в карте пользователей, сравниваем значения с введеным
     * в параметры номером, в случае соответсвия прекращаем цикл и возвращаем пользователя на текущей
     * итерации где он был найден.
     *
     * @param passport номер паспорта пользователя которого необходимо найти
     * @return возвращает результат поиска
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод позволяет найти банковский счет пользователя по его реквизитам.
     * Сначала проверяем что пользователь существует в системе.
     * Далее получаем список его счетов и ищем по заданным реквизитам соответсвующий счёт.
     *
     * @param passport  номер паспорта пользователя
     * @param requisite реквизиты счёта который нужно найти
     * @return банковский счёт найденный по реквизитам или null если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод позволяет определить успешность перевода средств с одного банковского счёта на другой.
     * Находим счета который будут участвовать в операции, если такие сущетсвуют осущетсвлем перевод.
     *
     * @param sourcePassport       номер паспорта пользователя который переводит деньги.
     * @param sourceRequisite      реквизиты счёта пользователя с которого переводятся деньги.
     * @param destinationPassport  номер паспорта пользователя который получает деньги.
     * @param destinationRequisite реквизиты счета пользователя на который должны прийти деньги.
     * @param amount               сумма которая переводится
     * @return true - перевод выполнен успешно; false - перевод отклонен.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account accountOne = findByRequisite(sourcePassport, sourceRequisite);
        Account accountTwo = findByRequisite(destinationPassport, destinationRequisite);
        if (accountOne != null && accountTwo != null && accountOne.getBalance() >= amount) {
            accountOne.setBalance(accountOne.getBalance() - amount);
            accountTwo.setBalance(accountTwo.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод позволяет получить список банковских счетов пользователя.
     *
     * @param user пользователь, счета которого хотим получить
     * @return список счетов пользователя в виде коллекции типа List
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
