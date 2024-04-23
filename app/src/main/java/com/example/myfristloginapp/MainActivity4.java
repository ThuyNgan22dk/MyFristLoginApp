package com.example.myfristloginapp;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.*;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    Button buttonSetData;
    TextView tv_dGia;
    DataAdapter mdataAdapter;
    List<Data> dataList;
    GraphView graphView;
    LineGraphSeries<DataPoint> series;
    FirebaseDatabase fireData;
    DatabaseReference dataRef;
    public static String diemDGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tv_dGia = findViewById(R.id.tv_DGia);
        graphView = findViewById(R.id.graphView);
        series = new LineGraphSeries<>();
        graphView.addSeries(series);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.rgb(90,220,200));
        //giới hạn giá trị cho cột y
        Viewport viewport = graphView.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(5);
        viewport.setXAxisBoundsManual(true);
        viewport.setMinX(24);
        viewport.setMaxX(31);
        //tạo một định dạng firebase để lấy dữ liệu về theo đường dẫn
        fireData = FirebaseDatabase.getInstance();
        dataRef = fireData.getReference("Drowiness detect timestamp 5");
        dataList = new ArrayList<>();
        mdataAdapter = new DataAdapter(dataList);

        buttonSetData = findViewById(R.id.btnSetData);
        buttonSetData.setOnClickListener(v -> getListDataFromRealtimeData());

        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX && value <= 31){
                    return super.formatLabel(value, isValueX) + "/12";
                }else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });

    }

    //Lấy dữ liệu từ firebase
    private void getListDataFromRealtimeData(){
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataPoint[] dp = new DataPoint[(int) snapshot.getChildrenCount()];
                int index = 0;
                int i = 24;
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
                diemDGia = String.valueOf(sum/mdataAdapter.getItemCount());
                tv_dGia.setText(diemDGia);
                series.resetData(dp);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity4.this, "Get list data fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
