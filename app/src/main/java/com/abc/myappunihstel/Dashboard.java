package com.abc.myappunihstel;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    // Dashboard Buttons
    Button btnAddMembers, btnAddPayment, btnStudentReg, btnInquiries, btnStaffContact,
            btnComplains, btnDirection, btnPaymentDue, btnInOut, btnViewTFR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard); // <-- your drawer+dashboard XML

        // Drawer setup
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Lambda-style navigation drawer listener
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_dashboard) {
                startActivity(new Intent(Dashboard.this, Dashboard.class));
            } else if (id == R.id.nav_data) {
                startActivity(new Intent(Dashboard.this, DataActivity.class));
            } else if (id == R.id.nav_search) {
                startActivity(new Intent(Dashboard.this, SearchActivity.class));
            } else if (id == R.id.nav_browse) {
                startActivity(new Intent(Dashboard.this, BrowseActivity.class));
            } else if (id == R.id.nav_services) {
                startActivity(new Intent(Dashboard.this, ServicesActivity.class));
            } else if (id == R.id.nav_users) {
                startActivity(new Intent(Dashboard.this, UsersActivity.class));
            } else if (id == R.id.nav_shares_user) {
                startActivity(new Intent(Dashboard.this, SharesUserActivity.class));
            } else if (id == R.id.nav_shares) {
                startActivity(new Intent(Dashboard.this, SharesActivity.class));
            } else if (id == R.id.nav_services_sub) {
                startActivity(new Intent(Dashboard.this, ServicesActivity.class));
            } else if (id == R.id.nav_email) {
                startActivity(new Intent(Dashboard.this, EmailActivity.class));
            }
            drawerLayout.closeDrawers();
            return true;
        });

        // Initialize dashboard buttons
        btnAddMembers = findViewById(R.id.btnAddMembers);
        btnAddPayment = findViewById(R.id.btnAddPayment);
        btnStudentReg = findViewById(R.id.btnStudentReg);
        btnInquiries = findViewById(R.id.btnInquiries);
        btnStaffContact = findViewById(R.id.btnStaffContact);
        btnComplains = findViewById(R.id.btnComplains);
        btnDirection = findViewById(R.id.btnDirection);
        btnPaymentDue = findViewById(R.id.btnPaymentDue);
        btnInOut = findViewById(R.id.btnInOut);
        btnViewTFR = findViewById(R.id.btnViewTFR);

        // Button click actions
        btnAddMembers.setOnClickListener(v -> startActivity(new Intent(this, AddMembersActivity.class)));
        btnAddPayment.setOnClickListener(v -> startActivity(new Intent(this, AddPaymentActivity.class)));
        btnStudentReg.setOnClickListener(v -> startActivity(new Intent(this, StudentRegActivity.class)));
        btnInquiries.setOnClickListener(v -> startActivity(new Intent(this, StudentInquiriesActivity.class)));
        btnStaffContact.setOnClickListener(v -> startActivity(new Intent(this, StaffContactActivity.class)));
        btnComplains.setOnClickListener(v -> startActivity(new Intent(this, ComplaintFormActivity.class)));
        btnDirection.setOnClickListener(v -> startActivity(new Intent(this, MapActivity.class)));
        btnPaymentDue.setOnClickListener(v -> startActivity(new Intent(this, PaymentDueActivity.class)));
        btnInOut.setOnClickListener(v -> startActivity(new Intent(this, QrActivity.class)));
        btnViewTFR.setOnClickListener(v -> startActivity(new Intent(this, TFRPaymentActivity.class)));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
