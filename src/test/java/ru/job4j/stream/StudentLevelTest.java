package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Evgenii Shegai
 * @since 06.09.2021
 * @version 1.0
 */

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Masha", 28));
        input.add(new Student("Pety", 128));
        List<Student> expected = List.of(
                new Student("Pety", 128),
                new Student("Masha", 28)
        );
        StudentLevel level = new StudentLevel();
        assertThat(level.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        StudentLevel level = new StudentLevel();
        assertThat(level.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student("Pety", 28));
        List<Student> expected = List.of(new Student("Pety", 28));
        StudentLevel level = new StudentLevel();
        assertThat(level.levelOf(input, 10), is(expected));
    }
}