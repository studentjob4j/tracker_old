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

public class FindByNameActionTest {

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        FindByNameAction findByName = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        findByName.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by name ===" + ln
                + "Заявки с таким именем найдены " + item.getName() + ln));
    }

    @Test
    public void whenNotFindByName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        FindByNameAction findByName = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("any");
        findByName.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by name ===" + ln
                + "Заявки с таким именем не найдены." +  ln));
    }
}