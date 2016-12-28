package me.ilich.hellosqlite;

import android.database.Cursor;

/**
 * Created by ilich on 27.12.16.
 */

public class User {

    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static User fromCursor(Cursor c) {
        int id = c.getInt(c.getColumnIndex("_id"));
        String name = c.getString(c.getColumnIndex("name"));
        return new User(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
