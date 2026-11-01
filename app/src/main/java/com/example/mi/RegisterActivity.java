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
import android.content.Intent;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        EditText username = findViewById(R.id.registerUserNameInput);
        EditText password = findViewById(R.id.registerPasswordInput);
        EditText confirmPassword = findViewById(R.id.confirmPasswordInput);
        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String confirm = confirmPassword.getText().toString();

                if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                    Toast.makeText(RegisterActivity.this,
                            "יש למלא את כל השדות",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!pass.equals(confirm)) {
                    Toast.makeText(RegisterActivity.this,
                            "הסיסמאות אינן תואמות",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(RegisterActivity.this,
                        "ההרשמה הצליחה!",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("username", user);
                intent.putExtra("password", pass);
                startActivity(intent);
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}