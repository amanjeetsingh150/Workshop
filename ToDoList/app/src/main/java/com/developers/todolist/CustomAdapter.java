package com.developers.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Amanjeet Singh on 30-Jan-17.
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> titles;
    private ArrayList<String> descriptions;


    public CustomAdapter(Context context, ArrayList<String> titles,ArrayList<String> descriptions){
        this.context=context;
        this.titles=titles;
        this.descriptions=descriptions;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int pos) {
        return titles.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(R.layout.list_row,null);
        String t=titles.get(position);
        String d=descriptions.get(position);
        TextView totitle= (TextView) view.findViewById(R.id.titlename);
        TextView todesc= (TextView) view.findViewById(R.id.descriptioname);
        totitle.setText(t);
        todesc.setText(d);
        return view;
    }
}
