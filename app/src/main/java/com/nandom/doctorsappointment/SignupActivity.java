package com.nandom.doctorsappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.nandom.doctorsappointment.util.Utils;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Utils.hideSoftKeyboard(this, findViewById(R.id.etFirstName));

        findViewById(R.id.tvLogin).setOnClickListener(v ->{
            Intent loginIntent = new Intent(SignupActivity.this, LoginActivity.class);
            loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(loginIntent);

        });
    }
}