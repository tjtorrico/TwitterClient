package net.tjtorrico.twitterclient.images.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import net.tjtorrico.twitterclient.R;
import net.tjtorrico.twitterclient.TwitterClientApp;
import net.tjtorrico.twitterclient.images.ImagesPresenter;
import net.tjtorrico.twitterclient.images.di.ImagesComponent;
import net.tjtorrico.twitterclient.images.entities.Image;
import net.tjtorrico.twitterclient.images.ui.adapters.ImagesAdapter;
import net.tjtorrico.twitterclient.images.ui.adapters.OnItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagesFragment extends Fragment implements ImagesView, OnItemClickListener {


    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.viewPager)
    FrameLayout viewPager;

    @Inject
    ImagesPresenter presenter;
    @Inject
    ImagesAdapter adapter;

    public ImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);

        setupInjection();
        setupRecyclerView();
        presenter.getImageTweets();
        return view;
    }

    private void setupInjection() {
        TwitterClientApp app = (TwitterClientApp) getActivity().getApplication();
        ImagesComponent imagesComponent = app.getImagesComponent(this, this, this);
        imagesComponent.inject(this);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onItemClick(Image image) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(image.getImageURL()));
        startActivity(intent);
    }

    @Override
    public void showImages() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideImages() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String error) {
        Snackbar.make(viewPager, error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setContent(List<Image> items) {
        adapter.setItems(items);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
