package com.example.jb.myapplication;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jb.myapplication.model.User;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<User> mData;
    private LayoutInflater inflater;
    public RecyclerViewAdapter(FragmentActivity mContext, List<User> mData) {
        this.mData = mData;
        inflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v= inflater.inflate(R.layout.naviitem, parent, false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User album = mData.get(position);
      holder.textView.setText(album.getName());
      holder.id=album.getId();

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public String id;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.name);
        }


    }
}