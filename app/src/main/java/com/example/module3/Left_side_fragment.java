package com.example.module3;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class Left_side_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_left_side_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerViewLeft);
        List<Data> data = fill_with_data();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),R.layout.row_layout,data);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    public List<Data> fill_with_data() {
        List<Data> data = new ArrayList<>();
        data.add(new Data("Red"));
        data.add(new Data("Blue"));
        data.add(new Data("Green"));
        data.add(new Data("Yellow"));
        data.add(new Data("Black"));
        return data;
    }
}