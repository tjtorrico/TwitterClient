package net.tjtorrico.twitterclient.images.di;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import net.tjtorrico.twitterclient.api.CustomTwitterApiClient;
import net.tjtorrico.twitterclient.images.ImagesInteractor;
import net.tjtorrico.twitterclient.images.ImagesInteractorImpl;
import net.tjtorrico.twitterclient.images.ImagesPresenter;
import net.tjtorrico.twitterclient.images.ImagesPresenterImpl;
import net.tjtorrico.twitterclient.images.ImagesRepository;
import net.tjtorrico.twitterclient.images.ImagesRepositoryImpl;
import net.tjtorrico.twitterclient.images.entities.Image;
import net.tjtorrico.twitterclient.images.ui.ImagesView;
import net.tjtorrico.twitterclient.images.ui.adapters.ImagesAdapter;
import net.tjtorrico.twitterclient.images.ui.adapters.OnItemClickListener;
import net.tjtorrico.twitterclient.lib.base.EventBus;
import net.tjtorrico.twitterclient.lib.base.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 24/06/2016.
 */
@Module
public class ImagesModule {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener){
        return new ImagesAdapter(dataset, imageLoader, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Image> providesItemsList(){
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    ImagesPresenter providesImagesPresenter(ImagesView view, EventBus eventBus, ImagesInteractor interactor){
        return new ImagesPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    ImagesView providesImagesView(){
        return this.view;
    }

    @Provides
    @Singleton
    ImagesInteractor providesImagesInteractor(ImagesRepository repository){
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new ImagesRepositoryImpl(eventBus, client);
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
