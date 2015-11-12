package com.uv.sortinglist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    String[] month = new String[] { "Jan","Feb","Mar","Apr","May","Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    ArrayAdapter<String> monthArrayAdapter;

    ArrayList<String> months = new ArrayList<String>(Arrays.asList(month));
    ListView monthList;
    Button asc, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setListeners();
    }

    private void setListeners() {
        asc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(months);
                monthArrayAdapter.notifyDataSetChanged();
            }
        });

        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(months, Collections.reverseOrder());
                monthArrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initializeViews() {

        asc = (Button) findViewById(R.id.asc);
        desc = (Button) findViewById(R.id.desc);
        monthList = (ListView) findViewById(R.id.months);
        monthArrayAdapter = new ArrayAdapter<String>(this, R.layout.list_white_text, R.id.list_content, months);
        monthList.setAdapter(monthArrayAdapter);
    }


}
