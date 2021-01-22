package org.dms.functions;

public class SalariedEmployee extends Employee {

    public SalariedEmployee(EmployeeRecord record) {}

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
