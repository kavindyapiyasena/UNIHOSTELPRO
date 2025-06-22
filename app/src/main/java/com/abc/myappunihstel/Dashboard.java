package com.abc.myappunihstel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    Button btnAddMembers, btnAddPayment, btnStudentReg, btnInquiries, btnStaffContact,
            btnComplains, btnDirection, btnPaymentDue, btnInOut, btnViewTFR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard); // Use your actual layout file here

        // Initialize all buttons
        btnAddMembers = findViewById(R.id.btnAddMembers);
        btnAddPayment = findViewById(R.id.btnAddPayment);
        btnStudentReg = findViewById(R.id.btnStudentReg);
        btnInquiries = findViewById(R.id.btnInquiries);
        btnStaffContact = findViewById(R.id.btnStaffContact);
        btnComplains = findViewById(R.id.btnComplains);
        btnDirection = findViewById(R.id.btnDirection);
        btnPaymentDue = findViewById(R.id.btnPaymentDue);
        btnInOut = findViewById(R.id.btnInOut);
        btnViewTFR = findViewById(R.id.btnViewTFR);

        // Set up button click actions
        btnAddMembers.setOnClickListener(v -> startActivity(new Intent(this, AddMembersActivity.class)));
        btnAddPayment.setOnClickListener(v -> startActivity(new Intent(this, AddPaymentActivity.class)));
        btnStudentReg.setOnClickListener(v -> startActivity(new Intent(this, StudentRegActivity.class)));
        btnInquiries.setOnClickListener(v -> startActivity(new Intent(this, StudentInquiriesActivity.class)));
        btnStaffContact.setOnClickListener(v -> startActivity(new Intent(this, StaffContactActivity.class)));
        btnComplains.setOnClickListener(v -> startActivity(new Intent(this, ComplaintFormActivity.class)));
        btnDirection.setOnClickListener(v -> startActivity(new Intent(this, MapActivity.class)));
        btnPaymentDue.setOnClickListener(v -> startActivity(new Intent(this, PaymentDueActivity.class)));
        btnInOut.setOnClickListener(v -> startActivity(new Intent(this, QrActivity.class))); // If InOutActivity was renamed
        btnViewTFR.setOnClickListener(v -> startActivity(new Intent(this, TFRPaymentActivity.class)));
    }
}
