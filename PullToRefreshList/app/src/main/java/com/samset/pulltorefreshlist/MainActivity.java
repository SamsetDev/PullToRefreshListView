package com.samset.pulltorefreshlist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] items = new String[]{
                "India", "U.S.A.", "Nepal", "Bhotan", "Pakistan", "China", "Bangladesh", "Myanmar", "Taivan", "Iron", "Afganistan", "British"
        };

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (SwipeRefreshLayout) findViewById(R.id.swype);
        layout.setOnRefreshListener(this);

        // Set the refresh swype color scheme
        layout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void onRefresh() {
        // I create a handler to stop the refresh and show a message after 3s
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                layout.setRefreshing(false);
                Toast.makeText(MainActivity.this, "Update.. !", Toast.LENGTH_LONG).show();
            }

        }, 3000);


    }
}

