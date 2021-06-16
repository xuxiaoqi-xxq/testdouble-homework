package com.tw.academy.banking;

import com.tw.banking.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionRepositoryTest {

    private Clock clock;
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void init() {
        clock = mock(Clock.class);
        transactionRepository = new TransactionRepository(clock);
    }

    @Test
    public void should_add_amount_is_100_transaction_when_add_deposit_100() {
        transactionRepository.addDeposit(100);

        List<Transaction> transactions = transactionRepository.allTransactions();
        assertEquals(1, transactions.size());
        assertEquals(100, transactions.get(0).amount());
    }

    @Test
    public void should_add_amount_is_negative_100_transaction_when_add_withdraw_100() {
        transactionRepository.addDeposit(-100);

        List<Transaction> transactions = transactionRepository.allTransactions();
        assertEquals(1, transactions.size());
        assertEquals(-100, transactions.get(0).amount());
    }
}
