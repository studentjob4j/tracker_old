package ru.job4j.inheritance;

/**
 * @author Shegai Ecgenii
 * @since 04.07.2022
 * @version 1.0
 * Вызов переопределенного метода родителя - super.method
 */

public class PizzaShop {

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        PizzaExtraCheese pizzaExtraCheese = new PizzaExtraCheese();
        PizzaExtraCheeseExtraTomato pizzaExtraCheeseExtraTomato = new PizzaExtraCheeseExtraTomato();
        System.out.println(pizza.name());
        System.out.println(pizzaExtraCheese.name());
        System.out.println(pizzaExtraCheeseExtraTomato.name());
    }
}
