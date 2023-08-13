package com.example.fontage;

import android.app.Activity;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog {
    private Activity activity;
    private TextView txt_contents;
    private Button checkPhoneClick;
    private Button backHome;
    private TextView ex;

    //생성자
    @SuppressLint("MissingInflatedId")
    public CustomDialog(@NonNull Context context, String contents) {
        super(context);
        setContentView(R.layout.activity_custom_dialog);

        txt_contents = findViewById(R.id.txt_contents);
        txt_contents.setText(contents);

        ex = findViewById(R.id.ex); // 'ex' TextView 가져오기

        // 'ex' TextView에 밑줄 추가
        SpannableString exSpannable = new SpannableString(ex.getText());
        exSpannable.setSpan(new UnderlineSpan(), 0, ex.getText().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ex.setText(exSpannable);

        checkPhoneClick = findViewById(R.id.btn_checkPhone);
        backHome = findViewById(R.id.btn_backHome);


        checkPhoneClick.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                //설정으로 이동하는 코드
                Intent intent = new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS);
                getContext().startActivity(intent);  //startActivityForResult() 는 호출한 Activity로 부터 결과를 받을 경우 사용.
                dismiss();//버튼을 눌렀을 때 창을 닫아주는 함수 ->
            }
        }));

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                dismiss();  //버튼을 눌렀을 떄 창을 닫아주는 함수
            }
        });

    }
}
