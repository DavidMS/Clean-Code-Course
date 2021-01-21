package org.dms.naming;

public class Cell {

    private static final int FLAGGED = 4;
    private int status;

    public boolean isFlagged() {
        return status == FLAGGED;
    }
}
