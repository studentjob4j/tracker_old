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

public class DeleteItemActionTest {

    @Test
    public void whenDelete() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        DeleteItemAction deleteAction = new DeleteItemAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно." + ln));
    }

    @Test
    public void whenNotDelete() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        DeleteItemAction deleteAction = new DeleteItemAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(0);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Ошибка удаления заявки." + ln));
    }


}