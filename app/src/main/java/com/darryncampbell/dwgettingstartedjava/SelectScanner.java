package com.darryncampbell.dwgettingstartedjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.darryncampbell.dwgettingstartedjava.Class.UserService;

public class SelectScanner extends AppCompatActivity {

    private UserService mUserService;
    SharedPreferences mSharedPreferences;
    private final static String APP_NAME= "POKAYOKE";
    private final static String NPK = "npk";
    private final static String PASSWORD = "password";
    private final static String NAMA = "nama";
    private final static String ID = "id";

    private TextView mNama;

    CardView card1, card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_scanner);
        mSharedPreferences = getSharedPreferences(APP_NAME, MODE_PRIVATE);
        String namasp = mSharedPreferences.getString(NAMA, null);


        mNama = findViewById(R.id.nama_user);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);

        mNama.setText(namasp);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectScanner.this, MainActivity.class);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectScanner.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}