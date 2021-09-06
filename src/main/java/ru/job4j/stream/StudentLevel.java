package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.*;

/**
 * @author Evgenii Shegai
 * @since 06.09.2021
 * @version 1.0
 */


public class StudentLevel {

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((st1, st2) -> st2.getScore() - st1.getScore())
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
