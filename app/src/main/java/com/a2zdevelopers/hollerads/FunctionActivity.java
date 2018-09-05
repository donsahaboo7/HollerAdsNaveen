package com.a2zdevelopers.hollerads;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class FunctionActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    FunctionRecyclerAdapter functionRecyclerAdapter;
    String[] data;
    int[] salary;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        Bundle bundle = getIntent().getExtras();
        position = bundle.getInt(MainRecyclerAdapter.POSITION);
        loadData();

        toolbar = findViewById(R.id.fToolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);


        recyclerView = findViewById(R.id.functionRecycler);
        functionRecyclerAdapter = new FunctionRecyclerAdapter(this, data,salary);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(functionRecyclerAdapter);


    }

    private void loadData() {
        switch (position){
            case 0:
                data = getResources().getStringArray(R.array.webdeveloper);
                salary = getResources().getIntArray(R.array.salary);
                break;
            case 1:
                data = getResources().getStringArray(R.array.appdeveloper);
                salary = getResources().getIntArray(R.array.salary);

                break;
            case 2:
                data = getResources().getStringArray(R.array.logodesign);
                salary = getResources().getIntArray(R.array.salary);

                break;
            case 3:
                data = getResources().getStringArray(R.array.seo);
                salary = getResources().getIntArray(R.array.salary);

                break;
            case 4:
                data = getResources().getStringArray(R.array.smo);
                salary = getResources().getIntArray(R.array.salary);

                break;
            case 5:
                data = getResources().getStringArray(R.array.smm);
                salary = getResources().getIntArray(R.array.salary);

                break;
            case 6:
                data = getResources().getStringArray(R.array.marcketing);
                salary = getResources().getIntArray(R.array.salary);

                break;
            case 7:
                data = getResources().getStringArray(R.array.contentwriting);
                salary = getResources().getIntArray(R.array.salary);

                break;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_function,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort:
                Toast.makeText(this, "List Shorted", Toast.LENGTH_SHORT).show();
                Arrays.sort(salary);
                functionRecyclerAdapter.notifyDataSetChanged();
                break;

        }
        return true;
    }
}
