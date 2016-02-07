package com.example.dns.leapfrog2.module;

import android.speech.tts.TextToSpeech;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dns.leapfrog2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Dns on 2/3/2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    private List<UserInfo> items;
    private int itemLayout;
    private static ClickListener clickListener;

    public RecycleViewAdapter(List<UserInfo> items, int itemLayout){
        this.items = items;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserInfo ui = items.get(position);
        holder.mTextView.setText(ui.getUser_name());
        holder.mJobTitle.setText(ui.getJob_title());
        holder.mImageView.setImageBitmap(null);
        Picasso.with(holder.mImageView.getContext()).cancelRequest(holder.mImageView);
        Picasso.with(holder.mImageView.getContext()).load(ui.getImage_url()).into(holder.mImageView);
        holder.itemView.setTag(ui);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mTextView, mJobTitle;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.nameTextView);
            mImageView = (ImageView)v.findViewById(R.id.profileImageView);
            mJobTitle = (TextView)v.findViewById(R.id.jobTitleTextView);
            v.setOnClickListener(this);
            //this.mImageView = i;
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View singleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent, false);
        ViewHolder vh = new ViewHolder(singleView);
        return vh;
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        RecycleViewAdapter.clickListener = clickListener;
    }

    public  interface ClickListener {
        void onItemClick(int position, View v);
    }

}
