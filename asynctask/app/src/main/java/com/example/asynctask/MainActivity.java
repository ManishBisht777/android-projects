package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyAsyncTask myasyncTask;
    Integer temp;
    TextView progress;
    ProgressBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button start = findViewById(R.id.button);
        Button resume = findViewById(R.id.button2);
        Button stop = findViewById(R.id.button3);

        start.setOnClickListener(this);
        resume.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        progress=findViewById(R.id.textView);
        bar=findViewById(R.id.progressBar);

        switch (v.getId()){
            case R.id.button:
                myasyncTask= new MyAsyncTask();
                myasyncTask.execute(0);
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                myasyncTask.cancel(true);
                break;
        }
    }

    class MyAsyncTask extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected Integer doInBackground(Integer... integers) {
            temp=integers[0];
            try{
                while(temp<100){
                    Thread.sleep(50);
                    temp++;
                    publishProgress(temp);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return temp;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Initial value : 0", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Toast.makeText(MainActivity.this, "Final Value :"  + integer.toString(), Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progress.setText(values[0].toString()+" %");
            bar.setProgress(values[0]);
        }
    }


}