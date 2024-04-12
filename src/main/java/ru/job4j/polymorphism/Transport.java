package ru.job4j.polymorphism;

public interface Transport {
    void drive();

    void passengers(int quantity);

    int fillUp(int liters);
}
