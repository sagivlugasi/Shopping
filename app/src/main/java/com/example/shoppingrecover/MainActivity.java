package com.example.shoppingrecover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> items = new ArrayList<String>();
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        if (intent.getStringArrayListExtra("List") != null) {
            items = intent.getStringArrayListExtra("List");
        }


        items.add("חלב");
        items.add("מים");
        items.add("סוכר");
        items.add("שמן");
        items.add("קורנפלקס");
        items.add("אבקת כביסה");
        items.add("חטיפים");
        items.add("מים");




        recyclerView = findViewById(R.id.recyclerview);
        myAdapter adapter = new myAdapter(this,items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        add = findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddItem.class);
           //     myIntent.putExtra("List", items); //Optional parameters
                MainActivity.this.startActivity(myIntent);

            }
        });

    }

}