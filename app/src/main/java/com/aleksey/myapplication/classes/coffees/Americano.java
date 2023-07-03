package com.aleksey.myapplication.classes.coffees;

public class Americano implements Coffee {

    @Override
    public int coffeeBeans() {
        return 100;
    }

    @Override
    public int milk() {
        return 100;
    }

    @Override
    public int water() {
        return 100;
    }

    @Override
    public int cash() {
        return 100;
    }
}
