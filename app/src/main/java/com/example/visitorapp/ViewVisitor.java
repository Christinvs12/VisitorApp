package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class ViewVisitor extends AppCompatActivity {
    TextView t1;
    Button bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_visitor);
        t1 = (TextView) findViewById(R.id.viewt);
        bb=(Button) findViewById(R.id.gbback);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(y);
            }
        });
        callApi();
    }
        private void callApi(){
            String apiUrl="https://log-app-demo-api.onrender.com/getvistors";
            JsonArrayRequest request= new JsonArrayRequest(
                    Request.Method.GET,
                    apiUrl,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            StringBuilder result=new StringBuilder();
                            for(int i=0;i<response.length();i++)
                            {
                                try {
                                    JSONObject ob=response.getJSONObject(i);
                                    String getfname=ob.getString("firstname");
                                    String getlname=ob.getString("lastname");
                                    String getpurp=ob.getString("purpose");
                                    String getwhmeet=ob.getString("whomToMeet");

                                    result.append("First Name:").append(getfname).append("\n");
                                    result.append("Last Name:").append(getlname).append("\n");
                                    result.append("Purpose:").append(getpurp).append("\n");
                                    result.append("Whom to meet").append(getwhmeet).append("\n");
                                    result.append("------------------------------------------\n");
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            t1.setText(result.toString());
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(),("error occured"),Toast.LENGTH_LONG).show();
                        }
                    }

            );
            RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
            queue.add(request);
        }

    }
