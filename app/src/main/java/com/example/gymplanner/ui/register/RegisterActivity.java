package com.example.gymplanner.ui.register;

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
import com.example.gymplanner.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText etNome = findViewById(R.id.etRegisterNome);
        EditText etEmail = findViewById(R.id.etRegisterEmail);
        EditText etSenha = findViewById(R.id.etRegisterSenha);
        EditText etConfirmar = findViewById(R.id.etRegisterConfirmarSenha);

        Button buttonCadastrar = findViewById(R.id.btnCadastrar);
        Button buttonVoltar = findViewById(R.id.btnVoltarLogin);

        buttonCadastrar.setOnClickListener(view -> {

            String nome = etNome.getText().toString();
            String email = etEmail.getText().toString();
            String senha = etSenha.getText().toString();
            String confirmar = etConfirmar.getText().toString();

            UserDAO dao = new UserDAO(RegisterActivity.this);


            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }


            if (!senha.equals(confirmar)) {
                Toast.makeText(RegisterActivity.this, "Senhas diferentes", Toast.LENGTH_SHORT).show();
                return;
            }


            if (dao.checkEmail(email)) {
                Toast.makeText(RegisterActivity.this, "Email já cadastrado", Toast.LENGTH_SHORT).show();
                return;
            }


            User user = new User();
            user.setName(nome);
            user.setEmail(email);
            user.setPassword(senha);

            boolean sucesso = dao.insert(user);

            if (sucesso) {
                Toast.makeText(RegisterActivity.this, "Cadastro realizado!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            } else {
                Toast.makeText(RegisterActivity.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
            }
        });

        buttonVoltar.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }
}
