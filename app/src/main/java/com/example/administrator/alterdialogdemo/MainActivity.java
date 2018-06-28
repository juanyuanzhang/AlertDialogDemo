package com.example.administrator.alterdialogdemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder builder ;
    private Dialog dialog;
    private String[] fruit_list = {"Banana","Apple","Pineapple","Orange","Strawberry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnalert = findViewById(R.id.btnalert);
        btnalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("message")
                        .setIcon(R.mipmap.question)
                        .setMessage("Are you sure?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                dialog = builder.create();  //把dialog建立出來
                dialog.show();  //顯示出dialog
            }
        });
        Button btnfruit = findViewById(R.id.butfruit);
        btnfruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Which one is your favorite?")
                        .setIcon(R.mipmap.pineapple)
                        .setSingleChoiceItems(fruit_list, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"Your choice is "+fruit_list[which],Toast.LENGTH_LONG).show();
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                dialog = builder.create();
                dialog.show();
            }
        });
    }
}
