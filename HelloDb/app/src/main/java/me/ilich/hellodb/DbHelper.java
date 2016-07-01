package me.ilich.hellodb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ilich on 30.06.16.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static DbHelper ins = null;

    public static void init(Context context){
        ins = new DbHelper(context);
    }

    public static DbHelper getInstance(){
        return ins;
    }

    private DbHelper(Context context) {
        super(context, "example.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE t1 (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
