package com.deathstroke.moneymanager;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public List<DailyTransactionItem> mDailyTransactionItems;

    public DataManager(){
        mDailyTransactionItems = new ArrayList<DailyTransactionItem>();
        initializeData();
    }

    private void initializeData() {
        DailyTransactionItem item1 = new DailyTransactionItem("25/06 wed");
        ArrayList<TransactionData> transactionList1 = new ArrayList<>();
        transactionList1.add(new TransactionData("Food","biryani",100,android.R.drawable.btn_radio));
        transactionList1.add(new TransactionData("Food","Wine",200,android.R.drawable.btn_radio));
        item1.initializeTransactions(transactionList1);
        DailyTransactionItem item2 = new DailyTransactionItem("24/06 tue");
        ArrayList<TransactionData> transactionList2 = new ArrayList<>();
        transactionList2.add(new TransactionData("Food","biryani",100,android.R.drawable.btn_radio));
        transactionList2.add(new TransactionData("Food","Wine",200,android.R.drawable.btn_radio));
        transactionList2.add(new TransactionData("Transport","Mys - Bng",100,android.R.drawable.btn_radio));
        transactionList2.add(new TransactionData("Petrol","",100,android.R.drawable.btn_radio));
        item2.initializeTransactions(transactionList2);
        mDailyTransactionItems.add(item1);
        mDailyTransactionItems.add(item2);
    }

    public class DailyTransactionItem {
        private String mDate;
        private int totalExpense = 0;
        private int totalIncome = 0;
        public ArrayList<TransactionData> mTransactionData;

        public DailyTransactionItem(String date){
            mTransactionData = new ArrayList<TransactionData>();
            mDate = date;
        }

        public String getDate() {
            return mDate;
        }

        public void setDate(String date) {
            mDate = date;
        }

        public int getTotalExpense() {
            return totalExpense;
        }

        public void setTotalExpense(int totalExpense) {
            this.totalExpense = totalExpense;
        }

        public int getTotalIncome() {
            return totalIncome;
        }

        public void setTotalIncome(int totalIncome) {
            this.totalIncome = totalIncome;
        }

        public ArrayList<TransactionData> getTransactionData() {
            return mTransactionData;
        }

        public void setTransactionData(ArrayList<TransactionData> transactionData) {
            mTransactionData = transactionData;
        }

        public void initializeTransactions(ArrayList<TransactionData> data){
            mTransactionData = data;
        }

    }

    public class TransactionData {

        private String category;
        private String description;
        private String transactionType;
        private int amount;
        private int imageId;

        public TransactionData(String category, String description, int amount, int imageId) {
            this.category = category;
            this.description = description;
            this.amount = amount;
            this.imageId = imageId;
        }

        public int getImageId() {
            return imageId;
        }

        public void setImageId(int imageId) {
            this.imageId = imageId;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            category = category;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

}
