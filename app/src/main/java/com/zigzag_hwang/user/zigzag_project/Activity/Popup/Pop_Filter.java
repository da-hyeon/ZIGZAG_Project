package com.zigzag_hwang.user.zigzag_project.Activity.Popup;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.zigzag_hwang.user.zigzag_project.Fragment.ShoppingMall;
import com.zigzag_hwang.user.zigzag_project.R;

public class Pop_Filter extends Activity {

    private Button button_Age[];
    private Button button_Style[];

    private boolean button_Age_Check[];
    private boolean button_Style_check[];

    private Button button_Reset;
    private Button selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pop__filter);


        int button_Age_id[] = {
                R.id.button_cho10,
                R.id.button_cho20,
                R.id.button_jung20,
                R.id.button_hu20,
                R.id.button_cho30,
                R.id.button_jung30,
                R.id.button_hu30};

        int button_Style_id[] = {
                R.id.button_style_Peminin,
                R.id.button_style_Modernsik,
                R.id.button_style_Simple,
                R.id.button_style_Lovely,
                R.id.button_style_Unique,
                R.id.button_style_Misi,
                R.id.button_style_Campus,
                R.id.button_style_Vintage,
                R.id.button_style_Sexyglam,
                R.id.button_style_School,
                R.id.button_style_romantic,
                R.id.button_style_Office,
                R.id.button_style_Luxury,
                R.id.button_style_Hollywood
        };

        button_Age = new Button[button_Age_id.length];
        button_Style = new Button[button_Style_id.length];

        button_Age_Check= new boolean[button_Age_id.length];
        button_Style_check = new boolean[button_Style_id.length];

        for (int i = 0; i < button_Age_id.length; i++) {
            button_Age[i] = (Button) findViewById(button_Age_id[i]);
        }

        for (int i = 0; i < button_Style_id.length; i++) {
            button_Style[i] = (Button) findViewById(button_Style_id[i]);
        }

        button_Reset = (Button) findViewById(R.id.button_Reset);
        selectedItem = (Button) findViewById(R.id.selectedItem);

        SharedPreferences sp = getSharedPreferences("check_File",MODE_PRIVATE);

        for(int i = 0; i < button_Age_Check.length; i++){
            button_Age_Check[i] = sp.getBoolean("button_Age_Check" + i,false);
            button_First_click_Age(getApplicationContext(), button_Age[i], i);
        }

        for(int i = 0; i < button_Style_check.length; i++){
            button_Style_check[i] = sp.getBoolean("button_Style_check" + i,false);
            button_First_click_Style(getApplicationContext(), button_Style[i], i);
        }

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_cho10:
                        button_click_Age(getApplicationContext(), button_Age[0], 0);
                        break;
                    case R.id.button_cho20:
                        button_click_Age(getApplicationContext(), button_Age[1], 1);
                        break;
                    case R.id.button_jung20:
                        button_click_Age(getApplicationContext(), button_Age[2], 2);
                        break;
                    case R.id.button_hu20:
                        button_click_Age(getApplicationContext(), button_Age[3], 3);
                        break;
                    case R.id.button_cho30:
                        button_click_Age(getApplicationContext(), button_Age[4], 4);
                        break;
                    case R.id.button_jung30:
                        button_click_Age(getApplicationContext(), button_Age[5], 5);
                        break;
                    case R.id.button_hu30:
                        button_click_Age(getApplicationContext(), button_Age[6], 6);
                        break;

                    case R.id.button_style_Peminin:
                        button_click_Style(getApplicationContext(), button_Style[0], 0);
                        break;
                    case R.id.button_style_Modernsik:
                        button_click_Style(getApplicationContext(), button_Style[1], 1);
                        break;
                    case R.id.button_style_Simple:
                        button_click_Style(getApplicationContext(), button_Style[2], 2);
                        break;
                    case R.id.button_style_Lovely:
                        button_click_Style(getApplicationContext(), button_Style[3], 3);
                        break;
                    case R.id.button_style_Unique:
                        button_click_Style(getApplicationContext(), button_Style[4], 4);
                        break;
                    case R.id.button_style_Misi:
                        button_click_Style(getApplicationContext(), button_Style[5], 5);
                        break;
                    case R.id.button_style_Campus:
                        button_click_Style(getApplicationContext(), button_Style[6], 6);
                        break;
                    case R.id.button_style_Vintage:
                        button_click_Style(getApplicationContext(), button_Style[7], 7);
                        break;
                    case R.id.button_style_Sexyglam:
                        button_click_Style(getApplicationContext(), button_Style[8], 8);
                        break;
                    case R.id.button_style_School:
                        button_click_Style(getApplicationContext(), button_Style[9], 9);
                        break;
                    case R.id.button_style_romantic:
                        button_click_Style(getApplicationContext(), button_Style[10], 10);
                        break;
                    case R.id.button_style_Office:
                        button_click_Style(getApplicationContext(), button_Style[11], 11);
                        break;
                    case R.id.button_style_Luxury:
                        button_click_Style(getApplicationContext(), button_Style[12], 12);
                        break;
                    case R.id.button_style_Hollywood:
                        button_click_Style(getApplicationContext(), button_Style[13], 13);
                        break;

                    case R.id.button_Reset:
                        for(int i = 0; i < button_Age.length; i++){
                            button_Age[i].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.buttonshape_mint_empty));
                            button_Age[i].setTextColor(Color.parseColor("#53bec2"));
                            setButton_Age_Check(false, i);
                        }

                        for(int i = 0; i < button_Style.length; i++){
                            button_Style[i].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.buttonshape_red_empty));
                            button_Style[i].setTextColor(Color.parseColor("#E81E61"));
                            setButton_Style_Check(false, i);
                        }
                        break;
                    case R.id.selectedItem:
                        SharedPreferences sharedPreferences = getSharedPreferences("check_File",MODE_PRIVATE);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        for(int i = 0; i < button_Age_Check.length; i++){
                            editor.putBoolean("button_Age_Check"+i , button_Age_Check[i]);
                            editor.putString("button_Age_String"+i , button_Age[i].getText().toString());
                        }

                        int styleTrue_Check = 0;
                        for(int i = 0; i < button_Style_check.length; i++){
                            editor.putBoolean("button_Style_check"+i , button_Style_check[i]);

                            if(button_Style_check[i]) {
                                editor.putString("button_Style_String" + styleTrue_Check, button_Style[i].getText().toString());
                                styleTrue_Check++;
                            }
                        }

                        editor.putInt("button_Age_Check_Length" , button_Age_Check.length);
                        editor.putInt("button_Style_check_Length" , styleTrue_Check);
                        editor.commit();

                        ShoppingMall.load_json.goJson();
                        finish();
                        break;
                }
            }
        };

        for (Button button : button_Age) {
            button.setOnClickListener(onClickListener);
        }
        for (Button button : button_Style) {
            button.setOnClickListener(onClickListener);
        }
        button_Reset.setOnClickListener(onClickListener);
        selectedItem.setOnClickListener(onClickListener);
    }

    //Popup진입시 버튼들 초기화작업. button_First_click_Style도 동일.
    public void button_First_click_Age(Context context, Button button, int boolID) {
        if (button_Age_Check[boolID]) {
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.buttonshape_mint_full));
            button.setTextColor(Color.parseColor("#FFFFFF"));
            setButton_Age_Check(true, boolID);
        } else {
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.buttonshape_mint_empty));
            button.setTextColor(Color.parseColor("#53bec2"));
            setButton_Age_Check(false, boolID);
        }
    }


    public void button_First_click_Style(Context context, Button button, int boolID) {
        if (button_Style_check[boolID]) {
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.buttonshape_red_full));
            button.setTextColor(Color.parseColor("#FFFFFF"));
            setButton_Style_Check(true, boolID);
        } else {
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.buttonshape_red_empty));
            button.setTextColor(Color.parseColor("#E81E61"));
            setButton_Style_Check(false, boolID);
        }
    }

    //버튼 터치시 스위치작업. button_click_Style 동일.
    public void button_click_Age(Context context, Button button, int boolID) {
        if (!button_Age_Check[boolID]) {
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.buttonshape_mint_full));
            button.setTextColor(Color.parseColor("#FFFFFF"));
            setButton_Age_Check(true, boolID);
        } else {
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.buttonshape_mint_empty));
            button.setTextColor(Color.parseColor("#53bec2"));
            setButton_Age_Check(false, boolID);
        }
    }

    public void button_click_Style(Context context, Button button, int boolID) {
        if (!button_Style_check[boolID]) {
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.buttonshape_red_full));
            button.setTextColor(Color.parseColor("#FFFFFF"));
            setButton_Style_Check(true, boolID);
        } else {
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.buttonshape_red_empty));
            button.setTextColor(Color.parseColor("#E81E61"));
            setButton_Style_Check(false, boolID);
        }
    }

    public void setButton_Style_Check(boolean button_check, int boolID) {
        this.button_Style_check[boolID] = button_check;
    }

    public void setButton_Age_Check(boolean button_check, int boolID) {
        this.button_Age_Check[boolID] = button_check;
    }

    public boolean[] getButton_Age_Check() {
        return button_Age_Check;
    }

    public boolean[] getButton_Style_check() {
        return button_Style_check;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}
