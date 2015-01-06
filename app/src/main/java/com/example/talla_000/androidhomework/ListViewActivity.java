package com.example.talla_000.androidhomework;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* This activity is called only in portrait mode. It displays a list view with string items
 */

public class ListViewActivity extends Activity {
    ArrayAdapter<String> itemsAdapter;
    final static int INDEX_ONE=1;
    final static int INDEX_TWO=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] source;
        ArrayAdapter itemsAdapter;
        setContentView(R.layout.activity_list_view);
        int buttonIndex=getIntent().getIntExtra("Index",0);
        ListView lv= (ListView) findViewById(R.id.stringList);

        //Check for button index and display list view accordingly
        if(buttonIndex==INDEX_ONE){
            source= getResources().getStringArray(R.array.list1);
            itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,source);

        }
        else{
            source= getResources().getStringArray(R.array.list2);
            itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,source);
        }
        lv.setAdapter(itemsAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view, menu);
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
