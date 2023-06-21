package com.example.prm_assignment_foodanddrink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Food> foodList;
    private FoodActivity foodActivity;

    public FoodAdapter(Context context, int layout, List<Food> foodList, FoodActivity foodActivity) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
        this.foodActivity = foodActivity;
    }

    public FoodActivity getFoodActivity() {
        return foodActivity;
    }

    public void setFoodActivity(FoodActivity foodActivity) {
        this.foodActivity = foodActivity;
    }

    @Override
    public int getCount() {
//        return 0;
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtFoodName, txtFoodPrice;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        convertView = inflater.inflate(layout, null);
//        TextView txtName =(TextView)convertView.findViewById(R.id.textViewNameFood);
//        ImageView imgImage = (ImageView) convertView.findViewById(R.id.imageViewImageFood);
//
//        Food food = foodList.get(position);
//        txtName.setText(food.getFoodName());
//        imgImage.setImageResource(food.getFoodImg());
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtFoodName = (TextView) convertView.findViewById(R.id.textViewNameFood);
            holder.txtFoodPrice = (TextView) convertView.findViewById(R.id.textViewPriceFood);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Food food = foodList.get(position);
        holder.txtFoodName.setText(food.getFoodName());
        holder.txtFoodPrice.setText(food.getFoodPrice());

        return convertView;
    }
}
