package com.dapi.wisatalombok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPantaiAdapter extends RecyclerView.Adapter<ListPantaiAdapter.ListViewHolder> {
    private android.content.Context context;
    private ArrayList<Pantai> listPantai;

    public ListPantaiAdapter(Context context, ArrayList<Pantai> list) {
        this.context = context;
        this.listPantai = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }
    @NonNull
    @Override
    public ListPantaiAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pantai,parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Pantai pantai = listPantai.get(position);
        Glide.with(holder.itemView.getContext())
                .load(pantai.getLogo())
                .apply(new RequestOptions().override(  50,  50))
                .into(holder.imgPhoto);

        holder.tvName.setText(pantai.getNama());
        holder.tvDetail.setText(pantai.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClickedPantai(listPantai.get(holder.getAdapterPosition()));
            }
        });


    }

    @Override
    public int getItemCount() { return listPantai.size(); }
        class ListViewHolder extends RecyclerView.ViewHolder {
            ImageView imgPhoto;
            TextView tvName;
            TextView tvDetail;
            ListViewHolder(View itemview) {
                super(itemview);
                imgPhoto = itemview.findViewById(R.id.img_item);
                tvName = itemview.findViewById(R.id.tv_nama);
                tvDetail = itemview.findViewById(R.id.tv_detail);
        }
    }
}
