package com.example.expensemanager;

import java.nio.DoubleBuffer;

public class Data {
    private String name;
    private String month;
    private String charge;
    private String comment;



  Data(String name, String month, String charge, String comment ) {
        this.name = name;
        this.month = month;
        this.charge = charge;
        this.comment = comment;

    }
        String getName () {
            return this.name;
        }

        String getMonth () {
            return this.month;
        }

        String getMonthly_charge () {
            return this.charge;
        }

        String getComment () {return this.comment;}



    public void setName(String name) {
        this.name = name;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

