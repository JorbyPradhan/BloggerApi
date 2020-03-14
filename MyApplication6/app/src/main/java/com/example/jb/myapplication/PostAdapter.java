package com.example.jb.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private Context context;
    LayoutInflater inflater;
    private List<Item> items;
//    Item item;

    public PostAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.other, parent,false);
        PostViewHolder viewHolder=new PostViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
       final Item  item=items.get(position);
        holder.postTitle.setText(item.getTitle());

        Document document= Jsoup.parse(item.getContent());
        holder.postDescription.setText(document.text());
        Elements elements=document.select("img");
       /* Log.d("Code","Image"+elements.get(0).attr("src"));
        Log.d("Text",document.text());*/
        /*Pattern p= Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
        Matcher m =p.matcher(item.getContent());
        List<String>tokens= new ArrayList<>();
        while (m.find()){
            String token=m.group(1);
            tokens.add(token);
        }*/
        Glide.with(context).load(elements.get(0).attr("src")).into(holder.postImg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookActivity.class);
                intent.putExtra("url",item.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        ImageView postImg;
        TextView postTitle;
        TextView postDescription;
        public PostViewHolder(View itemView) {
            super(itemView);
            postImg=(ImageView)itemView.findViewById(R.id.otherImg);
            postTitle=(TextView)itemView.findViewById(R.id.title1);
            postDescription=(TextView)itemView.findViewById(R.id.Des);
        }
    }
}