package com.tw.academy.banking;

import com.tw.banking.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void should_return_1_when_transaction_date_greater_than_compared_transaction_date() {
        Transaction transaction = new Transaction("30/12/2021", 100);

        Transaction comparedTransaction = new Transaction("30/06/1997", 50);

        int comparedResult = transaction.compareTo(comparedTransaction);

        assertEquals(1, comparedResult);
    }

    @Test
    public void should_return_1_when_transaction_date_equals_compared_transaction_date() {
        Transaction transaction = new Transaction("30/12/2021", 100);

        Transaction comparedTransaction = new Transaction("30/12/2021", 50);

        int comparedResult = transaction.compareTo(comparedTransaction);

        assertEquals(1, comparedResult);
    }

    @Test
    public void should_return_negative_1_when_transaction_date_less_than_compared_transaction_date() {
        Transaction transaction = new Transaction("10/10/2010", 100);

        Transaction comparedTransaction = new Transaction("30/06/2020", 19950);

        int comparedResult = transaction.compareTo(comparedTransaction);

        assertEquals(-1, comparedResult);
    }
}
