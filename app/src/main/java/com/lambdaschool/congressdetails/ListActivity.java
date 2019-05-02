package com.lambdaschool.congressdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lambdaschool.congressdataapiaccess.CongressDao;
import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<CongresspersonOverview> congresspersonOverviewArrayList=CongressDao.getAllMembers();

        RecyclerView recyclerView = findViewById(R.id.list_activity_recycler_view_location);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListActivityAdapter listActivityAdapter = new ListActivityAdapter(congresspersonOverviewArrayList);
        recyclerView.setAdapter(listActivityAdapter);
        recyclerView.setHasFixedSize(true);
    }
}
