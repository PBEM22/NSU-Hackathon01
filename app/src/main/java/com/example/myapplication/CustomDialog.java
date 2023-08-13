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

public class CustomDialog extends Dialog {

    private TextView txt_contents;
    private Button checkPhoneClick;
    private ImageButton backHome;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    public CustomDialog(@NonNull Context context, String contents) {
        super(context);
        setContentView(R.layout.activity_custom_dialog);

        txt_contents = findViewById(R.id.txt_contents);
        txt_contents.setText(contents);
        checkPhoneClick = findViewById(R.id.btn_onsetting);
        backHome = findViewById(R.id.btn_shutdown);

        checkPhoneClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
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
