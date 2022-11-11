package ru.samsung.itschool.mdev.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private int counter = 0;

    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.PoplaukhinId);

        textView = findViewById(R.id.textView2);
        button.setOnClickListener(view -> {
            counter++;
            String result = "Вы тыкнули на мою кнопочку " + Integer.toString(counter);
            textView.setText(result);
                });
    }

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