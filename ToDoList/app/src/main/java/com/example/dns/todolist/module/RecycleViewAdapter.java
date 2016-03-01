package com.example.dns.todolist.module;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dns.todolist.R;

import java.util.ArrayList;

/**
 * Created by Dns on 2/25/2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    public ArrayList<Todolist> list;
    private int itemLayoout;
    public static ClickListener clickListener;

    public RecycleViewAdapter(ArrayList<Todolist> list, int res) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CheckBox ck;
        TextView listId, name, datetime;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            ck = (CheckBox) itemView.findViewById(R.id.checkBox);
            name = (TextView) itemView.findViewById(R.id.lnameTextView);
            datetime = (TextView) itemView.findViewById(R.id.dateTimeTextView);
            img = (ImageView) itemView.findViewById(R.id.imgId);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View singleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        ViewHolder v = new ViewHolder(singleView);
        return v;
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.ViewHolder holder, int position) {
        Todolist correctList = list.get(position);
        holder.name.setText(correctList.getName());
        holder.datetime.setText(correctList.getPhone());

        Log.v("test",correctList.isEdit+"");
        if (correctList.isEdit) {
            holder.itemView.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.itemView.setBackgroundColor(Color.CYAN);
        }
        holder.itemView.setTag(correctList);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        RecycleViewAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

}
