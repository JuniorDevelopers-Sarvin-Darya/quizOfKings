package com.group.quizofkings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class GameAdaptor extends RecyclerView.Adapter<GameAdaptor.ViewHolder>
{
    private PersonModel[] personModels;

    public GameAdaptor(PersonModel[] personModels)
    {
        this.personModels = personModels;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View personModel = inflater.inflate(R.layout.person_item, parent, false);
        return new ViewHolder(personModel);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PersonModel model = personModels[position];
        holder.imageView.setImageResource(model.getImageID());
        holder.textView.setText(model.getName());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo
                //load games
            }
        });
    }

    @Override
    public int getItemCount() {
        return personModels.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageView;
        private TextView textView;
        private ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_opponent_list);
            textView = itemView.findViewById(R.id.opponent_username);
            imageView = itemView.findViewById(R.id.opponent_image);
        }

    }
}
