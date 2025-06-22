package com.abc.myappunihstel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentInquiriesActivity extends AppCompatActivity {

    EditText etName, etEmail, etInquiry;
    Button btnSubmit;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_inquiries);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etInquiry = findViewById(R.id.etInquiry);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnBack = findViewById(R.id.btnBack); // back button reference

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String inquiry = etInquiry.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || inquiry.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Inquiry Submitted", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etEmail.setText("");
                etInquiry.setText("");
            }
        });

        // Back button logic
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(StudentInquiriesActivity.this, Dashboard.class);
            startActivity(intent);
            finish();
        });
    }
}
