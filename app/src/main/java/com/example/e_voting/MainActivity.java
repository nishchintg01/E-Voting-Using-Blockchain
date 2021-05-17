package com.example.e_voting;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import android.util.Log;
import org.json.JSONObject;
import org.json.JSONException;
import com.android.volley.Response;

public class MainActivity extends AppCompatActivity {
    EditText enternumber;
    Button otpbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enternumber = findViewById(R.id.input_mobile_number);
        otpbutton = findViewById(R.id.buttongetotp);

        final ProgressBar progressbar = findViewById(R.id.progressbar_send_otp);

        otpbutton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               if(!enternumber.getText().toString().trim().isEmpty()){
                   if((enternumber.getText().toString().trim()).length() > 0){
                       progressbar.setVisibility(View.VISIBLE);
                       otpbutton.setVisibility(View.INVISIBLE);
                       RequestQueue  requestqueue = Volley.newRequestQueue(MainActivity.this);
                       String url = "https://evotingblockchain.herokuapp.com/send-otp/"+enternumber.getText().toString().trim();
                       StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                           @Override
                           public void onResponse(String response) {

                               try {
                                   //Do it with this it will work
                                   JSONObject person = new JSONObject(response);
                                   String otp = person.getString("otp");
                                   // Staring MainActivity
                                   Toast.makeText(getApplicationContext(), "Otp Has Been Send", Toast.LENGTH_SHORT).show();
                                   Intent intent = new Intent(getApplicationContext(), Verifyotp.class);
                                   intent.putExtra("otp", otp);
                                   intent.putExtra("phone", enternumber.getText().toString().trim());
                                   startActivity(intent);
                                   //}

                               } catch (JSONException e) {
                                   e.printStackTrace();
                                   Toast.makeText(getApplicationContext(), "Either You are Not Registered or You have Already Casted Your Vote! Please Try Again", Toast.LENGTH_LONG).show();
                                   progressbar.setVisibility(View.INVISIBLE);
                                   otpbutton.setVisibility(View.VISIBLE);
                               }
                           }
                       }, new Response.ErrorListener() {
                           @Override
                           public void onErrorResponse(VolleyError error) {
                               Log.d("error",error.toString());
                               Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                           }
                       });
                       requestqueue.add(request);

                   }
                   else{
                       Toast.makeText(getApplicationContext(), "Enter Correct Mobile Number", Toast.LENGTH_SHORT).show();
                   }
               }
               else{
                   Toast.makeText(getApplicationContext(), "Enter Mobile Number", Toast.LENGTH_SHORT).show();
               }
           }
        });
    }
}