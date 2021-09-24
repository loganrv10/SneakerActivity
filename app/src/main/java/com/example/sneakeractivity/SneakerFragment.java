package com.example.sneakeractivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sneakeractivity.Recycleview.Adapter;
import com.example.sneakeractivity.Recycleview.Apiservice;
import com.example.sneakeractivity.Recycleview.ItemCliclkLister;
import com.example.sneakeractivity.Recycleview.Network;
import com.example.sneakeractivity.Recycleview.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SneakerFragment extends Fragment implements ItemCliclkLister {

    List<ResponseDTO> responseList = new ArrayList<>();
    RecyclerView recyclerView;
    private NavController navcontroller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sneaker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview(view);

    }

    private void initview(View view) {
        recyclerView = view.findViewById(R.id.recycleView);
        Apiservice apiService = Network.getRetrofitInstance().create(Apiservice.class);
        apiService.getPost().enqueue(new Callback<List<ResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ResponseDTO>> call, Response<List<ResponseDTO>> response) {
                responseList.addAll(response.body());
                DisplayData();
            }

            @Override
            public void onFailure(Call<List<ResponseDTO>> call, Throwable t) {

            }
        });

    }
    private void DisplayData() {
        Adapter adapter = new Adapter(responseList,this);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClickListener(ResponseDTO responseDTO, int position) {
      String pic = responseDTO.getMedia().getImageUrl();
      String name = responseDTO.getName();
      String brand = responseDTO.getBrand();
      String year = responseDTO.getReleaseDate();
        Bundle bundle = new Bundle();
        bundle.putString("pic1", pic);
        bundle.putString("title1", name);
        bundle.putString("subtitle1", brand);
        bundle.putString("year",year);
        navcontroller.navigate(R.id.action_sneakerFragment_to_sneakerDetailsFragment,bundle);

    }
}