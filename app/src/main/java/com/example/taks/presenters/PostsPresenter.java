package com.example.taks.presenters;

import androidx.fragment.app.Fragment;

import com.example.taks.adapters.PhotosAdapter;
import com.example.taks.adapters.PostsAdapter;
import com.example.taks.models.PhotoModel;
import com.example.taks.models.PostModel;
import com.example.taks.reposetories.PostsApiClient;
import com.example.taks.reposetories.PostsRepo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostsPresenter {
    private PostsView postsView;
    private Fragment fragment;

    public PostsPresenter(PostsView postsView, Fragment fragment) {
        this.postsView = postsView;
        this.fragment = fragment;
    }

    public void getAllPosts() {
        Retrofit retrofit = PostsRepo.getInstance().createRetrofitConnection();
        PostsApiClient postsApiClient = retrofit.create(PostsApiClient.class);
        Call<ArrayList<PostModel>> call = postsApiClient.getPosts();
        call.enqueue(new Callback<ArrayList<PostModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {
                if (response.isSuccessful()) {
                    PostsAdapter postsAdapter = new PostsAdapter(fragment, response.body());
                    postsView.getPosts(postsAdapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getAllPhotos() {
        Retrofit retrofit = PostsRepo.getInstance().createRetrofitConnection();
        PostsApiClient postsApiClient = retrofit.create(PostsApiClient.class);
        Call<ArrayList<PhotoModel>> call = postsApiClient.getPhotos();
        call.enqueue(new Callback<ArrayList<PhotoModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PhotoModel>> call, Response<ArrayList<PhotoModel>> response) {
                if (response.isSuccessful()){
                    PhotosAdapter photosAdapter = new PhotosAdapter(fragment,response.body());
                    postsView.getPhotos(photosAdapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PhotoModel>> call, Throwable t) {
               t.printStackTrace();
            }
        });
    }
}
