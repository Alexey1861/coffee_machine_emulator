package com.aleksey.myapplication.classes;

public class Resource {
    private int coffeeBeans;
    private int milk;
    private int water;
    private int cash;

    public Resource(int coffeeBeans, int milk, int water) {
        this.coffeeBeans = coffeeBeans;
        this.milk = milk;
        this.water = water;
        this.cash = 0;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public int getCash() {
        return cash;
    }

    public void addCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans += coffeeBeans;
    }

    public void addMilk(int milk) {
        this.milk += milk;
    }

    public void addWater(int water) {
        this.water += water;
    }

    public void addCash(int cash) {
        this.cash += cash;
    }

    public void reduceCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans -= coffeeBeans;
    }

    public void reduceMilk(int milk) {
        this.milk -= milk;
    }

    public void reduceWater(int water) {
        this.water -= water;
    }

    public void reduceCash(int cash) {
        this.cash -= cash;
    }
}
