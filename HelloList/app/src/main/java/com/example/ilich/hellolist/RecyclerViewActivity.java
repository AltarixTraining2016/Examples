package com.example.ilich.hellolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilich on 16.06.16.
 */
public class RecyclerViewActivity extends AppCompatActivity {


    List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        for(int i=0; i<10000; i++){
            data.add("Item " + i);
        }

        recyclerView.setAdapter(new Adaper());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }

    }

    class Adaper extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(View.inflate(RecyclerViewActivity.this, R.layout.listitem_card, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String s = data.get(position);
            holder.textView.setText(s);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

    }
}
