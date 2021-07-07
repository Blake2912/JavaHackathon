package com.example.applicationtoconnectpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OptionChooseActivity extends AppCompatActivity {
    TextView displayUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_choose);
        displayUserName = findViewById(R.id.DisplayUserName);
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

    }
}