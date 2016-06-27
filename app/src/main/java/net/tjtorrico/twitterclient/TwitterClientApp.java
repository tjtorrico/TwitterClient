package net.tjtorrico.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import net.tjtorrico.twitterclient.hashtags.di.DaggerHashtagsComponent;
import net.tjtorrico.twitterclient.hashtags.di.HashtagsComponent;
import net.tjtorrico.twitterclient.hashtags.di.HashtagsModule;
import net.tjtorrico.twitterclient.hashtags.ui.HashtagsView;
import net.tjtorrico.twitterclient.images.di.DaggerImagesComponent;
import net.tjtorrico.twitterclient.images.di.ImagesComponent;
import net.tjtorrico.twitterclient.images.di.ImagesModule;
import net.tjtorrico.twitterclient.images.ui.ImagesView;
import net.tjtorrico.twitterclient.lib.di.LibsModule;

import io.fabric.sdk.android.Fabric;

/**
 * Created by TJT on 24/06/2016.
 */
public class TwitterClientApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        iniFabric();
    }

    private void iniFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY,BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, net.tjtorrico.twitterclient.images.ui.adapters.OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view, clickListener))
                .build();
    }

    public HashtagsComponent getHastagsComponent(HashtagsView view, net.tjtorrico.twitterclient.hashtags.ui.adapters.OnItemClickListener clickListener){
        return DaggerHashtagsComponent
                .builder()
                .libsModule(new LibsModule(null))
                .hashtagsModule(new HashtagsModule(view, clickListener))
                .build();
    }
}
