package com.example.dns.leapfrog2.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dns.leapfrog2.R;

import java.util.ArrayList;

/**
 * Created by Dns on 2/8/2016.
 */
public class JsonArrayAdapter extends ArrayAdapter<EmployeeJson> {
    int res;
    Context con;
    ArrayList<EmployeeJson> elist;
    LayoutInflater minflater;

    public JsonArrayAdapter(Context con, int res, ArrayList<EmployeeJson> elist){
        super(con, res, elist);
        this.con = con;
        this.res = res;
        this.elist = elist;
        this.minflater = (LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EmployeeJson ej = getItem(position);
        View row = convertView;
        ViewHolder viewHolder;

        if(row == null) {
            row = minflater.inflate(res, parent, false);
            viewHolder = new ViewHolder(row);
            row.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)row.getTag();
        }

        viewHolder.nameTV.setText(ej.getEname());
        viewHolder.jobTitleTV.setText(ej.getJobTtile());

        return row;
    }

    @Override
    public int getCount() {
        return elist.size();
    }

    private static class ViewHolder {
        public TextView nameTV, jobTitleTV;

        public ViewHolder(View v) {
            nameTV = (TextView)v.findViewById(R.id.nameTextView);
            jobTitleTV = (TextView)v.findViewById(R.id.jobTitleTextView);
        }
    }
}
