package com.example.uas_akb_10118347;

// Rifky Arya Nur Salman - IF 8 - 10118347
// 13 agustus 2021

import com.google.android.gms.maps.model.LatLng;

public class DataAlam{
  String nama;
  String desc;
  String gambar;
  LatLng latLng;


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {

        this.nama = nama;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public String getGambar() {

        return gambar;
    }

    public void setGambar(String gambar) {

        this.gambar = gambar;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng LatLng) {
        this.latLng = latLng;
    }

    public DataAlam(String nama, String desc, String gambar, LatLng latLng) {
        this.nama = nama;
        this.desc = desc;
        this.gambar = gambar;
        this.latLng = latLng;
    }
}
