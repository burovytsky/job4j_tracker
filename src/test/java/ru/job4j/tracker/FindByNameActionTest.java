package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindByNameActionTest {

    @Test@Ignore
    public void findByNameTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Store memTracker = new SqlTracker();
        Item item = new Item("item");
        memTracker.add(item);
        FindByNameAction action = new FindByNameAction();
        action.execute(new StubInput(new String[]{item.getName()}), memTracker);
        String expected = item.getName() + " : " + item.getId();
        assertThat(new String(out.toByteArray()), is(expected));
        System.setOut(def);
    }
}
