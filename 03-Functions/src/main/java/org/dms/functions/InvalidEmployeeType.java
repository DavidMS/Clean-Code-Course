package org.dms.functions;

public class InvalidEmployeeType extends Exception {

    public InvalidEmployeeType(EmployeType type) {
        super("type:" + type.name());
    }
}
