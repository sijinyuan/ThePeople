package com.people.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.people.R;

import java.util.Timer;
import java.util.TimerTask;

public class FlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/sijinyuan.ttf");
        TextView textView = (TextView) findViewById(R.id.textViewsijinyuan);
        textView.setTypeface(tf);
        Timer tiemr=new Timer();
        tiemr.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(FlashActivity.this,MainActivity.class));
                finish();
            }
        },3000);
    }
}
