package com.example.shoppingrecover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    myAdapter adapter;
    public ArrayList<String> items = new ArrayList<String>();
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize the list from the device data
        ReadList();

        //Add new item from AddItem Activity
        String NewItemString;
        if (savedInstanceState == null ) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                NewItemString= null;
            } else {
                NewItemString= extras.getString("Item");
                if(!NewItemString.isEmpty()) {
                    items.add(NewItemString);
                }

            }
        } else {
            NewItemString= (String) savedInstanceState.getSerializable("Item");
            if(!NewItemString.isEmpty()) {
                items.add(NewItemString);
            }
        }
        //--------------------------------------------------------------

        //save the list into the device
        SaveList(items);

        //if the list is not empty, show the recyclerView
        if (!items.isEmpty()) {
            recyclerView = findViewById(R.id.recyclerview);
            adapter = new myAdapter(this, items);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

           adapter.setOnItemClickListener(new myAdapter.OnItemClickListener() {
            @Override
             public void onItemClick(int position) {

            Toast.makeText(MainActivity.this, items.get(position),
                        Toast.LENGTH_SHORT).show();
              }

               @Override
               public void onChecklClick(int position) {
                   Toast.makeText(MainActivity.this, "check!",
                           Toast.LENGTH_SHORT).show();
                   RemoveItem(position);
               }
           });
        }

        add = findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddItem.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    public void SaveList(ArrayList<String>listToSave)
    {
        SharedPreferences.Editor editor = getSharedPreferences("ShoppingList", MODE_PRIVATE).edit();
        Set<String> set = new HashSet<String>();
        set.addAll(listToSave);
        editor.putStringSet("MyList", set);
        editor.commit();
    }

    public void ReadList()
    {
        Set<String> defaultSet = new HashSet<String>();
        defaultSet.add("No items");
        SharedPreferences prefs = getSharedPreferences("ShoppingList", MODE_PRIVATE);
        if(prefs != null) {
            items.addAll(prefs.getStringSet("MyList", defaultSet));
        }
    }


    public void RemoveItem(int position)
    {
        items.remove(position);
        adapter.notifyItemRemoved(position);
        SaveList(items);
    }

}