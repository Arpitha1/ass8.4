package com.example.abhi.intermediatealertdialog.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.abhi.intermediatealertdialog.R;
import com.example.abhi.intermediatealertdialog.model.Details;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Details> details;

    public CustomListAdapter(Activity activity, List<Details> details) {
        this.activity = activity;
        this.details = details;
    }

    @Override
    public int getCount() {
        return details.size();
    }

    @Override
    public Object getItem(int location) {
        return details.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, null);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView ph = (TextView) convertView.findViewById(R.id.ph);
        TextView DOB = (TextView) convertView.findViewById(R.id.dob);

        Details m = details.get(position);

        name.setText(m.getName());
        ph.setText(m.getPhoneNumber());
        DOB.setText(m.getDOB());

        return convertView;
    }

}