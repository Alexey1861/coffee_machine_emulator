package com.aleksey.myapplication.classes.coffees;

public class Espresso implements Coffee {

    @Override
    public int coffeeBeans() {
        return 300;
    }

    @Override
    public int milk() {
        return 300;
    }

    @Override
    public int water() {
        return 300;
    }

    @Override
    public int cash() {
        return 300;
    }
}
