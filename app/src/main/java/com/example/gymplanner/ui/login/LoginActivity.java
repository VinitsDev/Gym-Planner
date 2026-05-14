package com.example.gymplanner.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymplanner.R;
import com.example.gymplanner.database.UserDAO;
import com.example.gymplanner.model.User;
import com.example.gymplanner.ui.home.HomeActivity;
import com.example.gymplanner.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etEmail = findViewById(R.id.etLoginEmail);
        EditText etSenha = findViewById(R.id.etLoginSenha);

        Button buttonLogin = findViewById(R.id.btnEntrar);
        Button buttonRegister = findViewById(R.id.btnIrCadastrar);

        buttonLogin.setOnClickListener(view -> {

            String email = etEmail.getText().toString();
            String senha = etSenha.getText().toString();


            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            UserDAO dao = new UserDAO(LoginActivity.this);
            User user = dao.login(email, senha);

            if (user != null) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.putExtra("USER_ID", user.getId());
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
