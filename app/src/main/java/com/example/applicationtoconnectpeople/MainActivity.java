package com.example.applicationtoconnectpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText PhoneNumberIP,PasswordIP;
    Button LoginBTN,RegisterBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhoneNumberIP = findViewById(R.id.PhoneNumberInput);
        PasswordIP = findViewById(R.id.PasswordInput);
        LoginBTN = findViewById(R.id.LoginButton);
        RegisterBTN = findViewById(R.id.RegisterBTN);

        RegisterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistrationPage.class));
            }
        });

        LoginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputPhone = PhoneNumberIP.getText().toString();
                String inputPassword = PasswordIP.getText().toString();
                if(inputPassword.isEmpty() || inputPhone.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter the details properly",Toast.LENGTH_SHORT).show();
                }
                else{
                    UserDetailsDatabase userDetailsDatabase = UserDetailsDatabase.getUserDetailsDatabase(getApplicationContext());
                    final UserDetailsDao userDetailsDao = userDetailsDatabase.userDetailsDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserDetails userDetails = userDetailsDao.login(inputPhone,inputPassword);
                            if(userDetails == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this,"Incorrect Credentials,try again!",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            else{
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(MainActivity.this,OptionChooseActivity.class)
                                                .putExtra("phone_number",inputPhone)
                                                .putExtra("password",inputPassword));
                                    }
                                });
                            }
                        }
                    }).start();
                }
            }
        });
    }
}