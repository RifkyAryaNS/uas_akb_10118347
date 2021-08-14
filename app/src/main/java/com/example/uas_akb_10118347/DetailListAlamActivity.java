package com.example.uas_akb_10118347;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// Rifky Arya Nur Salman - IF 8 - 10118347
// 14 agustus 2021

public class DetailListAlamActivity extends AppCompatActivity {
    String judul, descripsi, image;
    double lat, lng;
    LatLng latLng;

    TextView nama, desc;
    ImageView gambar;

    GoogleMap map;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_list_alam);
        nama = findViewById(R.id.tv_nama_data_alam);
        desc = findViewById(R.id.tv_desc_data_alam);
        gambar = findViewById(R.id.img_data_alam);


        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        judul = getIntent().getStringExtra("extra_nama_data_alam");
        descripsi = getIntent().getStringExtra("extra_desc_data_alam");
        image = getIntent().getStringExtra("extra_gambar_data_alam");
        lat = getIntent().getDoubleExtra("extra_lat_data_alam",0);
        lng = getIntent().getDoubleExtra("extra_lng_data_alam", 0);
        latLng = new LatLng(lat,lng);

        nama.setText(judul);
        desc.setText(descripsi);
        Glide.with(getApplicationContext()).load(image).into(gambar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this::onMapReady);

    }

    public void onMapReady(GoogleMap googleMap){
        map = googleMap;
        map.addMarker(new MarkerOptions().position(latLng). title(judul));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15f));
    }

}
