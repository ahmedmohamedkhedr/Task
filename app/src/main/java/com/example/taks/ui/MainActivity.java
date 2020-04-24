package com.example.taks.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.taks.R;
import com.example.taks.adapters.ListAdapter;
import com.example.taks.models.ApiResponse;
import com.example.taks.models.ListModel;
import com.example.taks.presenters.LoginView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener , LoginView {

    @BindView(R.id.mainToolbar)
    Toolbar mainToolbar;
    @BindView(R.id.navigationBar)
    BottomNavigationView navigationBar;

    @BindView(R.id.list)
    ListView list;
    @BindView(R.id.nav_drawer)
    DrawerLayout navDrawer;

    private WhatsHotFragment whatsHotFragment;
    private PhotosFragment photosFragment;
    private DashboardFragment dashboardFragment;
    private ListAdapter adapter;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        whatsHotFragment = new WhatsHotFragment();
        photosFragment = new PhotosFragment();
        dashboardFragment = new DashboardFragment();
        ListModel[] listModels = {new ListModel(StartApplication.getSharedPreferences().getString("name", "")
                , StartApplication.getSharedPreferences().getString("email", ""))};
        adapter = new ListAdapter(this, R.layout.list_item, listModels , this);
        list.setAdapter(adapter);
        //list.setOnItemClickListener(new DrawerItemSelected());
        navDrawer.setDrawerListener(actionBarDrawerToggle);
        setUpDrawerToggle();
        initializeFragment();
        navigationBar.setOnNavigationItemSelectedListener(this);

    }

    private void initializeFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, whatsHotFragment);
        fragmentTransaction.add(R.id.container, photosFragment);
        fragmentTransaction.add(R.id.container,dashboardFragment);
        fragmentTransaction.show(whatsHotFragment);
        fragmentTransaction.hide(photosFragment);
        fragmentTransaction.hide(dashboardFragment);
        fragmentTransaction.commit();

    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (fragment == whatsHotFragment) {
            fragmentTransaction.hide(photosFragment);
            fragmentTransaction.hide(dashboardFragment);
        } else if (fragment == photosFragment) {
            fragmentTransaction.hide(whatsHotFragment);
            fragmentTransaction.hide(dashboardFragment);
        }else {
            fragmentTransaction.hide(photosFragment);
            fragmentTransaction.hide(whatsHotFragment);


        }
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences preferences = StartApplication.getSharedPreferences();
        if (preferences.getString("login", "").equals("no")) {
            sendToLoginActivity();
        }

    }

    private void sendToLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.whatsHot:
                replaceFragment(whatsHotFragment);
                return true;

            case R.id.photos:
                replaceFragment(photosFragment);

                return true;

            default:
                return false;
        }

    }

    private void setUpDrawerToggle() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, navDrawer, mainToolbar, R.string.app_name, R.string.app_name);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onLogin(String errorMessage, ApiResponse response) {

    }

    @Override
    public void onLogout(String message) {
       if ("logOut".equals(message)){
           StartApplication.getSharedPreferences().edit().putString("login","no").commit();
           sendToLoginActivity();
       }
    }

    @Override
    public void onClickDashboard() {
        replaceFragment(dashboardFragment);
        navDrawer.closeDrawer(list);
    }

}
