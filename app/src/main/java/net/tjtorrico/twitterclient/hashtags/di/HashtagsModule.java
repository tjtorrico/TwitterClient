package net.tjtorrico.twitterclient.hashtags.di;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import net.tjtorrico.twitterclient.api.CustomTwitterApiClient;
import net.tjtorrico.twitterclient.hashtags.HashtagsInteractor;
import net.tjtorrico.twitterclient.hashtags.HashtagsInteractorImpl;
import net.tjtorrico.twitterclient.hashtags.HashtagsPresenter;
import net.tjtorrico.twitterclient.hashtags.HashtagsPresenterImpl;
import net.tjtorrico.twitterclient.hashtags.HashtagsRepository;
import net.tjtorrico.twitterclient.hashtags.HashtagsRepositoryImpl;
import net.tjtorrico.twitterclient.hashtags.entities.Hashtag;
import net.tjtorrico.twitterclient.hashtags.ui.HashtagsView;
import net.tjtorrico.twitterclient.hashtags.ui.adapters.HashtagsAdapter;
import net.tjtorrico.twitterclient.hashtags.ui.adapters.OnItemClickListener;
import net.tjtorrico.twitterclient.lib.base.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
    @Provides
    @Singleton
    HashtagsAdapter providesAdapter(List<Hashtag> dataset, OnItemClickListener clickListener){
        return new HashtagsAdapter(dataset, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> providesItemsList(){
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    HashtagsPresenter providesHashtagsPresenter(HashtagsView view, EventBus eventBus, HashtagsInteractor interactor){
        return new HashtagsPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    HashtagsView providesHashtagsView(){
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsInteractor providesHashtagsInteractor(HashtagsRepository repository){
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository providesHashtagsRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new HashtagsRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(Session session){
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    Session providesTwitterSession(){
        return Twitter.getSessionManager().getActiveSession();
    }
}
