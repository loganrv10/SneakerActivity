package com.example.sneakeractivity.Recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sneakeractivity.R;

public class SneakerHolder extends RecyclerView.ViewHolder {

    private LinearLayout linearLayout;
    private ImageView mIvImageShoe;
    private TextView mTvShoePrice, mTvShoeName;
    private ItemCliclkLister itemCliclkLister;


    public SneakerHolder(@NonNull View itemView, ItemCliclkLister itemCliclkLister) {
        super(itemView);
        this.itemCliclkLister = itemCliclkLister;
        initView(itemView);
    }

    private void initView(View itemView) {
       linearLayout = itemView.findViewById(R.id.linearLayout);
       mIvImageShoe = itemView.findViewById(R.id.IvImageShoe);
        mTvShoePrice = itemView.findViewById(R.id.TvShoePrice);
        mTvShoeName = itemView.findViewById(R.id.TvShoeName);
    }

    public void setData(ResponseDTO responseDTO) {
        Glide.with(mIvImageShoe).load(responseDTO.getMedia().getImageUrl()).into(mIvImageShoe);
        mTvShoeName.setText(responseDTO.getName());
        mTvShoePrice.setText(responseDTO.getRetailPrice()+ "");
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCliclkLister.onClickListener(responseDTO,getAdapterPosition());
            }
        });

    }
}
