package com.example.callswipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    float x1;
    float x2;
    float y1;
    float y2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch (touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1=touchEvent.getX() ;
                y1=touchEvent.getY() ;
                break ;
            case MotionEvent.ACTION_UP:
                x2=touchEvent.getX() ;
                y2=touchEvent.getY() ;

                if(y1>y2){
                        Intent intent = new Intent(MainActivity.this,call.class);
                    startActivity(intent);
                }
        }
        return false ;
    }
}