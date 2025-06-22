package com.abc.myappunihstel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;
    TextView txtCreateAccount, fingerprintText;
    DatabaseHelper databaseHelper;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        edtUsername = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginButton);
        txtCreateAccount = findViewById(R.id.createAccount);
        fingerprintText = findViewById(R.id.fingerprintText);

        databaseHelper = new DatabaseHelper(this);
        prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        boolean isFirstLogin = prefs.getBoolean("first_login_done", false);

        // Force show for testing — remove this after testing
        fingerprintText.setVisibility(View.VISIBLE);

        btnLogin.setOnClickListener(v -> {
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isValid = databaseHelper.checkUser(username, password);
            if (isValid) {
                prefs.edit()
                        .putBoolean("first_login_done", true)
                        .putString("saved_username", username)
                        .apply();

                Toast.makeText(this, "Login Successful. Fingerprint will be used next time.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, Dashboard.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        txtCreateAccount.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, Signup.class));
        });

        fingerprintText.setOnClickListener(v -> {
            // Show confirmation for debug
            Toast.makeText(this, "Opening Fingerprint Activity", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, FingerprintActivity.class);
            intent.putExtra("from_login_page", true);
            startActivity(intent);
        });
    }
}
