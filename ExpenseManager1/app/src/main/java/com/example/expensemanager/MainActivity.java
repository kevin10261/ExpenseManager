package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeActivity.HomeActivityListener {
    ListView ExpenseListView;
    ArrayAdapter<Data> moneyAdapter;

    ArrayList<Data> dataList;
    Button button;

    Double totalExpense;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpenseListView = findViewById(R.id.expense_list);
        dataList = new ArrayList<>();



        moneyAdapter = new CustomList(this,dataList);

        ExpenseListView.setAdapter(moneyAdapter);
        setUpListViewListener();




        button = findViewById(R.id.button);
        button.setOnClickListener(view ->  {
            new HomeActivity(null).show(getSupportFragmentManager(),"ADD_CITY");


        });
        ExpenseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view, int position,long id) {

                Data selectedData = dataList.get(position);

                HomeActivity editDataFragment = new HomeActivity(selectedData);
                editDataFragment.show(getSupportFragmentManager(),"EDIT DATA");

            }
        });


    }

    private void setUpListViewListener() {
        ExpenseListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                dataList.remove(i);
                moneyAdapter.notifyDataSetChanged();

                totalExpense = 0.00;
                for (Data datas : dataList) {
                    totalExpense += Double.parseDouble(datas.getMonthly_charge());
                }
                String totalExpense2 = Double.toString(totalExpense);
                TextView totalExpenseamount = findViewById(R.id.total_expense_txt);
                totalExpenseamount.setText(totalExpense2);
                return true;
            }
        });
    }


    @Override
    public void applyTexts(Data data) {
        if (data != null && data.getMonthly_charge() != null && !data.getMonthly_charge().isEmpty()) {
            moneyAdapter.add(data);

            totalExpense = 0.00;
            for (Data datas : dataList) {
                totalExpense += Double.parseDouble(datas.getMonthly_charge());
            }
            String totalExpense2 = Double.toString(totalExpense);
            TextView totalExpenseamount = findViewById(R.id.total_expense_txt);
            totalExpenseamount.setText(totalExpense2);
        } else {

        }
      }

public void editTotalsum(){
        totalExpense = 0.00;
        for (Data datas : dataList) {
            totalExpense += Double.parseDouble(datas.getMonthly_charge());
        }
        String totalExpense2 = Double.toString(totalExpense);
        TextView totalExpenseamount = findViewById(R.id.total_expense_txt);
        totalExpenseamount.setText(totalExpense2);


}
        public void refreshListView () {
            moneyAdapter.notifyDataSetChanged();
        }




}
