package ru.job4j.cast;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println("Самолёт летит по воздуху");
    }

    @Override
    public void movementFeature() {
        System.out.println("Скорость движения свыше 300 км/ч");
    }
}
