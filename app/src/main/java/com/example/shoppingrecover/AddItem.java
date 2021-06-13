package com.example.shoppingrecover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class AddItem extends AppCompatActivity {
    ArrayList<String> items = new ArrayList<String>();
    Button add;
    EditText itemText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        add= findViewById(R.id.AddButton);
        itemText = findViewById(R.id.ItemText);


        //Get The List From Main

        Intent intent = getIntent();
        if (intent.getStringArrayListExtra("List") != null) {
            items = intent.getStringArrayListExtra("List");
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                items.add(itemText.getText().toString());
                SharedPreferences.Editor editor = getSharedPreferences("List", MODE_PRIVATE).edit();
                editor.putString("name", items.toString());
                editor.apply();
*/
                Toast.makeText(AddItem.this, "הפריט נוסף לרשימה",
                        Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(AddItem.this, MainActivity.class);
                myIntent.putExtra("List", items); //Optional parameters
                AddItem.this.startActivity(myIntent);

            }
        });
    }
}