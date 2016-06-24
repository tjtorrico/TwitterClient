package net.tjtorrico.twitterclient.images.di;

import net.tjtorrico.twitterclient.images.ui.ImagesFragment;
import net.tjtorrico.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TJT on 24/06/2016.
 */
@Singleton
@Component(modules = {LibsModule.class, ImagesModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
}
