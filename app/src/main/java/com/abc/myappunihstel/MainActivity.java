package com.abc.myappunihstel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView websiteLink, loginLink;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Ensure this layout file exists

        // Initialize views
        websiteLink = findViewById(R.id.websiteLink);
        loginLink = findViewById(R.id.loginLink);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Open website
        websiteLink.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ou.ac.lk/"));
            startActivity(browserIntent);
        });

        // Open login page from login link
        loginLink.setOnClickListener(v -> {
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });

        // Open login page from login button
        buttonLogin.setOnClickListener(v -> {
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });
    }
}
