package com.example.retrofitrecycleview.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofitrecycleview.R;

public class SplashScreen extends AppCompatActivity {

    Animation topAnim, bottomAnim;

    TextView text1, text2;
    ImageView image;

    private static int SPLASH_SCREEN = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.topanimation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottomanimation);

        image = findViewById(R.id.splash_iamge);
        text1 = findViewById(R.id.splash_text1);
        text2 = findViewById(R.id.splash_text2);

        image.setAnimation(bottomAnim);
        text1.setAnimation(topAnim);
        text2.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}