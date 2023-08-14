package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button[] buttons;
    private int[] buttonIds = {R.id.magni, R.id.btn_fontSize, R.id.btn_easyMode, R.id.phone_info};
    private String[] buttonLabels = {"화면 확대하기", "글자 크기 변경", "쉬운 모드 사용", "휴대전화 정보 확인"};
    private String[] contents = {
            "1. 이동하기 버튼 \n2. 시인성 향상 \n3. 확대",
            "1. 이동하기 버튼 \n2. 글자 크기와 스타일 \n3. 맨 아래 파란 점을 좌우로",
            "1. 이동하기 버튼을 누른다. \n2. 아래에서 위로 끌어올리면서 '쉬운 사용 모드'가 찾는다. \n3. '쉬운 사용 모드' 글씨를 누르고 한번 더 누른다.",
            "1. 설정에 들어간다.\n2. 화면을 맨 아래로 내린다.\n3. '휴대전화 정보' 를 클릭한다."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dimBackground();
        hideActionBar();

        buttons = new Button[buttonIds.length];
        for (int i = 0; i < buttonIds.length; i++) {
            buttons[i] = findViewById(buttonIds[i]);
            final int index = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog(buttonLabels[index], contents[index]);
                }
            });
        }
    }

    private void dimBackground() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);
    }

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void showDialog(String buttonLabel, String content) {
        CustomDialog customDialog = new CustomDialog(MainActivity.this, buttonLabel, content);
        customDialog.show();
    }
}
