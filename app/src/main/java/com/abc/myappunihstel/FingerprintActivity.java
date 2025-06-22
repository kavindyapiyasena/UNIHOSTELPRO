package com.abc.myappunihstel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Executor;

public class FingerprintActivity extends AppCompatActivity {

    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    boolean launchedFromLogin = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fingerprint); // Make sure fingerprint.xml exists and is valid

        // Check if launched from LoginActivity
        launchedFromLogin = getIntent().getBooleanExtra("from_login_page", false);

        // Check biometric support
        BiometricManager biometricManager = BiometricManager.from(this);
        int canAuthenticate = biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG);

        if (canAuthenticate != BiometricManager.BIOMETRIC_SUCCESS) {
            if (!launchedFromLogin) {
                Toast.makeText(this, "Biometric authentication not supported or not set up", Toast.LENGTH_LONG).show();
            }
            finish();
            return;
        }

        // Setup biometric prompt
        Executor executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(FingerprintActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

                if (!launchedFromLogin) {
                    Toast.makeText(FingerprintActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }

                // Go to Home or Dashboard after successful auth
                startActivity(new Intent(FingerprintActivity.this, Dashboard.class)); // or HomeActivity.class
                finish();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                if (!launchedFromLogin) {
                    Toast.makeText(FingerprintActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Prompt config
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Fingerprint Login")
                .setDescription("Use your fingerprint to login")
                .setNegativeButtonText("Cancel")
                .build();

        // Start biometric auth
        biometricPrompt.authenticate(promptInfo);
    }
}
