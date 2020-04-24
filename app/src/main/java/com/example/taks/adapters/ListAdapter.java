package com.example.taks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.taks.R;
import com.example.taks.models.ListModel;
import com.example.taks.presenters.LoginView;


public class ListAdapter extends ArrayAdapter<ListModel> implements AdapterView.OnClickListener {
    private int resId;
    private Context context;
    private ListModel[] listModels;
    private LoginView loginView;

    public ListAdapter(Context context, int resource, ListModel[] listModels , LoginView loginView) {
        super(context, resource, listModels);
        this.context = context;
        this.resId = resource;
        this.listModels = listModels;
        this.loginView = loginView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resId, parent, false);
        TextView name = view.findViewById(R.id.nav_name);
        TextView email = view.findViewById(R.id.nav_email);
        TextView logout = view.findViewById(R.id.nav_logout);
        TextView dashboard = view.findViewById(R.id.vav_dashboard);
        logout.setOnClickListener(this);
        dashboard.setOnClickListener(this);
        ListModel listModel = listModels[position];
        name.setText(listModel.getName());
        email.setText(listModel.getEmail());
        return view;
    }


    @Override
    public void onClick(View v) {
       if (v.getId()==R.id.nav_logout){
           loginView.onLogout("logOut");
       }else if (v.getId()==R.id.vav_dashboard){
           loginView.onClickDashboard();
       }

    }
}
