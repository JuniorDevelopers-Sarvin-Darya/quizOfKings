package com.group.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SettingActivity extends AppCompatActivity {
    private Button changeUserNameBtn;
    private Button changePasswordBtn;
    private CheckBox musicBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        changeUserNameBtn = findViewById(R.id.change_username_btn);
        changePasswordBtn = findViewById(R.id.change_password_btn);
        musicBox = findViewById(R.id.music_checkbox);
        //todo connect this activity to others
        if(musicBox.isChecked())
        {
            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.imagine);
            mediaPlayer.start();
        }
        changeUserNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ChangeUserNameActivity.class);
                startActivity(intent);
                //todo send person data when using this

            }
        });
        changePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                //todo send person data
            }
        });
        musicBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo change user music field
            }
        });

    }
}