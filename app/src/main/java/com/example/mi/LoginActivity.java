package com.example.mi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.content.Intent;
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        String savedUsername = getIntent().getStringExtra("username");
        String savedPassword = getIntent().getStringExtra("password");
        EditText username = findViewById(R.id.usernameInput);
        EditText password = findViewById(R.id.passwordInput);
        if (savedUsername != null && savedPassword != null) {
            username.setText(savedUsername);
            password.setText(savedPassword);
        }
        Button loginButton = findViewById(R.id.loginButton);
        TextView registerText = findViewById(R.id.registerText);
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(LoginActivity.this,
                            "יש למלא שם משתמש וסיסמה",
                            Toast.LENGTH_SHORT).show();
                }
                if (savedUsername != null && savedPassword != null
                        && user.equals(savedUsername)
                        && pass.equals(savedPassword)) {
                    Toast.makeText(LoginActivity.this,
                            "הכניסה הצליחה!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this,
                            "שם משתמש או סיסמה שגויים",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}