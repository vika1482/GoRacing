package com.example.goracing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class activity_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_second1);
        final ImageView userCar = (ImageView) findViewById(R.id.userCar);
        final ImageView computerCar = (ImageView) findViewById(R.id.computerCar);
        ImageView finish = (ImageView) findViewById(R.id.finish);
        Button drive_btn = (Button) findViewById(R.id.btn_drive);
        Button start_btn = (Button) findViewById(R.id.btn_start);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float translationX = computerCar.getTranslationX();
                float translationY = computerCar.getTranslationY();
                TranslateAnimation animation = new TranslateAnimation(translationX, translationX+2600, translationY,translationX);
                animation.setDuration(TimeUnit.SECONDS.toMillis(4L));
                animation.setFillAfter(true);
                computerCar.startAnimation(animation);
            }
        });

        drive_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                float translationX = userCar.getTranslationX();
                float translationY = userCar.getTranslationY();
                TranslateAnimation animation = new TranslateAnimation(translationX, translationX+2600, translationY,translationX);
                animation.setDuration(TimeUnit.SECONDS.toMillis(2L));
                animation.setFillAfter(true);
                userCar.startAnimation(animation);

                return false;
            }
        });
    }
}