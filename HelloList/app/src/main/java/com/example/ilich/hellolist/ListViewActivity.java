package com.example.ilich.hellolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilich on 16.06.16.
 */
public class ListViewActivity extends AppCompatActivity {

    List<String> data = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ListView lv = (ListView) findViewById(R.id.list);

        for(int i=0; i<10000; i++){
            data.add("Item " + i);
        }

        lv.setAdapter(new Adapter());


    }

    private class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public String getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.v("ListView", "convertView = " + convertView);
            if(convertView==null){
                convertView = View.inflate(ListViewActivity.this, android.R.layout.simple_list_item_1, null);
                ViewHolder vh = new ViewHolder();
                vh.textView = (TextView) convertView.findViewById(android.R.id.text1);
                convertView.setTag(vh);
            }
            String item = getItem(position);
            ViewHolder vh = (ViewHolder) convertView.getTag();
            vh.textView.setText(item);
            return convertView;
        }

    }

    class ViewHolder {
        TextView textView;
    }
}
