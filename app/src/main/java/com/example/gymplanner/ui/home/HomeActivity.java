package com.example.gymplanner.ui.home;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymplanner.R;
import com.example.gymplanner.ui.history.TrainingHistoryActivity;
import com.example.gymplanner.ui.login.LoginActivity;
import com.example.gymplanner.ui.split.SplitListActivity;
import com.example.gymplanner.ui.training.StartTrainingActivity;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        int userId = getIntent().getIntExtra("USER_ID", -1);

        ImageView buttonSair = findViewById(R.id.btnSair);
        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        ImageButton buttonNavTreino = findViewById(R.id.btnNavTreino);
        buttonNavTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, StartTrainingActivity.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);


            }
        });

        ImageButton buttonNavSplit = findViewById(R.id.btnNavSplit);
        buttonNavSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, SplitListActivity.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);

            }
        });

        ImageButton buttonNavHistory = findViewById(R.id.btnNavHistory);
        buttonNavHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, TrainingHistoryActivity.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);

            }
        });

    }
}
