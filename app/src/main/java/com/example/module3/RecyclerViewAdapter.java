package com.example.module3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<view_holder> {
    List<Data> radio_group;
    Context ctxt;
    int resource;

    public RecyclerViewAdapter(Context context,int res,List<Data> data){
        radio_group=data;
        ctxt = context;
        resource = res;
    }


    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctxt).inflate(resource,parent,false);
        view_holder holder = new view_holder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {
        holder.radioButton.setText(radio_group.get(position).radioText);
    }


    @Override
    public int getItemCount() {
        return radio_group.size();
    }
}
