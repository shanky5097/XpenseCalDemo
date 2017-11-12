package com.example.shanky.xpensecaldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Cal extends AppCompatActivity {
    int p1p2=0,p2p3=0,p1p3=0,p2p1=0,p3p1=0,p3p2=0;
    int spend_mode=1,amt;
    TextView tv1,tv2;
    EditText e1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        tv1=(TextView)findViewById(R.id.player1);
        tv2=(TextView)findViewById(R.id.player2);
        e1=(EditText)findViewById(R.id.editText);
        spend_mode=1;
        tv1.setText("Pay Player2:"+p1p2);
        tv2.setText("Pay Player3:"+p1p3);
        Cal.this.setTitle("Player 1 Dashboard");


    }



    public void mode1(View view){
        Cal.this.setTitle("Player 1 Dashboard");
        spend_mode=1;
        tv1.setText("Pay Player2:  "+p2p1);
        tv2.setText("Pay Player3:  "+p3p1);


    }
    public void mode2(View view){
        Cal.this.setTitle("Player 2 Dashboard");
        spend_mode=2;
        tv1.setText("Pay Player1:  "+p1p2);
        tv2.setText("Pay Player3:  "+p3p2);
    }
    public void mode3(View view){
        Cal.this.setTitle("Player 3 Dashboard");
        spend_mode=3;
        tv1.setText("Pay Player2:  "+p2p3);
        tv2.setText("Pay Player1:  "+p1p3);
    }

    public void spend(View view){
        if(spend_mode==1){
            String str=e1.getText().toString();
            amt=Integer.parseInt(str);
            p1p2+=amt/3;
            p1p3+=amt/3;
            Toast.makeText(this,"Data updated",Toast.LENGTH_SHORT).show();
            update();

        }
        if(spend_mode==2){
            String str=e1.getText().toString();
            amt=Integer.parseInt(str);
            p2p1+=amt/3;
            p2p3+=amt/3;
            Toast.makeText(this,"Data updated",Toast.LENGTH_SHORT).show();
            update();

        }
        if(spend_mode==3){
            String str=e1.getText().toString();
            amt=Integer.parseInt(str);
            p3p1+=amt/3;
            p3p2+=amt/3;
            Toast.makeText(this,"Data updated",Toast.LENGTH_SHORT).show();
            update();

        }

    }
    public void update(){
        if(p1p2<p2p1){
            p2p1-=p1p2;
            p1p2=0;
        }
        else{
            p1p2-=p2p1;
            p2p1=0;
        }
        if (p1p3<p3p1){
            p3p1-=p1p3;
            p1p3=0;
        }
        else{
            p1p3-=p3p1;
            p3p1=0;
        }
        if(p2p3<p3p2){
            p3p2-=p2p3;
            p2p3=0;
        }
        else{
            p2p3-=p3p2;
            p3p2=0;
        }
    }
}
