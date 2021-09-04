package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class OneBigThenTwoTest {

    @Test
    public void whenOneBigThenTwo() {
        Item one = new Item(2, "test2");
        Item two = new Item(3, "test3");
        Item three = new Item(1, "test1");
        List<Item> temp = new ArrayList<>(List.of(three, two, one));
        Collections.sort(temp, new OneBigThenTwo());
        List<Item> expect = List.of(two, one, three);
        assertThat(temp, is(expect));
    }
}