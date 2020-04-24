package com.example.taks.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taks.R;
import com.example.taks.models.PostModel;
import com.example.taks.ui.WhatsHotFragment;

import java.util.ArrayList;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private View view;
    private Fragment context;
    private ArrayList<PostModel> models;

    public PostsAdapter(Fragment context , ArrayList<PostModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context.getContext()).inflate(R.layout.post_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.postTitle.setText(models.get(position).getTitle());
        holder.postBody.setText(models.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView postTitle , postBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            postTitle = itemView.findViewById(R.id.post_title);
            postBody = itemView.findViewById(R.id.post_body);
        }
    }
}
