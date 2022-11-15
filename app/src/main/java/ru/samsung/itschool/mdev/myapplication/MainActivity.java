package ru.samsung.itschool.mdev.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button4;
    private ToggleButton tg;
    private TextView textView;
    private int counter = 0;

    private MediaPlayer mp;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.PoplaukhinId);
        button4 = findViewById(R.id.button4);
        tg = findViewById(R.id.toggleButton);
        textView = findViewById(R.id.textView2);
        button.setOnClickListener(view -> {
            counter++;
            String result = "Вы тыкнули на мою кнопочку " + Integer.toString(counter);
            textView.setText(result);
                });
        button4.setOnClickListener(view -> {
            if(flag) {
                button4.setBackgroundColor(Color.BLACK);
                flag = false;
            } else  {
                button4.setBackgroundColor(Color.RED);
                flag = true;
            }

        });
        tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    ///CommentNow

    public void doPlay(View v)
    {
        mp = MediaPlayer.create(this, R.raw.strom);
        mp.start();
    }

    public void doStop(View v)
    {
        mp.pause();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("value",counter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("value");
        textView.setText(Integer.toString(counter));
    }
}