package com.example.taks.presenters;

import com.example.taks.models.ApiResponse;

public interface LoginView {
    void onLogin(String errorMessage , ApiResponse response);
    void onLogout(String message);
    void onClickDashboard();
}
