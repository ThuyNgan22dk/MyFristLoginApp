package com.example.myfristloginapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Activity_Thtin3 extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> listData;
    private ArrayAdapter<String> adapter;
    private Context context;
    private Button buttonAdd, buttonUpdate, buttonQl;
    private EditText editText;
    private int visit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thtin3);
        context = this;

        listView = (ListView) findViewById(R.id.lv3);
        buttonAdd = (Button) findViewById(R.id.btnAdd3);
        editText = (EditText) findViewById(R.id.edt3);
        buttonUpdate = (Button) findViewById(R.id.btnUp3);
        buttonQl = (Button) findViewById(R.id.btnE);

        listData = new ArrayList<>();
        listData.add("Tên: Kiều Thị Phượng");
        listData.add("Năm sinh: 2000");
        listData.add("Địa chỉ: Hòa Khánh Nam, Đà Nẵng");
        listData.add("Đơn vị làm việc: Quản lý");

        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listData);

        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editText.getText().toString().trim();
                if(TextUtils.isEmpty(item)){
                    Toast.makeText(context, "Bạn chưa nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }
                listData.add(item);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(context, listData.get(position), Toast.LENGTH_SHORT).show();
                editText.setText(listData.get(position));
                visit = position;
            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listData.set(visit, editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        //nhấn giữ để xóa thông tin
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Xác nhận");
                dialog.setMessage("Bạn có đồng ý xóa không?");
                dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listData.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });

                dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });
        buttonQl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Activity_Thtin3.this, ActivityThongtin.class);
                startActivity(intent1);
            }
        });
    }
}