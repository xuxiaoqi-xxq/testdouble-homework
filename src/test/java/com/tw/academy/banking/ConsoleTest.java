package com.tw.academy.banking;

import com.tw.banking.Console;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ConsoleTest {

    @Test
    public void should_print_line_when_console() {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteStream));
        Console console = new Console();

        console.printLine("hello world");

        assertEquals("hello world\n", byteStream.toString());
    }
}
