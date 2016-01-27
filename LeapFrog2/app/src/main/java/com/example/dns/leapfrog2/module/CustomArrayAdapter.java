package com.example.dns.leapfrog2.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.dns.leapfrog2.R;

import java.util.ArrayList;

/**
 * Created by Dns on 1/17/2016.
 */
public class CustomArrayAdapter extends ArrayAdapter<UserInfo> {

    int resource;
    Context con;
    ArrayList<UserInfo> userlist;
    LayoutInflater mInflater;

    public CustomArrayAdapter(Context con, int resource, ArrayList<UserInfo> userlist) {
        super(con, resource, userlist);
        this.con = con;
        this.resource = resource;
        this.userlist = userlist;
        this.mInflater = (LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserInfo uinfo = getItem(position);
        ViewHolder vholder;
        View row = convertView;

        if(row == null) {
            row = mInflater.inflate(resource, parent, false);
            vholder = new ViewHolder (row);
            row.setTag(vholder);
        }
        else {
            vholder = (ViewHolder)row.getTag();
        }

        vholder.profileIV.setImageResource(uinfo.getImage_url());
        vholder.nameTV.setText(uinfo.getUser_name());
        vholder.jobTitleTV.setText(uinfo.getJob_title());

        return row;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    private static class ViewHolder {
        public TextView nameTV, jobTitleTV;
        public ImageView profileIV;

        public ViewHolder(View v) {
            nameTV = (TextView)v.findViewById(R.id.nameTextView);
            jobTitleTV = (TextView)v.findViewById(R.id.jobTitleTextView);
            profileIV = (ImageView)v.findViewById(R.id.profileImageView);
        }
    }
}
