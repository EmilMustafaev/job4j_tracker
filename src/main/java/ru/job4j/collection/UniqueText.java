package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();

        for (String stringOrigin : origin) {
            check.add(stringOrigin);
        }
        for (String checkedText : text) {
            if (!check.contains(checkedText)) {
                result = false;
            }
        }
        return result;
    }
}