package com.group.quizofkings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {
    private RecyclerView activeGamesRView;
    private RecyclerView passiveGamesRView;
    private Button startNewGameBtn;
    private GameActivityModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users_with_opponents);
        Bundle bundle = getIntent().getExtras();
        final String username = bundle.getString("username");
        model = new GameActivityModel();
        activeGamesRView = findViewById(R.id.active_games_recycler_view);
        passiveGamesRView = findViewById(R.id.passive_games_recycler_view);
        startNewGameBtn = findViewById(R.id.start_new_game);
        startNewGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(model.isAligible(username))
                {
                    Object user = model.getUser();
                    startRandomGame(user);
                }
            }
        });
    }

    private void startRandomGame(Object user) {
        Intent intent = new Intent(GameActivity.this, StartGameActivity.class);
        intent.putExtra("work", "random-opponent");
        intent.putExtra("currUser", user.toString());
    }
}