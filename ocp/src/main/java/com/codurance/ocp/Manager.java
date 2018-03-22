package com.codurance.ocp;

public class Manager extends Employee {

    Manager(int salary, int bonus) {
        super(salary, bonus);
    }

    @Override
    public int payAmount() {
        return salary + bonus;
    }
}
