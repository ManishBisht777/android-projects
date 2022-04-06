package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner=findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.images, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ImageView img=findViewById(R.id.sampleimgview);
        switch (position)
        {
            case 0:
                img.setImageResource(R.drawable.ic_launcher_background);
                break;
            case 1:
                img.setImageResource(R.drawable.profile);
                break;
            case 2:
                img.setImageResource(R.drawable.ether);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}