package com.deathstroke.moneymanager.ui.transactions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.deathstroke.moneymanager.DailyTransactionListAdapter;
import com.deathstroke.moneymanager.DataManager;
import com.deathstroke.moneymanager.R;
import com.deathstroke.moneymanager.TransactionListAdapter;

import java.util.ArrayList;

public class TransactionsFragment extends Fragment {

    private TransactionsViewModel mTransactionsViewModel;
    private TextView mIncomeVal;
    private TextView mExpenseVal;
    private TextView mRemainingVal;
    private DataManager mDataManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mTransactionsViewModel =
                ViewModelProviders.of(this).get(TransactionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_transactions, container, false);
        mIncomeVal = root.findViewById(R.id.income_val);
        mExpenseVal = root.findViewById(R.id.expense_val);
        mRemainingVal = root.findViewById(R.id.remaining_val);

        mDataManager = new DataManager();
        initializeIncomeExpenseData();
        populateDailyTransaction(root);
        return root;
    }

    private void populateDailyTransaction(View root) {
        RecyclerView dailyTransactionRecyclerView = (RecyclerView) root.findViewById(R.id.daily_transac_list);
        DailyTransactionListAdapter adapter = new DailyTransactionListAdapter((ArrayList<DataManager.DailyTransactionItem>) mDataManager.mDailyTransactionItems);
        dailyTransactionRecyclerView.setHasFixedSize(true);
        dailyTransactionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyTransactionRecyclerView.setAdapter(adapter);
    }

    private void initializeIncomeExpenseData() {
        mIncomeVal.setText(mTransactionsViewModel.getIncome());
        mExpenseVal.setText(mTransactionsViewModel.getExpense());
        mRemainingVal.setText(mTransactionsViewModel.getRemaining());
    }
}
