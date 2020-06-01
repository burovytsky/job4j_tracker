package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test@Ignore
    public void whenPrtMenu() {
        List<UserAction> actions = new ArrayList<>();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        actions.add(action);
        new StartUI().init(input, new SqlTracker(), actions);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test@Ignore
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Store memTracker = new SqlTracker();
        new CreateAction().execute(input, memTracker);
        Item created = memTracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test@Ignore
    public void whenReplaceItem() {
        Store memTracker = new SqlTracker();
        Item item = new Item("new item");
        memTracker.add(item);
        String[] answers = {item.getId(), "replaced item"};
        new EditAction().execute(new StubInput(answers), memTracker);
        Item replaced = memTracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test@Ignore
    public void whenDeleteItem() {
        Store memTracker = new SqlTracker();
        Item item = new Item("new item");
        memTracker.add(item);
        String[] answers = {item.getId()};
        new DeleteAction().execute(new StubInput(answers), memTracker);
        Item replaced = memTracker.findById(item.getId());
        assertThat(replaced, is(nullValue()));
    }
}
