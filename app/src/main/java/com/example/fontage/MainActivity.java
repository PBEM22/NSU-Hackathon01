package com.example.fontage;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View logo = findViewById(R.id.logo);
        logo.bringToFront();
    }

}