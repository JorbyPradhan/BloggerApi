package com.example.jb.myapplication;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.widget.ViewFlipper;

import com.example.jb.myapplication.Fragment.HomePageFragment;
import com.example.jb.myapplication.model.Data;
import com.example.jb.myapplication.model.User;

public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    private ViewFlipper viewFlipper;
    private Animation fadeIn,fadeOut;
   // FlipperLayout flipperLayout;
    LinearLayoutManager manager;
    //Adapter adapter;
    HomePageAdapter adapter;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    AppBarLayout appBarLayout;
    Fragment fragment = null;
    public static  DataBaseHandler db;

    private NavigationView navigationView;
    int navItem;
   public static int index ;
    public  int id;
    public static String tablename;
    int title[] = {R.string.app_name,R.string.beauty_title,R.string.dental_title,R.string.mental_title,R.string.bone_title,R.string.cancer_title,R.string.common_title,R.string.other_title,
            R.string.invite_title,R.string.favourite_title,R.string.read_title,R.string.rateapp_title,R.string.setting_title};
    /*int title[] = {R.string.app_name, R.string.beauty_title, R.string.dental_title, R.string.mental_title, R.string.bone_title, R.string.cancer_title, R.string.common_title, R.string.other_title,
            R.string.invite_title, R.string.favourite_title, R.string.read_title, R.string.rateapp_title, R.string.setting_title};*/
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //   @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Networking");
     /*   viewFlipper=(ViewFlipper)findViewById(R.id.viewflipper);
         fadeIn= AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadeOut= AnimationUtils.loadAnimation(this,R.anim.fadeout);
        viewFlipper.setInAnimation(fadeIn);
        viewFlipper.setOutAnimation(fadeOut);
        viewFlipper.startFlipping();*/

        /*flipperLayout=(FlipperLayout)findViewById(R.id.vp_flipper_layout);
        setLayout();*/
       /* manager = new LinearLayoutManager(this);
        String[] a = {"Knowledge of Networking", "Learn from video", "Member", "About"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(a));
        adapter = new Adapter(list, this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);*/

        /*fragment = new HomePageFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_body, fragment)
                .addToBackStack("home").commit();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);*/
        db = new DataBaseHandler(this);
        writedatabase();
        fragment = new HomePageFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_body, fragment)
                .addToBackStack("home").commit();
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);


    }

    /*private void setLayout() {
        for (int i=0; i<3; i++){
            FlipperView view= new FlipperView(getBaseContext());
            view.setImageDrawable(R.drawable.cmp);
            flipperLayout.addFlipperView(view);
        }
    }*/

    @Override
    public void onBackPressed() {
            finish();
            super.onBackPressed();

        }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navigation, menu);
        return true;
    }*/
  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
    //}
    private void initCollapsingToolbar() {

         CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getString(title[index]));
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setEnabled(true);
    }

    public void writedatabase()
    {

        for(int i=0;i<10;i++)
        {try {
           /* db.addContact(new User(Data.BookImg[i]));*/
            db.addContact(new User(Data.mo_text1[i]));
        }catch (ArrayIndexOutOfBoundsException e){}

        }

    }
  /*  @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.basic) {
            fragment=new BasicFragment();
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction  = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_body,fragment).addToBackStack("home").commit();
            Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();
            index=1;
            //initCollapsingToolbar();


        } else if (id == R.id.dental) {
            Toast.makeText(getApplication(),"click",Toast.LENGTH_LONG).show();

        } else if (id == R.id.mental) {
            Toast.makeText(getApplication(),"click",Toast.LENGTH_LONG).show();}



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
    }

