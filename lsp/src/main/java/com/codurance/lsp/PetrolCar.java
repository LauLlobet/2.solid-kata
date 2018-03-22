package com.codurance.lsp;

public class PetrolCar extends Vehicle {

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

    @Override
    public void fillUp() {
        fillUpWithFuel();
    }
}
