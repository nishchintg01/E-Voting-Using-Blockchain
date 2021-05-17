package com.example.e_voting;


import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.text.TextWatcher;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class Verifyotp extends AppCompatActivity {
    EditText inpputnumber1, inpputnumber2, inpputnumber3, inpputnumber4, inpputnumber5, inpputnumber6;
    String verifyotp, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyotp);

        inpputnumber1 = findViewById(R.id.inputotp1);
        inpputnumber2 = findViewById(R.id.inputotp2);
        inpputnumber3 = findViewById(R.id.inputotp3);
        inpputnumber4 = findViewById(R.id.inputotp4);
        inpputnumber5 = findViewById(R.id.inputotp5);
        inpputnumber6 = findViewById(R.id.inputotp6);

        Button verifyotpbutton = findViewById(R.id.buttongetotp);
        verifyotp = getIntent().getStringExtra("otp");
        phoneNumber = getIntent().getStringExtra("phone");
        
        verifyotpbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!inpputnumber1.getText().toString().trim().isEmpty() && !inpputnumber2.getText().toString().trim().isEmpty() && !inpputnumber3.getText().toString().trim().isEmpty() && !inpputnumber4.getText().toString().trim().isEmpty() && !inpputnumber5.getText().toString().trim().isEmpty() && !inpputnumber6.getText().toString().trim().isEmpty()){
                    String enteredotp = inpputnumber1.getText().toString().trim() +
                            inpputnumber2.getText().toString().trim() +
                            inpputnumber3.getText().toString().trim() +
                            inpputnumber4.getText().toString().trim() +
                            inpputnumber5.getText().toString().trim() +
                            inpputnumber6.getText().toString().trim();

                    if(enteredotp.compareTo(verifyotp) == 0) {
                    Toast.makeText(getApplicationContext(), "OTP Verified", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    intent.putExtra("phone", phoneNumber);
                    startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Enter Correct OTP", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter Correct OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });

        numberotpmove();


    }

    private void numberotpmove(){
        inpputnumber1.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                if(!s.toString().trim().isEmpty()){
                    inpputnumber2.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s){

            }

        });
        inpputnumber2.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                if(!s.toString().trim().isEmpty()){
                    inpputnumber3.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s){

            }

        });
        inpputnumber3.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                if(!s.toString().trim().isEmpty()){
                    inpputnumber4.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s){

            }

        });
        inpputnumber4.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                if(!s.toString().trim().isEmpty()){
                    inpputnumber5.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s){

            }

        });
        inpputnumber5.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                if(!s.toString().trim().isEmpty()){
                    inpputnumber6.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s){

            }

        });


    }
}