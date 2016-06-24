package net.tjtorrico.twitterclient.hashtags;

/**
 * Created by TJT on 24/06/2016.
 */
public class HashtagsInteractorImpl implements HashtagsInteractor {
    private HashtagsRepository repository;

    public HashtagsInteractorImpl(HashtagsRepository hashtagsRepository) {
        this.repository = hashtagsRepository;
    }

    @Override
    public void getHashtagItemsList() {
        repository.getHashtags();
    }
}
