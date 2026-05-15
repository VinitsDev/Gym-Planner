package com.example.gymplanner.ui.split;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymplanner.R;
import com.example.gymplanner.database.SplitDAO;
import com.example.gymplanner.model.Split;
import com.example.gymplanner.ui.home.HomeActivity;

public class SplitCreateActivity extends AppCompatActivity {

    private int userId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_create);

        userId = getIntent().getIntExtra("USER_ID", -1);

        EditText etName = findViewById(R.id.etSplitNome);
        EditText etDescricao = findViewById(R.id.etSplitDescricao);

        ImageButton buttonVoltar = findViewById(R.id.btnVoltar);
        Button buttonCriarSplit = findViewById(R.id.btnCriarSplit);


        buttonVoltar.setOnClickListener(view -> {
            finish();
        });


        buttonCriarSplit.setOnClickListener(view -> {

            String nome = etName.getText().toString();
            String descricao = etDescricao.getText().toString();

            if (nome.isEmpty()) {
                Toast.makeText(this, "Digite o nome do treino", Toast.LENGTH_SHORT).show();
                return;
            }

            Split split = new Split();
            split.setName(nome);
            split.setDescricption(descricao);
            split.setUserId(userId);

            SplitDAO dao = new SplitDAO(this);

            boolean sucesso = dao.insert(split);

            if (sucesso) {
                Toast.makeText(this, "Treino criado com sucesso!", Toast.LENGTH_SHORT).show();
                finish(); // volta pra lista
            } else {
                Toast.makeText(this, "Erro ao criar treino", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

