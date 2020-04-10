package ru.job4j.tracker.tasks.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = new Diapason().diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = new Diapason().diapason(7, 10, x -> x * x);
        List<Double> expected = Arrays.asList(49D, 64D, 81D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = new Diapason().diapason(3, 7, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(8D, 16D, 32D, 64D);
        assertThat(result, is(expected));
    }
}
