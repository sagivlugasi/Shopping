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
    String item;
    Button add;
    EditText itemText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        add= findViewById(R.id.AddButton);
        itemText = findViewById(R.id.ItemText);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                items.add(itemText.getText().toString());
                SharedPreferences.Editor editor = getSharedPreferences("List", MODE_PRIVATE).edit();
                editor.putString("name", items.toString());
                editor.apply();
*/

                item = itemText.getText().toString();
                if(!item.isEmpty()) {
                    Toast.makeText(AddItem.this, item,
                            Toast.LENGTH_SHORT).show();

                    Intent myIntent = new Intent(AddItem.this, MainActivity.class);
                    myIntent.putExtra("Item", item);
                    AddItem.this.startActivity(myIntent);
                }
                else {
                    Toast.makeText(AddItem.this, "לא הוכנס שם פריט",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}