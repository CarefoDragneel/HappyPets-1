package com.example.happypets.Activity;

import static com.example.happypets.Activity.LoginActivity.token;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.happypets.R;

public class SPlashScreenActivity extends Activity {
    private ImageView logo;
    private TextView title,slogan;
    public static boolean isLoggedIn=false;
    Animation topAnimation,bottomAnimation;
    public static SharedPreferences userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        logo = findViewById(R.id.logo);
        title = findViewById(R.id.title);
        slogan = findViewById(R.id.slogan);
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        logo.setAnimation(topAnimation);
        title.setAnimation(bottomAnimation);
        slogan.setAnimation(bottomAnimation);


        int SPLASH_SCREEN = 4500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                userInfo=getSharedPreferences(LoginActivity.PREFERENCE_DETAIL,MODE_PRIVATE);
                boolean isLoggedIn=userInfo.getBoolean("hasLoggedIn",false);
                String userId=userInfo.getString("userId",null);
                token=userInfo.getString("token",null);
                if(isLoggedIn && userId!=null && token!=null) intent=new Intent(SPlashScreenActivity.this,MainActivity.class);
                else
                intent = new Intent(SPlashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN );

    }
}
