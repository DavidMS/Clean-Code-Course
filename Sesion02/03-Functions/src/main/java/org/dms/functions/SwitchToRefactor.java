package org.dms.functions;

public class SwitchToRefactor {

    public Money calculatePay(Employee e) throws InvalidEmployeeType {
        switch(e.type) {
            case COMISSIONED:
                return calculateCommisionedPay(e);
            case HOURLY:
                return calculateHourlyPay(e);
            case SALARIED:
                return calculateSalariedPay(e);
            default:
                throw new InvalidEmployeeType(e.type);
        }
    }

    private Money calculateCommisionedPay(Employee employee) {
        return null;
    }

    private Money calculateHourlyPay(Employee employee) {
        return null;
    }

    private Money calculateSalariedPay(Employee employee) {
        return null;
    }
}
