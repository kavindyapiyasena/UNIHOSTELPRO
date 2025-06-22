package com.abc.myappunihstel;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class ComplaintFormActivity extends AppCompatActivity {

    EditText editTextName, editTextRegNo, editTextComplaint;
    Spinner spinnerFlow;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_form);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextRegNo = findViewById(R.id.editTextRegNo);
        editTextComplaint = findViewById(R.id.editTextComplaint);
        spinnerFlow = findViewById(R.id.spinnerFlow);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Setup Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.flow_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFlow.setAdapter(adapter);

        // Handle button click
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String regNo = editTextRegNo.getText().toString();
                String flow = spinnerFlow.getSelectedItem().toString();
                String complaint = editTextComplaint.getText().toString();

                Toast.makeText(ComplaintFormActivity.this,
                        "Complaint submitted:\nName: " + name + "\nReg No: " + regNo,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
