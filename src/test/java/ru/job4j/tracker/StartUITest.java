package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("Item name");
        list.add("1");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(out),
                new ExitAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator() + "0. Add new Item"
        + System.lineSeparator() + "1. Exit" + System.lineSeparator() + "=== Create a new Item ===="
        + System.lineSeparator() + "Menu: " + System.lineSeparator() + "0. Add new Item"
        + System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add(String.valueOf(item.getId()));
        list.add(replacedName);
        list.add("1");
        Input in = new StubInput(list);
        List<UserAction> actions = List.of(
                new EditItemAction(out),
                new ExitAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator() + "0. Edit item"
                + System.lineSeparator() + "1. Exit" + System.lineSeparator() + "=== Edit item ==="
                + System.lineSeparator() + "Заявка изменена успешно."
                + System.lineSeparator() + "Menu: " + System.lineSeparator() + "0. Edit item"
                + System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
        public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add(String.valueOf(item.getId()));
        list.add("1");
        Input in = new StubInput(list);
        List<UserAction> actions = List.of(
                new DeleteItemAction(out),
                new ExitAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator() + "0. Delete item"
                + System.lineSeparator() + "1. Exit" + System.lineSeparator() + "=== Delete item ==="
                + System.lineSeparator() + "Заявка удалена успешно."
                + System.lineSeparator() + "Menu: " + System.lineSeparator() + "0. Delete item"
                + System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        List<String> list = new ArrayList<>();
        list.add("0");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu: " + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        List<String> list = new ArrayList<>();
        list.add("-1");
        list.add("0");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu: " + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu: " + ln
                        + "0. Exit" + ln
                )
        );
    }
}