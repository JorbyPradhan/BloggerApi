package com.example.jb.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jb.myapplication.DataBaseHandler;
import com.example.jb.myapplication.MainActivity;
import com.example.jb.myapplication.R;
import com.example.jb.myapplication.RecyclerViewAdapter;
import com.example.jb.myapplication.model.User;

import java.util.List;


public class BasicFragment extends Fragment {
    private List<User> mData;
    //RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* mData = new ArrayList<>();
        mData.add(new User(user.getName()));*/

    }
static User user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_basic, container, false);

        //TextView txt=(TextView)view.findViewById(R.id.txt);
        //user=MainActivity.db.getContact(MainActivity.index);
        /* user=MainActivity.db.getContact(MainActivity.index);
        txt.setText(user.getName());*/
             DataBaseHandler db=new DataBaseHandler(getActivity());
        mData= db.getContact(MainActivity.index);


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        adapter = new RecyclerViewAdapter(getActivity(), mData);
              recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return view;
    }


}
