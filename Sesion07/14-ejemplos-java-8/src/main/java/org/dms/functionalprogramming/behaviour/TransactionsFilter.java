package org.dms.functionalprogramming.behaviour;

import java.util.ArrayList;
import java.util.List;

public class TransactionsFilter {

    public static List<Transaction> filterBigTransactions(List<Transaction> transactions) {

        List<Transaction> result = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getAmout() > 1000) {
                result.add((transaction));
            }
        }

        return  result;
    }

    public static List<Transaction> filterSmallTransactions(List<Transaction> transactions) {

        List<Transaction> result = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getAmout() < 10) {
                result.add(transaction);
            }
        }

        return result;
    }

    public static List<Transaction> filterTransactions(List<Transaction> transactions, String type) {
        List<Transaction> result = new ArrayList<>();

        if("BIG".equals(type)) {
            result = filterBigTransactions(transactions);
        } else if("SMALL".equals(type)) {
            result = filterSmallTransactions(transactions);
        }
        return result;
    }

    public static List<Transaction> filterTransactions(List<Transaction> transactions, TransactionPredicate predicate) {
        List<Transaction> result = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(predicate.test(transaction)) {
                result.add(transaction);
            }
        }
        return result;
    }

    public static List<Transaction> filterBigTransactionsBigPredicate(List<Transaction> transactions) {

        List<Transaction> result = new ArrayList<>();

        return filterTransactions(transactions, new BigTransactionPredicate());
    }

    public static List<Transaction> filterSmallTransactionsSmallPredicate(List<Transaction> transactions) {

        List<Transaction> result = new ArrayList<>();

        return filterTransactions(transactions, new SmallTransactionPredicate());
    }

    public static List<Transaction> filterBigTransactionsGenericPredicate(List<Transaction> transactions) {

        List<Transaction> result = new ArrayList<>();

        return filterTransactions(transactions, new TransactionPredicate() {
            @Override
            public boolean test(Transaction transaction) {
                return transaction.getAmout() > 1000;
            }
        });
    }

    public static List<Transaction> filterSmallTransactionsGenericPredicate(List<Transaction> transactions) {

        List<Transaction> result = new ArrayList<>();

        return filterTransactions(transactions, new TransactionPredicate() {
            @Override
            public boolean test(Transaction transaction) {
                return transaction.getAmout() < 10;
            }
        });
    }

    public static List<Transaction> filterBigTransactionsIsBigMethod(List<Transaction> transactions) {

        List<Transaction> result = new ArrayList<>();

        return filterTransactions(transactions, TransactionsFilter::isBig);
    }

    public static List<Transaction> filterSmallTransactionsIsSmallMethod(List<Transaction> transactions) {

        List<Transaction> result = new ArrayList<>();

        return filterTransactions(transactions, TransactionsFilter::isSmall);
    }

    private static boolean isSmall(Transaction transaction) {
        return transaction.getAmout() < 10;
    }

    private static boolean isBig(Transaction transaction) {
        return transaction.getAmout() > 1000;
    }






}
