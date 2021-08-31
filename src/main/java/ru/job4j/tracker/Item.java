package ru.job4j.tracker;

public class Item {

    private String id;
    private String name;

    public Item() {
    }

    public Item(String id) {
        this.id = id;
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
