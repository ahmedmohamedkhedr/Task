package com.example.taks.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taks.R;
import com.example.taks.adapters.PhotosAdapter;
import com.example.taks.adapters.PostsAdapter;
import com.example.taks.presenters.PostsPresenter;
import com.example.taks.presenters.PostsView;


public class WhatsHotFragment extends Fragment implements PostsView {
    private View view;
    private RecyclerView recyclerView;
    private PostsPresenter postsPresenter;


    public WhatsHotFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_whats_hot, container, false);
        recyclerView = view.findViewById(R.id.postsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        postsPresenter = new PostsPresenter(this,this);
        postsPresenter.getAllPosts();
        return view;

    }

    @Override
    public void getPosts(PostsAdapter postsAdapter) {
        if (postsAdapter!=null){
            recyclerView.setAdapter(postsAdapter);
        }
    }

    @Override
    public void getPhotos(PhotosAdapter photosAdapter) {

    }
}
