package com.example.a.ycphack2018;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.ycphack2018.*;

class ListViewAdapter extends ArrayAdapter<String> {

    private final LayoutInflater mLayoutInflater;

    public ListViewAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View dataView = convertView;

        // Check for recycled View
        if (null == dataView) {
            // Not recycled. Create the View
            dataView = mLayoutInflater.inflate(R.layout.listitem, parent, false);
            // Cache View information in ViewHolder Object
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.shortdes=dataView.findViewById(R.id.shortdescription);
            viewHolder.projecttitle=dataView.findViewById(R.id.projecttitle);
            viewHolder.icon=dataView.findViewById(R.id.icon);
            dataView.setTag(viewHolder);
        }


        // Retrieve the viewHolder Object
        ViewHolder storedViewHolder = (ViewHolder) dataView.getTag();

        //Set the data in the data View
        storedViewHolder.projecttitle.setText(getItem(position));
        storedViewHolder.shortdes.setText((getItem(position)));
        storedViewHolder.icon.setImageResource((int) getItemId(position));

        return dataView;
    }

    // The ViewHolder class. See:
    // http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
    static class ViewHolder {
        TextView shortdes;
        TextView projecttitle;
        ImageView icon;
    }
}

