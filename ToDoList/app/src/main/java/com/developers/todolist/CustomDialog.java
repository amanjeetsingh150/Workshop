package com.developers.todolist;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Amanjeet Singh on 29-Jan-17.
 */

public class CustomDialog extends Dialog {

    private Context context;
    private CustomAdapter adapter;


    private EditText title,desc;
    private String todotitle,tododesc;
    private Button submit;
    private DBhelper dBhelper;
    private Cursor cursor;
    private static final String COLUMN_TITLE="TITLE";
    private static final String COLUMN_DESC="DESC";
    private ArrayList<String> titles;
    private ArrayList<String> descriptions;

    public CustomDialog(Context context,CustomAdapter adapter,ArrayList titles,ArrayList descriptions) {
        super(context);
        this.context=context;
        this.adapter=adapter;
        this.titles=titles;
        this.descriptions=descriptions;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialogbox);
        title= (EditText) findViewById(R.id.totitle);
        desc= (EditText) findViewById(R.id.todesc);
        submit= (Button) findViewById(R.id.submit);
        dBhelper=new DBhelper(context);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todotitle=title.getText().toString();
                tododesc=desc.getText().toString();
                boolean value =dBhelper.insertData(todotitle,tododesc);
                if(value){
                    Toast.makeText(context,"Activity Added",Toast.LENGTH_SHORT).show();
                    cursor=dBhelper.getData();
                    if(cursor!=null){
                        titles.clear();
                        descriptions.clear();
                        while(cursor.isAfterLast()==false){
                            String ti=cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
                            String de=cursor.getString(cursor.getColumnIndex(COLUMN_DESC));
                            Log.d("Dialog",ti+"-> "+de);
                            titles.add(ti);
                            descriptions.add(de);
                            cursor.moveToNext();
                        }
                        adapter.notifyDataSetChanged();
                    }
                    dismiss();
                }

            }
        });
    }
}
