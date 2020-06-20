package com.deathstroke.moneymanager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DailyTransactionListAdapter extends RecyclerView.Adapter<DailyTransactionListAdapter.ViewHolder> {

    private ArrayList<DataManager.DailyTransactionItem> mDailyTransactionItems;

    public DailyTransactionListAdapter(ArrayList<DataManager.DailyTransactionItem> data){
        mDailyTransactionItems = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.daily_transac_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataManager.DailyTransactionItem dataItem = mDailyTransactionItems.get(position);
        Log.i(TAG, "onBindViewHolder: "+dataItem.getDate());
        holder.date.setText(dataItem.getDate());
        holder.totalCost.setText("some number");
        ///holder.mTextView.setText(dataItem.getDate());
//        TransactionListAdapter adapter = new TransactionListAdapter(dataItem.getTransactionData());
//        holder.transactionListView.setLayoutManager(new LinearLayoutManager());
    }

    @Override
    public int getItemCount() {
        return mDailyTransactionItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView date;
        public TextView totalCost;
        public RecyclerView transactionListView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.text_date);
            totalCost = (TextView) itemView.findViewById(R.id.text_expense);
            transactionListView = (RecyclerView) itemView.findViewById(R.id.transac_list);
        }
    }
}
