package com.example.shanky.xpensecaldemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);



    }
    public void sendMessage(View view) {
        Intent it=new Intent(this,Cal.class);
        startActivity(it);
    }
}
