package com.example.dns.leapfrog2.module;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.dns.leapfrog2.R;

/**
 * Created by Dns on 2/2/2016.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mcontext;

    public ImageAdapter(Context c){
        this.mcontext = c;
    }

    @Override
    public int getCount() {
        return mImageNum.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mcontext);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mImageNum[position]);
        return imageView;
    }

    private Integer[] mImageNum = {
            R.drawable.cat1, R.drawable.cat1,
            R.drawable.cat1, R.drawable.cat1,
            R.drawable.cat1, R.drawable.cat1,
            R.drawable.cat1, R.drawable.cat1,
            R.drawable.cat1, R.drawable.cat1,
            R.drawable.cat1, R.drawable.cat1,
    };
}
