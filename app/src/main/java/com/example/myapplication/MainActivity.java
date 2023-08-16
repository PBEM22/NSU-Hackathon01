
package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppCompatImageButton magni;
    private AppCompatImageButton btn_fontSize;
    private AppCompatImageButton btn_easyMode;
    private AppCompatImageButton app;
    private AppCompatImageButton phone_info;
    private AppCompatImageButton btn_exit;
    private TextView buttonLabel;

    private int clickCount = 0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //액션 바(타이틀 바) 없애기
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
                // 카운터 증가
                clickCount++;

                // 5번마다 광고 팝업창 띄우기
                if (clickCount % 5 == 0) {
                    showAdPopup();
                } else {
                    showCustomDialog("화면 확대하기", "1. 이동하기 버튼 \n2. '시인성 향상' 클릭 \n3. 확대 바로가기 클릭", "accessibility");
                }
            }
        });

        btn_fontSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickCount++;

                if (clickCount % 5 == 0) {
                    showAdPopup();
                } else {
                    showCustomDialog("글자 크기 변경", "1. 이동하기 버튼 \n2. 글자 크기와 스타일 \n3. 맨 아래 파란 점을 좌우로", "mode");
                }
            }
        });

        btn_easyMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickCount++;

                if (clickCount % 5 == 0) {
                    showAdPopup();
                } else {
                    showCustomDialog("쉬운 모드 사용", "1. 이동하기 버튼 \n2. 화면을 내리면서 \n    '쉬운 사용 모드' 찾기 \n3. '쉬운 사용 모드' 클릭 \n4. 한번 더 클릭", "mode");
                }
            }
        });
        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickCount++;

                if (clickCount % 5 == 0) {
                    showAdPopup();
                } else {
                    showCustomDialog("어플 권한 설정", "1. 이동하기 버튼 \n2. 화면을 내리면서 \n    원하는 앱 찾기 \n3. 권한 클릭 \n4. 원하는 권한 설정", "app");
                }
            }
        });

        phone_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickCount++;

                if (clickCount % 5 == 0) {
                    showAdPopup();
                } else {
                    showCustomDialog("휴대전화 정보 확인", "1. 이동하기 버튼 \n2. 화면을 맨 아래로 내림 \n3. '휴대전화 정보' 클릭", "device");
                }
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("정말로 종료하시겠습니까?");
                builder.setTitle("종료 알림창")
                        .setCancelable(false)
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("종료 알림창");
                alert.show();
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

        clickCount = 0; // 카운터 초기화
    }


    private void showCustomDialog(String buttonLabel, String contents,  String type) {

        CustomDialog customDialog = new CustomDialog(MainActivity.this, buttonLabel, contents, type);
        customDialog.show();
    }


}