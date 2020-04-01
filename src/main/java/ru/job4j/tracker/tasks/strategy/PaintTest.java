package ru.job4j.tracker.tasks.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.StringJoiner;

public class PaintTest {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream stdout = System.out;

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(new StringJoiner(System.lineSeparator())
                        .add("+++++++")
                        .add("+     +")
                        .add("+     +")
                        .add("+++++++")
                        .add(System.lineSeparator())
                        .toString())
        );
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(new StringJoiner(System.lineSeparator())
                        .add("   *")
                        .add("  ***")
                        .add(" *****")
                        .add("*******")
                        .toString())
        );
    }
}