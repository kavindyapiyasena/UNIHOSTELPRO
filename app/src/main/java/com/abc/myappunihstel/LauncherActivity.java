package com.abc.myappunihstel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean isFirstLogin = prefs.getBoolean("first_login_done", false);

        if (isFirstLogin) {
            startActivity(new Intent(this, FingerprintActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }
        finish();
    }
}
