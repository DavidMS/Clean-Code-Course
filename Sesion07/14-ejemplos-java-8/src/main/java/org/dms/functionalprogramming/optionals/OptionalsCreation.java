package org.dms.functionalprogramming.optionals;

import java.util.Optional;

public class OptionalsCreation {

    static String myString;
    static Integer myInteger;
    static Number myNumber;

    static Optional<String> emptyOptional;
    static Optional<Integer> optionalNull;
    static Optional<Number> optionalNumber;

    static void createOptionalOfNullable() {
        optionalNumber = Optional.ofNullable(myNumber);
    }

    static void createOptionals() {
        emptyOptional = Optional.empty();
        optionalNull = Optional.of(myInteger);
    }

    boolean myBoolean = false;
    Optional<PaymentMethod> paymentMethod = null;

    public void unwrappingOptionals() {
        // Unwrapping Optionals
        String stringOptional = Optional.ofNullable(myString).get();
        Integer integerOptional = Optional.ofNullable(myInteger).orElse(0);
        Number numberOptional = Optional.ofNullable(myNumber).orElseGet(() -> 0.0d);
        Object objectOptional = Optional.ofNullable(new Object()).orElseThrow(() -> new RuntimeException());
        Optional.ofNullable(myBoolean).ifPresent(System.out::println);

        // Rejectig Optional values
        Optional<Integer> integer2 = Optional.ofNullable(myInteger).filter(i -> i % 2 == 0);

        paymentMethod
                .filter("Paypal"::equals)
                .ifPresent(s ->
                        System.out.println("Payment method is Paypal"));

    }
}
