package org.dms.functionalprogramming.optionals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalsCreationTest {

    @Test
    public void createOptionalsNullPointerTest() {
        OptionalsCreation.myInteger = null;
        Assertions.assertThrows(NullPointerException.class, () -> OptionalsCreation.createOptionals());
    }

    @Test
    public void createOptionalsNullCheckTest() {
        OptionalsCreation.myInteger = 1;
        OptionalsCreation.myNumber = null;
        OptionalsCreation.createOptionals();

        assertEquals(1, OptionalsCreation.optionalNull.get());

        assertFalse(OptionalsCreation.optionalNumber.isPresent());

        assertThrows(NoSuchElementException.class, () -> OptionalsCreation.optionalNumber.get());

        assertEquals(5, OptionalsCreation.optionalNumber.orElse(5));
    }

    @Test
    public void createEmptyOptionalTest() {
        OptionalsCreation.myInteger = 2;
        OptionalsCreation.createOptionals();
        assertFalse(OptionalsCreation.emptyOptional.isPresent());
    }
}
