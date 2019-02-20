package com.example.workout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.workout.model.Type;
import com.example.workout.model.Workout;

import java.util.ArrayList;

public class TypeArrayAdapter extends ArrayAdapter<Type> {
    static final int VIEW_TYPE_WORKOUT = 0;
    static final int VIEW_TYPE_PAUSE = 1;
    static final int VIEW_TYPE_COUNT = 2;

    public TypeArrayAdapter(Context context, ArrayList<Type> types) {

        super(context,0, types);
    }
    @Override
    public int getViewTypeCount(){

        return VIEW_TYPE_COUNT;
    }
    @Override
    public int getItemViewType(int position){
        Type type = getItem(position);
        if(type instanceof Workout){
            return VIEW_TYPE_WORKOUT;
        }
        else{
            return VIEW_TYPE_PAUSE;
        }
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Type type = getItem(position);
        if(convertView == null){
            int layoutId = 0;
            if(getItemViewType(position) == VIEW_TYPE_WORKOUT){
                layoutId = R.layout.list_row_workout;
            }
            else {
                layoutId = R.layout.list_row_pause;
            }
            convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);

        }
        TextView typeViewText = convertView.findViewById(R.id.type_name);
        typeViewText.setText(type.getType());
        TextView secondsViewText = convertView.findViewById(R.id.text_list_item_seconds);
        secondsViewText.setText(Integer.toString(type.getSeconds()));
        return convertView;
    }
}
