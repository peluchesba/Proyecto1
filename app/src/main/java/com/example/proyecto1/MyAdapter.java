package com.example.proyecto1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> item;
    private int Elemento;

    public MyAdapter(Context context, int layout, List<String> item) {
        this.context = context;
        this.layout = layout;
        this.item = item;
        Elemento = R.layout.grid_item;
        }

   @Override
    public int getCount() {
        return this.item.size();
    }

    @Override
    public Object getItem(int position) {
        return this.item.get(position);
    }

    @Override
    public long getItemId(int position) {
       return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            //convertView = layoutInflater.inflate(R.layout.list_item, null);
            convertView = layoutInflater.inflate(Elemento, null);

        }
        else {
            //holder = (ViewHolder) convertView.getTag();

        }

        return convertView;
    }

    public void agregarImagen(){
        Elemento = R.layout.grid_item;
        this.notifyDataSetChanged();
    }

    public void agregarNota(){
        Elemento = R.layout.grid_item2;
        this.notifyDataSetChanged();
    }


    static class ViewHolder {
        public TextView nombreTextView;
    }
}

