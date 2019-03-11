package com.example.converter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    public byte conTypeFlag = 0;

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
        TextView convStat = (TextView) findViewById(R.id.converter_state);
        switch (item.getItemId()) {
            case R.id.j2g: {
                conTypeFlag = 0;
                convStat.setText("jilli to Gregorian");
                break;
            }
            case R.id.g2j: {
                conTypeFlag = 1;
                convStat.setText("Gregorian to jilli");
                break;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        try {
            EditText editTextDate = findViewById(R.id.edit_text_date);
            TextView textResult = findViewById(R.id.textViewResult);
            String dateStr = editTextDate.getText().toString();
            String[] splitStr = dateStr.split("/");
            int year = Integer.parseInt(splitStr[0]);
            int month = Integer.parseInt(splitStr[1]);
            int day = Integer.parseInt(splitStr[2]);
            if (conTypeFlag == 0) {
                textResult.setText(Arrays.toString(Convert.jilli_to_gregorian(year, month, day)) + ("Cristian"));

            } else if (conTypeFlag == 1) {
                textResult.setText(Arrays.toString(Convert.gregorian_to_jilli(year, month, day)) + ("Jalali"));
            }

        } catch (Exception e) {
            Log.e(TAG, "Exception Logger failed!", e);
        }
    }
}
