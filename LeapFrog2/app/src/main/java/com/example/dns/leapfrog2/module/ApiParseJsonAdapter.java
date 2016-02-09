package com.example.dns.leapfrog2.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dns.leapfrog2.R;

import java.util.ArrayList;

/**
 * Created by Dns on 2/9/2016.
 */
public class ApiParseJsonAdapter extends ArrayAdapter<Contact> {

        int res;
        Context con;
        ArrayList<Contact> list;
        LayoutInflater minflater;

        public ApiParseJsonAdapter(Context con, int res, ArrayList<Contact> list){
            super(con, res, list);
            this.con = con;
            this.res = res;
            this.list = list;
            this.minflater = (LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Contact con = getItem(position);
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

            viewHolder.nameTV.setText(con.getName());
            viewHolder.emailTV.setText(con.getEmail());

            return row;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        private static class ViewHolder {
            public TextView nameTV, emailTV;

            public ViewHolder(View v) {
                nameTV = (TextView)v.findViewById(R.id.nameTextView);
                emailTV = (TextView)v.findViewById(R.id.emailTextView);
            }
        }
    }
