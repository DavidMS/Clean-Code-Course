package org.dms.functionalprogramming.behaviour;

public class BigTransactionPredicate implements TransactionPredicate {
    @Override
    public boolean test(Transaction transaction) {
        return transaction.getAmout() > 1000;
    }
}
