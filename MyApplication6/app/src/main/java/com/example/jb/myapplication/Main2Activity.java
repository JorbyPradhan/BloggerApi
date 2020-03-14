package com.example.jb.myapplication;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jb.myapplication.Fragment.KnowledgeDataFragment;
import com.example.jb.myapplication.Fragment.KnowledgeFragment;
import com.example.jb.myapplication.Fragment.NetworkInfrastructure;
import com.example.jb.myapplication.Fragment.NetworkType;
import com.example.jb.myapplication.model.Data;
import com.example.jb.myapplication.model.User;

//implements KnowledgeFragment.OnFragmentInteractionListener,NetworkInfrastructure.OnFragmentInteractionListener,NetworkType.OnFragmentInteractionListener,KnowledgeDataFragment.OnFragmentInteractionListener
public class Main2Activity extends AppCompatActivity {
    ActionBar actionBar;
    ViewPager viewPager;
    TextView dbName;
    DBHelper handler;
    RecyclerViewAdapter recyclerViewAdapter;
    private ViewPagerAdapter adapter;
    //  DataBaseAccess handler;
    String id, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //dbName = (TextView) findViewById(R.id.dbName);
        viewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablay);
        db=new DataBaseHandler(this);
        writedatabase();
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new KnowledgeFragment(),"");
        adapter.AddFragment(new NetworkInfrastructure(), "");
        adapter.AddFragment(new NetworkType(), "");
        adapter.AddFragment(new KnowledgeDataFragment(),"");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon( R.drawable.other);
        tabLayout.getTabAt(2).setIcon( R.drawable.ic_settings_24dp);
        tabLayout.getTabAt(3).setIcon( R.drawable.ic_local_library_24dp);
      //  getData();




       /* tabLayout.addTab(tabLayout.newTab().setText("Networking"));
        tabLayout.addTab(tabLayout.newTab().setText("Network Infrastructure"));
        tabLayout.addTab(tabLayout.newTab().setText("Type Of Network"));
        tabLayout.addTab(tabLayout.newTab().setText("Book"));*/
     //   tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //id=getIntent().getStringExtra("id");
      /*  User user = (User) handler.getNetwork();
        Cursor cursor=handler.getRowItem();
        if (cursor.moveToFirst()) {
            //id = cursor.getString(cursor.getColumnIndex("_id"));
            name = cursor.getString(cursor.getColumnIndex("name"));
            dbName.setText(name);
        }*/


        //
        //  User user=handler.getAddress(id);
        //Disease disease=handler.getDetail(id);
       /* actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);*/

     /*   viewPager = (ViewPager) findViewById(R.id.pager);
        final MainFragmentPagerAdapter mainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(mainFragmentPagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
*//*                switch (tab.getPosition()){
                    case 0:
                        *//**//*Log.i("CHECK DB : ", "" + checkDataBase());
                        if (!checkDataBase()) {
                            copyDataBase();
                        }*//**//*
                        DataBaseAccess dataBaseAccess=DataBaseAccess.getAccess(getApplicationContext());
                        dataBaseAccess.open();
                        int id=0;
                        dbName.setText(dataBaseAccess.getAddress(id));
                        break;

                }*//*
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }*/
   /* public boolean checkDataBase() {
        String DB_PATH = "/data/data/com.example.jb.myapplication/databases/";
        String DB_NAME = "";
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }*/
  /*  private void copyDataBase() {
        ContextWrapper cw = new ContextWrapper(Main2Activity.this);
        String DB_PATH = "/data/data/com.example.jb.myapplication/databases/";
        String DB_NAME = "
        ";

        Log.i("Database", "New database is being copied to device!");
        byte[] buffer = new byte[1024];
        OutputStream myOutput = null;
        int length;
        // Open your local db as the input stream
        InputStream myInput = null;
        try {
            File file_dbpath = new File(DB_PATH);
            if (!file_dbpath.exists()) {
                file_dbpath.mkdirs();
            }

            myInput = Main2Activity.this.getAssets().open(DB_NAME);

            myOutput = new FileOutputStream(DB_PATH + DB_NAME);
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.close();
            myOutput.flush();
            myInput.close();
            Log.i("Database", "New database has been copied to device!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    }


    public static DataBaseHandler db;
    private void writedatabase()
    {

        for(int i=0;i<10;i++)
        {
            try {
                db.addContact(new User(Data.BookImg[i]));
            }catch (ArrayIndexOutOfBoundsException e){}
        }

    }
/*    private void getData()
    {
        Call<PostList> postList = BloggerApi.getService().getPostList();
        postList.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList list = response.body();
                Toast.makeText(Main2Activity.this,"Success",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                Toast.makeText(Main2Activity.this,"Error",Toast.LENGTH_LONG).show();
            }
        });
    }*/

}
      /*  FragmentManager fragmentManager = getSupportFragmentManager();

        ViewPager.SimpleOnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        };

        viewPager.setOnPageChangeListener(pageChangeListener);

       MainFragmentPagerAdapter mainFragmentPagerAdapter = new MainFragmentPagerAdapter(fragmentManager, tabLayout.getTabCount());

        viewPager.setAdapter(mainFragmentPagerAdapter);

        actionBar.setDisplayShowTitleEnabled(true);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

            }


        };

        ActionBar.Tab tab = actionBar.newTab().setText("Friend").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Coffee").setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Address").setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Phone").setTabListener(tabListener);
        actionBar.addTab(tab);
    }*/
  //  }

