package com.example.jb.myapplication.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.example.jb.myapplication.HomePageAdapter;
import com.example.jb.myapplication.JobActivity;
import com.example.jb.myapplication.Main2Activity;
import com.example.jb.myapplication.R;
import com.example.jb.myapplication.WebViewActivity;
import com.example.jb.myapplication.model.Service_HomePage_Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UCSM on 10/24/2016.
 */

public class HomePageFragment extends Fragment {
   // ContextThemeWrapper ctw=new ContextThemeWrapper(getContext(), R.style.CardView_Light);
    private List<Service_HomePage_Model> homeItems;
    private RecyclerView recyclerView;
    private HomePageAdapter adapter;
    public  int id;
    private Animation animation;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
/*    DatabaseHandler databaseHandler = new DatabaseHandler(getActivity());
    FavouriteFragment favouriteFragment;*/
    AlertDialog alertDialog;
    String[] diseaseName={"Acne","Allery","Bad Smell","Hair Loss","Nail Fungus","Dandruff"
    ,"Bad Breath","Gum Disease","Mouth Sores","Oral Cancer","Tooth Decay","Tooth Erosion","Tooth Sensitivity","Toothache"
    ,"Anxiety","Bipolar Disorder","Depression","Eating Disorder","Schizophrenia","Abuse and Addiction"
    ,"Acomegaly","Bone Cancer","Fibrous Dysplasia","Osteogenesis","Osteomalacia","Osteomyelitis","Osteoporosis","Paget's","Petthes","Ricket"
    ,"Bladder Cancer","Blood Cancer","Brain Cancer","Breast Cancer","Colon Cancer","Liver Cancer","Lung Cancer","Osesophagal Cancer","Prostate Cancer","Stomach"
    ,"Asthma","Coronary","Dengue Fever","Hypertension","Liver","Malaria","Pneumonia","Typhoid Fever","Yellow Fever"
    ,"Headache","Diarrhoeal" , "Dengue Fever" , "Heart Attack" , "Asthma" , "Kidney" , "Measles" , "Coronary Heart"};

    private void initializeData() {
        homeItems = new ArrayList<Service_HomePage_Model>();
        homeItems.add(new Service_HomePage_Model(R.string.invite));
        homeItems.add(new Service_HomePage_Model(R.string.favourite));
        homeItems.add(new Service_HomePage_Model(R.string.readlater));
        homeItems.add(new Service_HomePage_Model(R.string.share));
        homeItems.add(new Service_HomePage_Model(R.string.about));
    }

    public HomePageFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeData();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View homePageView = inflater.inflate(R.layout.home_fragment, container,
                false);
        recyclerView = (RecyclerView) homePageView.findViewById(R.id.home_page_recyclerview);

        adapter = new HomePageAdapter(getActivity(),homeItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
      recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        /*Animation a= AnimationUtils.loadAnimation(getContext(),R.anim.mixed_anim);
        recyclerView.startAnimation(a);*/
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(
                getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                switch (position){
                    case 0:
                        Intent intent= new Intent(getActivity(),Main2Activity.class);
                        intent.putExtra("id",id);
                        startActivity(intent);

                        break;
                    case 1:
                        Intent intent1=new Intent(getContext(), WebViewActivity.class);
                        startActivity(intent1);
                    case 2:
                        Intent intent2=new Intent(getContext(), JobActivity.class);
                        startActivity(intent2);
                        break;

                    case 3:
                        shartIt();
                        break;
                    case 4:
                        new AlertDialog.Builder(getActivity()).setIcon(android.R.mipmap.sym_def_app_icon)
                                .setTitle("Network")
                                .setMessage("Developed By :\nMg Jobby\n\nUniversity Of Computer Studies, Lashio")
                                .setPositiveButton("OK",null)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).show();
                        break;


                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return homePageView;
    }


    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

   private static class RecyclerTouchListener implements
            RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context,
                                     final RecyclerView recyclerView,
                                     final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context,
                    new GestureDetector.SimpleOnGestureListener() {
                        @Override
                        public boolean onSingleTapUp(MotionEvent e) {
                            return true;
                        }
                    });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null
                    && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
    private void shartIt(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_SUBJECT,"AndroidSolved");
        intent.putExtra(intent.EXTRA_TEXT,"https://androidsolved.wordpress.com/");
        startActivity(intent.createChooser(intent,"Share via"));
    }
    private void inviteIt(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_SUBJECT,"AndroidSolved");
        intent.putExtra(intent.EXTRA_TEXT,"https://androidsolved.wordpress.com/");
        startActivity(intent.createChooser(intent,"Invite Friends"));
    }


}
