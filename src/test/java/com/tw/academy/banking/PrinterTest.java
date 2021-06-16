package com.tw.academy.banking;

import com.tw.banking.Transaction;
import org.junit.jupiter.api.Test;

import com.tw.banking.Console;
import com.tw.banking.Printer;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PrinterTest {

    @Test
    public void should_print_statement_with_right_format_when_print() {
        Console console = Mockito.mock(Console.class);
        Printer printer = new Printer(console);
        List<Transaction> transactions = generateTransactionList();

        printer.print(transactions);

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(console, times(4)).printLine(stringArgumentCaptor.capture());
        List<String> actualArguments = stringArgumentCaptor.getAllValues();

        assertEquals(Printer.STATEMENT_HEADER, actualArguments.get(0));
        assertEquals("30/06/2021 | 10000 | 11100", actualArguments.get(1));
        assertEquals("20/06/2021 | 1000 | 1100", actualArguments.get(2));
        assertEquals("10/06/2021 | 100 | 100", actualArguments.get(3));
    }

    @Test
    public void should_print_statement_without_transaction_when_print() {
        Console console = Mockito.mock(Console.class);
        Printer printer = new Printer(console);
        List<Transaction> transactions = new ArrayList<>();

        printer.print(transactions);

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(console, times(1)).printLine(stringArgumentCaptor.capture());
        List<String> actualArguments = stringArgumentCaptor.getAllValues();

        assertEquals(Printer.STATEMENT_HEADER, actualArguments.get(0));
    }

    private List<Transaction> generateTransactionList() {
        Transaction transaction1 = new Transaction("10/06/2021", 100);
        Transaction transaction2 = new Transaction("20/06/2021", 1000);
        Transaction transaction3 = new Transaction("30/06/2021", 10000);
        return Arrays.asList(transaction1, transaction2, transaction3);
    }
}
