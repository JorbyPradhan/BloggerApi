package com.example.jb.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        ImageView imageView=(ImageView)findViewById(R.id.logo);

        TextView textView=(TextView)findViewById(R.id.texTV);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.mixed_anim);
        imageView.startAnimation(animation);
        Animation animation1= AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        textView.startAnimation(animation1);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
