package com.example.temperaturecalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editCelcius;
    private TextView tViewCelciusToReamur, tViewCelciusToKelvin, tViewCelciusToFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCelcius = findViewById(R.id.edit_celcius);
        tViewCelciusToReamur = findViewById(R.id.tv_celcius_to_reamur);
        tViewCelciusToKelvin = findViewById(R.id.tv_celcius_to_kelvin);
        tViewCelciusToFahrenheit = findViewById(R.id.tv_celcius_to_fr);
        Button btnHitungCelcius = (Button) findViewById(R.id.btn_hitung_celcius);

        btnHitungCelcius.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_hitung_celcius:
                try {
                    int celcius = Integer.parseInt(String.valueOf(editCelcius.getText()));

                    int resultCelciusToReamur = celcius * 4 / 5;
                    int resultCelciusToKelvin = celcius + 273;
                    int resultCelciusToFr = (celcius * 9 / 5) + 32;

                    tViewCelciusToReamur.setVisibility(View.VISIBLE);
                    tViewCelciusToKelvin.setVisibility(View.VISIBLE);
                    tViewCelciusToFahrenheit.setVisibility(View.VISIBLE);

                    tViewCelciusToKelvin.setText("Kelvin : " + String.valueOf(resultCelciusToKelvin));
                    tViewCelciusToReamur.setText("Reamur : " + String.valueOf(resultCelciusToReamur));
                    tViewCelciusToFahrenheit.setText("Fahrenheit : " + String.valueOf(resultCelciusToFr));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}