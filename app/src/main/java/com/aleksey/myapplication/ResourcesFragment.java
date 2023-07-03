package com.aleksey.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.aleksey.myapplication.classes.Machine;

public class ResourcesFragment extends Fragment {

    private Machine machine;
    private TextView outputMilk;
    private TextView outputWater;
    private TextView outputBeans;
    private TextView outputCash;
    private EditText inputMilk;
    private EditText inputWater;
    private EditText inputBeans;
    private EditText inputCash;
    private ImageButton addResources;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resources, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initComponents(view);

        addFunctionality();

        refreshOutputData();
    }

    private void initComponents(View view) {
        machine = Machine.useMachine();
        outputMilk = view.findViewById(R.id.fragment2_output_milk);
        outputWater = view.findViewById(R.id.fragment2_output_water);
        outputBeans = view.findViewById(R.id.fragment2_output_beans);
        outputCash = view.findViewById(R.id.fragment2_output_cash);
        inputMilk = view.findViewById(R.id.fragment2_input_milk_field);
        inputWater = view.findViewById(R.id.fragment2_input_water_field);
        inputBeans = view.findViewById(R.id.fragment2_input_beans_field);
        inputCash = view.findViewById(R.id.fragment2_input_cash_field);
        addResources = view.findViewById(R.id.fragment2_add_resources_button);
    }

    private void addFunctionality() {
        addResources.setOnClickListener(view -> {
            int milk = parseIntOrGetZero(inputMilk);
            int water = parseIntOrGetZero(inputWater);
            int beans = parseIntOrGetZero(inputBeans);
            int cash = parseIntOrGetZero(inputCash);

            machine.addMilk(milk);
            machine.addWater(water);
            machine.addCoffeeBeans(beans);
            machine.addCash(cash);

            inputMilk.setText("");
            inputWater.setText("");
            inputBeans.setText("");
            inputCash.setText("");

            refreshOutputData();

            Toast.makeText(
                    getContext(),
                    String.format(
                            "%s мл. молока, %s мл. воды, %s шт. зёрен, %s у.е. денег успешно добавлены",
                            milk, water, beans, cash
                    ),
                    Toast.LENGTH_LONG
            ).show();
        });
    }

    private int parseIntOrGetZero(EditText inputResource) {
        try {
            return Integer.parseInt(inputResource.getText().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void refreshOutputData() {
        outputMilk.setText(String.format("Milk: %s", machine.getMilk()));
        outputWater.setText(String.format("Water: %s", machine.getWater()));
        outputBeans.setText(String.format("Beans: %s", machine.getCoffeeBeans()));
        outputCash.setText(String.format("Cash: %s", machine.getCash()));
    }
}