package com.example.uas_akb_10118347;

import android.util.Log;

import com.example.uas_akb_10118347.DataAlam;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Rifky Arya Nur Salman - IF 8 - 10118347
// 13 agustus 2021

public class DaftarAlamImplement implements DataAlamInterfaces {

    FirebaseDatabase db = FirebaseDatabase.getInstance("https://uas-akb-10118347-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference myRef = db.getReference("alam");

    private DataAlamListener dataAlamListener;

    public void setDataAlamListener(DataAlamListener listener) {
        this.dataAlamListener = listener;
    }

    @Override
    public void getDataAlam() {
        Log.d("Tag JSON", String.valueOf(db));
        myRef.child("cimahi").get().addOnCompleteListener(task -> {
           if (!task.isSuccessful()) {
               Log.e("firebase", "Error getting data", task.getException());
           } else {
               ArrayList<Object> res = (ArrayList<Object>) task.getResult().getValue();
               Log.d("Tag JSON", "getDataAlam" + res);

               ArrayList<DataAlam> result = new ArrayList<DataAlam>();
               for(int i = 0; i < res.size(); i++) {
                   HashMap<String, Object> explorObject = (HashMap<String, Object>) res.get(i);
                   Log.d("Tag JSON SATUAN", "getDataAlam:" + explorObject);

                   String nama = (String) explorObject.get("nama");
                   String desc = (String) explorObject.get("desc");
                   String gambar = (String) explorObject.get("gambar");
                   String lat = String.valueOf(explorObject.get("latitude"));
                   String lang = String.valueOf(explorObject.get("longitude"));

                   DataAlam dataAlam = new DataAlam(nama, desc, gambar, new LatLng(Double.parseDouble(lat), Double.parseDouble(lang)));
                   result.add(dataAlam);
               }
               dataAlamListener.onSuccess(result);
           }
        });


        }

    public interface DataAlamListener {
        void onSuccess(List<DataAlam> result);
    }
}
