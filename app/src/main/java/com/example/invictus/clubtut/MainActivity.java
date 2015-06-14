package com.example.invictus.clubtut;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    Toolbar toolbar;

    RecyclerView recyler;

    List<UserModel> users = Collections.EMPTY_LIST;

    String[] names = {"john", "ken", "sany", "purity", "john", "ken", "sany", "purity"};
    int[] images = {R.drawable.aj, R.drawable.ao, R.drawable.e, R.drawable.j,
            R.drawable.k, R.drawable.o, R.drawable.z, R.drawable.aj};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        recyler = (RecyclerView) findViewById(R.id.recycler);



        LinearLayoutManager layout = new LinearLayoutManager(this);
        //GridLayoutManager layout=new GridLayoutManager();
        recyler.setLayoutManager(layout);

        //init list
        users = new ArrayList<>();

        for (int x = 0; x < names.length; x++) {
            users.add(new UserModel(names[x], images[x]));
        }


        recyler.setAdapter(new myRecyclerAdapter(this, users));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
