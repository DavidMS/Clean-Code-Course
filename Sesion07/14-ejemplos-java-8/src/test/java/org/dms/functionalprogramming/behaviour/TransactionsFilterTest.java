package org.dms.functionalprogramming.behaviour;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionsFilterTest {


    private static List<Transaction> transactions;

    @BeforeAll
    public static void setUpOnce() {
        initTransactions();
        printTransactions("TRANSACTIONS UNFILTERED");
    }

    @BeforeEach
    public void setUp() {
        initTransactions();
    }

    @Test
    @DisplayName("Filter Big Transactions the old way")
    @Order(1)
    public void testFilterBigTransactionsOldWay() {
        transactions = TransactionsFilter.filterBigTransactions(transactions);
        printTransactions("BIG TRANSACTIONS FILTERED OLD WAY");
        assertEquals(3, transactions.size());
    }

    @Test
    @DisplayName("Filter Small Transactions the old way")
    @Order(2)
    public void testFilterSmallTransactionsOldWay() {
        transactions = TransactionsFilter.filterSmallTransactions(transactions);
        printTransactions("SMALL TRANSACTIONS FILTERED OLD WAY");
        assertEquals(3, transactions.size());
    }

    @Test
    @DisplayName("Filter Big Transactions using BigPredicate")
    @Order(3)
    public void testFilterBigTransactionsBigPredicate() {
        transactions = TransactionsFilter.filterBigTransactionsBigPredicate(transactions);
        printTransactions("BIG TRANSACTIONS FILTERED BIG PREDICATE");
        assertEquals(3, transactions.size());
    }

    @Test
    @DisplayName("Filter Small Transactions using SmallPredicate")
    @Order(4)
    public void testFilterSmallTransactionsSmallPredicate() {
        transactions = TransactionsFilter.filterSmallTransactionsSmallPredicate(transactions);
        printTransactions("SMALL TRANSACTIONS FILTERED SMALL PREDICATE");
        assertEquals(3, transactions.size());
    }

    @Test
    @DisplayName("Filter Big Transactions using Generic Predicate")
    @Order(5)
    public void testFilterBigTransactionsGenericPredicate() {
        transactions = TransactionsFilter.filterBigTransactionsGenericPredicate(transactions);
        printTransactions("BIG TRANSACTIONS FILTERED GENERIC PREDICATE");
        assertEquals(3, transactions.size());
    }

    @Test
    @DisplayName("Filter Small Transactions using Generic Predicate")
    @Order(6)
    public void testFilterSmallTransactionsGenericPredicate() {
        transactions = TransactionsFilter.filterSmallTransactionsGenericPredicate(transactions);
        printTransactions("SMALL TRANSACTIONS FILTERED GENERIC PREDICATE");
        assertEquals(3, transactions.size());
    }

    @Test
    @DisplayName("Filter Big Transactions using isBig Method")
    @Order(7)
    public void testFilterBigTransactionsIsBigMethod() {
        transactions = TransactionsFilter.filterBigTransactionsIsBigMethod(transactions);
        printTransactions("BIG TRANSACTIONS FILTERED IS BIG METHOD");
        assertEquals(3, transactions.size());
    }

    @Test
    @DisplayName("Filter Small Transactions using isSmall Method")
    @Order(8)
    public void testFilterSmallTransactionsIsSmallMethod() {
        transactions = TransactionsFilter.filterSmallTransactionsIsSmallMethod(transactions);
        printTransactions("SMALL TRANSACTIONS FILTERED IS SMALL METHOD");
        assertEquals(3, transactions.size());
    }

    public static void printTransactions(String message) {
        printSeparator(message);
        for(int i = 0, j = transactions.size(); i < j; i++) {
            int index = i + 1;
            System.out.println(index + ". " + transactions.get(i).getAmout() + " $");
        }

    }

    private static void printSeparator(String message) {
        System.out.println("================ " + message + " ===================");
    }

    private static void initTransactions() {
        transactions = Arrays.asList(
                new Transaction(5),
                new Transaction(20),
                new Transaction(4),
                new Transaction(10),
                new Transaction(3),
                new Transaction(1000),
                new Transaction(2000),
                new Transaction(8999),
                new Transaction(7654));
    }
}
