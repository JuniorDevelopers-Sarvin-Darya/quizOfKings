package com.group.quizofkings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class GameListAdaptor extends RecyclerView.Adapter<GameListAdaptor.ViewHolder>
{
    private GameUI[] gameUIS = new GameUI[6];
    @NonNull
    @Override
    public GameListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View gameModel = inflater.inflate(R.layout.game_item, parent, false);
        return new ViewHolder(gameModel);
    }

    @Override
    public void onBindViewHolder(@NonNull GameListAdaptor.ViewHolder holder, int position) {
        final GameUI ui = gameUIS[position];
        holder.b1.setText(ui.getFirstWinLoseState());
        holder.b2.setText(ui.getSecondQuestionText());
        holder.b3.setText(ui.getThirdQuestionText());

    }

    @Override
    public int getItemCount() {
        return 6;
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private Button b1, b2, b3;
        private ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            b1 = itemView.findViewById(R.id.button1);
            b2 = itemView.findViewById(R.id.button2);
            b3 = itemView.findViewById(R.id.button3);
            layout = itemView.findViewById(R.id.layout_play);
        }
    }
}
