package com.example.jb.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jb.myapplication.R;


public class NetworkType extends Fragment {
    View v;
    RecyclerView recyclerView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.type_of_network, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.postList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
     //   getData();

        return v;
    }
    public NetworkType(){}
 /*   private void getData()
    {
        Call<PostList> postList = BloggerApi.getService().getPostList();
        postList.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList list = response.body();
//                recyclerView.setAdapter(new PostAdapter(getActivity(), list.getItems()));
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
            }
        });
    }
*//**/
   /* public interface OnFragmentInteractionListener {
    }*/
}