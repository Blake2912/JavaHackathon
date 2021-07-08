package com.example.applicationtoconnectpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NGOActivity extends AppCompatActivity {
    TextView ngo1,ngo2,ngo3,ngo4,ngo5,ngo6,ngo7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngoactivity);
        ngo1 = findViewById(R.id.NGO1);
        ngo2 = findViewById(R.id.NGO2);
        ngo3 = findViewById(R.id.NGO3);
        ngo4 = findViewById(R.id.NGO4);
        ngo5 = findViewById(R.id.NGO5);
        ngo6 = findViewById(R.id.NGO6);
        ngo7 = findViewById(R.id.NGO7);

        ngo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.missionoxygen.org/");
            }
        });
        ngo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.swasth.org/index.html");
            }
        });
        ngo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.sphoorti.org/");
            }
        });

        ngo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://teasngo.org/");
            }
        });

        ngo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.concernindiafoundation.org/");
            }
        });

        ngo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://gautamgambhirfoundation.org");
            }
        });

        ngo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.akshayapatra.org");
            }
        });
    }
    private void gotoURL(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}