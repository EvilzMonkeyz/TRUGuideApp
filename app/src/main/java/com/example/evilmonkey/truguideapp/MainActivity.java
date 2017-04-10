package com.example.evilmonkey.truguideapp;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    Button but_ar,but_local,but_tuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but_ar = (Button) findViewById(R.id.but_ar);
        but_local = (Button) findViewById(R.id.but_local);
        but_tuto = (Button) findViewById(R.id.but_tuto);


    }

    public void menuButtons(View v){
        switch (v.getId()){
            case R.id.but_ar:

                break;
            case  R.id.but_local:
                Intent nt = new Intent(MainActivity.this, LocationsActivity.class);
                startActivity(nt);
                break;
            case R.id.but_tuto:
                break;
        }
    }
}
