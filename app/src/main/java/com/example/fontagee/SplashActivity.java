package com.example.fontagee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.splashscreen.SplashScreen;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        // 스플래시 화면 설정 후 메인 액티비티로 전환
        startActivity(new Intent(this, MainActivity.class));
        finish(); // 스플래시 액티비티를 종료
    }
}