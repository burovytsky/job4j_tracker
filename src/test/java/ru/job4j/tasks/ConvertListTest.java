package ru.job4j.tasks;

import org.junit.Test;
import ru.job4j.tasks.collections.ConvertList;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListTest {
    @Test
    public void whenTwoList() {
        List<int[]> in = new ArrayList<>(
                List.of(
                        new int[]{1},
                        new int[]{2, 3, 4, 5},
                        new int[]{6, 7, 8, 9})
        );
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(ConvertList.convert(in), is(expect));
    }
}
