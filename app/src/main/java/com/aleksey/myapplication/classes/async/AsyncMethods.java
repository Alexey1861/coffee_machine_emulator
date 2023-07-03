package com.aleksey.myapplication.classes.async;

import android.content.Context;
import android.widget.Toast;

public class AsyncMethods {
    private static final AsyncMethods asyncMethods = new AsyncMethods();
    private Context context;

    public static AsyncMethods useAsync(Context context) {
        asyncMethods.context = context;
        return asyncMethods;
    }

    private AsyncMethods() {}

    public void coffeeProcessing() {
        Toast.makeText(context, "Начало нагревания воды", Toast.LENGTH_SHORT).show();
        heatWater();
        Toast.makeText(context, "Конец нагревания воды", Toast.LENGTH_SHORT).show();

        Thread coffeeBrewing = new Thread(this::brewCoffee);
        Thread milkWhipping = new Thread(this::whipMilk);

        Toast.makeText(context, "Начало заварки кофе", Toast.LENGTH_SHORT).show();
        coffeeBrewing.start();

        Toast.makeText(context, "Начало взбития сливок", Toast.LENGTH_SHORT).show();
        milkWhipping.start();

        try {
            coffeeBrewing.join();
            Toast.makeText(context, "Конец заварки кофе", Toast.LENGTH_SHORT).show();

            milkWhipping.join();
            Toast.makeText(context, "Конец взбития сливок", Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        Toast.makeText(context, "Начало смешивания молока и кофе", Toast.LENGTH_SHORT).show();
        mixCoffeeAndMilk();
        Toast.makeText(context, "Конец смешивания молока и кофе", Toast.LENGTH_SHORT).show();

        Toast.makeText(context, "Кофе готово", Toast.LENGTH_SHORT).show();
    }

    private void heatWater() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }

    private void brewCoffee() {


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }

    private void whipMilk() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }

    private void mixCoffeeAndMilk() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }
}