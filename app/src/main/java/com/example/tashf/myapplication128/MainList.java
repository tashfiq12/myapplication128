package com.example.tashf.myapplication128;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tashf on 11/26/2017.
 */

public class MainList extends ArrayAdapter<Infos> {
    private Activity context;
    private List<Infos> arraylist;
    public MainList(Activity context,List<Infos>arraylist)
    {
        super(context,R.layout.list_layout,arraylist);
        this.context=context;
        this.arraylist=arraylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listviewitem=inflater.inflate(R.layout.list_layout,null,true);
        TextView text1=(TextView)listviewitem.findViewById(R.id.textView33);
        TextView text2=(TextView)listviewitem.findViewById(R.id.textView34);
        TextView text3=(TextView)listviewitem.findViewById(R.id.textView35);
        Infos info=arraylist.get(position);
         Double a1=info.getLatitude();
         String s1=Double.toString(a1);
         text1.setText(s1);
        Double a2=info.getLongitude();
        String s2=Double.toString(a2);
        text2.setText(s2);
        int a3=info.getCheck_alive();
        String s3=Integer.toString(a3);
        text3.setText(s3);

         return listviewitem;

    }
}
