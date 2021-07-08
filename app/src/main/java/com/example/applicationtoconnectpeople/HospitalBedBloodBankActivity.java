package com.example.applicationtoconnectpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HospitalBedBloodBankActivity extends AppCompatActivity {
    Button bedStatusBTN,BloodBankInfoBTN,DonorInfoBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_bed_blood_bank);
        bedStatusBTN = findViewById(R.id.COVIDBedButton);
        BloodBankInfoBTN = findViewById(R.id.bloodbankButton);
        DonorInfoBTN = findViewById(R.id.DonorInfoButton);

        bedStatusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HospitalBedBloodBankActivity.this,HospitalBedListsActivity.class));
            }
        });

        BloodBankInfoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://indianhelpline.com/BLOOD-BANKS/");
            }
        });

        DonorInfoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.nhp.gov.in/organ-donation-day_pg");
            }
        });


    }
    private void gotoURL(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}