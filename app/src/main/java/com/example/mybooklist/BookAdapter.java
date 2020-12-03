package com.example.mybooklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends ArrayAdapter {

    public BookAdapter( Context context, List object) {
        super(context, 0, object);
    }



    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.mylayout,parent,false);
        }


        Objects current = (Objects) getItem(position);
        TextView bookname = (TextView)listItemView.findViewById(R.id.book);
        bookname.setText(current.getmBookName());

        TextView authorname = (TextView)listItemView.findViewById(R.id.author);
        authorname.setText(current.getMauthorName());

        return listItemView;

    }
}
