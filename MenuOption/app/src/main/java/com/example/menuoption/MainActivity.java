package com.example.menuoption;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getTitle().toString())
        {
            case "Title One":
                Toast.makeText(this, "Item 1 is selected", Toast.LENGTH_SHORT).show();
            case "Title Two":
                Toast.makeText(this, "Item 2 is selected", Toast.LENGTH_SHORT).show();
            case "Title Three":
                Toast.makeText(this, "Item 3 is selected", Toast.LENGTH_SHORT).show();
            case "Title Four":
                Toast.makeText(this, "Item 4 is selected", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}