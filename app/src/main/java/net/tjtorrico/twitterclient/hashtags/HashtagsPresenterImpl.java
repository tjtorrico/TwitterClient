package net.tjtorrico.twitterclient.hashtags;

import net.tjtorrico.twitterclient.hashtags.entities.Hashtag;
import net.tjtorrico.twitterclient.hashtags.events.HashtagsEvent;
import net.tjtorrico.twitterclient.hashtags.ui.HashtagsView;
import net.tjtorrico.twitterclient.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by TJT on 24/06/2016.
 */
public class HashtagsPresenterImpl implements HashtagsPresenter {
    private EventBus eventBus;
    private HashtagsView view;
    private HashtagsInteractor interactor;

    public HashtagsPresenterImpl(EventBus eventBus, HashtagsView view, HashtagsInteractor hashtagsInteractor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = hashtagsInteractor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getHashtagTweets() {
        if (view != null) {
            view.hideList();
            view.showProgress();
        }
        interactor.getHashtagItemsList();
    }

    @Override
    @Subscribe
    public void onEventMainThread(HashtagsEvent event) {
        String errorMsg = event.getError();
        if (view != null) {
            view.showList();
            view.hideProgress();
            if (errorMsg != null) {
                this.view.onError(errorMsg);
            } else {
                List<Hashtag> items = event.getHashtags();
                if (items != null && !items.isEmpty()) {
                    view.setContent(items);
                }
            }
        }
    }
}
