package com.example.jb.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<String>{
private Integer[] Book;
    private FragmentActivity context;
    private String[]Description;
    private String []Link;
    public Adapter(FragmentActivity context, Integer[] Book,String[]Description,String[]Link) {
        super(context, R.layout.book, Description);
        this.context=context;
        this.Book=Book;
        this.Description=Description;
        this.Link=Link;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.book,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {viewHolder=(ViewHolder) r.getTag();

        }
        viewHolder.img.setImageResource(Book[position]);
        viewHolder.textView.setText(Description[position]);
        viewHolder.link.setText(Link[position]);
        return r;
    }
    class ViewHolder{
        ImageView img;
        TextView textView;
        TextView link;

        ViewHolder(View v) {
            textView=(TextView) v.findViewById(R.id.name2);
            link=(TextView)v.findViewById(R.id.name3);
            img=(ImageView)v.findViewById(R.id.img);
            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(link.getText().toString()));
                    v.getContext().startActivity(i);
                }
            });
        }

    }
}
