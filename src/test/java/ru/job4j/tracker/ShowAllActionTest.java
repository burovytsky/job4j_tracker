package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class ShowAllActionTest {

    @Test@Ignore
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Store memTracker = new SqlTracker();
        Item item = new Item("fix bug");
        memTracker.add(item);
        ShowAllAction act = new ShowAllAction();
        act.execute(new StubInput(new String[] {}), memTracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(item.getId() + " " + item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
