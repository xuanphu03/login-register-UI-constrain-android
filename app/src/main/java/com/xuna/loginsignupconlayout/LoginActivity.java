package com.xuna.loginsignupconlayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView registerNowTxt = findViewById(R.id.registernow_txt);
        TextView resultValue = findViewById(R.id.textfild_txt);

        EditText username_ip = findViewById(R.id.username_input);
        EditText password_ip = findViewById(R.id.password_input);

        Button login_btn = findViewById(R.id.signin_btn);

        registerNowTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                final String username_string = username_ip.getText().toString();
                final String password_string = password_ip.getText().toString();
                final String valueString = "Account\nUsername: " + username_string + "\nPassword: " + password_string;

                if (!username_string.isEmpty() && !password_string.isEmpty()) {
                    resultValue.setText(valueString);
                } else {
                    resultValue.setText("Not value");
                }

                username_ip.setText("");
                password_ip.setText("");
            }
        });
    }
}