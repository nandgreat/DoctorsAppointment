package com.nandom.doctorsappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nandom.doctorsappointment.util.Utils;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Utils.hideSoftKeyboard(this, findViewById(R.id.etEmail));

        findViewById(R.id.tvSignup).setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, SignupActivity.class)));
    }
    public void login(View view){
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}