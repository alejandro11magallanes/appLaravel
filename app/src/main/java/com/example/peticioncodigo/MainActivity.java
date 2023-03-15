package com.example.peticioncodigo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {


    String url = "https://www.barrilitodepiña.store/api/movil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.respuesta);
        final EditText input = (EditText) findViewById(R.id.input_campo);
        RequestQueue queue = Volley.newRequestQueue(this);


        findViewById(R.id.enviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        response-> {
                            Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        },error ->{
                    Toast.makeText(MainActivity.this,"Tu codigo no es valido", Toast.LENGTH_SHORT).show();
                }){
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("code", input.getText().toString());
                        return params;
                    }

                };
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(stringRequest);
        }
        });
    }


}