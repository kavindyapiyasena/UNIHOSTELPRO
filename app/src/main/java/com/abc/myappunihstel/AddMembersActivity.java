package com.abc.myappunihstel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddMembersActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etRoom;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etRoom = findViewById(R.id.etRoom);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String room = etRoom.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || room.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // You can save to database or send to server here
                Toast.makeText(this, "Member added:\n" + name, Toast.LENGTH_LONG).show();

                // Clear inputs
                etName.setText("");
                etEmail.setText("");
                etPhone.setText("");
                etRoom.setText("");
            }
        });
    }
}
