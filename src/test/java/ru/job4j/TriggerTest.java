package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriggerTest {

    @Test
    public void whenGetSumm() {
        assertThat(new Trigger().summ(1, 1), is(2));
    }
}