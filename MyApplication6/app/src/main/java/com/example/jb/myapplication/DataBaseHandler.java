package com.example.jb.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jb.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "contactsManager3";

    private static final String TABLE_CONTACTS = "contacts";
    private static final String id = "_id";
    private static  final String  BookImg = "Bimg";
    private static final String mo_text1 = "Monasterytext1";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE  " + TABLE_CONTACTS + "("
                + id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BookImg + " INTEGER," +
                mo_text1 + " TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(db);
    }

    void addContact(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(String.valueOf(BookImg), user.getPhoto());
        values.put(mo_text1, user.getName());
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    public List<User> getContact(int id1) {
        List<User> lst = new ArrayList<User>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{id, mo_text1}, id + "=?",
                new String[]{String.valueOf(id1)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User((cursor.getString(0)),cursor.getString(1));
        lst.add(user);
        return lst;
    }

    public User getData(int id2) {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = new User();
        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{id, BookImg, mo_text1}, id + "=?", new String[]{String.valueOf(id2)}, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {

                do {
                    user = new User(Integer.parseInt(cursor.getString(0)),cursor.getString(2));

                } while (cursor.moveToNext());
            }
                db.close();
            }
            return user;


    }
}