package com.example.evilmonkey.truguideapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class room_Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room__detail);

        Bundle bundle = getIntent().getExtras();

        String roomName = bundle.getString("textRoom");
        String roomDetail = bundle.getString("textRoomDetail");
        int imageRoom = bundle.getInt("imageRoom");

        ImageView roomImage = (ImageView) findViewById(R.id.roomImage);
        TextView detail_room_name = (TextView) findViewById(R.id.detail_room_name);
        TextView addressText = (TextView) findViewById(R.id.addressText);
        TextView addressDetail = (TextView) findViewById(R.id.addressDetail);
        TextView teacherText = (TextView) findViewById(R.id.teacherText);
        TextView techerDetail = (TextView) findViewById(R.id.techerDetail);
        TextView detailText = (TextView) findViewById(R.id.detailText);
        TextView detailDetail = (TextView) findViewById(R.id.detailDetail);


        roomImage.setImageResource(imageRoom);
        detail_room_name.setText(roomName);
        detailText.setText("รายละเอียดของห้อง");
        detailDetail.setText(roomDetail);

        addressText.setText("ตรงนี้ใส่ที่อยู่ของห้อง");
        addressDetail.setText("รายละเอียดที่อยู่ห้อง");

        teacherText.setText("แสดงรายชื่ออาจารย์");
        techerDetail.setText("แสดงรายชื่ออาจารย์ประจำห้อง");


    }
}
