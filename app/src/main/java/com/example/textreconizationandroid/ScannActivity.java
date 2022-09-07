package com.example.textreconizationandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lucem.anb.characterscanner.Scanner;
import com.lucem.anb.characterscanner.ScannerListener;
import com.lucem.anb.characterscanner.ScannerView;

public class ScannActivity extends AppCompatActivity {

    SurfaceView surfaceView;
    Button btnCapture;
    EditText editText;
    String extractValue;
   // Scanner scanner;
    private boolean scanning = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scann);

        //surfaceView = findViewById(R.id.surface);
        btnCapture = findViewById(R.id.btncapture);
        editText = findViewById(R.id.editValue);

        ScannerView scanner = findViewById(R.id.scanner);

        scanner.setOnDetectedListener(this, new ScannerListener() {
            @Override
            public void onDetected(String s) {

                extractValue = s;
                Toast.makeText(ScannActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStateChanged(String s, int i) {

            }
        });

        /*Scanner scanner = new Scanner(this, surfaceView, new ScannerListener() {
            @Override
            public void onDetected(String s) {

                extractValue = s;

                Toast.makeText(ScannActivity.this, s, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStateChanged(String s, int i) {

                Toast.makeText(ScannActivity.this, s, Toast.LENGTH_SHORT).show();

            }
        });*/


        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scanner.isScanning();
                scanner.setVisibility(View.INVISIBLE);
                //surfaceView.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.VISIBLE);
                editText.setText(extractValue);
            }
        });
    }
}