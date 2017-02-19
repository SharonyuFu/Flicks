package com.codepath.flicks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by sharonyu on 2017/2/18.
 */

public class MyAdapter extends BaseAdapter {

    private Context myContext;
    private MovieGson myData;
    private int mOrientation;
    private int mScreenWidth;
    private final int ITEM_TYPE_NOT_POPULAR = 0;
    private final int ITEM_TYPE_POPULAR = 1;

    public MyAdapter(Context context, MovieGson data) {
        this.myContext = context;
        this.myData = data;
    }


    private static class ViewHolder {
        ImageView imagePoster;
        TextView textTitle;
        TextView textOverview;
    }


    @Override
    public int getCount() {
        if (myData != null) {
            return myData.results.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        int type = getItemViewType(position);

        if (view == null) {
            view = LayoutInflater.from(myContext).inflate(R.layout.list_item_type1, parent, false);
            holder = new ViewHolder();
            holder.imagePoster = (ImageView) view.findViewById(R.id.image_poster);
            holder.textTitle = (TextView) view.findViewById(R.id.text_title);
            holder.textOverview = (TextView) view.findViewById(R.id.text_overview);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.textTitle.setText(myData.results.get(position).title);
        holder.textOverview.setText(myData.results.get(position).overview);

        Picasso.with(myContext).load(getImageUrl(myData.results.get(position).poster_path))
                .into(holder.imagePoster);


        return view;
    }

    @Override
    public int getItemViewType(int position) {

        if (myData.results.get(position).vote_average >= 5.0f) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {

        return 2;
    }

    private String getImageUrl(String urlFromApi) {
        String prefix = "https://image.tmdb.org/t/p/w780";
        String urlArray = urlFromApi.substring(0, urlFromApi.length());
        return prefix + urlArray;
    }


}



