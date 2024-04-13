package ru.job4j.cast;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("Поезд движется по рельсам");
    }

    @Override
    public void movementFeature() {
        System.out.println("Скорость передвижения 150 км/ч");
    }
}
