
package com.example.fontagee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ImageButton magni;
    private ImageButton btn_fontSize;
    private ImageButton btn_easyMode;
    private ImageButton app;
    private ImageButton phone_info;
    private ImageButton btn_exit;
    private TextView  buttonLabel;

    private void setWindowDim(boolean dim) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        if (dim) {
            lp.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            lp.dimAmount = 0.8f; // 흐리게 설정할 정도를 0과 1사이로 설정 (예: 0.1f)
            getWindow().setAttributes(lp);
        } else {
            lp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            getWindow().setAttributes(lp);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 액션 바(타이틀 바) 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        magni = findViewById(R.id.magni);
        btn_fontSize = findViewById(R.id.btn_fontSize);
        btn_easyMode = findViewById(R.id.btn_easyMode);
        app = findViewById(R.id.app);
        phone_info = findViewById(R.id.phone_info);
        btn_exit = findViewById(R.id.btn_exit);

        magni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWindowDim(true); // 화면 흐리게 만듦
                showCustomDialog("화면 확대하기", "1. 이동하기 버튼 \n2. 시인성 향상 \n3. 확대", "accessibility");
            }
        });

        btn_fontSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWindowDim(true); // 화면 흐리게 만듦
                showCustomDialog("글자 크기 변경", "1. 이동하기 버튼 \n2. 글자 크기와 스타일 \n3. 맨 아래 파란 점을 좌우로","mode");
            }
        });

        btn_easyMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWindowDim(true); // 화면 흐리게 만듦
                showCustomDialog("쉬운 모드 사용","1. 이동하기 버튼을 누른다. \n 2. 아래에서 위로 끌어올리면서 '쉬운 사용 모드'가 찾는다. \n 3. '쉬운 사용 모드' 글씨를 누르고 한번 더 누른다.", "mode");
            }
        });

        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWindowDim(true); // 화면 흐리게 만듦
                showCustomDialog("어플리케이션 권한 설정","1. 이동하기 버튼을 누른다. \n 2. 아래에서 위로 끌어올리면서 '쉬운 사용 모드'가 찾는다. \n 3. '쉬운 사용 모드' 글씨를 누르고 한번 더 누른다.", "app");
            }
        });

        phone_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWindowDim(true); // 화면 흐리게 만듦
                showCustomDialog("휴대전화 정보 확인","1. 설정에 들어간다.\n 2. 화면을 맨 아래로 내린다.\n 3. '휴대전화 정보' 를 클릭한다.", "device");
            }
        });
    }

    private void showAdPopup() {

        Dialog adDialog = new Dialog(MainActivity.this);
        adDialog.setContentView(R.layout.activity_addialog);

        Button closeButton = adDialog.findViewById(R.id.closeButton);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adDialog.dismiss();
            }
        });

        adDialog.show();
    }

    private void showCustomDialog(String buttonLabel, String contents,  String type) {
        CustomDialog customDialog = new CustomDialog(MainActivity.this, buttonLabel, contents, type);
        customDialog.show();
    }
}