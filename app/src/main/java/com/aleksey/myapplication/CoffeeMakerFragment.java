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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aleksey.myapplication.classes.Machine;
import com.aleksey.myapplication.classes.coffees.Americano;
import com.aleksey.myapplication.classes.coffees.Cappuccino;
import com.aleksey.myapplication.classes.coffees.Espresso;

import javax.crypto.Mac;


public class CoffeeMakerFragment extends Fragment {

    private Machine machine;
    private TextView outputBeans;
    private TextView outputMilk;
    private TextView outputWater;
    private TextView outputMoney;
    private RadioGroup radioGroup;
    private EditText inputMoney;
    private ImageButton makeCoffee;
    private ImageButton addMoney;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coffee_maker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initComponents(view);

        addFunctionality();

        refreshOutputData();
    }

    private void initComponents(View view) {
        outputBeans = view.findViewById(R.id.fragment1_output_beans);
        outputMilk = view.findViewById(R.id.fragment1_output_milk);
        outputWater = view.findViewById(R.id.fragment1_output_water);
        outputMoney = view.findViewById(R.id.fragment1_output_money);
        radioGroup = view.findViewById(R.id.fragment1_radio_group);
        inputMoney = view.findViewById(R.id.fragment1_input_money_field);
        makeCoffee = view.findViewById(R.id.fragment1_make_coffee);
        addMoney = view.findViewById(R.id.fragment1_input_money_button);
        machine = Machine.useMachine();
    }

    private void addFunctionality() {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.fragment1_radio_americsno -> {
                    makeCoffee.setOnClickListener(view -> {
                        if (machine.makeCoffee(new Americano(), getContext())) {
                            refreshOutputData();
                        } else {
                            Toast.makeText(getActivity(), "Недостаточно ресурсов", Toast.LENGTH_LONG).show();
                        }
                    });
                } case R.id.fragment1_radio_cappucino -> {
                    makeCoffee.setOnClickListener(view -> {
                        if (machine.makeCoffee(new Cappuccino(), getContext())) {
                            refreshOutputData();
                        } else {
                            Toast.makeText(getActivity(), "Недостаточно ресурсов", Toast.LENGTH_LONG).show();
                        }
                    });
                } case R.id.fragment1_radio_espresso -> {
                    makeCoffee.setOnClickListener(view -> {
                        if (machine.makeCoffee(new Espresso(), getContext())) {
                            refreshOutputData();
                        } else {
                            Toast.makeText(getActivity(), "Недостаточно ресурсов", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        addMoney.setOnClickListener(view -> {
            int cash = parseIntOrGetZero(inputMoney);
            machine.addCash(cash);

            inputMoney.setText("");

            refreshOutputData();

            Toast.makeText(getContext(), String.format("%s у.е. упешно добавлено", cash), Toast.LENGTH_LONG).show();
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
        outputBeans.setText(String.format("Beans: %s", machine.getCoffeeBeans()));
        outputMilk.setText(String.format("Milk: %s", machine.getMilk()));
        outputWater.setText(String.format("Water: %s", machine.getWater()));
        outputMoney.setText(String.format("Your money: %s", machine.getCash()));
    }
}