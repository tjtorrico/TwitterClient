package net.tjtorrico.twitterclient.hashtags.di;

import net.tjtorrico.twitterclient.hashtags.ui.HashtagsFragment;
import net.tjtorrico.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TJT on 24/06/2016.
 */
@Singleton
@Component(modules = {LibsModule.class, HashtagsModule.class})
public interface HashtagsComponent {
    void inject(HashtagsFragment fragment);
}
