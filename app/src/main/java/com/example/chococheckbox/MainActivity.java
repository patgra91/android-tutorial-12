package com.example.chococheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> checkBoxIds = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Save the Id for every Checkbox in the LinearLayout.
        LinearLayout linearLayout = findViewById(R.id.linear_layout_checkboxes);
        if (linearLayout != null) {
            final int childCount = linearLayout.getChildCount();
            checkBoxIds = new ArrayList<Integer>(childCount);
            CheckBox checkBox = null;
            for (int i = 0; i < childCount; i++) {
                checkBox = (CheckBox) linearLayout.getChildAt(i);
                checkBoxIds.add(i, checkBox.getId());
            }
        }

    }

    public void showToast(View view) {
        String message = "Toppings:";

        // Iterate through every checkbox to see which are selected.
        CheckBox checkBox = null;
        for (int id : checkBoxIds) {
            checkBox = findViewById(id);
            if (checkBox.isChecked()) {
                message += " " + checkBox.getText().toString();
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}