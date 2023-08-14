package com.example.myapplication;

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
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Device extends Dialog {
    private TextView txt_contents;
    private Button checkPhoneClick;
    private ImageButton backHome;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    public Device(@NonNull Context context, String buttonLabel,String contents) {
        super(context);
        setContentView(R.layout.activity_custom_dialog);

        txt_contents = findViewById(R.id.txt_contents);
        txt_contents.setText(contents);
        TextView labelTextView = findViewById(R.id.buttonLabel);
        labelTextView.setText(buttonLabel);

        checkPhoneClick = findViewById(R.id.btn_onsetting);
        backHome = findViewById(R.id.btn_shutdown);

        checkPhoneClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                //설정으로 이동하는 코드
                Intent intent = new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS);
                context.startActivity(intent);
                dismiss();
            }
        });

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                dismiss();
            }
        });
    }
}

