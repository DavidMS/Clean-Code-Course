package org.dms.functionalprogramming.optionals;

import java.util.Optional;

public class AccountOptional {

    private PaymentMethod paymentMethod;

    public Optional<PaymentMethod> getPaymentMethod() {
        return Optional.ofNullable(paymentMethod);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
