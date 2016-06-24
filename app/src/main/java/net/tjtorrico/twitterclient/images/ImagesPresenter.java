package net.tjtorrico.twitterclient.images;

import net.tjtorrico.twitterclient.images.events.ImagesEvent;

/**
 * Created by TJT on 24/06/2016.
 */
public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
