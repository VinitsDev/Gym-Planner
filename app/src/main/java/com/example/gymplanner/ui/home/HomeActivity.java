package com.example.gymplanner.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymplanner.R;
import com.example.gymplanner.ui.history.TrainingHistoryActivity;
import com.example.gymplanner.ui.split.SplitListActivity;
import com.example.gymplanner.ui.training.StartTrainingActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        ImageButton buttonNavTreino = findViewById(R.id.btnNavTreino);
        buttonNavTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, StartTrainingActivity.class);
                startActivity(intent);


            }
        });

        ImageButton buttonNavSplit = findViewById(R.id.btnNavSplit);
        buttonNavSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, SplitListActivity.class);
                startActivity(intent);

            }
        });

        ImageButton buttonNavHistory = findViewById(R.id.btnNavHistory);
        buttonNavHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, TrainingHistoryActivity.class);
                startActivity(intent);

            }
        });

    }
}
