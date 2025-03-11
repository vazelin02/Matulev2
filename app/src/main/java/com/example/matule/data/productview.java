package com.example.matule.data;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.matule.R;

//пользоватеьский элемент для одной единицы товара
public class productview extends LinearLayout {

    public productview(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }


    public productview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(R.layout.activity_productview, this, true);
    }

//    public void click(View view)
//    {
//
//
//
//    }



}