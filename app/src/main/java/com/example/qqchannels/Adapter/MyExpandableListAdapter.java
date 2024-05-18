package com.example.qqchannels.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qqchannels.R;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    private String[] groups =new String[]{"休闲馆","娱乐","体育馆","图书馆"};  //组名称
    private String[] [] children =new String[][]{{"公告","情感分析","头像","图书交流"},{"公告","情感分析","头像","图书交流"},{"公告","情感分析","头像","图书交流"},{"公告","情感分析","头像","图书交流"}};//定义的子选项
    private Context context =null;
    public MyExpandableListAdapter(Context context){
        this.context=context;
    }
    private TextView buildTextView(){
      /*  AbsListView.LayoutParams params =new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,90);

        TextView textView =new TextView(this.context);

        textView.setLayoutParams(params);
        textView.setTextSize(16.0f);
        textView.setGravity(Gravity.LEFT);*/
        return null;
    }
    @Override
    public int getGroupCount() {
        return this.groups.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.children[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.groups[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {          //取得指定的子选项
        return this.children[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
       /* TextView textView=this.buildTextView();
        textView.setText(this.getGroup(groupPosition).toString());
        textView.setTextSize(20f);
        return textView;*/
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.parent_item, null);
        TextView textView = convertView.findViewById(R.id.text_parent);

        textView.setText(this.getGroup(groupPosition).toString());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_item, null);
        }


        TextView text_child_small = convertView.findViewById(R.id.text_child_small);
        TextView text_child = convertView.findViewById(R.id.text_child);
        ImageView image_child = convertView.findViewById(R.id.image_child);
        ImageView image_child_small = convertView.findViewById(R.id.image_child_small);
        text_child.setText(this.getChild(groupPosition, childPosition).toString());
        text_child_small.setText(this.getChild(groupPosition, childPosition).toString());
        image_child.setImageResource(R.drawable.avatar);
        image_child_small.setImageResource(R.drawable.horn);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
