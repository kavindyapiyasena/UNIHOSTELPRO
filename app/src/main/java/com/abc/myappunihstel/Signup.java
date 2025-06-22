package com.abc.myappunihstel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.abc.myappunihstel.DatabaseHelper;
import com.abc.myappunihstel.LoginActivity;
import com.abc.myappunihstel.R;

public class Signup extends AppCompatActivity {

    EditText etUserName, etPassword;
    Button btnSignUp;
    DatabaseHelper databaseHelper; // Assuming DBHelper has insertUser(username, password)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup); // Ensure this layout contains the right IDs

        // Initialize views
        etUserName = findViewById(com.abc.myappunihstel.R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);

        // Initialize DBHelper
        databaseHelper = new DatabaseHelper(this);

        // Sign-up button click
        btnSignUp.setOnClickListener(v -> {
            String username = etUserName.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.length() < 4 || password.length() < 6) {
                Toast.makeText(this, "Username must be 4+ characters, Password 6+", Toast.LENGTH_SHORT).show();
            } else {
                boolean inserted = databaseHelper.insertUser(username, password);
                if (inserted) {
                    Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Signup.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Signup Failed (Username might exist)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
