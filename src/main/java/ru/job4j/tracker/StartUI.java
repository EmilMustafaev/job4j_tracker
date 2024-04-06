package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item itemOne = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(itemOne.getCreated().format(formatter));
        Item itemTwo = new Item();
        System.out.println(itemTwo);
    }
}
