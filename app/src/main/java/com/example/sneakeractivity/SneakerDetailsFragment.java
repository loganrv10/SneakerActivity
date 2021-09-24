package com.example.sneakeractivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class SneakerDetailsFragment extends Fragment {

    private ImageView detailsImage;
    private TextView mdetailsBrand,mdetailYear,detailsPrice,name;
    private Button btn1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sneaker_details, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        detailsImage = view.findViewById(R.id.detailsImage);
        mdetailsBrand = view.findViewById(R.id.detailsBrand);
        mdetailYear = view.findViewById(R.id.detailYear);
        detailsPrice = view.findViewById(R.id.detailsPrice);
        name = view.findViewById(R.id.detailsname);
        Bundle bundle = this.getArguments();
        Glide.with(detailsImage).load(bundle.getString("pic1")).into(detailsImage);
        String title = bundle.getString("title1");
        name.setText(title);
        String title2 = bundle.getString("subtitle1");
        mdetailsBrand.setText(title2);




    }
}