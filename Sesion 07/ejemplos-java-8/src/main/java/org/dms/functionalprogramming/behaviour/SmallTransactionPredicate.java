package org.dms.functionalprogramming.behaviour;

public class SmallTransactionPredicate implements TransactionPredicate {
    @Override
    public boolean test(Transaction transaction) {
        return transaction.getAmout() < 10;
    }
}
