package ru.job4j.oop;

/**
 * @author Shegai Evgenii
 * @version 1.0
 * @since 30.10.2022
 * Приведение типов
 */

public class Example {

    public static void main(String[] args) {

        Airplane airplane = new Airplane();
        Train train = new Train();
        Bus bus = new Bus();
        Vehicle[] array = new Vehicle[] {airplane, train, bus};
        for (Vehicle temp : array) {
            temp.move();
            temp.fuel();
        }
    }
}
