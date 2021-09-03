package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class TrackerTest {

    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item(1);
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item(1);
        Item second = new Item(2);
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getId(), is(first.getId()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item(1, "First");
        Item second = new Item(2, "second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item(3, "First"));
        tracker.add(new Item(4, "Second"));
        tracker.add(new Item(5, "First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item(1, "First");
        Item second = new Item(2, "Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item(3, "First"));
        tracker.add(new Item(4, "Second"));
        tracker.add(new Item(5, "First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item first = new Item(1, "First");
        Item second = new Item(2, "Second");
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.replace(2, new Item(0, "Third")), is(true));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item first = new Item(1, "First");
        Item second = new Item(2, "Second");
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.delete(2), is(true));
    }

}