package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddVisitor extends AppCompatActivity {
    EditText et1,et2,et3,et4;
    Button bv1,bv2;
    String getfname,getlname,getpurp,getwhmeet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_visitor);
        et1=(EditText) findViewById(R.id.fname);
        et2=(EditText) findViewById(R.id.lname);
        et3=(EditText) findViewById(R.id.purp);
        et4=(EditText) findViewById(R.id.whmeet);
        bv1=(Button) findViewById(R.id.sub);
        bv2=(Button) findViewById(R.id.gback);
        bv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getfname=et1.getText().toString();
                getlname=et2.getText().toString();
                getpurp=et3.getText().toString();
                getwhmeet=et4.getText().toString();
                Toast.makeText(getApplicationContext(),(getfname+getlname+getpurp+getwhmeet),Toast.LENGTH_LONG).show();
            }
        });
        bv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        };
    }
