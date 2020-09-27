package com.example.module3;
import android.view.View;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;

public class view_holder extends RecyclerView.ViewHolder {

        public RadioButton radioButton;
        view_holder(View itemView) {
        super(itemView);
        radioButton = (RadioButton) itemView.findViewById(R.id.radioButtonRed);
        }

}
