package com.abc.myappunihstel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentRegActivity extends AppCompatActivity {

    EditText etName, etRegNo, etNIC, etFaculty;
    Spinner spinnerYear, spinnerProgram;
    Button btnSubmit;
    ImageView btnBack;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_reg_activity); // Ensure XML is named correctly

        etName = findViewById(R.id.etName);
        etRegNo = findViewById(R.id.etRegNo);
        etNIC = findViewById(R.id.etNIC);
        etFaculty = findViewById(R.id.etFaculty);
        spinnerYear = findViewById(R.id.spinnerYear);
        spinnerProgram = findViewById(R.id.spinnerProgram);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnBack = findViewById(R.id.btnBack);

        dbHelper = new DatabaseHelper(this);

        // Spinner data
        String[] years = {"First Year", "Second Year", "Third Year", "Fourth Year"};
        String[] programs = {"BSE Engineering", "BBA", "BA Arts", "BSCS"};

        spinnerYear.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years));
        spinnerProgram.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, programs));

        // Back button action
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(StudentRegActivity.this, Dashboard.class);
            startActivity(intent);
            finish();
        });

        // Submit action
        btnSubmit.setOnClickListener(v -> {
            boolean inserted = dbHelper.insertStudent(
                    etName.getText().toString(),
                    etRegNo.getText().toString(),
                    etNIC.getText().toString(),
                    etFaculty.getText().toString(),
                    spinnerYear.getSelectedItem().toString(),
                    spinnerProgram.getSelectedItem().toString()
            );

            if (inserted) {
                Toast.makeText(StudentRegActivity.this, "Student Registered!", Toast.LENGTH_SHORT).show();
                clearForm();
            } else {
                Toast.makeText(StudentRegActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clearForm() {
        etName.setText("");
        etRegNo.setText("");
        etNIC.setText("");
        etFaculty.setText("");
        spinnerYear.setSelection(0);
        spinnerProgram.setSelection(0);
    }
}
