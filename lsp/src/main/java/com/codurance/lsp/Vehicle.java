package com.codurance.lsp;

public abstract class Vehicle {
    protected int autonomy = 0;
    protected static final int FULL = 100;

    public int getAutonomy() {
        return autonomy;
    }

    public abstract void fillUp();
}
