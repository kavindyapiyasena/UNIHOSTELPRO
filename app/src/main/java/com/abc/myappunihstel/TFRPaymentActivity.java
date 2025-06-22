package com.abc.myappunihstel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TFRPaymentActivity extends AppCompatActivity {

    RadioGroup paymentMethodGroup;
    Button btnPayTFR;
    TextView txtAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tfr_payment);

        txtAmount = findViewById(R.id.txtAmount);
        paymentMethodGroup = findViewById(R.id.paymentMethodGroup);
        btnPayTFR = findViewById(R.id.btnPayTFR);

        btnPayTFR.setOnClickListener(v -> {
            int selectedId = paymentMethodGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedMethod = findViewById(selectedId);
            String method = selectedMethod.getText().toString();

            Toast.makeText(this, "Processing payment via " + method, Toast.LENGTH_LONG).show();

            // Implement actual payment logic here
        });
    }
}
