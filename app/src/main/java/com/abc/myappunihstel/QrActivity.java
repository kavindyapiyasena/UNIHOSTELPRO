package com.abc.myappunihstel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class QrActivity extends AppCompatActivity {

    Button btn_scan;
    CheckBox checkIn, checkOut;

    // QR scanner launcher
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(
            new ScanContract(),
            result -> {
                if (result.getContents() != null) {
                    // Get checkbox status
                    String status = "";
                    if (checkIn.isChecked()) status += "IN selected\n";
                    if (checkOut.isChecked()) status += "OUT selected\n";
                    if (status.isEmpty()) status = "No status selected\n";

                    // Show alert with scan result and selected status
                    AlertDialog.Builder builder = new AlertDialog.Builder(QrActivity.this);
                    builder.setTitle("Scan Result");
                    builder.setMessage("QR Code: " + result.getContents() + "\n" + status);
                    builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
                    builder.show();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_activity);

        // Bind views
        btn_scan = findViewById(R.id.btn_scan);
        checkIn = findViewById(R.id.checkbox_in);
        checkOut = findViewById(R.id.checkbox_out);

        // Scan button logic
        btn_scan.setOnClickListener(v -> scanCode());
    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to turn on flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }
}
