package com.example.gymplanner.ui.split;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymplanner.R;
import com.example.gymplanner.ui.home.HomeActivity;

public class SplitCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_create);

        ImageButton buttonVoltar = findViewById(R.id.btnVoltar);
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SplitCreateActivity.this, SplitListActivity.class);
                startActivity(intent);

            }
        });

        Button buttonCriarSplit = findViewById(R.id.btnCriarSplit);
        buttonCriarSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SplitCreateActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

    }
}
