package com.example.evilmonkey.truguideapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LocalDetailActivity extends AppCompatActivity {


    private TextView textHeader;
    private ListView listView;
    private String[] textRoom;
    private String[] textRoomDetail;
    int[] imageRoom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_detail);

        textHeader = (TextView) findViewById(R.id.textHeader);
        listView = (ListView) findViewById(R.id.listView);

        Bundle bundle = getIntent().getExtras();



        String localName = bundle.getString("Location_Name");
        String localParth = bundle.getString("Location_Parth");

        textHeader.setText(localName);
        textRoom = getResources().getStringArray(R.array.Building_B);
        textRoomDetail = getResources().getStringArray(R.array.Building_B_Detail);
        imageRoom = new int[textRoom.length];

        String imagename = "@drawable/"+localParth;
            
        for(int i=0;i<=textRoom.length-1; i++){
            int drawableId =getResources().getIdentifier(imagename+(i+1), "drawable", this.getPackageName());
            imageRoom[i]=drawableId;

        }



        LocalAdapter localAdapter = new LocalAdapter(this,imageRoom,textRoom,textRoomDetail);
        listView.setAdapter(localAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(LocalDetailActivity.this, room_Detail.class);
                i.putExtra("textRoom", textRoom[position]);
                i.putExtra("imageRoom",imageRoom[position]);
                i.putExtra("textRoomDetail",textRoomDetail[position]);
                startActivity(i);

            }
        });



    }
}
