package com.group.quizofkings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartGameActivity extends AppCompatActivity {
    private Button turnBtn;
    private RecyclerView selfGamesView;
    private RecyclerView opponentGameView;
    private StartGameModel model = new StartGameModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        turnBtn = findViewById(R.id.turn_button);
        selfGamesView = findViewById(R.id.self_games_scores);
        opponentGameView = findViewById(R.id.opponent_games_score);
        turnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(model.isSelfTurn())
                {
                    Intent questionsIntent = new Intent(StartGameActivity.this, QuestionLoaderActivity.class);
                    startActivity(questionsIntent);
                }
            }
        });

    }
}