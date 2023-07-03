package com.aleksey.myapplication.classes;


import android.content.Context;

import com.aleksey.myapplication.classes.async.AsyncMethods;
import com.aleksey.myapplication.classes.coffees.Coffee;

public class Machine {

    private static final Machine machine = new Machine();
    private final Resource resource;

    private Machine() {
        resource = new Resource(0, 0, 0);
    }

    public static Machine useMachine() {
        return machine;
    }

    public int getCoffeeBeans() {
        return resource.getCoffeeBeans();
    }

    public int getMilk() {
        return resource.getMilk();
    }

    public int getWater() {
        return resource.getWater();
    }

    public int getCash() {
        return resource.getCash();
    }

    public void addCoffeeBeans(int coffeeBeans) {
        resource.addCoffeeBeans(coffeeBeans);
    }

    public void addMilk(int milk) {
        resource.addMilk(milk);
    }

    public void addWater(int water) {
        resource.addWater(water);
    }

    public void addCash(int cash) {
        resource.addCash(cash);
    }

    public boolean makeCoffee(Coffee coffee, Context context) {
        if (isAvailable(coffee)) {
            discardResources(coffee);
            AsyncMethods.useAsync(context).coffeeProcessing();
            return true;
        } else {
            return false;
        }
    }

    private boolean isAvailable(Coffee coffee) {
        return resource.getCoffeeBeans() >= coffee.coffeeBeans() &&
               resource.getMilk() >= coffee.milk() &&
               resource.getWater() >= coffee.water() &&
               resource.getCash() >= coffee.cash();
    }

    private void discardResources(Coffee coffee) {
        resource.reduceCoffeeBeans(coffee.coffeeBeans());
        resource.reduceMilk(coffee.milk());
        resource.reduceWater(coffee.water());
        resource.reduceCash(coffee.cash());
    }
}
