package com.example.myfristloginapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {
    Button btnTT, btnTK12, btnTK1;
    ImageButton ibtnExit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnTT = (Button) findViewById(R.id.btnTT);
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, ActivityThongtin.class);
                startActivity(intent);
            }
        });
        btnTK12 = (Button) findViewById(R.id.btnTK12);
        btnTK12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        btnTK1 = (Button) findViewById(R.id.btnTK1);
        btnTK1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
        ibtnExit2 = findViewById(R.id.ibtnExit2);
        ibtnExit2.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this,android.R.style.Theme_DeviceDefault_Dialog);
            builder.setTitle("Bạn muốn thoát khỏi app?");
            builder.setMessage("Hãy lựa chọn bên dưới để xác nhận.");
            builder.setIcon(R.drawable.ic_launcher_foreground);
            builder.setPositiveButton("Có", (dialog, which) -> this.finishAffinity());
            builder.setNegativeButton("Không", (dialog, which) -> {            });
            builder.show();
        });
    }
}