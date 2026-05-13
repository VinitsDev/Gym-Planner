package com.example.gymplanner.ui.training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymplanner.R;

public class StartTrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_training);

        Button buttonStartTraining = findViewById(R.id.btnComecarTreino);
        buttonStartTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StartTrainingActivity.this, TrainingInProgressActivity.class);
                startActivity(intent);

            }
        });


    }
}
