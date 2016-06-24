package net.tjtorrico.twitterclient.images.events;

import net.tjtorrico.twitterclient.images.entities.Image;

import java.util.List;

/**
 * Created by TJT on 24/06/2016.
 */
public class ImagesEvent {
    private String error;
    private List<Image> images;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
