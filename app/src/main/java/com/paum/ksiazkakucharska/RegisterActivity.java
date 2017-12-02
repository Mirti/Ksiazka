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

public class RegisterActivity extends AppCompatActivity {
    RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view) {
        TextView tvLogin = findViewById(R.id.txtLogin);
        TextView tvPassword = findViewById(R.id.txtPassword);
        TextView tvEmail = findViewById(R.id.txtEmail);
        String login = tvLogin.getText().toString();
        String password = tvPassword.getText().toString();
        String email = tvEmail.getText().toString();
        String url = "http://192.168.1.102:80/ksiazka/register.php?login=" + login + "&password=" + password + "&email=" + email;

        rq = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.toString().equals("0")) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        else{
                            findViewById(R.id.txtRegisterError).setVisibility(View.VISIBLE);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        rq.add(stringRequest);

    }
}
