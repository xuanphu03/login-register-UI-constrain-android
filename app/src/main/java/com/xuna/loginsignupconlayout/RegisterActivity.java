package com.xuna.loginsignupconlayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView loginTxt = findViewById(R.id.login_txt);
        TextView resultValue = findViewById(R.id.textfild_txt);

        EditText fullname_ip = findViewById(R.id.fullname_input);
        EditText username_ip = findViewById(R.id.username_input);
        EditText email_ip = findViewById(R.id.email_input);
        EditText password_ip = findViewById(R.id.password_input);
        EditText cfpassword_ip = findViewById(R.id.cfpassword_input);

        Button signup_btn = findViewById(R.id.signup_btn);

        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });


        signup_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                final String fullname = fullname_ip.getText().toString();
                final String username = username_ip.getText().toString();
                final String email = email_ip.getText().toString();
                final String password = password_ip.getText().toString();
                final String cfpassword = cfpassword_ip.getText().toString();
                final String valueString = "Account\nUsername: " + username + "\nPassword: " + password + "\nFullname: " + fullname + "\nEmail: "+ email;

                if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    resultValue.setText("Error!!!");
                } else {
                    if (password.equals(cfpassword)) {
                        resultValue.setText(valueString);
                    }
                    else {
                        resultValue.setText("Confirm password is not match");
                    }
                }

                username_ip.setText("");
                password_ip.setText("");
                email_ip.setText("");
                fullname_ip.setText("");
                cfpassword_ip.setText("");
            }
        });
    }
}