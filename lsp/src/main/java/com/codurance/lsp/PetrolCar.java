package com.codurance.lsp;

public class PetrolCar extends Vehicle {
    private static final int FULL = 100;
    private int fuelTankLevel = 0;

    public void fillUpWithFuel(){
        this.fuelTankLevel = FULL;
    }

    public int fuelTankLevel() {
        return fuelTankLevel;
    }

    @Override
    public int getAutonomy(){
        return fuelTankLevel;
    }
}
