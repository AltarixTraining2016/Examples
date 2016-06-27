package com.example.ilich.hellolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

        for (int i = 0; i < 10000; i++) {
            data.add("Item " + i);
        }

        recyclerView.setAdapter(new Adaper());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    abstract class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        protected abstract void fill(String s);

    }

    class TextViewHolder extends ViewHolder {

        TextView textView;

        public TextViewHolder(ViewGroup parent) {
            super(getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false));
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }

        @Override
        protected void fill(String s) {
            textView.setText(s);
        }
    }

    class ImageViewHolder extends ViewHolder {

        public ImageViewHolder(ViewGroup parent) {
            super(getLayoutInflater().inflate(R.layout.listitem_image, parent, false));
        }

        @Override
        protected void fill(String s) {

        }
    }

    class Text2ViewHolder extends ViewHolder {

        TextView textView1;
        TextView textView2;

        public Text2ViewHolder(ViewGroup parent) {
            super(getLayoutInflater().inflate(android.R.layout.simple_list_item_2, parent, false));
            textView1 = (TextView) itemView.findViewById(android.R.id.text1);
            textView2 = (TextView) itemView.findViewById(android.R.id.text2);
        }

        @Override
        protected void fill(String s) {
            textView1.setText(s);
            textView2.setText(s.length() + "");
        }
    }

    class Adaper extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public int getItemViewType(int position) {
            return position % 3 == 0 ? position % 5 == 0 ? 2 : 1 : 0;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case 1:
                    return new ImageViewHolder(parent);
                case 0:
                    return new TextViewHolder(parent);
                case 2:
                    return new Text2ViewHolder(parent);
                default:
                    return null;
            }
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String s = data.get(position);
            holder.fill(s);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }


    }
}
