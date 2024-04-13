package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус едет по трассе");
    }

    @Override
    public void movementFeature() {
        System.out.println("Скорость движения 80 км/ч");
    }
}
