package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("Количество пассажиров в автобусе +" + quantity);
    }

    @Override
    public int fillUp(int liters) {
        System.out.println("Заправили автобус");
        return liters;
    }
}
