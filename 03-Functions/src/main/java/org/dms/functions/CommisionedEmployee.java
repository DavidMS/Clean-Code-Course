package org.dms.functions;

public class CommisionedEmployee extends Employee {

    public CommisionedEmployee(EmployeeRecord record){}

    @Override
    public boolean isPayDay() {
        return false;
    }

    @Override
    public Money calculatePay() {
        return null;
    }

    @Override
    public void deliveryPay(Money pay) {

    }
}
