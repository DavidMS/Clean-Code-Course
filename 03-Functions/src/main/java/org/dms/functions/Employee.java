package org.dms.functions;

public abstract class Employee {

    public EmployeType type;

    public abstract boolean isPayDay();
    public abstract Money calculatePay();
    public abstract void deliveryPay(Money pay);
}
