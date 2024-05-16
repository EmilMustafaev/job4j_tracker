package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mustafaev.emil@mail.ru", "Mustafaev Emil' Rudemovich");
        map.put("ivanov.ivan@mail.ru", "Ivanov Ivan Ivanovich");
        map.put("petrov.oleg@mail.ru", "Petrov Oleg Petrovich");
        map.put("ivanov.ivan@mail.ru", "Ivanov Ivan Semenovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }

    }
}
