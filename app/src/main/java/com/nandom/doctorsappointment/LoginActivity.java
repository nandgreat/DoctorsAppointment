package com.nandom.doctorsappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nandom.doctorsappointment.data.AppDatabase;
import com.nandom.doctorsappointment.data.AppExecutors;
import com.nandom.doctorsappointment.data.User;
import com.nandom.doctorsappointment.util.SharedPrefManager;
import com.nandom.doctorsappointment.util.Utils;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    TextView tvEmailError;
    TextView tvPasswordError;
    private AppDatabase appDatabase;

    SharedPrefManager sharedPrefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        initViews();

        sharedPrefManager = new SharedPrefManager(this);

        // Check if user is logged in
        if (sharedPrefManager.isLoggedIn()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }else
            Toast.makeText(this, "No user logged in", Toast.LENGTH_SHORT).show();

        appDatabase = AppDatabase.getInstance(getApplicationContext());

        findViewById(R.id.tvSignup).setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, SignupActivity.class)));
    }

    public void login(View view) {

        if (validateInput()) {
            AppExecutors.getInstance().diskIO().execute(() -> {
                User user = appDatabase.userDao().loginUser(etEmail.getText().toString(), etPassword.getText().toString());
                if (user != null) {
                    this.runOnUiThread(() -> Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show());
                    sharedPrefManager.setLoggedInUser(user);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    this.runOnUiThread(() -> Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show());
                }
            });
        }
    }

    private boolean validateInput() {
        String emailError = Utils.validateEmail(etEmail.getText().toString().trim());
        if (!emailError.contentEquals("valid_email") || etPassword.getText().toString().isEmpty()) {
            tvEmailError.setVisibility(View.VISIBLE);
            tvEmailError.setText(emailError);
            tvPasswordError.setVisibility(View.VISIBLE);
            return false;
        } else return true;
    }


    public void initViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvEmailError = findViewById(R.id.tvEmailError);
        tvPasswordError = findViewById(R.id.tvPasswordError);

    }
}