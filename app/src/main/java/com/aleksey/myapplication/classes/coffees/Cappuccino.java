package com.aleksey.myapplication.classes.coffees;

public class Cappuccino implements Coffee {
    @Override
    public int coffeeBeans() {
        return 200;
    }

    @Override
    public int milk() {
        return 200;
    }

    @Override
    public int water() {
        return 200;
    }

    @Override
    public int cash() {
        return 200;
    }
}
