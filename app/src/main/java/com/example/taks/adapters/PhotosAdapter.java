package com.example.taks.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taks.R;
import com.example.taks.models.PhotoModel;
import com.example.taks.ui.PhotoDialog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {
    private View view;
    private Fragment fragment;
    private ArrayList<PhotoModel> photoModels;

    public PhotosAdapter(Fragment fragment, ArrayList<PhotoModel> photoModels) {
        this.fragment = fragment;
        this.photoModels = photoModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(fragment.getContext()).inflate(R.layout.photo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.photoTitle.setText(photoModels.get(position).getTitle());
        Picasso.get().load(photoModels.get(position).getThumbnailUrl()).into(holder.photo);
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoDialog photoDialog = new PhotoDialog(fragment.getContext(),photoModels.get(position).getThumbnailUrl());
                photoDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView photoTitle;
        ImageView photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photoTitle = itemView.findViewById(R.id.photo_title);
            photo = itemView.findViewById(R.id.photo);
        }
    }
}
