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

public class CustomDialog extends Dialog {
    private TextView txt_contents;
    private Button checkPhoneClick;
    private ImageButton backHome;

    public CustomDialog(@NonNull Context context, String buttonLabel, String contents, String type) {
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
                if (type.equals("device")) {
                    showDeviceInfo(context);
                } else if (type.equals("accessibility")) {
                    showAccessibility(context);
                } else if (type.equals("mode")) {
                    showMode(context);
                } else if(type.equals("app")) {
                    showApp(context);
                }
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

    private void showDeviceInfo(Context context) {
        Intent intent = new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS);
        context.startActivity(intent);
    }

    private void showAccessibility(Context context) {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        context.startActivity(intent);
    }

    private void showMode(Context context) {
        Intent intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
        context.startActivity(intent);
    }

    private void showApp(Context context) {
        Intent intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
        context.startActivity(intent);
    }
}
