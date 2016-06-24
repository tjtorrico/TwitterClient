package net.tjtorrico.twitterclient.hashtags.di;

import net.tjtorrico.twitterclient.hashtags.ui.HashtagsView;
import net.tjtorrico.twitterclient.hashtags.ui.adapters.OnItemClickListener;

import dagger.Module;

/**
 * Created by TJT on 24/06/2016.
 */
@Module
public class HashtagsModule {
    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

}
