package com.abc.myappunihstel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result); // Link to your XML layout

        // Bind views
        TextView tvDate = findViewById(R.id.tv_date);
        TextView tvInTime = findViewById(R.id.tv_in_time);
        TextView tvOutTime = findViewById(R.id.tv_out_time);

        // Get current date and time
        String currentDate = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date());
        String inTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());

        // Set text
        tvDate.setText(currentDate);
        tvInTime.setText(inTime);
        tvOutTime.setText("9.00 AM"); // This can be updated based on your logic
    }
}
