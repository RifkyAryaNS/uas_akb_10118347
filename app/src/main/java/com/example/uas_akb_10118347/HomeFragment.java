package com.example.uas_akb_10118347;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import java.util.ArrayList;

// Rifky Arya Nur Salman - IF 8 - 10118347
// 14 agustus 2021
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    DataAlamAdapter dataAlamAdapter;
    DaftarAlamImplement daftarAlamImplement;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.list_data_alam);
        daftarAlamImplement = new DaftarAlamImplement();
        daftarAlamImplement.getDataAlam();
        daftarAlamImplement.setDataAlamListener(result -> {
            dataAlamAdapter = new DataAlamAdapter(getContext(), new ArrayList(result));
            recyclerView.setAdapter(dataAlamAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setHasFixedSize(true);

            dataAlamAdapter.setOnitemClick(data -> {
                Intent intent = new Intent(getContext(), DetailListAlamActivity.class);
                intent.putExtra("extra_nama_data_alam", data.getNama());
                intent.putExtra("extra_desc_data_alam", data.getDesc());
                intent.putExtra("extra_gambar_data_alam", data.getGambar());
                intent.putExtra("extra_lat_data_alam", data.getLatLng().latitude);
                intent.putExtra("extra_lng_data_alam", data.getLatLng().longitude);
                startActivity(intent);

            });
        });
    }
}