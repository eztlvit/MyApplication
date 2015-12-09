package com.example.eric.fragmentbestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eric.fragmentbestpractice.entity.News;

import java.util.List;

/**
 * Created by Eric on 2015/12/9.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    private int resourceID;

    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        resourceID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        News news = getItem(position);
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceID,null);
        }else{
            view = convertView;
        }
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        newsTitleText.setText(news.getTitle());
        return view;
    }
}
