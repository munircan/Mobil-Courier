package com.example.mobilkurye;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_OUT = 3500;

    Animation top_anim, bot_anim;
    ImageView image;
    TextView logo, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bot_anim = AnimationUtils.loadAnimation(this, R.anim.bot_anim);

        image = findViewById(R.id.imageView);
        logo = findViewById(R.id.textView2);
        info = findViewById(R.id.textView3);

        image.setAnimation(top_anim);
        logo.setAnimation(bot_anim);
        info.setAnimation(bot_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(image, "logoImage");
                pairs[1] = new Pair<View, String>(logo, "logoText");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        }, SPLASH_SCREEN_OUT);

    }
}