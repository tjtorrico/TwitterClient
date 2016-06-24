package net.tjtorrico.twitterclient.hashtags.events;

import net.tjtorrico.twitterclient.hashtags.entities.Hashtag;

import java.util.List;

/**
 * Created by TJT on 24/06/2016.
 */
public class HashtagsEvent {
    private String error;
    private List<Hashtag> hashtags;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
