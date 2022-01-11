package uk.mdixon.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
TextView lblMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblMsg = findViewById(R.id.lblMsg);
    }

    public void btnGo_onClick(View v){
        lblMsg.setText("Request sent, waiting ...");
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url;
        url ="https://www.metaweather.com/api/location/search/?query=london";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        new Response.Listener <String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                lblMsg.setText(response);
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_LONG).show();
                lblMsg.setText("ERROR: " + error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}