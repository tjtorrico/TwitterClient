package net.tjtorrico.twitterclient.hashtags.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by TJT on 24/06/2016.
 */
public class HashtagsListAdapter {
    private List<String> items;

    public HashtagsListAdapter(List<String> items) {
        this.items = items;
    }



    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
