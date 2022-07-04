package ru.job4j.inheritance;

/**
 * @author Shegai Ecgenii
 * @since 04.07.2022
 * @version 1.0
 * Вызов переопределенного метода родителя - super.method
 */

public class PizzaExtraCheese extends Pizza {

    @Override
    public String name() {
        return super.name() + " + extra cheese";
    }
}
