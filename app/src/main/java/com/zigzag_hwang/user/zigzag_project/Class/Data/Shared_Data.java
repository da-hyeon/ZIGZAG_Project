package com.zigzag_hwang.user.zigzag_project.Class.Data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

public class Shared_Data {
    private Context context;
    private String shopAge_Comparison_Target[];
    private String shopStyle_Comparison_Target[];

    private String age_String = "";
    private String style_String = "";

    private static int age_Check_Count;
    private static int style_Check_Count;

    private int button_Age_Check_Length;
    private int button_Style_check_Length;

    public Shared_Data(Context context) {
        this.context = context;
        Run_SharedPreferences();
    }

    private void Run_SharedPreferences() {
        SharedPreferences sp = context.getSharedPreferences("check_File", MODE_PRIVATE);
        button_Age_Check_Length = sp.getInt("button_Age_Check_Length", 0);
        button_Style_check_Length = sp.getInt("button_Style_check_Length", 0);
        age_Check_Count = 0;
        style_Check_Count = 0;

        shopAge_Comparison_Target = new String[button_Age_Check_Length];
        shopStyle_Comparison_Target = new String[button_Style_check_Length];

        for (int i = 0; i < button_Age_Check_Length; i++) {
            boolean button_Age_Check = sp.getBoolean("button_Age_Check" + i, false);

            if (button_Age_Check) {
                shopAge_Comparison_Target[i] = "1";
                age_String += sp.getString("button_Age_String" + i, "");
                age_String += " , ";
                age_Check_Count++;
            } else
                shopAge_Comparison_Target[i] = "0";
        }

        Log.d("Style_check_Length : " , button_Style_check_Length+"");

        for (int i = 0; i < button_Style_check_Length; i++) {
            shopStyle_Comparison_Target[i] = sp.getString("button_Style_String" + i, "");
            Log.d("shopStyle_Comparison_Target["+ i + "] : " , shopStyle_Comparison_Target[i]);
            style_String += shopStyle_Comparison_Target[i];
            style_String += " , ";
        }
    }

    public int getButton_Age_Check_Length() {
        return button_Age_Check_Length;
    }

    public int getButton_Style_check_Length() {
        return button_Style_check_Length;
    }

    public String getAge_String() {
        if (!age_String.equals(""))
            return age_String.substring(0, age_String.length() - 3);
        else
            return age_String;
    }

    public String getStyle_String() {

        if (!style_String.equals(""))
            return style_String.substring(0, style_String.length() - 3);
        else
            return style_String;
    }

    public String getShopAge_Comparison_Target(int index) {
        return shopAge_Comparison_Target[index];
    }

    public String getShopStyle_Comparison_Target(int index) {
        return shopStyle_Comparison_Target[index];
    }
    public int getAge_Check_Count() {
        return age_Check_Count;
    }

}



