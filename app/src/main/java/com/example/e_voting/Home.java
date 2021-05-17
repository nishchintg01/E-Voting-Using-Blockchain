package com.example.e_voting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class Home extends AppCompatActivity implements View.OnClickListener {

    public CardView card1, card2, card3, card4, card5, card6;
    private long backPressedTime;
    String phoneNumber;
    private Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        card1 = (CardView) findViewById(R.id.castvote);
        card2 = (CardView) findViewById(R.id.blockchain);
        card3 = (CardView) findViewById(R.id.profile);
        card4 = (CardView) findViewById(R.id.parties);
        card5 = (CardView) findViewById(R.id.info);
        card6 = (CardView) findViewById(R.id.logout_card);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);

        phoneNumber = getIntent().getStringExtra("phone");


    }

    @Override
    public void onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast = Toast.makeText(getApplicationContext(), "Press Back Again to Exit!", Toast.LENGTH_SHORT);
            backToast.show();
        }

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId()){
            case R.id.castvote:
                i = new Intent(getApplicationContext(), castvote.class);
                i.putExtra("phone", phoneNumber);
                startActivity(i);
                break;
            case R.id.blockchain:
                i = new Intent(getApplicationContext(), blockchain.class);
                i.putExtra("phone", phoneNumber);
                startActivity(i);
                break;
            case R.id.profile:
                i = new Intent(getApplicationContext(), profile.class);
                i.putExtra("phone", phoneNumber);
                startActivity(i);
                break;
            case R.id.parties:
                i = new Intent(getApplicationContext(), partieslist.class);
                i.putExtra("phone", phoneNumber);
                startActivity(i);
                break;
            case R.id.info:
                i = new Intent(getApplicationContext(), info.class);
                i.putExtra("phone", phoneNumber);
                startActivity(i);
                break;
            case R.id.logout_card:
                Home.this.finish();
                System.exit(0);
                break;
        }


    }
}