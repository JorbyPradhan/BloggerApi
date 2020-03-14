package com.example.jb.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jb.myapplication.model.User;

import java.util.List;

public class NetAdapter extends RecyclerView.Adapter<NetAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    List<User> diseaseList;

    public NetAdapter(Context mContext, List<User> diseaseList) {
        this.mContext = mContext;
        this.diseaseList = diseaseList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
View view = inflater.inflate(R.layout.naviitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User album = diseaseList.get(position);
        holder.name.setText(album.getName());
       // holder.photo.setImageBitmap(album.getPhoto());
        holder.id=album.getId();

    }


    @Override
    public int getItemCount() {
    return diseaseList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public String id;
        public ImageView photo;
        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            //photo = (ImageView) view.findViewById(R.id.photo);

        }
    }
}