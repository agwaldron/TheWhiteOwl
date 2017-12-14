package com.example.alec.thewhiteowl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<MenuItem> {
    List<MenuItem> menuItems;

    public MenuAdapter(Context context, int resource, List<MenuItem> objects){
        super(context, resource, objects);
        menuItems = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.menu_item_view, parent, false);
        }

        MenuItem location = menuItems.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.menu_item_text_view);
        nameText.setText(location.getItemName());

        TextView descriptionText = (TextView) convertView.findViewById(R.id.menu_description_text_view);
        descriptionText.setText(location.getItemDescription());

        TextView priceText = (TextView) convertView.findViewById(R.id.menu_price_text_view);
        priceText.setText(location.getItemPrice());

        return convertView;
    }
}
