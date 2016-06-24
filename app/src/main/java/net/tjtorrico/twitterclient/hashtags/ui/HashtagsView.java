package net.tjtorrico.twitterclient.hashtags.ui;

import net.tjtorrico.twitterclient.hashtags.entities.Hashtag;

import java.util.List;

/**
 * Created by TJT on 24/06/2016.
 */
public interface HashtagsView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Hashtag> items);
}
