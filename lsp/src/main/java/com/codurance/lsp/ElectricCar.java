package com.codurance.lsp;

public class ElectricCar extends Vehicle{

    @Override
    public void fillUp() {
        this.autonomy = FULL;
    }
}
