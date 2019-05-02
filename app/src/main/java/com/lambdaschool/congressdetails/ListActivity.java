package com.lambdaschool.congressdetails;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final RecyclerView recyclerView = findViewById(R.id.list_activity_recycler_view_location);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CongressPersonOverviewViewModel congressPersonOverviewViewModel = ViewModelProviders.of(this).get(CongressPersonOverviewViewModel.class);
        congressPersonOverviewViewModel.getCongressPersonOverviewList().observe(this, new Observer<ArrayList<CongresspersonOverview>>() {
            @Override
            public void onChanged(@Nullable ArrayList<CongresspersonOverview> congresspersonOverviewArrayList) {
                ListActivityAdapter listActivityAdapter = new ListActivityAdapter(congresspersonOverviewArrayList);
                recyclerView.setAdapter(listActivityAdapter);
                recyclerView.setHasFixedSize(true);
            }
        });
    }
}
