package com.example.myfristloginapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.service.controls.templates.ControlButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    TextView tvRegister, tvLogin;
    EditText user, pass;
    ImageButton ibtnExit;
    String ten, mk, xnmk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();
        tvRegister = findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(v -> DialogRegister());
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if(user.getText().length() != 0 && pass.getText().length() != 0){
                        if(user.getText().toString().equals(ten) && pass.getText().toString().equals(mk)){
                            Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);

                        }   else if(user.getText().toString().equals("ngan") && pass.getText().toString().equals("123456")) {
                            Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                        }   else if(user.getText().toString().equals("phuong") && pass.getText().toString().equals("123456")) {
                            Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                        }   else if(user.getText().toString().equals("khoa") && pass.getText().toString().equals("123456")) {
                            Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                        }   else {
                            Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                        }
                    }   else{
                        Toast.makeText(MainActivity.this,"Mời bạn nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    //Thoát ứng dụng
    private void ControlButton(){
        ibtnExit.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_DeviceDefault_Dialog);
            builder.setTitle("Bạn muốn thoát khỏi app?");
            builder.setMessage("Hãy lựa chọn bên dưới để xác nhận.");
            builder.setIcon(R.drawable.ic_launcher_foreground);
            builder.setPositiveButton("Có", (dialog, which) -> onBackPressed());
            builder.setNegativeButton("Không", (dialog, which) -> {            });
            builder.show();
        });
    }
    //Xử lý đăng ký
    private void DialogRegister(){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_register);
        //ánh xạ
        EditText edtUsername = dialog.findViewById(R.id.inputUsername);
        EditText edtPassword = dialog.findViewById(R.id.inputPassword);
        EditText edtConPassword = dialog.findViewById(R.id.inputConformPassword);
        Button btnDKy = dialog.findViewById(R.id.btnRegister);
        ImageButton ibtnExit = dialog.findViewById(R.id.ibnThoat);
        btnDKy.setOnClickListener(v -> {
            {
                ten = edtUsername.getText().toString();
                mk = edtPassword.getText().toString();
                xnmk = edtConPassword.getText().toString();

                if(ten.equals("") || mk.equals("") || xnmk.equals(""))
                    Toast.makeText(MainActivity.this, "Mời bạn nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                else{
                    if (mk.equals(xnmk)) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng ký thành công",Toast.LENGTH_SHORT).show();
                        edtUsername.setText(ten);
                        edtPassword.setText(mk);
                        dialog.cancel();
                    }else{
                        Toast.makeText(MainActivity.this, "Đăng ký không thành công",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        dialog.show();
        ibtnExit.setOnClickListener(v -> dialog.cancel());
    }
    private void Anhxa(){
        user = findViewById(R.id.editTUser);
        pass = findViewById(R.id.editTPass);
        tvLogin = findViewById(R.id.tvLogin);
        tvRegister = findViewById(R.id.tvRegister);
        ibtnExit = findViewById(R.id.ibtnExit);
    }
}