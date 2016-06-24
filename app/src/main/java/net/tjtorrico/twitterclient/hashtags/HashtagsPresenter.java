package net.tjtorrico.twitterclient.hashtags;

import net.tjtorrico.twitterclient.hashtags.events.HashtagsEvent;

/**
 * Created by TJT on 24/06/2016.
 */
public interface HashtagsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagsEvent event);
}
