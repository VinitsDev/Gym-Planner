package com.example.gymplanner.ui.training;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymplanner.R;
import com.example.gymplanner.ui.home.HomeActivity;

public class TrainingInProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_progress_training);

        ImageButton btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TrainingInProgressActivity.this, StartTrainingActivity.class);
                startActivity(intent);
            }
        });

        Button buttonFinalizarTreino = findViewById(R.id.btnFinalizarTreino);
        buttonFinalizarTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TrainingInProgressActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
