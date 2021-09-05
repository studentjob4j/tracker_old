package ru.job4j.collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class JobTest {

    @Test
    public void whenComparingByAscName() {
        Job one = new Job("name", 2);
        Job two = new Job("test", 3);
        List<Job> list = new ArrayList<>(List.of(two, one));
        Collections.sort(list, new JobAscByName());
        List<Job> expect = List.of(one, two);
        assertThat(list, is(expect));
    }

    @Test
    public void whenComparingByDescName() {
        Job one = new Job("name", 2);
        Job two = new Job("test", 3);
        List<Job> list = new ArrayList<>(List.of(one, two));
        Collections.sort(list, new JobDescByName());
        List<Job> expect = List.of(two, one);
        assertThat(list, is(expect));
    }

    @Test
    public void whenComparingByAscPriority() {
        Job one = new Job("name", 2);
        Job two = new Job("test", 3);
        List<Job> list = new ArrayList<>(List.of(two, one));
        Collections.sort(list, new JobAscByPriority());
        List<Job> expect = List.of(one, two);
        assertThat(list, is(expect));
    }

    @Test
    public void whenComparingByDescPriority() {
        Job one = new Job("name", 2);
        Job two = new Job("test", 3);
        List<Job> list = new ArrayList<>(List.of(one, two));
        Collections.sort(list, new JobDescByPriority());
        List<Job> expect = List.of(two, one);
        assertThat(list, is(expect));
    }

    @Test
    public void whenComparingByNameThenByPriority() {
        Job one = new Job("name", 2);
        Job two = new Job("name", 3);
        List<Job> list = new ArrayList<>(List.of(two, one));
        Collections.sort(list, new JobAscByName().thenComparing(new JobAscByPriority()));
        List<Job> expect = List.of(one, two);
        assertThat(list, is(expect));
    }

    @Test
    public void whenComparingByPriorityThenByName() {
        Job one = new Job("a", 2);
        Job two = new Job("e", 2);
        List<Job> list = new ArrayList<>(List.of(two, one));
        Collections.sort(list, new JobDescByPriority().thenComparing(new JobAscByName()));
        List<Job> expect = List.of(one, two);
        assertThat(list, is(expect));
    }

}