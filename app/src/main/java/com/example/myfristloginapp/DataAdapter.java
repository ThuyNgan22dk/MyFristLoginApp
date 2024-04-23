package com.example.myfristloginapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>{
    private List<Data> mListData;

    public DataAdapter(List<Data> mListData) {
        this.mListData = mListData;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Data data = mListData.get(position);
        if(data == null){
            return;
        }
        holder.tvDate.setText("Date: " + data.getDate());
        holder.tvScore.setText("Score: " + data.getScore());
    }

    @Override
    public int getItemCount() {
        if(mListData != null){

            return mListData.size();
        }
        return 0;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{
        private TextView tvDate;
        private TextView tvScore;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvScore = itemView.findViewById(R.id.tv_score);
        }
    }
}
