package com.group.quiz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GamePageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //todo just for testing, this is not the main activity of the app
        recyclerView = findViewById(R.id.recycler);
        PersonUI[] personUIS = new PersonUI[5];
        for (int i = 0; i < 5; i++)
            personUIS[i] = new PersonUI(android.R.drawable.btn_star, "somebody");
        MyListAdapter adapter = new MyListAdapter(personUIS);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}