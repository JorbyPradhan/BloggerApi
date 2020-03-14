package com.example.jb.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jb.myapplication.model.Service_HomePage_Model;
import com.example.jb.myapplication.model.User;

import java.util.Collections;
import java.util.List;

/**
 * Created by UCSM on 10/24/2016.
 */

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ItemViewHolder>{
Context context;
    static User user;
    List<Service_HomePage_Model> data = Collections.emptyList();
    private LayoutInflater inflater;

    public HomePageAdapter(Context context, List<Service_HomePage_Model> data) {
       this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }



    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.cardName.setText(data.get(position).item);
        //holder.cardLogo.setImageResource(data.get(position).logoId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnCreateContextMenuListener{
        TextView cardName;
        //ImageView cardLogo;
        int id;

        ItemViewHolder(View itemView) {
            super(itemView);
            cardName = (TextView)itemView.findViewById(R.id.name1);
            //cardLogo = (ImageView)itemView.findViewById(R.id.home_page_imageview);

            itemView.setOnCreateContextMenuListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardName.getText().toString().equals("Knowledge of Networking")){
                    Intent i = new Intent(v.getContext(), Main2Activity.class);
                    /*i.putExtra("id",String.valueOf(id));*/
                    v.getContext().startActivity(i);}
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        }
    }
}
