package com.abc.myappunihstel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    TextView txtCreateAccount, fingerprintText, tvUserPassDisplay;
    DatabaseHelper databaseHelper;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        edtUsername = findViewById(R.id.etUsername);
        edtPassword = findViewById(R.id.etPassword);
        txtCreateAccount = findViewById(R.id.createAccount);
        fingerprintText = findViewById(R.id.fingerprintText);
        tvUserPassDisplay = findViewById(R.id.tvUserPassDisplay);

        databaseHelper = new DatabaseHelper(this);
        prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Login button click listener
        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isValid = databaseHelper.checkUser(username, password);
            if (isValid) {
                // Save login info
                prefs.edit()
                        .putBoolean("first_login_done", true)
                        .putString("saved_username", username)
                        .putString("saved_password", password)
                        .apply();

                // Show username and password in black
                tvUserPassDisplay.setTextColor(getResources().getColor(android.R.color.black));
                tvUserPassDisplay.setText("Username: " + username + "\nPassword: " + password);

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

                // Go to Dashboard
                startActivity(new Intent(LoginActivity.this, Dashboard.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        // Navigate to Signup page
        txtCreateAccount.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, Signup.class));
        });

        // Fingerprint click
        if (fingerprintText != null) {
            fingerprintText.setOnClickListener(v -> {
                Toast.makeText(this, "Opening Fingerprint Activity", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, FingerprintActivity.class));
            });
        }
    }
}
