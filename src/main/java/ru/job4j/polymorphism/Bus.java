package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
    }

    @Override
    public void passengers(int quantity) {
    }

    @Override
    public int fillUp(int liters) {
        return 0;
    }
}
