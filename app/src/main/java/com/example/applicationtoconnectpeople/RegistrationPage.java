package com.example.applicationtoconnectpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    EditText NameRegister,PhoneNumberRegister,PasswordRegister,ConfirmPassword;
    Button RegisterUserBTN;

    String TempPassword,TempConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        NameRegister = findViewById(R.id.NameRegInput);
        PhoneNumberRegister = findViewById(R.id.PhoneRegInput);
        PasswordRegister = findViewById(R.id.PasswordRegInput);
        ConfirmPassword = findViewById(R.id.PasswordConfirmInput);
        RegisterUserBTN = findViewById(R.id.RegisterUserBTN);

        RegisterUserBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDetails userDetails = new UserDetails();
                userDetails.setName(NameRegister.getText().toString());
                userDetails.setPhone_number(PhoneNumberRegister.getText().toString());
                TempPassword = PasswordRegister.getText().toString();
                TempConfirmPassword = ConfirmPassword.getText().toString();
                if(TempPassword.equals(TempConfirmPassword)){
                    userDetails.setPassword(TempPassword);
                }
                else{
                    Toast.makeText(RegistrationPage.this,"Please enter the password properly!",Toast.LENGTH_SHORT).show();
                }

                if(ValidateInput(userDetails)){
                    UserDetailsDatabase userDetailsDatabase = UserDetailsDatabase.getUserDetailsDatabase(getApplicationContext());
                    final UserDetailsDao userDetailsDao = userDetailsDatabase.userDetailsDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDetailsDao.insert(userDetails);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegistrationPage.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegistrationPage.this,MainActivity.class));
                                }
                            });
                        }
                    }).start();
                }
                else{
                    Toast.makeText(RegistrationPage.this,"Please enter all details properly!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    Boolean ValidateInput(UserDetails userDetails){
        if(userDetails.getName().isEmpty() ||
                userDetails.getPhone_number().isEmpty() ||
                userDetails.getPassword().isEmpty()){
            return false;
        }
        return true;
    }
}