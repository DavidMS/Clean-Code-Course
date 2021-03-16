package org.dms.functionalprogramming.optionals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientServiceTest {

    public static final String PAYPAL = "Paypal";
    private static Client client;
    private static ClientOptional clientOptional;

    @Test
    public void testGetPaymentMethodName_OK() {
        initFullClient();
        String result = ClientService.getPaymentMethodName(client);
        Assertions.assertEquals(PAYPAL, result);
    }

    @Test
    public void testGetPaymentMethodName_Exception() {
        client = new Client();
        Assertions.assertThrows(NullPointerException.class, () -> ClientService.getPaymentMethodName(client));
    }

    @Test
    public void testGetPaymentMethodNameNullCheck_OK() {
        initFullClient();
        String result = ClientService.getPaymentMethodNameNullCheck(client);
        Assertions.assertEquals(PAYPAL, result);
    }

    @Test
    public void testGetPaymentMethodNameNullCheck_Null() {
        client = new Client();
        Assertions.assertNull(ClientService.getPaymentMethodNameNullCheck(client));
    }

    @Test
    public void testGetPaymentMethodNameDefaultNull_Null() {
        client = new Client();
        Assertions.assertNull(ClientService.getPaymentMethodDefaultNull(client));
    }

    @Test
    public void testGetPaymentMethodNameOptionals_OK() {
        initFullClientOptional();
        String result = ClientService.getPaymentMethodNameOptionals(clientOptional);
        Assertions.assertEquals(PAYPAL, result);
    }

    @Test
    public void testGetPaymentMethodNameOptionals_Null() {
        client = new Client();
        Assertions.assertNull(ClientService.getPaymentMethodNameOptionals(clientOptional));
    }

    private static void initFullClient() {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName(PAYPAL);
        Account account = new Account();
        account.setPaymentMethod(paymentMethod);
        client = new Client();
        client.setAccount(account);
    }

    private static void initFullClientOptional() {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName(PAYPAL);
        AccountOptional account = new AccountOptional();
        account.setPaymentMethod(paymentMethod);
        clientOptional = new ClientOptional();
        clientOptional.setAccount(account);
    }
}
