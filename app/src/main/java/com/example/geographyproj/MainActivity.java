package com.example.geographyproj;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String [] countrysArry;
    String [] capitalsArry;
    String [] populationsArry;
    int [] flagsArry;
    Spinner spinner;
    CustomAdapter customAdapter;
    TextView countryTV, populationTV, capitalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.spinner);
        countryTV = findViewById(R.id.countryTV);
        populationTV = findViewById(R.id.populationTV);
        capitalTV = findViewById(R.id.capitalTV);

        countrysArry = new String [] {"choose a country", "Israel", "USA", "Japan",
                "China", "Germany", "Greece", "France"};

        capitalsArry = new String [] {" ", "Jerusalem", "Washington D.C.", "Tokyo",
                "Beijing", "Berlin", "Athens", "Paris"};

        populationsArry = new String[]{ "9 Million", "331 Million", "126 Million",
                "1.4 Billion", "83 Million", "10 Million", "67 Million"};

        flagsArry = new int [] {R.drawable.white ,R.drawable.israel, R.drawable.usa,
                R.drawable.japan, R.drawable.china, R.drawable.germany, R.drawable.greece, R.drawable.france};

        customAdapter = new CustomAdapter(this, flagsArry, countrysArry, capitalsArry);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        if (i != 0)
        {
            countryTV.setText(countrysArry[i]);
            capitalTV.setText(capitalsArry[i]);
            populationTV.setText(populationsArry[i-1]);
        }

        else
        {
            countryTV.setText("");
            capitalTV.setText("");
            populationTV.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}