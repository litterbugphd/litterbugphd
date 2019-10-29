package com.e.litterfirebase;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;




import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NopeAdapter extends RecyclerView.Adapter<NopeAdapter.ViewHolder> {

    private List<NopeObject> nolists;

    public void setOnOptionSelected(OnOptionSelected onOptionSelected) {
        this.onOptionSelected = onOptionSelected;
    }

    private OnOptionSelected onOptionSelected;


    public void setNolists(List<NopeObject> nolists) {
        this.nolists = nolists;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mListImage;
        TextView name;
        RadioGroup rbg;
        RadioButton op1, op2, op3, op4, op5, op6;

        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            rbg = view.findViewById(R.id.rbg);
            op1 = view.findViewById(R.id.radioButton);
            op2 = view.findViewById(R.id.radioButton2);
            op3 = view.findViewById(R.id.radioButton3);
            op4 = view.findViewById(R.id.radioButton4);
            op5 = view.findViewById(R.id.radioButton5);
            op6 = view.findViewById(R.id.radioButton6);
            op1.setOnClickListener(this);
            op2.setOnClickListener(this);
            op3.setOnClickListener(this);
            op4.setOnClickListener(this);
            op5.setOnClickListener(this);
            op6.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.radioButton:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 1);
                    break;

                case R.id.radioButton2:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 2);
                    break;

                case R.id.radioButton3:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 3);
                    break;
                case R.id.radioButton4:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 4);
                    break;

                case R.id.radioButton5:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 5);
                    break;

                case R.id.radioButton6:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 6);
                    break;
            }
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        // create a normal view
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nolist, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.name.setText(nolists.get(position).getName());
        viewHolder.mListImage.setImageResource(nolists.get(position).getListImage());



        Log.e("POSITION" + position, "1" + nolists.get(position).isOp1Sel());

        Log.e("POSITION" + position, "2" + nolists.get(position).isOp2Sel());
        Log.e("POSITION" + position, "3" + nolists.get(position).isOp3Sel());
        Log.e("POSITION" + position, "4" + nolists.get(position).isOp4Sel());

        Log.e("POSITION" + position, "5" + nolists.get(position).isOp5Sel());
        Log.e("POSITION" + position, "6" + nolists.get(position).isOp6Sel());


        viewHolder.op1.setChecked(nolists.get(position).isOp1Sel());
        viewHolder.op2.setChecked(nolists.get(position).isOp2Sel());
        viewHolder.op3.setChecked(nolists.get(position).isOp3Sel());
        viewHolder.op4.setChecked(nolists.get(position).isOp4Sel());
        viewHolder.op5.setChecked(nolists.get(position).isOp5Sel());
        viewHolder.op6.setChecked(nolists.get(position).isOp6Sel());


    }

    @Override
    public int getItemCount() {
        if (nolists != null) {
            return nolists.size();
        }
        return 0;
    }
}