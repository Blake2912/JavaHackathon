package com.example.applicationtoconnectpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OptionChooseActivity extends AppCompatActivity {
    TextView displayUserName;
    Button BedAvailableBTN,NgoBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_choose);
        displayUserName = findViewById(R.id.DisplayUserName);
        BedAvailableBTN = findViewById(R.id.BedAvailabilityBTN);
        NgoBTN = findViewById(R.id.ngoButton);

        String phone_number = getIntent().getStringExtra("phone_number");
        String password_temp = getIntent().getStringExtra("password");
        UserDetailsDatabase userDetailsDatabase = UserDetailsDatabase.getUserDetailsDatabase(getApplicationContext());
        final UserDetailsDao userDetailsDao = userDetailsDatabase.userDetailsDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                UserDetails userDetails = userDetailsDao.findCustomer(phone_number,password_temp);
                String customerName = userDetails.getName();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayUserName.setText(customerName);
                    }
                });
            }
        }).start();

        BedAvailableBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptionChooseActivity.this,HospitalBedBloodBankActivity.class));
            }
        });

        NgoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptionChooseActivity.this,NGOActivity.class));
            }
        });


    }
}