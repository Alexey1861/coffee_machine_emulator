package com.aleksey.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.aleksey.myapplication.classes.Machine;

public class MainActivity extends AppCompatActivity {

    private ImageButton coffeeButton;
    private ImageButton resourceButton;
    private FrameLayout frameLayout;
    private CoffeeMakerFragment coffeeMakerFragment;
    private ResourcesFragment resourcesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        addFunctionality();
    }

    private void initComponents() {
        coffeeButton = findViewById(R.id.coffee_making_button);
        resourceButton = findViewById(R.id.resources_button);
        frameLayout = findViewById(R.id.fragment);
        coffeeMakerFragment = new CoffeeMakerFragment();
        resourcesFragment = new ResourcesFragment();
    }

    private void addFunctionality() {
        coffeeButton.setOnClickListener(view -> goToToFragment(coffeeMakerFragment));
        resourceButton.setOnClickListener(view -> goToToFragment(resourcesFragment));
    }

    private void goToToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
    }
}