package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

public class Accessibility extends Dialog {
    private TextView txt_contents;
    private Button checkPhoneClick;
    private ImageButton backHome;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    public Accessibility(@NonNull Context context, String buttonLabel,String contents) {
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
                // 접근성 설정 화면으로 이동
//                Intent intent = new Intent();
//                intent.setClassName("com.android.settings", "com.android.settings.Settings$MagnificationSettingsActivity");
//                startActivity(intent);
//                dialog.dismiss();
                Intent intent = new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS);
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
