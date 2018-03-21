package com.codurance.ocp;

public class Employee {

    protected int salary;
    protected int bonus;

    Employee(int salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public int payAmount() {
        return salary;
    }

}