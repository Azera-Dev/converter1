package com.example.converter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    public byte convTypeFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Enter Your date Of Birth", Toast.LENGTH_SHORT).show();
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.j2g: {
                convTypeFlag = 0;
                break;
            }
            case R.id.g2j: {
                convTypeFlag = 1;
                break;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        try {
            EditText editTextDate = (EditText) findViewById(R.id.edit_text_date);
            TextView textResult = (TextView) findViewById(R.id.textViewResult);
            TextView edtxtConvState = (TextView) findViewById(R.id.converter_state);
            String dateStr = editTextDate.getText().toString();
            String[] splitStr = dateStr.split("/");
            int year = Integer.parseInt(splitStr[0]);
            int month = Integer.parseInt(splitStr[1]);
            int day = Integer.parseInt(splitStr[2]);
            if (convTypeFlag == 0) {
                textResult.setText(Arrays.toString(Convert.jalali_to_gregorian(year, month, day)) + ("Cristian"));

            } else if (convTypeFlag == 1) {
                textResult.setText(Arrays.toString(Convert.gregorian_to_jalali(year, month, day)) + ("Jalali"));
            }

        } catch (Exception e) {
            Log.e(TAG, "Exception Logger failed!", e);
        }
    }
}
