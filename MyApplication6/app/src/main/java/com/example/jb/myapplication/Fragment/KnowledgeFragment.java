package com.example.jb.myapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jb.myapplication.DBHelper;
import com.example.jb.myapplication.ItemActivity;
import com.example.jb.myapplication.R;
import com.example.jb.myapplication.RecyclerViewAdapter;
import com.example.jb.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeFragment extends Fragment {
    private List<User> mData;
    public static String beautyPosition;
    public static boolean beautyCondition;
    DBHelper handler;
    public static int index1;


    private RecyclerView recyclerView;
    View homePageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = new ArrayList<>();
        mData.add(new User("What is Network?"));
        mData.add(new User("What is Network Infrastructure?"));
        mData.add(new User("Type of Network"));
        mData.add(new User("Basic Networking(part 1)"));
        mData.add(new User("Basic Networking(part 2)"));
        mData.add(new User("Basic Networking(part 3)"));
        mData.add(new User("Basic Networking(part 4)"));
        mData.add(new User("Basic Networking(part 5)"));
        mData.add(new User("Basic Networking(part 6)"));
        mData.add(new User("Basic Networking(part 7)"));



    }


    public KnowledgeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        homePageView = inflater.inflate(R.layout.fragment_knowledge, container,
                false);
        recyclerView = (RecyclerView) homePageView.findViewById(R.id.beauty_recycler);
       // handler=new DBHelper(getActivity());
        //mData=handler.getNetwork();
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), mData);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                index1=position+1;
                switch (position){
                    case 0:

                      //  beautyPosition = "SELECT * FROM Network WHERE id= 1";break;
                        break;
                    case 1:
                        //index1=2;

                        Toast.makeText(getActivity(),"Click",Toast.LENGTH_LONG).show();break;
                    case 10:
                        /*fragment[0] = new NetworkType();
                        fragmentManager[0] = getActivity().getSupportFragmentManager();
                        fragmentTransaction[0] = fragmentManager[0].beginTransaction();
                        //Toast.makeText(getActivity(), "Basic", Toast.LENGTH_SHORT).show();
                        fragmentTransaction[0].replace(R.id.content_body1, fragment[0]).addToBackStack("home").commit();
                        Toast.makeText(getActivity(), "Basic", Toast.LENGTH_SHORT).show();*/
                        // writedatabase();
                        break;
                    default:
                        break;
                }
                //beautyCondition = true;
                Intent intent= new Intent(getActivity(),ItemActivity.class);
                // intent.putExtra("id",id);
                startActivity(intent);

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

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}

