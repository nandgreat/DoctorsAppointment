package com.nandom.doctorsappointment.util;

import android.app.Activity;
import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    public static void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    public static String correctPhoneNumber(String phone) {
        if (phone.substring(0, 4).contentEquals("+234"))
            phone = "0" + phone.substring(4, 14);
        else if (phone.substring(0, 3).contentEquals("234"))
            phone = "0" + phone.substring(3, 13);

        return phone;

    }

    public static String moneyFormat(String amount){

        DecimalFormat formatter = new DecimalFormat("###,###,###.00");
        return formatter.format(Double.parseDouble(amount));
    }


    public static String validateEmail(String email){
        if(!email.isEmpty()) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches())
                return "valid_email";
            else return "Invalid Email address";
        }else{
            return "Email field is required";
        }
    }

}
