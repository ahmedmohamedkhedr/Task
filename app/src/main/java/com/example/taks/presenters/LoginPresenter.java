package com.example.taks.presenters;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.taks.models.AccountModel;
import com.example.taks.models.ApiResponse;
import com.example.taks.models.Data;
import com.example.taks.reposetories.LoginApiClient;
import com.example.taks.reposetories.LoginRepo;
import com.example.taks.ui.StartApplication;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

public class LoginPresenter {
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String email, String password) {

        AccountModel model = new AccountModel(email, password);
        Retrofit retrofit = LoginRepo.getInstant().getClient();
        LoginApiClient client = retrofit.create(LoginApiClient.class);
        Call<ApiResponse> call = client.login(model);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getReturn()){
                        loginView.onLogin(null, response.body());
                        SharedPreferences preferences = StartApplication.getSharedPreferences();
                        preferences.edit().putString("login", "yes").commit();
                        preferences.edit().putString("name",response.body().getData().getName()).commit();
                        preferences.edit().putString("email",response.body().getData().getEmail()).commit();

                    }
                } else {
                    loginView.onLogin(response.message() + " : email or password is wrong try again", null);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });

    }
}
