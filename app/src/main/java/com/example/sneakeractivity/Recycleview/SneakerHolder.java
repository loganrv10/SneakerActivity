package com.example.sneakeractivity.Recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SneakerHolder extends RecyclerView.ViewHolder {

    private LinearLayout linearLayout;
    private ImageView mIvImageShoe;
    private TextView mTvShoePrice, mTvShoeName;

    public SneakerHolder(@NonNull View itemView) {
        super(itemView);
    }
}
