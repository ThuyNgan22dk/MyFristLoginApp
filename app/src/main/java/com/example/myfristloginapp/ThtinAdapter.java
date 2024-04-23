package com.example.myfristloginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThtinAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ThtinChitiet> ThtinList;

    public ThtinAdapter(Context context, int layout, List<ThtinChitiet> thtinList) {
        this.context = context;
        this.layout = layout;
        ThtinList = thtinList;
    }

    @Override
    public int getCount() {
        return ThtinList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMoTa;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            holder = new ViewHolder();
            //anh xa view
            holder.txtTen = (TextView) convertView.findViewById(R.id.textviewten);
            holder.txtMoTa = (TextView) convertView.findViewById(R.id.textviewmota);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imageh_anh);
            convertView.setTag(holder);
        }else {
            holder =(ViewHolder) convertView.getTag();
        }
        // gan gia tri
        ThtinChitiet ThtinLaixe = ThtinList.get(position);
        holder.txtTen.setText(ThtinLaixe.getTen());
        holder.txtMoTa.setText(ThtinLaixe.getMota());
        holder.imgHinh.setImageResource(ThtinLaixe.getH_anh());

        return convertView;
    }
}
