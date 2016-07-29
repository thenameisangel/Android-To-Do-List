package com.example.angello.angelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing button
        Button buttonName = (Button) findViewById(R.id.button);

        //initializing list view

        ListView listView = (ListView) findViewById(R.id.myList);
        final EditText editText = (EditText) findViewById(R.id.editText);

        //make an array list to store our data
        final ArrayList<String> myItems = new ArrayList<>();

        //make an array adapter to connect the list view to the list of data
        final ArrayAdapter myAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, myItems);

        listView.setAdapter(myAdapter);

        buttonName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //get edittext input as a string
                String currentItem = editText.getText().toString();

                //add it to the ArrayList
                myItems.add(currentItem);

                //update adapter
                myAdapter.notifyDataSetChanged();

                //clear EditText
                editText.setText("");

                Toast.makeText(MainActivity.this, "Added item!", Toast.LENGTH_LONG).show();
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //allows on click listener for just an item on the list; int is the index of the item on the list
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //remove an item at position i
                myItems.remove(i);
                myAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Item Removed!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
