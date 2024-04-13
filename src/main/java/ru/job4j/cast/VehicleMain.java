package ru.job4j.cast;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle aiplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] vehicles = new Vehicle[]{aiplane, train, bus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.movementFeature();
        }
    }
}
