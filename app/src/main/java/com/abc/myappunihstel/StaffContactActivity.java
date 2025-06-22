package com.abc.myappunihstel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StaffContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_contact);

        ImageButton callKavisha = findViewById(R.id.call_kavisha);
        ImageButton callSamadhi = findViewById(R.id.call_samadhi);
        ImageButton callJaneesha = findViewById(R.id.call_janeesha);

        callKavisha.setOnClickListener(v -> dialPhone("0121234567"));
        callSamadhi.setOnClickListener(v -> dialPhone("0113456723"));
        callJaneesha.setOnClickListener(v -> dialPhone("0119876350"));
    }

    private void dialPhone(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }
}
