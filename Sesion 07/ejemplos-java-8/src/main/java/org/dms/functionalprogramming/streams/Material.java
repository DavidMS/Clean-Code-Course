package org.dms.functionalprogramming.streams;

public class Material {
    private Type type;
    private String color = null;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean hasColor() {
        return color != null;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
