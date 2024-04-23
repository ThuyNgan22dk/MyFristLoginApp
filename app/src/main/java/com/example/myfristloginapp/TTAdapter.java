package com.example.myfristloginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TTAdapter extends RecyclerView.Adapter<TTAdapter.TTViewHolder>{
    List<Thtin> mListData;
    Context context;

    public TTAdapter(Context context, List<Thtin> mListData) {
        this.context = context;
        this.mListData = mListData;
    }

    @NonNull
    @Override
    public TTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_th_tin, parent, false);
        return new TTViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TTViewHolder holder, int position) {
        if(mListData != null && mListData.size() > 0){
            Thtin model = mListData.get(position);
            holder.tvNgay.setText(model.getNgay());
            holder.tvSoLan.setText(model.getSoLan());
            holder.tvDanhGia.setText(model.getDanhGia());
        } else{
            return;
        }
    }

    @Override
    public int getItemCount() {
        if(mListData != null){

            return mListData.size();
        }
        return 0;
    }

    public static class TTViewHolder extends RecyclerView.ViewHolder{
        TextView tvNgay, tvSoLan, tvDanhGia;

        public TTViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNgay = itemView.findViewById(R.id.tv_ngay);
            tvSoLan = itemView.findViewById(R.id.tv_soLan);
            tvDanhGia = itemView.findViewById(R.id.tv_danhGia);
        }
    }
}
