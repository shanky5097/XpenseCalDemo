package com.example.shanky.xpensecaldemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
    EditText e1,e2;


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
            mode1(view);

        }
        if(spend_mode==2){
            String str=e1.getText().toString();
            amt=Integer.parseInt(str);
            p2p1+=amt/3;
            p2p3+=amt/3;
            Toast.makeText(this,"Data updated",Toast.LENGTH_SHORT).show();
            update();
            mode2(view);

        }
        if(spend_mode==3){
            String str=e1.getText().toString();
            amt=Integer.parseInt(str);
            p3p1+=amt/3;
            p3p2+=amt/3;
            Toast.makeText(this,"Data updated",Toast.LENGTH_SHORT).show();
            update();
            mode3(view);

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
    public void pay1(final View view){

        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setMessage("Enter the amount you wish to pay");
        obj.setTitle("ALERT");
         e2=new EditText(Cal.this);
        obj.setView(e2);
        obj.setPositiveButton("Pay",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int amt=Integer.parseInt(e2.getText().toString());
                switch (spend_mode){
                    case 1:
                        if(p2p1>=amt) {
                            p2p1 -= amt;
                            Toast.makeText(Cal.this,"Data Updated",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Cal.this,"Invalid Amount",Toast.LENGTH_SHORT).show();
                        mode1(view);
                        break;
                    case 2:
                        if(p1p2>=amt) {
                            p1p2 -= amt;
                            Toast.makeText(Cal.this,"Data Updated",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Cal.this,"Invalid Amount",Toast.LENGTH_SHORT).show();
                        mode2(view);
                        break;
                    case 3:
                        if(p2p3>=amt) {
                            p2p3 -= amt;
                            Toast.makeText(Cal.this,"Data Updated",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Cal.this,"Invalid Amount",Toast.LENGTH_SHORT).show();
                        mode3(view);
                        break;
                }

            }
        });
        obj.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        obj.show();
    }
    public void pay2(final View view){

        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setMessage("Enter the amount you wish to pay");
        obj.setTitle("ALERT");
        e2=new EditText(Cal.this);
        obj.setView(e2);
        obj.setPositiveButton("Pay",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int amt=Integer.parseInt(e2.getText().toString());
                switch (spend_mode){
                    case 1:
                        if(p3p1>=amt) {
                            p3p1 -= amt;
                            Toast.makeText(Cal.this,"Data Updated",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Cal.this,"Invalid Amount",Toast.LENGTH_SHORT).show();
                        mode1(view);
                        break;
                    case 2:
                        if(p3p2>=amt) {
                            p3p2 -= amt;
                            Toast.makeText(Cal.this,"Data Updated",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Cal.this,"Invalid Amount",Toast.LENGTH_SHORT).show();
                        mode2(view);
                        break;
                    case 3:
                        if(p1p3>=amt) {
                            p1p3 -= amt;
                            Toast.makeText(Cal.this,"Data Updated",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Cal.this,"Invalid Amount",Toast.LENGTH_SHORT).show();
                        mode3(view);
                        break;
                }

            }
        });
        obj.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        obj.show();
    }


}
