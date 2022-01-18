package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class FindByIdActionTest {

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        FindByIdAction findById = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findById.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ====" + ln
                + "Заявка с введенным id найдена " + item.getName() + ln));
    }

    @Test
    public void whenNotFindById() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        FindByIdAction findById = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(0);
        findById.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ====" + ln
                + "Заявка с введенным id не найдена." + ln));
    }
}