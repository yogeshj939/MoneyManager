package com.deathstroke.moneymanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TransactionListAdapter extends RecyclerView.Adapter<TransactionListAdapter.ViewHolder> {

    private List<DataManager.TransactionData> mTransactionData;

    public TransactionListAdapter(ArrayList<DataManager.TransactionData> transactionData){
        mTransactionData = transactionData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.transac_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataManager.TransactionData listData = mTransactionData.get(position);
        holder.imageCategory.setImageResource(listData.getImageId());
        holder.description.setText(listData.getDescription());
        holder.transaction_cost.setText(listData.getAmount());
        holder.mConstraintLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"click on item: "+listData.getDescription(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mTransactionData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageCategory;
        public TextView description;
        public TextView transaction_cost;
        public ConstraintLayout mConstraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCategory = (ImageView) itemView.findViewById(R.id.image_category);
            description = (TextView) itemView.findViewById(R.id.text_description);
            transaction_cost = (TextView) itemView.findViewById(R.id.text_transac_amount);
            mConstraintLayout = (ConstraintLayout) itemView.findViewById(R.id.transac_list_item_constraint);
        }
    }
}
