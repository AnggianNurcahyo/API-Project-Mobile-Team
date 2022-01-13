package com.darryncampbell.dwgettingstartedjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.darryncampbell.dwgettingstartedjava.Class.API;
import com.darryncampbell.dwgettingstartedjava.Class.User;
import com.darryncampbell.dwgettingstartedjava.Class.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private UserService mUserService;
    EditText etUsername, etPassword;
    SharedPreferences mSharedPreferences;
    Button btnLogin;
    private final static String APP_NAME = "POKAYOKE";
    private final static String NPK = "npk";
    private final static String PASSWORD = "password";
    private final static String NAMA = "nama";
    private final static String ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mSharedPreferences = getSharedPreferences(APP_NAME, MODE_PRIVATE);

        etUsername = findViewById(R.id.userLog);
        etPassword = findViewById(R.id.passwordLog);

        btnLogin = findViewById(R.id.btnReset);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            login();
            }
        });
    }

    private void login() {
        String npk = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        mUserService = API.getUserService();
        Call<User> call = mUserService.getLogin(npk, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Log.e("NPK", "onResponse: " + response.body().toString());
                    User user = response.body();
                    SharedPreferences.Editor edit = mSharedPreferences.edit();
                    edit.putString(NPK, user.getNpk());
                    edit.putString(PASSWORD, user.getPassword());
                    edit.putString(NAMA, user.getName());
                    edit.putInt(ID, user.getId());
                    edit.apply();
                    startActivity(new Intent(Login.this, SelectScanner.class));
                    etUsername.setText("");
                    etPassword.setText("");
                } else {
                    Toast.makeText(Login.this, "Failed To Login !", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Log In Error : ", t.getMessage());
                Toast.makeText(Login.this, "Gagal Login!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
