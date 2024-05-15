package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mustafaev.emil@mail.ru", "Mustafaev Emil' Rudemovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }

    }
}
