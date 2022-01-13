package com.darryncampbell.dwgettingstartedjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private static final String URL = "jdbc:mysql://192.168.100.97:3306/master_db";
    private static final String USER = "anggi";
    private static final String PASSWORD = "anggi";

    EditText etUsername, etPassword;
    Button btnLogin;
    String Username, Password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etUsername = findViewById(R.id.userLog);
        etPassword = findViewById(R.id.passwordLog);

        btnLogin = findViewById(R.id.btnReset);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SelectScanner.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    public class InfoAsyncTask extends AsyncTask<Void, Void, Map<String, String>> {
        @Override
        protected Map<String, String> doInBackground(Void... voids) {
            Map<String, String> info = new HashMap<>();

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String sql = "SELECT id, name, guard_name FROM roles";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    info.put("id", resultSet.getString("id"));
                    info.put("name", resultSet.getString("name"));
                    info.put("guard_name", resultSet.getString("guard_name"));
                    Log.e("gagal data", "Data : " + resultSet.getString("name"));
                }
            } catch (Exception e) {
                Log.e("InfoAsyncTask", "Error reading user", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Map<String, String> stringStringMap) {
            super.onPostExecute(stringStringMap);
        }
    }

}
