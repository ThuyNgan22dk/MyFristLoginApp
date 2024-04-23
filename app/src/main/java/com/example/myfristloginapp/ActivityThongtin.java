package com.example.myfristloginapp;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ActivityThongtin extends AppCompatActivity {
    ListView listView;
    ArrayList<ThtinChitiet> listData;
    ThtinAdapter adapter;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);

        AnhXa();

        adapter = new ThtinAdapter(this, R.layout.dong_thtin_chitiet, listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        Intent intent1 = new Intent(ActivityThongtin.this, Activity_Thtin1.class);
                        startActivity(intent1);
                        break;
                    }
                    case 1: {
                        Intent intent2 = new Intent(ActivityThongtin.this, Activity_Thtin2.class);
                        startActivity(intent2);
                        break;
                    }
                    case 2: {
                        Intent intent3 = new Intent(ActivityThongtin.this, Activity_Thtin3.class);
                        startActivity(intent3);
                        break;
                    }
                    case 3: {
                        Intent intent4 = new Intent(ActivityThongtin.this, Activity_Thtin4.class);
                        startActivity(intent4);
                        break;
                    }
                }
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentB = new Intent(ActivityThongtin.this, MainActivity2.class);
                startActivity(intentB);
            }
        });
    }
    private  void AnhXa(){
        listView = (ListView) findViewById(R.id.lvTT);
        buttonBack = (Button) findViewById(R.id.btnBack);

        listData = new ArrayList<>();
        listData.add(new ThtinChitiet("Nguyễn Văn A", R.drawable.user, "Lái Xe"));
        listData.add(new ThtinChitiet("Đào Thị Thúy Ngân", R.drawable.user, "Quản lý"));
        listData.add(new ThtinChitiet("Kiều Thị Phượng", R.drawable.user, "Quản lý"));
        listData.add(new ThtinChitiet("Võ Trần Anh Khoa", R.drawable.user, "Quản lý"));
    }
}