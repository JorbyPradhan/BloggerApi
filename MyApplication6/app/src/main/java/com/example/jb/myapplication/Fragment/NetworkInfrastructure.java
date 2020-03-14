package com.example.jb.myapplication.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jb.myapplication.BloggerApi;
import com.example.jb.myapplication.Item;
import com.example.jb.myapplication.MainActivity;
import com.example.jb.myapplication.PostAdapter;
import com.example.jb.myapplication.PostList;
import com.example.jb.myapplication.R;
import com.example.jb.myapplication.model.ConnectionDetector;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkInfrastructure extends Fragment {
    View v;
    RecyclerView recyclerView;
    PostAdapter adapter;
    LinearLayoutManager manager;
    List<Item> items = new ArrayList<>();
    Boolean isScrolling =false;
    private LinearLayout layout;
    ConnectionDetector cd;
    int currentitems, totalItems, scrollOutItems;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.network_imfra, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.postList1);
         layout=(LinearLayout)v.findViewById(R.id.Infa);
        cd=new ConnectionDetector(getContext());
        if(cd.isConnected()){
            manager=new LinearLayoutManager(getActivity());
            adapter = new PostAdapter(getActivity(),items);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                        isScrolling=true;
                    }
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    currentitems = manager.getChildCount();
                    totalItems = manager.getItemCount();
                    scrollOutItems = manager.findFirstVisibleItemPosition();
                    if(isScrolling && (currentitems + scrollOutItems == totalItems))
                    {
                        isScrolling = false;
                        getData();
                    }
                }
            });
            getData();

        }
        else {
            getData();
        }
        return v;

    }

    private void showSnackBar() {
        getData();

    }

    private void getData() {
        Call<PostList> postListCall = BloggerApi.getService().getPostList();
        postListCall.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList list = response.body();
               /*recyclerView.setAdapter(new PostAdapter(getActivity(),list.getItems()));*/
                items.addAll(list.getItems());
                adapter.notifyDataSetChanged();
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                Snackbar snackbar=Snackbar.make(layout,"Internet Connection Required", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(cd.isConnected()) {
                                    Intent intent=new Intent(getActivity(), MainActivity.class);
                                    startActivity(intent);
                                    Snackbar snac = Snackbar.make(layout, "Successful", Snackbar.LENGTH_LONG);
                                    snac.show();
                                }
                                else {
                                    Snackbar snackbar=Snackbar.make(layout,"Internet Connection Required", Snackbar.LENGTH_INDEFINITE)
                                            .setAction("Retry", new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    if(cd.isConnected()) {
                                                        Intent intent=new Intent(getActivity(), MainActivity.class);
                                                        startActivity(intent);
                                                        Snackbar snac = Snackbar.make(layout, "Successful", Snackbar.LENGTH_LONG);
                                                        snac.show();
                                                    }
                                                }
                                            }).setActionTextColor(Color.RED);
                                    View snackView=snackbar.getView();
                                    TextView textView=snackView.findViewById(android.support.design.R.id.snackbar_text);
                                    textView.setTextColor(Color.YELLOW);
                                    snackbar.show();

                                }
                            }
                        })
                        .setActionTextColor(Color.RED);
                View snackView=snackbar.getView();
                TextView textView=snackView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();

            }

        });
    }
public NetworkInfrastructure(){}
    /*public interface OnFragmentInteractionListener {
    }*/
}