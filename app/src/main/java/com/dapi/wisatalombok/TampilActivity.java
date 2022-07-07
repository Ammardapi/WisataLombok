package com.dapi.wisatalombok;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TampilActivity extends AppCompatActivity {
    private ListPantaiAdapter pantaiadapter;
    private RecyclerView rvtampil;
    private DatabaseReference reference;
    private ArrayList<Pantai> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        rvtampil = findViewById(R.id.recyclerView);
        rvtampil.setHasFixedSize(true);

        reference = FirebaseDatabase.getInstance().getReference().child("pantai");

        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Pantai pantai = dataSnapshot.getValue(Pantai.class);
                    list.add(pantai);
                }
                showRecyclerList();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void showRecyclerList() {
        rvtampil.setLayoutManager(new LinearLayoutManager(this));
        pantaiadapter = new ListPantaiAdapter(getApplicationContext(), list);
        rvtampil.setAdapter(pantaiadapter);
        pantaiadapter.setOnItemClickCallback(this::showSelectedClub);
    }

    private void showSelectedClub(Pantai pantai) {
        Intent intent = new Intent(TampilActivity.this,DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_NAME, pantai.getNama());
        intent.putExtra(DetailActivity.EXTRA_DETAIL, pantai.getDetail());
        intent.putExtra(DetailActivity.EXTRA_LOGO, pantai.getLogo());
        intent.putExtra(DetailActivity.EXTRA_LINK, pantai.getMaps());
        startActivity(intent);
    }
}