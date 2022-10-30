package ru.job4j.oop;

/**
 * @author Shegai Evgenii
 * @version 1.0
 * @since 30.10.2022
 * Приведение типов
 */

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Я езжу в городах ");
    }

    @Override
    public void fuel() {
        System.out.println("Заправляюсь бензином");
    }
}
