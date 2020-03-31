package com.example.sagutdinov2_2_2hw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class ToolsArrayAdapter extends BaseAdapter {
    private List<Tool> list;
    private Context context;

    public ToolsArrayAdapter(Context context, List<Tool> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.item_list_view, parent, false);
        }

        Button btnDelete = convertView.findViewById(R.id.btnDelete);
        ConstraintLayout listItem = convertView.findViewById(R.id.listItem);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });


        TextView toolTitle = convertView.findViewById(R.id.toolTitle);
        TextView toolSubtitle = convertView.findViewById(R.id.toolSubtitle);
        ImageView toolImage = convertView.findViewById(R.id.toolIcon);

        Tool t = list.get(position);

        toolTitle.setText(t.title);
        toolSubtitle.setText(t.subtitle);
        toolImage.setImageDrawable(context.getDrawable(t.icon));

        listItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, "- " +  list.get(position).title + " -", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return convertView;
    }

    static class Tool {
        int icon;
        int title, subtitle;

        Tool(int icon, int title, int subtitle) {
            this.icon = icon;
            this.title = title;
            this.subtitle = subtitle;
        }
    }
}
