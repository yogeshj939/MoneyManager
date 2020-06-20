package com.deathstroke.moneymanager.ui.transactions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TransactionsViewModel extends ViewModel {

    private String mIncomeText;
    private String mExpenseText;
    private String mRemainingText;

    public TransactionsViewModel() {
        mIncomeText = "0";
        mExpenseText = "0";
        mRemainingText = "0";
    }

    public String getIncome() {
        return mIncomeText;
    }
    public String getExpense() {
        return mExpenseText;
    }
    public String getRemaining() {
        return mRemainingText;
    }

}