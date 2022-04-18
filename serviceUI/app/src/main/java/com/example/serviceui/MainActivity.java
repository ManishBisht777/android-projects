package com.example.serviceui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean x;
    String TAG ="com.example.serviceui";
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1,btn2,btn3;

        btn1=findViewById(R.id.button2);
        btn2=findViewById(R.id.button3);
        btn3=findViewById(R.id.button4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        TextView txt=findViewById(R.id.textView);
        x=true;

        switch (v.getId())
        {
            case R.id.button2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long  ThreadID = Thread.currentThread().getId();
                        Log.i(TAG , "main Thread: " + ThreadID);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                txt.setText(String.valueOf(ThreadID));
                            }
                        });
                    }
                }).start();
                break;

            case R.id.button3:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (x) {
                            String id = String.valueOf(Thread.currentThread().getId());
                            txt.setText("id: "+id);
                            Log.i(TAG, "ID: " + Thread.currentThread().getId());
                        }
                    }
                }).start();
                break;

            case R.id.button4:
                x=false;
                break;
        }
    }
}