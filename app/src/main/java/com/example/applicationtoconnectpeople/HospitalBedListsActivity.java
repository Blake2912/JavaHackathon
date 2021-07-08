package com.example.applicationtoconnectpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HospitalBedListsActivity extends AppCompatActivity {
    Button ApBTN,DlBTN,GaBTN,KaBTN,KlBTN,MpBTN,RjBTN,TnBTN,TsBTN,UpBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_bed_lists);
        ApBTN = findViewById(R.id.AP);
        DlBTN = findViewById(R.id.DL);
        GaBTN = findViewById(R.id.GA);
        KaBTN = findViewById(R.id.KA);
        KlBTN = findViewById(R.id.KL);
        MpBTN = findViewById(R.id.MP);
        RjBTN = findViewById(R.id.RJ);
        TnBTN = findViewById(R.id.TN);
        TsBTN = findViewById(R.id.TS);
        UpBTN = findViewById(R.id.UPS);

        ApBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("http://dashboard.covid19.ap.gov.in/ims/hospbed_reports/");
            }
        });

        DlBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://coronabeds.jantasamvad.org/");
            }
        });

        GaBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://goaonline.gov.in/beds");
            }
        });

        KaBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.powerbi.com/view?r=eyJrIjoiOTcyM2JkNTQtYzA5ZS00MWI4LWIxN2UtZjY1NjFhYmFjZDBjIiwidCI6ImQ1ZmE3M2I0LTE1MzgtNGRjZi1hZGIwLTA3NGEzNzg4MmRkNiJ9");
            }
        });

        KlBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://covid19jagratha.kerala.nic.in/home/addHospitalDashBoard");
            }
        });

        MpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://covidmp.com/");
            }
        });

        RjBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://covidinfo.rajasthan.gov.in/Covid-19hospital-wisebedposition-wholeRajasthan.aspx");
            }
        });

        TnBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://tncovidbeds.tnega.org");
            }
        });

        TsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://covid19.telangana.gov.in/health-facilities/treatment-facilities/");
            }
        });

        UpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("http://dgmhup.gov.in/en/CovidReport");
            }
        });

    }

    private void gotoURL(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}