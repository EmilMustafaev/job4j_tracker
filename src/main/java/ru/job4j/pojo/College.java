package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Mustafaev Emil' Rudemovich'");
        student.setGroup("IT");
        student.setDate(LocalDate.of(2023, 9, 3));
        System.out.println("ФИО: " + student.getFullName() + ", Группа " + student.getGroup()
                + ", Дата поступления: " + student.getDate());
    }
}
