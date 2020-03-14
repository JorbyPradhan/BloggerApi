package com.example.jb.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.jb.myapplication.Fragment.KnowledgeFragment;
import com.example.jb.myapplication.model.Data;
import com.example.jb.myapplication.model.User;

public class ItemActivity extends AppCompatActivity {
    TextView data1;
    User user;
    DBHelper dbhandler;
     int id=2;
    Cursor cursor =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar1);
        toolbar.setTitle("Networking");
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar1);
        collapsingToolbarLayout.setTitle("NW");
        data1=(TextView)findViewById(R.id.datas);
        db=new DataBaseHandler(this);
        writedatabase();
        //user=new User();
        user= ItemActivity.db.getData(KnowledgeFragment.index1);
        data1.setText(user.getName());
        //DataBaseHandler db=new DataBaseHandler(this);
        /*user= (User) ItemActivity.db.getContact(2);
        data1.setText(user.getName());*/

      /*  Button cl=(Button)findViewById(R.id.btn);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            //Error
            public void onClick(View v) {
                db = new DataBaseHandler(ItemActivity.this);
                user = ItemActivity.db.getData(KnowledgeFragment.index1);
                data1.setText(user.getName());

              *//*  Toast.makeText(ItemActivity.this, "Success", Toast.LENGTH_LONG).show();
                dbhandler = new DBHelper(getApplication());

                try {
                    dbhandler.createDataBase();
                } catch (IOException e) {
                    throw new Error("Unable to create database");
                }
                try {
                    dbhandler.openDataBase();
                    //  Log.i("Click","Clikwee");
                } catch (SQLException sqle) {

                    throw new Error("Unable to open database");

                }

                cursor= dbhandler.query("EMP_TABLE", null, null, null,null,null,null);
                cursor=dbhandler.getRowItem();
                if(cursor.moveToFirst()){
                    do{
                        data.setText(cursor.getString(0));
                    }while (cursor.moveToNext());
                }
            }*//*
            }
        });*/
           //
      //  cursor=dbhandler.getRowItem();


        }
    public static DataBaseHandler db;
    private void writedatabase()
    {

        for(int i=0;i<10;i++)
        {
            db.addContact(new User(Data.mo_text1[i]));
        }

    }
        /* cursor = dbhandler.getRowItem();
        if (cursor.moveToFirst()) {

             id = cursor.getString(cursor.getColumnIndex("_id"));

            //checksql = cursor.getInt(cursor.getColumnIndex("favourite"));

           *//* Bitmap bmp = BitmapFactory.decodeByteArray(cursor.getBlob(1), 0, cursor.getBlob(1).length);
            image.setImageBitmap(bmp);*//*

            txt_name = cursor.getString(cursor.getColumnIndex("Name"));
            data.setText(txt_name);
        }*/
   // }
}
