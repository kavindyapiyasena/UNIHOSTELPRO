package com.abc.myappunihstel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_add_new_card extends AppCompatActivity {

    EditText etCardNumber, etCardHolder, etExpiry, etCVV;
    CheckBox cbDefaultCard;
    Button btnAddCardPayNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_card);

        // Link UI components
        etCardNumber = findViewById(R.id.etCardNumber);
        etCardHolder = findViewById(R.id.etCardHolder);
        etExpiry = findViewById(R.id.etExpiry);
        etCVV = findViewById(R.id.etCVV);
        cbDefaultCard = findViewById(R.id.cbDefaultCard);
        btnAddCardPayNow = findViewById(R.id.btnAddCardPayNow);

        // Save/Add Card button action
        btnAddCardPayNow.setOnClickListener(v -> {
            String number = etCardNumber.getText().toString().trim();
            String holder = etCardHolder.getText().toString().trim();
            String expiry = etExpiry.getText().toString().trim();
            String cvv = etCVV.getText().toString().trim();

            if (number.isEmpty() || holder.isEmpty() || expiry.isEmpty() || cvv.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                if (cbDefaultCard.isChecked()) {
                    Toast.makeText(this, "Card saved as Default & Payment Done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Card Added & Payment Done", Toast.LENGTH_SHORT).show();
                }
                finish(); // Back to AddPaymentActivity
            }
        });
    }
}
