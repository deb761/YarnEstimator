package com.deb761.yarnestimator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by deb on 4/27/16.
 */
public class WeightListAdaptor extends BaseAdapter {

    private Context mContext;
    private int mResource;
    private YarnWeight[] mData;

    // return the number of items
    @Override
    public int getCount() {
        return mData.length;
    }

    // ignore for layout purposes
    @Override
    public Object getItem(int item) {
        return null;
    }
    // ignore for layout purposes

    @Override
    public long getItemId(int item) {
        return 0;
    }

    public WeightListAdaptor(Context context, int resource, YarnWeight[] data)
    {
        mContext = context;
        mResource = resource;
        mData = data;
    }

    static class ViewHolderList {
        TextView nameView;
        TextView sizeView;
        TextView gaugeView;
        TextView wpiView;
    }
    // return the view with image and string
    @Override
    public View getView(int pos, View convertView, ViewGroup group) {
        final ViewHolderList holder;
        if (convertView == null) {
            holder = new ViewHolderList();
            convertView = View.inflate(mContext, mResource, null);

            // Save the view references for future reference
            holder.nameView = (TextView)convertView.findViewById(R.id.weightHeader);
            holder.sizeView = (TextView)convertView.findViewById(R.id.needleSizeView);
            holder.gaugeView = (TextView)convertView.findViewById(R.id.gaugeView);
            holder.wpiView = (TextView)convertView.findViewById(R.id.wpiView);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolderList) convertView.getTag();
        }

        YarnWeight yarn = mData[pos];
        holder.nameView.setText(yarn.getName());
        holder.sizeView.setText(yarn.getNeedles());
        holder.gaugeView.setText(yarn.getGauge());
        holder.wpiView.setText(yarn.getWpi());

        return convertView;
    }
}
