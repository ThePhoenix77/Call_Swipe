package com.example.callswipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class call extends AppCompatActivity {
    EditText numerotelephone ;
    FloatingActionButton callButton ;
    static int PERMISSION_CODE=100 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        numerotelephone=findViewById(R.id.edittextphone) ;
        callButton=findViewById(R.id.callbutton) ;

        if (ContextCompat.checkSelfPermission(call.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(call.this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
        }

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numtelephone=numerotelephone.getText().toString() ;
                Intent intent=new Intent(Intent.ACTION_CALL) ;
                intent.setData(Uri.parse(""+numtelephone)) ;
                startActivity(intent);
            }
        });
    }
}