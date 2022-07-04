package ru.job4j.inheritance;

/**
 * @author Shegai Ecgenii
 * @since 04.07.2022
 * @version 1.0
 * Вызов переопределенного метода родителя - super.method
 */

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {

    @Override
    public String name() {
        return super.name() + " + extra tomato";
    }
}
