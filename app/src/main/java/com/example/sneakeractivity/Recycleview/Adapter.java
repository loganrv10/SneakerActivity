package com.example.sneakeractivity.Recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sneakeractivity.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<SneakerHolder> {
   List<ResponseDTO> shoeList ;
   ItemCliclkLister itemCliclkLister;

    public Adapter(List<ResponseDTO> shoeList, ItemCliclkLister itemCliclkLister) {
        this.shoeList = shoeList;
        this.itemCliclkLister = itemCliclkLister;
    }

    @NonNull
    @Override
    public SneakerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
         return new SneakerHolder(view,itemCliclkLister);
    }

    @Override
    public void onBindViewHolder(@NonNull SneakerHolder holder, int position) {
       ResponseDTO responseDTO = shoeList.get(position);
       holder.setData(responseDTO);
    }

    @Override
    public int getItemCount() {
        return shoeList.size();
    }
}
