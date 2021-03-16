package org.dms.junit;

public class Database {

    private int uniqueId;

    public boolean isAvailable() {
        return false;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }
}
