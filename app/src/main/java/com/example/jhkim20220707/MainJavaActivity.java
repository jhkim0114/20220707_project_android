package com.example.jhkim20220707;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MainJavaActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {




        Button buttonEvent = findViewById(R.id.button_event);
        buttonEvent.setOnClickListener(v -> {

        });
    }


}
