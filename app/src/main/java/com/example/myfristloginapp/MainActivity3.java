package com.example.myfristloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    Button buttonSetData;
    TextView tv_dGia;
    DataAdapter mdataAdapter;
    List<Data> dataList;
    GraphView graphView;
    LineGraphSeries<DataPoint> series;
    FirebaseDatabase fireData;
    DatabaseReference dataRef;
    public static String diemDGia2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_dGia = findViewById(R.id.tv_DGia2);
        graphView = findViewById(R.id.graphView2);
        series = new LineGraphSeries<>();
        graphView.addSeries(series);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.rgb(90,220,200));
        //giới hạn giá trị cho cột y
        Viewport viewport = graphView.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(10);
        viewport.setXAxisBoundsManual(true);
        viewport.setMinX(1);
        viewport.setMaxX(5);
        //tạo một định dạng firebase để lấy dữ liệu về theo đường dẫn
        fireData = FirebaseDatabase.getInstance();
        dataRef = fireData.getReference("Drowiness detect timestamp 6");
        dataList = new ArrayList<>();
        mdataAdapter = new DataAdapter(dataList);

        buttonSetData = findViewById(R.id.btnSetData2);
        buttonSetData.setOnClickListener(v -> getListDataFromRealtimeData2());

        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX && value <= 31){
                    return super.formatLabel(value, isValueX) + "/01";
                }else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });

    }

    //Lấy dữ liệu từ firebase
    private void getListDataFromRealtimeData2(){
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataPoint[] dp = new DataPoint[(int) snapshot.getChildrenCount()];
                int index = 0;
                int i = 1;
                int sum = 0;
                if(dataList != null){
                    dataList.clear();
                }
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Data mdata = dataSnapshot.getValue(Data.class);
                    dataList.add(mdata);
                    dp[index] = new DataPoint(i,mdata.getScore());
                    index++;
                    i++;
                    sum += mdata.getScore();
                }
                mdataAdapter.notifyDataSetChanged();
                diemDGia2 = String.valueOf(sum/mdataAdapter.getItemCount());
                tv_dGia.setText(diemDGia2);
                series.resetData(dp);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity3.this, "Get list data fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}