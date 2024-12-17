package com.example.geographyproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter
{
    private Context context;
    private int images[];
    private String stringList1[];
    private String stringList2[];
    private LayoutInflater inflater;

    public CustomAdapter (Context context, int[] images, String[] stringList1, String[] stringList2 )
    {
        this.context = context;
        this.images = images;
        this.stringList1 = stringList1;
        this.stringList2 = stringList2;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount()
    {
        return stringList1.length;
    }

    @Override
    public Object getItem(int position) {
        return stringList1[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent)
    {
        view = inflater.inflate(R.layout.custom_layout, parent, false);

        ImageView img = view.findViewById(R.id.ivflag);
        TextView str1 = view.findViewById(R.id.tvCountry);
        TextView str2 = view.findViewById(R.id.tvCapital);

        str1.setText(stringList1[i]);
        str2.setText(stringList2[i]);
        img.setImageResource(images[i]);

        return view;
    }


}
