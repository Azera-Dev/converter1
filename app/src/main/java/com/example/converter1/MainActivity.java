package com.example.converter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        try {
            EditText editTextDate =(EditText)findViewById(R.id.edit_text_date);
            TextView textResult = (TextView) findViewById(R.id.textViewResult);
            String dateStr = editTextDate.getText().toString();
            String[] splitStr = dateStr.split("/");
            int year = Integer.parseInt(splitStr[0]);
            int month = Integer.parseInt(splitStr[1]);
            int day = Integer.parseInt(splitStr[2]);
            if (toggleButton.isChecked()) {
                textResult.setText(Arrays.toString(Convert.jalali_to_gregorian(year, month, day))+("Cristyan"));

            } else {
                textResult.setText(Arrays.toString(Convert.gregorian_to_jalali(year,month,day))+("Jalali"));
            }

        } catch (Exception e) {
            Log.e(TAG, "Exception Logger failed!", e);

        }

    }
}
