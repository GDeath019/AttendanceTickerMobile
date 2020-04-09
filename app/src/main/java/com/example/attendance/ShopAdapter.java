package com.example.attendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    ArrayList<DataShop> dataShops;
    Context context;

    public ShopAdapter(ArrayList<DataShop> dataShops, Context context) {
        this.dataShops = dataShops;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_custom,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt1.setText(dataShops.get(position).getTxt1());
        holder.txt2.setText(dataShops.get(position).getTxt2());
        holder.txt3.setText(dataShops.get(position).getTxt3());
    }

    @Override
    public int getItemCount() {
        return dataShops.size();
    }
    public void RemoveItems(int position){
        dataShops.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt1,txt2,txt3;
        public ViewHolder(final View itemView){
            super(itemView);
            txt1 = (TextView)itemView.findViewById(R.id.tvCustom1);
            txt2 = (TextView)itemView.findViewById(R.id.tvCustom2);
            txt3 = (TextView)itemView.findViewById(R.id.tvCustom3);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RemoveItems(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Remove  "+txt1.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
