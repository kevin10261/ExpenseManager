package com.example.expensemanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.ArrayList;


public class HomeActivity extends AppCompatDialogFragment {


    private Data editData;

    ArrayList<Data> datasL;

    private HomeActivityListener listener;


    public interface HomeActivityListener{
        void applyTexts(Data data);
        void refreshListView();

        void editTotalsum();

    }
    public HomeActivity(Data data){
        if(data == null){

        }
        else{
            this.editData = data;
        }
    }

    /* Sending Information to Main Activity*/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof HomeActivityListener){
            listener = (HomeActivityListener) context;
        }else{
            throw new RuntimeException(context.toString()+"must implement HomeActivityListener");

        }
    }
@NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstancesState) {
        AlertDialog.Builder mydialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.custom_layout_for_add, null);
        mydialog.setView(view);
        AlertDialog dialog = mydialog.create();



        EditText edtname = view.findViewById(R.id.name_edit);
        EditText edtmonth = view.findViewById(R.id.month_edit);
        EditText edtcharge = view.findViewById(R.id.charge_edit);
        EditText edtcomment = view.findViewById(R.id.comment_edit);


        if(editData != null){
            edtname.setHint(editData.getName());
            edtmonth.setHint(editData.getMonth());
            edtcharge.setHint(editData.getMonthly_charge());
            edtcomment.setHint(editData.getComment());
        }

        Button btnSave = view.findViewById(R.id.btnAdd);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edtname.getText().toString();
                String month = edtmonth.getText().toString();
                String charge = edtcharge.getText().toString();
                String comment = edtcomment.getText().toString();


                if(editData != null){
                    if (name.equals("")){
                        name = editData.getName();
                    }
                    if (month.equals("")){
                        month = editData.getMonth();
                    }
                    if (charge.equals("")){
                        charge = editData.getMonthly_charge();
                    }
                    if (comment.equals("")){
                        comment = editData.getComment();
                    }
                    editData.setName(name);
                    editData.setMonth(month);
                    editData.setCharge(charge);
                    editData.setComment(comment);
                    listener.editTotalsum();
                    listener.refreshListView();
                    dismiss();

                }
                else{
                listener.applyTexts(new Data(name,month,charge,comment));
                listener.refreshListView();
                dismiss();
                }


            }
        });

        return mydialog.create();
    }



}




