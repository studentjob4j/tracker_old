package ru.job4j.tracker;

import java.time.LocalDateTime;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class Item {

    private String id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String id) {
        this.id = id;
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
