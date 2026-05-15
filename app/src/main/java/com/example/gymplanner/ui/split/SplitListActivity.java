package com.example.gymplanner.ui.split;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymplanner.R;
import com.example.gymplanner.database.SplitDAO;
import com.example.gymplanner.model.Split;
import com.example.gymplanner.ui.history.TrainingHistoryActivity;

import com.example.gymplanner.ui.training.StartTrainingActivity;

import java.util.ArrayList;
import java.util.List;

public class SplitListActivity extends AppCompatActivity {

    private int userId;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_list);

        userId = getIntent().getIntExtra("USER_ID", -1);

        listView = findViewById(R.id.lvSplitList);

        loadSplits();

        Button buttonNovoTreino = findViewById(R.id.btnCriarNovoSplit);
        buttonNovoTreino.setOnClickListener(view -> {
            Intent intent = new Intent(SplitListActivity.this, SplitCreateActivity.class);
            intent.putExtra("USER_ID", userId);
            startActivity(intent);
        });

        ImageButton buttonNavTreino = findViewById(R.id.btnNavTreino);
        buttonNavTreino.setOnClickListener(view -> {
            startActivity(new Intent(SplitListActivity.this, StartTrainingActivity.class));
        });

        ImageButton buttonNavSplit = findViewById(R.id.btnNavSplit);
        buttonNavSplit.setOnClickListener(view -> {
        });

        ImageButton buttonNavHistory = findViewById(R.id.btnNavHistory);
        buttonNavHistory.setOnClickListener(view -> {
            startActivity(new Intent(SplitListActivity.this, TrainingHistoryActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadSplits();
    }


    private void loadSplits() {

        SplitDAO dao = new SplitDAO(this);
        List<Split> splits = dao.listSplit(userId);

        List<String> nomes = new ArrayList<>();
        for (Split s : splits) {
            nomes.add(s.getName());
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomes);

        listView.setAdapter(adapter);
    }
}

