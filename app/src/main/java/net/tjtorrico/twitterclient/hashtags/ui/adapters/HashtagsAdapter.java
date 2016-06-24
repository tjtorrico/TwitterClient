package net.tjtorrico.twitterclient.hashtags.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.tjtorrico.twitterclient.R;
import net.tjtorrico.twitterclient.hashtags.entities.Hashtag;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by TJT on 24/06/2016.
 */
public class HashtagsAdapter extends RecyclerView.Adapter<HashtagsAdapter.ViewHolder>{
    private List<Hashtag> dataset;
    private OnItemClickListener clickListener;


    public HashtagsAdapter(List<Hashtag> items, OnItemClickListener clickListener) {
        this.dataset = items;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_hashtags, parent, false);
        return new ViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hashtag hashtag = dataset.get(position);
        holder.setOnClickListener(hashtag, clickListener);
        holder.txtTweet.setText(hashtag.getTweetText());
        holder.setItems(hashtag.getHashtags());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setItems(List<Hashtag> newItems){
        dataset.addAll(newItems);
        notifyDataSetChanged();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtTweet)
        TextView txtTweet;
        @Bind(R.id.recyclerView)
        RecyclerView recyclerView;

        private View view;
        private ArrayList<String> items;
        private HashtagsListAdapter adapter;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = itemView;

            items = new ArrayList<String>();
            adapter = new HashtagsListAdapter(items);
            CustomGridLayoutManager layoutManager = new CustomGridLayoutManager(context, 3);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        public void setItems(List<String> newItems){
            items.clear();
            items.addAll(newItems);
            adapter.notifyDataSetChanged();
        }

        public void setOnClickListener(final Hashtag hashtag, final OnItemClickListener listener){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(hashtag);
                }
            });
        }
    }
}
