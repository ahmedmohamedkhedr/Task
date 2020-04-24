package com.example.taks.presenters;

import com.example.taks.adapters.PhotosAdapter;
import com.example.taks.adapters.PostsAdapter;

public interface PostsView {

    void getPosts(PostsAdapter postsAdapter);
    void getPhotos(PhotosAdapter photosAdapter);
}
