package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_fontSize;
    private Button btn_easyMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //다이얼로그 밖의 화면은 흐리게 만들어줌
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);

        //액션 바(타이틀 바) 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btn_fontSize = findViewById(R.id.btn_fontSize);
        btn_easyMode = findViewById(R.id.btn_easyMode);

        btn_fontSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog("1. 설정에 들어간다.\n2. '휴대전화 정보'를 클릭한다.");
            }
        });

        btn_easyMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog("1. 설정에 들어간다.\n2. '쉬운 사용 모드'를 클릭한다.");
            }
        });

    }

    private void showCustomDialog(String contents) {
        CustomDialog customDialog = new CustomDialog(MainActivity.this, contents);
        customDialog.show();
    }
}
