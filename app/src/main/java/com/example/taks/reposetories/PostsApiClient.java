package com.example.taks.reposetories;

import com.example.taks.models.PhotoModel;
import com.example.taks.models.PostModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsApiClient {
    @GET("posts")
    Call<ArrayList<PostModel>> getPosts();

    @GET("photos")
    Call<ArrayList<PhotoModel>> getPhotos();
}
