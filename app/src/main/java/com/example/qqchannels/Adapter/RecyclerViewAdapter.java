package com.example.qqchannels.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qqchannels.R;
import com.example.qqchannels.classes.Photo;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Photo> mPhotoList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView photoImage;


        public ViewHolder(@NonNull View view) {
            super(view);
            photoImage = view.findViewById(R.id.photo_image);

        }
    }

    public RecyclerViewAdapter(List<Photo> photoList) {
        mPhotoList = photoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
         ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo = mPhotoList.get(position);
        holder.photoImage.setImageResource(photo.getImageId());

    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }
}
