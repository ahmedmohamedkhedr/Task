package com.example.taks.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taks.R;
import com.example.taks.models.ApiResponse;
import com.example.taks.presenters.LoginPresenter;
import com.example.taks.presenters.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    @BindView(R.id.editEmail)
    EditText editEmail;
    @BindView(R.id.editPassword)
    EditText editPassword;
    @BindView(R.id.loginBtn)
    Button loginBtn;
    @BindView(R.id.loginProgressBar)
    ProgressBar loginProgressBar;
    private LoginPresenter loginPresenter;
    private ApiResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onLogin(String errorMessage, ApiResponse response) {
        if (errorMessage == null) {
            this.response = response;
            sendToMainActivity();
        } else {
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
        loginProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLogout(String message) {

    }

    @Override
    public void onClickDashboard() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginBtn) {
            String email = editEmail.getText().toString();
            String password = editPassword.getText().toString();
            if (!("".equals(email)) && !("".equals(password))) {
                loginPresenter.login(email, password);
                loginProgressBar.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(this, "Enter email and password", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void sendToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", response.getData().getName());
        intent.putExtra("email", response.getData().getName());
        startActivity(intent);
        finish();
    }
}
