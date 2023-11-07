package com.example.expensemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<Data> {
    private ArrayList<Data> datas;
    private Context context;




    public CustomList(Context context, ArrayList<Data>datas){
        super(context,0,datas);
        this.datas = datas;
        this.context = context;


    }


    @NonNull

    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.adapter_view_layout,parent,false);
        }
        Data data = datas.get(position);



        TextView l_name = view.findViewById(R.id.textview_name);
        TextView l_month = view.findViewById(R.id.textview_month);
        TextView l_charge = view.findViewById(R.id.textview_expense);
        TextView l_comment = view.findViewById(R.id.textview_comment);



//        String l_charge2 = Double.toString(data.getMonthly_charge());
        l_name.setText(data.getName());
        l_month.setText(data.getMonth());
        l_charge.setText(data.getMonthly_charge());
        l_comment.setText(data.getComment());



        return view;
    }







}
