package com.tw.academy.banking;

import com.tw.banking.Account;
import com.tw.banking.Printer;
import com.tw.banking.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class AccountTest {

    @Test
    public void should_bob_account_add_100_when_deposit_100() {
        TransactionRepository transactionRepository = Mockito.mock(TransactionRepository.class);
        Printer printer = Mockito.mock(Printer.class);
        Account bob = new Account(transactionRepository, printer);

        int amount = 100;

        bob.deposit(amount);

        verify(transactionRepository, times(1)).addDeposit(amount);
    }

    @Test
    public void should_bob_account_desc_100_when_withdraw_100() {
        TransactionRepository transactionRepository = Mockito.mock(TransactionRepository.class);
        Printer printer = Mockito.mock(Printer.class);
        Account bob = new Account(transactionRepository, printer);

        int amount = 100;

        bob.withdraw(amount);

        verify(transactionRepository, times(1)).addWithdraw(amount);
    }

    @Test
    public void should_print_statement() {
        TransactionRepository transactionRepository = Mockito.mock(TransactionRepository.class);
        Printer printer = Mockito.mock(Printer.class);
        Account bob = new Account(transactionRepository, printer);

        bob.printStatement();

        verify(transactionRepository, times(1)).allTransactions();
    }
}
