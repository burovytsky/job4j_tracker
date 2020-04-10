package ru.job4j.tracker;
import org.junit.Test;
import ru.job4j.tracker.tasks.collections.DepDescComp;
import ru.job4j.tracker.tasks.collections.Departments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class DepDescCompTest {

    @Test
    public void whenAllDepatsThenSortedAscended() {
        List<String> input = Arrays.asList("K1/SK1/SSK1", "K2/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2", "K1/SK1", "K2/SK1/SSK2");
        List<String> expect = Arrays.asList("K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2", "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }
    @Test
    public void whenAllDepatsThenSortedDescended() {
        List<String> input = Arrays.asList("K1/SK1/SSK1", "K2/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2", "K1/SK1", "K2/SK1/SSK2");
        List<String> expect = Arrays.asList("K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2", "K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2");
        List<String> result = Departments.fillGaps(input);
        Departments.sortDesc(result);
        assertThat(result, is(expect));
    }

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

}
