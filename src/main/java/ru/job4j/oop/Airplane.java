package ru.job4j.oop;

/**
 * @author Shegai Evgenii
 * @version 1.0
 * @since 30.10.2022
 * Приведение типов
 */

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println("Я лечу быстрее всех");
    }

    @Override
    public void fuel() {
        System.out.println("Я питаюсь керосином");
    }
}
