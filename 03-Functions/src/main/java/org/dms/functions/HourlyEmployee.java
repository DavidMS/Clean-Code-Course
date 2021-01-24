package org.dms.functions;

public class HourlyEmployee extends Employee {

    public HourlyEmployee(EmployeeRecord record) {}

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
