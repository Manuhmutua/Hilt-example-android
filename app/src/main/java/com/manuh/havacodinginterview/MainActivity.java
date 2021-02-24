package com.manuh.havacodinginterview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroupTime;
    private RadioGroup radioGroupDistance;
    private EditText editTextKeyword;
    private Switch canceledSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canceledSwitch = findViewById(R.id.canceled_switch);
        editTextKeyword = findViewById(R.id.search_keyword);
        radioGroupTime = findViewById(R.id.radiogroup_time);
        radioGroupDistance = findViewById(R.id.radiogroup_distance);

        // Search Button Onclick Listener
        Button button = findViewById(R.id.button_search);
        button.setOnClickListener(v -> {

            int selectedTime = radioGroupTime.getCheckedRadioButtonId();
            int selectedDistance = radioGroupDistance.getCheckedRadioButtonId();


            RadioButton radioButtonTime = radioGroupTime.findViewById(selectedTime);

            RadioButton radioButtonDistance = radioGroupDistance.findViewById(selectedDistance);

            String keyword = editTextKeyword.getText().toString();

            boolean switchState = canceledSwitch.isChecked();


            Intent intent = new Intent(MainActivity.this, TripResultsActivity.class);
            intent.putExtra("search_keyword", keyword);
            intent.putExtra("distance", radioButtonDistance.getText());
            intent.putExtra("time", radioButtonTime.getText());
            intent.putExtra("switch", switchState);
            startActivity(intent);
        });

    }
}
