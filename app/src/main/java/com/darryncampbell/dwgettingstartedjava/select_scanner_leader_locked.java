package com.darryncampbell.dwgettingstartedjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class select_scanner_leader_locked extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_scanner_leader_locked);

        Button btnUnlock = findViewById(R.id.btnUnlock);
        btnUnlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(select_scanner_leader_locked.this, locked.class);
                startActivity(intent);
            }
        });
    }
}