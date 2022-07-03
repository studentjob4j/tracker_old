package ru.job4j.stream;

import java.time.LocalDate;

/**
 * @author Shegai Evgenii
 * @version 1.0
 * @since 29.05.2022
 *  Шаблоны проектирования в Stream API - Builder
 *  Когда стоит использовать шаблон проектирования Builder (Строитель):
 * 1. Когда мы хотим избавиться от конструктора с большим количеством параметров
 * 2. Когда код должен создавать разные представления какого-то объекта.
 * Например, когда нам надо инициализировать лишь несколько полей из всего набора;
 * 3. Когда нам необходимо собирать сложные объекты, т.е. когда поля в классе являются экземплярами других классов.
 */

public class Car {

    private String brand;

    private String model;

    private LocalDate created;

    private double volume;

    private String color;

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
           Car car = new Car();
           car.brand = brand;
           car.color = color;
           car.created = created;
           car.model = model;
           car.volume = volume;
           return car;
        }
    }

    @Override
    public String toString() {
        return "Car{" + "brand='" + brand + '\'' + ", model='" + model + '\''
                + ", created=" + created + ", volume=" + volume
                + ", color='" + color + '\'' + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(car);
        Car car2 = new Builder()
                .buildBrand("Honda")
                .buildModel("Step Wagon")
                .buildCreated(LocalDate.of(2022, 1, 2))
                .buildVolume(2.5)
                .build();
        System.out.println(car2);
    }
}
