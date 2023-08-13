package com.example.fontage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.fontage.CustomDialog;
import com.example.fontage.R;

public class MainActivity extends AppCompatActivity {

    //변수선언
    private Button btn_check;
    private CustomDialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //어플을 실행했을떄 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //다이얼로그 밖의 화면은 흐리게 만들어줌
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);


        btn_check = findViewById(R.id.btn_check);   //버튼변수에 xml에 만는 버튼 넣어줌
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//버튼을 눌렀을때 할 실행될 코드 적기



                // 여기서 customDialog를 생성하고 show() 메서드를 호출하면 됨
                customDialog = new CustomDialog(MainActivity.this,"\n     1. 설정에 들어간다.\n     2. 화면을 맨 아래로 내린다.\n     3. '휴대전화 정보' 를 클릭한다.");
                customDialog.show();
            }
        });
    }
}