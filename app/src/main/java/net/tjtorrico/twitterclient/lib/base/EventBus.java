package net.tjtorrico.twitterclient.lib.base;

/**
 * Created by TJT on 24/06/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
