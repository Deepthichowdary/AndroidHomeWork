package com.example.talla_000.androidhomework;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyActivity extends Activity {
   final static int INDEX_ONE=1;
   final static int INDEX_TWO=2;
   final static int SCREEN_PORTRAIT=1;
   final static int SCREEN_LANDSCAPE=2;
    ListView lv;

   ArrayAdapter<String> itemsAdapter;
   static List<String> listSource = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        lv= (ListView) findViewById(R.id.stringList);

        /*
        * Register a listerner to buttons
        * */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // On click set button index to 1, change color of background and call loadview to populate the string list
                button2.setBackgroundColor(Color.GRAY);
                button1.setBackgroundColor(Color.DKGRAY);
                view.setBackgroundColor(12);
                loadView(INDEX_ONE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // On click set button index to 2, change color of background and call loadview to populate the string list
                button1.setBackgroundColor(Color.GRAY);
                button2.setBackgroundColor(Color.DKGRAY);
                view.setBackgroundColor(21);
                loadView(INDEX_TWO);
            }
        });

    }
    private void loadView(int index){
        // Check for Screen orientation
        if(getResources().getConfiguration().orientation==SCREEN_PORTRAIT){
            //If Portrait
            // Call a new activity by passing button index as parameter
            Intent i=new Intent(this,ListViewActivity.class);
            i.putExtra("Index",index);
            startActivity(i);

        }
        else{
            // If landscape
            // populate third fragment view with list of strings
            getData(index);
            lv.setAdapter(itemsAdapter);
        }
    }
    private List<String> getData(int index){

        // Check for button index and load adapter to corresponding list from arrays resource file
        if(index==INDEX_ONE) {
            itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.list1));
            return listSource = Arrays.asList(getResources().getStringArray(R.array.list1));

        }
        else if(index== INDEX_TWO){
            itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.list2));
            return listSource = Arrays.asList(getResources().getStringArray(R.array.list2));
        } else{
            return  listSource=null;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
