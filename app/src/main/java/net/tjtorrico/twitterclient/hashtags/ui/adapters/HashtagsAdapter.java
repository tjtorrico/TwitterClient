package net.tjtorrico.twitterclient.hashtags.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.tjtorrico.twitterclient.hashtags.entities.Hashtag;

import java.util.List;

/**
 * Created by TJT on 24/06/2016.
 */
public class HashtagsAdapter {
    private List<Hashtag> items;
    private OnItemClickListener clickListener;


    public HashtagsAdapter(List<Hashtag> items, OnItemClickListener clickListener) {
        this.items = items;
        this.clickListener = clickListener;
    }



    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
