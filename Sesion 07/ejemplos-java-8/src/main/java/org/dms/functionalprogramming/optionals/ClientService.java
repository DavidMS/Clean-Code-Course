package org.dms.functionalprogramming.optionals;

import java.util.Optional;

public class ClientService {

    public static String getPaymentMethodName(Client client) {
        return client.getAccount().getPaymentMethod().getName();
    }

    public static String getPaymentMethodNameNullCheck(Client client) {
        if(client != null) {
            Account account = client.getAccount();
            if(account != null) {
                PaymentMethod paymentMethod = account.getPaymentMethod();
                if(paymentMethod != null) {
                    return paymentMethod.getName();
                }
            }
        }
        return null;
    }

    public static String getPaymentMethodDefaultNull(Client client) {
        if(client == null) {
            return null;
        }
        Account account = client.getAccount();
        if(account == null) {
            return null;
        }
        PaymentMethod paymentMethod = account.getPaymentMethod();
        if(paymentMethod == null) {
            return null;
        }
        return paymentMethod.getName();
    }

    public static String getPaymentMethodNameOptionals(ClientOptional clientOptional) {
        return Optional.ofNullable(clientOptional)
                .flatMap(ClientOptional::getAccount)
                .flatMap(AccountOptional::getPaymentMethod)
                .map(PaymentMethod::getName)
                .orElse(null);
    }
}
