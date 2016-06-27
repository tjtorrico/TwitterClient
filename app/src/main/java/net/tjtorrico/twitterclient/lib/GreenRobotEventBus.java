package net.tjtorrico.twitterclient.lib;

import net.tjtorrico.twitterclient.lib.base.EventBus;

/**
 * Created by TJT on 24/06/2016.
 */
public class GreenRobotEventBus implements EventBus {
    org.greenrobot.eventbus.EventBus eventBus;

    public GreenRobotEventBus(org.greenrobot.eventbus.EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void register(Object subscriber) {
        this.eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        this.eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        this.eventBus.post(event);
    }
}