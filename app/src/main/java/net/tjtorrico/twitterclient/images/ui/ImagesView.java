package net.tjtorrico.twitterclient.images.ui;

import net.tjtorrico.twitterclient.images.entities.Image;

import java.util.List;

/**
 * Created by TJT on 24/06/2016.
 */
public interface ImagesView {
    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> items);
}
