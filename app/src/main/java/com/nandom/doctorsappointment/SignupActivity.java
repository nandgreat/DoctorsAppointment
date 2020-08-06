package com.nandom.doctorsappointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.nandom.doctorsappointment.data.AppDatabase;
import com.nandom.doctorsappointment.data.AppExecutors;
import com.nandom.doctorsappointment.data.User;
import com.nandom.doctorsappointment.util.Utils;

public class SignupActivity extends AppCompatActivity {

    TextInputEditText etFirstName;
    TextInputEditText etLastName;
    TextInputEditText etEmail;
    TextInputEditText etPassword;
    TextInputEditText etConfirmPassword;

    TextInputLayout etFirstNameLayout;
    TextInputLayout etLastNameLayout;
    TextInputLayout etEmailLayout;
    TextInputLayout etPasswordLayout;
    TextInputLayout etConfirmPasswordLayout;


    TextView tvLogin;

    TextView tvLastNameError;
    TextView tvEmailError;
    TextView tvPasswordError;
    TextView tvFirstNameError;

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
        if (validateInput()) {

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
    }

    private boolean validateInput() {
        String emailError = Utils.validateEmail(etEmail.getText().toString().trim());
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();

        // Check if email is valid or fields are empty
        if (!emailError.contentEquals("valid_email") || etPassword.getText().toString().isEmpty()
                || etFirstName.getText().toString().isEmpty() || etLastName.getText().toString().isEmpty()
                || !password.contentEquals(confirmPassword)) {

            etEmailLayout.setError(!emailError.contentEquals("valid_email") ? emailError : null);
            etLastNameLayout.setError(etLastName.getText().toString().isEmpty() ? "Last name is required" : null);
            etFirstNameLayout.setError(etFirstName.getText().toString().isEmpty() ? "First name field is required" : null);
            etPasswordLayout.setError(password.isEmpty() ? "Password field is required" : null);
            etConfirmPasswordLayout.setError(confirmPassword.isEmpty() ? "Confirm password field is required" : null);

            // Check if password and confirm password matches
            if (!password.isEmpty() && !confirmPassword.isEmpty() && !password.contentEquals(confirmPassword)) {
                etPasswordLayout.setError(!password.contentEquals(confirmPassword) ? "Password fields do not match is required" : null);
                etConfirmPasswordLayout.setError(!password.contentEquals(confirmPassword) ? "Password fields do not match" : null);
            }
            return false;
        } else return true;
    }

    private void initViews() {
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        etFirstNameLayout = findViewById(R.id.etFirstNameLayout);
        etLastNameLayout = findViewById(R.id.etLastNameLayout);
        etEmailLayout = findViewById(R.id.etEmailLayout);
        etPasswordLayout = findViewById(R.id.etPasswordLayout);
        etConfirmPasswordLayout = findViewById(R.id.etConfirmPasswordLayout);
        tvLogin = findViewById(R.id.tvLogin);


    }
}