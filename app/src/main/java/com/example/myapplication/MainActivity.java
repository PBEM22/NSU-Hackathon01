package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_fontSize;
    private Button btn_easyMode;
    private TextView  buttonLabel;

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
                showCustomDialog("글자 크기 변경", "1. 이동하기 버튼 \n2. 글자 크기와 스타일 \n3. 맨 아래 파란 점을 좌우로");
            }
        });

        btn_easyMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog("쉬운 모드 사용","1. 이동하기 버튼을 누른다. \n 2. 아래에서 위로 끌어올리면서 '쉬운 사용 모드'가 찾는다. \n 3. '쉬운 사용 모드' 글씨를 누르고 한번 더 누른다.");
            }
        });

    }

    private void showCustomDialog(String buttonLabel, String contents) {
        CustomDialog customDialog = new CustomDialog(MainActivity.this, buttonLabel, contents);
        customDialog.show();
    }


}
