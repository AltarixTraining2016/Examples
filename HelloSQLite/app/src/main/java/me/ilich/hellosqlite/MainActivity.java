package me.ilich.hellosqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter = new Adapter();
    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (RecyclerView) findViewById(R.id.list);


        refreshList("");
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("name", "Vasia");
                OpenHelper.getInstance().getWritableDatabase().insert("users", null, cv);
                refreshList("");
            }
        });
        final EditText name = (EditText) findViewById(R.id.name);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        findViewById(R.id.filter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = name.getText().toString();
                refreshList(t);
            }
        });

    }

    private void refreshList(String filter) {
        filter = "%" + filter + "%";
        Cursor c = OpenHelper.getInstance().
                getWritableDatabase().
                rawQuery("SELECT _id, name FROM users WHERE name LIKE ? order by name desc", new String[]{filter});
        adapter.changeCursor(c);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView text1;
        TextView text2;

        public ViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(android.R.id.text1);
            text2 = (TextView) itemView.findViewById(android.R.id.text2);
        }

        public void bind(User user) {
            text1.setText(user.getName());
            text2.setText(user.getId() + "");
        }
    }

    private class Adapter extends RecyclerView.Adapter<ViewHolder> {

        private Cursor cursor = null;

        public void changeCursor(Cursor c) {
            if (cursor != null) {
                cursor.close();
            }
            cursor = c;
            cursor.moveToFirst();
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(MainActivity.this).inflate(android.R.layout.simple_list_item_2, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            cursor.moveToPosition(position);
            User user = User.fromCursor(cursor);
            holder.bind(user);
        }

        @Override
        public int getItemCount() {
            return cursor.getCount();
        }
    }
}
