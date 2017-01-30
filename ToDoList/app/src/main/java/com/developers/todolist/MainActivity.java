package com.developers.todolist;

import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private ListView listView;
    private DBhelper dBhelper;
    private Cursor cursor;
    private static final String COLUMN_TITLE="TITLE";
    private static final String COLUMN_DESC="DESC";
    private ArrayList<String> titlenames;
    private ArrayList<String> descriptionames;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton= (FloatingActionButton) findViewById(R.id.fab);
        listView= (ListView) findViewById(R.id.list);
        dBhelper=new DBhelper(MainActivity.this);
        titlenames=new ArrayList<>();
        descriptionames=new ArrayList<>();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog=new CustomDialog(MainActivity.this,customAdapter,titlenames,descriptionames);
                customDialog.show();
            }
        });
        cursor=dBhelper.getData();
        if (cursor != null) {
            while(cursor.isAfterLast()==false){
                String ti=cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
                String de=cursor.getString(cursor.getColumnIndex(COLUMN_DESC));
                titlenames.add(ti);
                descriptionames.add(de);
                Log.d("MainActivity ",ti+"-> "+de);
                cursor.moveToNext();
            }
            customAdapter=new CustomAdapter(MainActivity.this,titlenames,descriptionames);
            listView.setAdapter(customAdapter);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }
}
