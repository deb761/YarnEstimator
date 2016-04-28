package com.deb761.yarnestimator;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by deb on 4/25/16.
 */
public class SelectGridAdaptor extends BaseAdapter {
    private Context mContext;
    private int mResource;
    private Project[] mData;

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

    public SelectGridAdaptor(Context context, int resource, Project[] data) {
        mContext = context;
        mResource = resource;
        mData = data;
    }

    // A ViewHolder to cache the view items
    static class ViewHolderList {
        LinearLayout layout;
        ImageView imageView;
        TextView textView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolderList holder;
        final Project project = mData[position];
        if (convertView == null) {
            holder = new ViewHolderList();
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.select_portrait_layout, null);
            Log.d("list position::", "" + position);

            holder.layout = (LinearLayout) convertView.findViewById(R.id.selectPortraitLayout);
            holder.imageView = (ImageView) convertView.findViewById(R.id.selectPortraitImageView);
            holder.textView = (TextView) convertView.findViewById(R.id.selectPortraitTextView);

            holder.imageView.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent intent = new Intent(mContext, //<-------------
                            project.getaClass()).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });
            convertView.setTag(holder);
        } else {

            holder = (ViewHolderList) convertView.getTag();
        }

        holder.imageView.setImageResource(project.getThumbImageID());
        holder.textView.setText(project.getName());

        return convertView;
    }   //closing getview
}
