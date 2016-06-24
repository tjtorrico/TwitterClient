package net.tjtorrico.twitterclient.images;

/**
 * Created by TJT on 24/06/2016.
 */
public class ImagesInteractorImpl implements ImagesInteractor{
    private ImagesRepository repository;

    public ImagesInteractorImpl(ImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}