package com.nandom.doctorsappointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.nandom.doctorsappointment.data.AppDatabase;
import com.nandom.doctorsappointment.data.AppExecutors;
import com.nandom.doctorsappointment.data.User;
import com.nandom.doctorsappointment.util.Utils;

public class SignupActivity extends AppCompatActivity {

    EditText etFirstName;
    EditText etLastName;
    EditText etEmail;
    EditText etPassword;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Utils.hideSoftKeyboard(this, findViewById(R.id.etFirstName));

        initViews();

        findViewById(R.id.tvLogin).setOnClickListener(v -> {
            Intent loginIntent = new Intent(SignupActivity.this, LoginActivity.class);
            loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(loginIntent);
        });
    }

    public void onSignupButtonClicked(View view) {

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());

        User user = new User(
                etFirstName.getText().toString(),
                etLastName.getText().toString(),
                etEmail.getText().toString(),
                etPassword.getText().toString()
        );

        AppExecutors.getInstance().diskIO().execute(() -> {
            appDatabase.userDao().signupUser(user);
            this.runOnUiThread(() -> Toast.makeText(SignupActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show());
            finish();
        });
    }

    private void initViews() {
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvLogin = findViewById(R.id.tvLogin);
    }
}