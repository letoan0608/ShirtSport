package com.toan_it.soccershirt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  SearchView.OnQueryTextListener{


    GridView gridView;
    ArrayList<Shirt> arrayList;
    GridViewAdapter gridViewAdapter;
    SearchView searchView;

    public MainActivity() {
        arrayList = new ArrayList<Shirt>();


        Shirt vietNam = new Shirt("vietnam", "VIET NAM CLUB SOCCER", "Adidas", "$130");
        Shirt brazil = new Shirt("brazil", "BRAZIL CLUB SOCCER", "Nike", "$140");
        Shirt chelsea = new Shirt("chelsea", "CHELSEA CLUB SOCCER", "Adidas", "$135");
        Shirt liverpool = new Shirt("liverpool", "BO DAO NHA CLUB SOCCER", "Adidas", "$120");
        Shirt arsenal = new Shirt("arsenal", "ARSENAL CLUB SOCCER", "Nike", "$150");
        Shirt milan = new Shirt("milan", "MILAN CLUB SOCCER", "Adidas", "$110");


        arrayList.add(vietNam);
        arrayList.add(brazil);
        arrayList.add(chelsea);
        arrayList.add(liverpool);
        arrayList.add(arsenal);
        arrayList.add(milan);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        //Search
        gridView.setTextFilterEnabled(false);
        setUpSearchView();
        //GridView Click Item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, arrayList.get(position).getTenhinh(), Toast.LENGTH_SHORT).show();
                Object object = gridView.getItemAtPosition(position);

                Shirt s = (Shirt)object;


                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                String image = s.getTenhinh();
                String name = s.getTenhinh();
                String brand = s.getNhanhieu();
                String price = s.getGia();

                intent.putExtra("image",image);
                intent.putExtra("name",name);
                intent.putExtra("brand",brand);
                intent.putExtra("price",price);

                startActivity(intent);

            }
        });
    }

    private void AnhXa() {
        gridView = findViewById(R.id.gridView);
        searchView = findViewById(R.id.searchView);
        gridViewAdapter = new GridViewAdapter(this, R.layout.gridview_shirt, arrayList);
        gridView.setAdapter(gridViewAdapter);
    }

    public void setUpSearchView() {
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(false);
        searchView.setQueryHint("Search Here");

    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Filter filter = gridViewAdapter.getFilter();
        filter.filter(newText);

        return true;
    }

}
