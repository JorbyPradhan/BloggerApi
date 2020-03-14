package com.example.jb.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jb.myapplication.Fragment.KnowledgeDataFragment;
import com.example.jb.myapplication.Fragment.KnowledgeFragment;
import com.example.jb.myapplication.Fragment.NetworkInfrastructure;
import com.example.jb.myapplication.Fragment.NetworkType;
import com.example.jb.myapplication.model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "NetworkEngineering.sqlite";
  //  public static final String DBLocation = "data/data/com.example.jb.myapplication/databases/";
    public static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME = "Networktb";
    private static final String KEY_ID = "id";
    private  static final String KEY_NAME = "name";
  /*  private  static final String KEY_IMAGE = "image";
    private static final String KEY_DATA = "Data";*/
    KnowledgeFragment knowledgeFragment = new KnowledgeFragment();
    KnowledgeDataFragment knowledgeDataFragment=new KnowledgeDataFragment();
    NetworkInfrastructure networkInfrastructure=new NetworkInfrastructure();
    NetworkType networkType=new NetworkType();
    String DB_PATH = null;
    String selectQuery;
    String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
            KEY_ID + " INTEGER PRIMARY KEY NOT NULL, " +
            KEY_NAME + " TEXT, " ;

    private Context mContext;
    public DBHelper(Context mContext){
        super( mContext, DATABASE_NAME , null , DATABASE_VERSION );
        this.mContext =mContext;
        this.DB_PATH = "/data/data/" + mContext.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }
    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist){
        }
        else {this.getReadableDatabase();
            try {
                copyDataBase();
            }catch (IOException e){throw  new Error("Error copying Database");}
            }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {/*db.execSQL(CREATE_CONTACTS_TABLE);*/

    }
    public boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch (SQLiteException e){

        }
        if (checkDB !=null){
            checkDB.close();
        }

        return checkDB != null ? true : false ;
    }
    private void copyDataBase() throws IOException {
       // ContextWrapper cw = new ContextWrapper(Main2Activity.this);
      //  String DB_PATH = "/data/data/com.example.jb.myapplication/databases/";
        String DB_NAME = "NetworkEngineering.sqlite";

        //Log.i("Database", "New database is being copied to device!");
     //   byte[] buffer = new byte[1024];

        int length;
        // Open your local db as the input stream
        InputStream myInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];


        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }


           // myInput = Main2Activity.this.getAssets().open(DB_NAME);

            //myOutput = new FileOutputStream(DB_PATH + DB_NAME);

            myOutput.close();
            myOutput.flush();
            myInput.close();
         //   Log.i("Database", "New database has been copied to device!");


    }
    private SQLiteDatabase myDatabase;
    public void openDataBase()throws SQLException{
        String myPath = DB_PATH + DATABASE_NAME;
      myDatabase  = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }
    @Override
    public synchronized void close(){
        if(myDatabase != null)
            myDatabase.close();
        super.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion)
            try {
                copyDataBase();
            }catch (IOException e){e.printStackTrace();}
        /*db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);*/
    }
    public List<User> getNetwork() {
        List<User> lst = new ArrayList<User>();

        selectQuery = "SELECT * FROM " + TABLE_NAME+ " WHERE " + KEY_ID+ " = 1";
        Log.i("SelectQuery:Item", selectQuery);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                User disease = new User();
                disease.setId(cursor.getString(0));

              /*  Bitmap bmp = BitmapFactory.decodeByteArray(cursor.getBlob(1), 0, cursor.getBlob(1).length);
                disease.setPhoto(bmp);*/
                disease.setName(cursor.getString(1));
                lst.add(disease);
            } while (cursor.moveToNext());
        }
        db.close();
        return lst;
    }
    public Cursor getRowItem() {
        if (knowledgeFragment.beautyCondition == true) {
            selectQuery = knowledgeFragment.beautyPosition;
           knowledgeFragment.beautyCondition = false;
        }
       /* if (networkInfrastructure.favCondition == true){
            selectQuery = networkInfrastructure.favPosition;
            networkInfrastructure.favCondition = false;
        }
        if (networkType.dentalCondition == true){
            selectQuery = networkType.dentalPosition;
            networkType.dentalCondition = false;
        }
        if (knowledgeDataFragment.eautyCondition == true){
            selectQuery = knowledgeDataFragment.beautyPosition;
           knowledgeDataFragment.beautyCondition = false;
        }*/


        Log.i("SelectQuery", selectQuery);
        myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery(selectQuery, null);
        return cursor;
    }
    public Cursor query(String table, String[] columns, String selections, String[] selectionArgs, String groupBy, String having, String orderBy){
        return myDatabase.query("EMP_TABLE", null, null, null, null, null, null, null);

    }
   /* public User getDetail(String id){
        User disease = new User();
        selectQuery = "SELECT * FROM " + TABLE_NAME +" WHERE "+ KEY_ID + " = "+ id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursorfav = db.rawQuery(selectQuery,null);
        if (cursorfav.moveToFirst()) {
            do {
                disease.setId(cursorfav.getString(0));
                Bitmap bmp = BitmapFactory.decodeByteArray(cursorfav.getBlob(1), 0, cursorfav.getBlob(1).length);
                disease.setPhoto(bmp);
                disease.setName(cursorfav.getString(2));

            } while (cursorfav.moveToNext());
        }
        db.close();
        return disease;
    }*/
}