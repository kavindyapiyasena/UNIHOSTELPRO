package com.abc.myappunihstel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentDueActivity extends AppCompatActivity {

    Button btnPayNow;
    TextView txtViewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_due);

        btnPayNow = findViewById(R.id.btnPayNow);
        txtViewDetails = findViewById(R.id.txtViewDetails);

        btnPayNow.setOnClickListener(v -> {
            Toast.makeText(this, "Redirecting to Payment Gateway...", Toast.LENGTH_SHORT).show();
            // You can replace this with actual payment logic
        });

        txtViewDetails.setOnClickListener(v -> {
            Toast.makeText(this, "Viewing payment details...", Toast.LENGTH_SHORT).show();
            // Example: startActivity(new Intent(this, PaymentDetailsActivity.class));
        });
    }
}
