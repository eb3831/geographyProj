package com.example.geographyproj;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String [] countrysArry;
    String [] capitalsArry;
    int [] flagsArry;
    Spinner spinner;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.spinner);

        countrysArry = new String [] {"Israel", "USA", "Japan", "China", "Germany", "Greece", "France"};
        capitalsArry = new String [] {"Jerusalem", "Washington D.C.", "Tokyo", "Beijing", "Berlin", "Athens", "Paris"};
        flagsArry = new int [] {R.drawable.israel, R.drawable.usa, R.drawable.japan, R.drawable.china,
                R.drawable.germany, R.drawable.greece, R.drawable.france};

        customAdapter = new CustomAdapter(this, flagsArry, countrysArry, capitalsArry);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {

    }
}