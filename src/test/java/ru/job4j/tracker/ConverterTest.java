package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.tasks.lambda.Converter;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void whenConvertTwoDimensionalArray() {
        Integer[][] matrix = {{2, 4}, {5, 4}, {9, 3}, {8, 2}};
        List<Integer> expect = List.of(2, 4, 5, 4, 9, 3, 8, 2);
        assertThat(Converter.convertMatrixToList(matrix), is(expect));
    }
}
