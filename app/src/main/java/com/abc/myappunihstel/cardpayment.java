package com.abc.myappunihstel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class cardpayment extends AppCompatActivity {

    Button btnPayNow, btnApplePay, btnDebitCard, btnNetBanking;
    TextView tvAddNewCard, tvDetails;
    CheckBox cbSendReceipt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardpayment);

        btnPayNow = findViewById(R.id.btnPayNow);
        btnApplePay = findViewById(R.id.btnApplePay);
        btnDebitCard = findViewById(R.id.btnDebitCard);
        btnNetBanking = findViewById(R.id.btnNetBanking);
        tvAddNewCard = findViewById(R.id.tvAddNewCard);
        cbSendReceipt = findViewById(R.id.cbSendReceipt);

        // Extra TextView in cardpayment.xml to show details
        tvDetails = findViewById(R.id.tvDetails);

        // Get data from AddPaymentActivity
        String name = getIntent().getStringExtra("studentName");
        String regNo = getIntent().getStringExtra("regNo");
        String roomNo = getIntent().getStringExtra("roomNo");
        String amount = getIntent().getStringExtra("amount");
        String month = getIntent().getStringExtra("month");

        // Show details
        tvDetails.setText(
                "Student: " + name + "\n" +
                        "Reg No: " + regNo + "\n" +
                        "Room No: " + roomNo + "\n" +
                        "Month: " + month + "\n" +
                        "Amount: " + amount
        );

        // Pay Now button
        btnPayNow.setOnClickListener(v ->
                Toast.makeText(this, "Payment Processed!", Toast.LENGTH_SHORT).show()
        );

        // Open AddNewCardActivity when clicked
        tvAddNewCard.setOnClickListener(v -> {
            Intent intent = new Intent(cardpayment.this, activity_add_new_card.class);
            startActivity(intent);
        });
    }
}
