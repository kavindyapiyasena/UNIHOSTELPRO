package com.abc.myappunihstel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddPaymentActivity extends AppCompatActivity {

    EditText etStudentName, etRegNo, etRoomNo, etAmount;
    Spinner spinnerMonth;
    Button btnCreditCard, btnPay;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);

        etStudentName = findViewById(R.id.etStudentName);
        etRegNo = findViewById(R.id.etRegNo);
        etRoomNo = findViewById(R.id.etRoomNo);
        etAmount = findViewById(R.id.etAmount);
        spinnerMonth = findViewById(R.id.spinnerMonth);
        btnCreditCard = findViewById(R.id.btnCreditCard);
        btnPay = findViewById(R.id.btnPay);
        btnBack = findViewById(R.id.btnBack);

        // Populate spinner
        String[] months = {"January 2024", "February 2024", "March 2024", "April 2024", "May 2024", "June 2024"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, months);
        spinnerMonth.setAdapter(adapter);

        btnPay.setOnClickListener(v -> {
            Toast.makeText(this, "Payment submitted!", Toast.LENGTH_SHORT).show();
        });

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(AddPaymentActivity.this, Dashboard.class);
            startActivity(intent);
            finish();
        });
    }
}
