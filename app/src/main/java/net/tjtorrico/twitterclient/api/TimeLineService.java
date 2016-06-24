package net.tjtorrico.twitterclient.api;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by TJT on 24/06/2016.
 */
public interface TimeLineService {
    @GET("/1.1/statuses/home_timeline.json")
    void homeTimeLine(@Query("count") Integer count,
                      @Query("trim_user") Boolean trim_user,
                      @Query("exclude_replies") Boolean exclude_replies,
                      @Query("contributor_details") Boolean contributor_details,
                      @Query("include_entities") Boolean include_entities,
                      Callback<List<Tweet>> callback);

}