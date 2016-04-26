package com.deb761.yarnestimator;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    public SelectGridAdaptor(Context context, int resource, Project[] data)
    {
        mContext = context;
        mResource = resource;
        mData = data;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = View.inflate(mContext, mResource, null);
        } else {
            view = convertView;
        }
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.children_row_list, null);
            position=position+2;
            Log.d("list position::", "" + position);

            project.img_children_view=(ImageView)convertView.findViewById(R.id.image_children);
            project.text_child_name=(TextView)convertView.findViewById(R.id.text_children_name);
            project.text_child_month=(TextView)convertView.findViewById(R.id.text_children_month);
            project.text_group_name=(TextView)convertView.findViewById(R.id.text_children_group);

            project.img_children_view1=(ImageView)convertView.findViewById(R.id.image_children1);
            project.text_child_name1=(TextView)convertView.findViewById(R.id.text_children_name1);
            project.text_child_month1=(TextView)convertView.findViewById(R.id.text_children_month1);
            project.text_group_name1=(TextView)convertView.findViewById(R.id.text_children_group1);

            Resources r = getResources();
            float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90, r.getDisplayMetrics());
            int pixel_height = (int) pixels;
            project.img_children_view.setLayoutParams(new LinearLayout.LayoutParams(80 , 80));
            project.img_children_view1.setLayoutParams(new LinearLayout.LayoutParams(80 , 80));

            convertView.setTag(project);
        }
        else {

            project = (ViewHolderList) convertView.getTag();
        }

        if(position %2 == 0){
            //  System.out.println(position + " is even number.");
            project.text_child_name.setText(children_list.get(position).getFirst_name());
            project.text_child_name.setText(children_list.get(position).getFirst_name());
            project.text_child_month.setText(display_month);
            project.text_group_name.setText(children_list.get(position).getGroup_name());

            Bitmap bitmap = decodeFile(new File( Environment.getExternalStorageDirectory()+"/com.x/y/"+children_list.get(position).getPhoto()), ConfigurationData.staffImageSize,ConfigurationData.staffImageSize);
            //holder.img_children_view.setImageBitmap(bitmap);
        }
        else{
            //  System.out.println(position+ " is odd number.");
            project.text_child_name1.setText(children_list.get(position).getFirst_name());
            project.text_child_name1.setText(children_list.get(position).getFirst_name());
            project.text_child_month1.setText(display_month);
            project.text_group_name1.setText(children_list.get(position).getGroup_name());

            Bitmap bitmap1 = decodeFile(new File( Environment.getExternalStorageDirectory()+"/com.x/y/"+children_list.get(position).getPhoto()), ConfigurationData.staffImageSize,ConfigurationData.staffImageSize);
            //holder.img_children_view1.setImageBitmap(bitmap1);
        }

        return convertView;
    }   //closing getview
}
}
