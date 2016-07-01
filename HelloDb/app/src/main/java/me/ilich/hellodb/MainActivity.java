package me.ilich.hellodb;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText idEditText;
    EditText nameEdiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idEditText = (EditText) findViewById(R.id.editText);
        nameEdiText = (EditText) findViewById(R.id.editText2);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idEditText.getText().toString();
                Log.v("Sokolov", "select " + id);
                Cursor c = DbHelper.getInstance().getWritableDatabase().rawQuery("SELECT _id, name FROM t1 WHERE _id = ?", new String[]{id});
                if (c.moveToFirst()) {
                    String _id = c.getString(0);
                    String name = c.getString(1);
                    nameEdiText.setText(_id + " " + name);
                } else {
                    Log.w("Sokolov", "empty!");
                }
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idEditText.getText().toString();
                String name = nameEdiText.getText().toString();
                Log.v("Sokolov", "inser " + id + " " + name);
                ContentValues cv = new ContentValues();
                cv.put("_id", id);
                cv.put("name", name);
                DbHelper.getInstance().getWritableDatabase().insert("t1", null, cv);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idEditText.getText().toString();
                String name = nameEdiText.getText().toString();
                Log.v("Sokolov", "update " + id + " " + name);
                ContentValues cv = new ContentValues();
                cv.put("name", name);
                DbHelper.getInstance().getWritableDatabase().update("t1", cv, "_id = ?", new String[]{id});
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idEditText.getText().toString();
                Log.v("Sokolov", "delete " + id);
                DbHelper.getInstance().getWritableDatabase().delete("t1", "_id = ?", new String[]{id});
            }
        });
    }
}
