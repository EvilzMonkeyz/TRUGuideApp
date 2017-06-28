package com.example.evilmonkey.truguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by EvilMonkey on 18-Apr-17.
 */

public class LocalAdapter extends BaseAdapter{
    private Context context;
    private int[] intspic;
    private String[] stringsName,stringsDetail;


    public LocalAdapter(Context context, int[] intspic, String[] stringsName, String[] stringsDetail) {
        this.context = context;
        this.intspic = intspic;
        this.stringsName = stringsName;
        this.stringsDetail = stringsDetail;
    }

    @Override
    public int getCount() {
        return stringsName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view1= layoutInflater.inflate(R.layout.listview_local,parent,false);

        ImageView imageView = (ImageView) view1.findViewById(R.id.imageRoom);
        TextView room = (TextView) view1.findViewById(R.id.textRoom);
        TextView room_detail = (TextView) view1.findViewById(R.id.textRoomDetail);

        imageView.setImageResource(intspic[position]);
        room.setText(stringsName[position]);
        room_detail.setText(stringsDetail[position]);

        return view1;
    }
}
