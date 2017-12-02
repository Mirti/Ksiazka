package com.paum.ksiazkakucharska;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends AppCompatActivity {
    RequestQueue rq;
    public boolean isLogged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        TextView tvLogin = findViewById(R.id.txtLogin);
        TextView tvPassword = findViewById(R.id.txtPassword);
        String login = tvLogin.getText().toString();
        String password = tvPassword.getText().toString();
        String url = "http://192.168.1.102:80/ksiazka/login.php?login=" + login + "&password=" + password;

        rq = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.toString().equals("1")) isLogged=true;
                        else isLogged=false;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        rq.add(stringRequest);

        if (isLogged) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            findViewById(R.id.txtLoginError).setVisibility(View.VISIBLE);  //Jeżeli login jest niepoprawny wyświetla komunikat
        }
    }
}

