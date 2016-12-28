package me.ilich.hellosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ilich on 27.12.16.
 */

public class OpenHelper extends SQLiteOpenHelper {

    private static OpenHelper instance = null;

    private OpenHelper(Context context) {
        super(context, "mydb.sqlite", null, 3);
    }

    public static void init(Context context) {
        instance = new OpenHelper(context);
    }

    public static OpenHelper getInstance() {
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        initDb(db);
    }

    private void initDb(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (\n" +
                "\t_id INTEGER PRIMARY KEY,\n" +
                "\tname TEXT NOT NULL\n" +
                ");");

        db.beginTransaction();
        try {
            for (int i = 0; i < 100; i++) {
                ContentValues cv = new ContentValues();
                cv.put("name", "user " + i);
                db.insert("users", null, cv);
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {

        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE users");
        initDb(db);
    }

}
