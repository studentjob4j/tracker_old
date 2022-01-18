package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Shegai Evgenii
 * @since 18.01.2022
 * @version 1.0
 */

public class EditItemActionTest {

    @Test
    public void whenReplace() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("Replaced item");
        tracker.add(item);
        String replacedName = "New item name";
        EditItemAction edit = new EditItemAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        edit.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Заявка изменена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenNotReplace() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("Replaced item");
        tracker.add(item);
        String replacedName = "New item name";
        EditItemAction edit = new EditItemAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(0);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        edit.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Ошибка замены заявки." + ln));
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));
    }
}