package com.dapi.wisatalombok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    private ImageView imgPhoto;
    private TextView tv_nama;
    private TextView tv_detail;
    private TextView tv_maps;

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_LOGO = "extra_logo";
    public static final String EXTRA_LINK = "extra_link";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle intent = getIntent().getExtras();

        String nama = intent.getString(EXTRA_NAME);
        String detail = intent.getString(EXTRA_DETAIL);
        String logo = intent.getString(EXTRA_LOGO);
        String maps = intent.getString(EXTRA_LINK);

        if (getSupportActionBar() !=null){
            getSupportActionBar().setTitle(nama);
        }

        imgPhoto = findViewById(R.id.detail_photo);
        tv_nama = findViewById(R.id.detail_name);
        tv_detail = findViewById(R.id.detail_detail);
        tv_maps = findViewById(R.id.detai_link);

        Glide.with(this)
                .load(logo)
                .apply(new RequestOptions().override(  550,  550))
                .into(imgPhoto);

        tv_nama.setText(nama);
        tv_detail.setText(detail);
        tv_maps.setText(maps);

        tv_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Membuka Google Maps"+ maps,Toast.LENGTH_SHORT).show();
                String url = maps;
                Intent link = new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse(url));
                startActivity(link);

            }
        });
    }
}