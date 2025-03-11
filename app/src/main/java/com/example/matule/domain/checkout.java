package com.example.matule.domain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.matule.R;

public class checkout extends AppCompatActivity {

    //код для страницы проверки заказа с всплывающим окном
    FrameLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        main = findViewById(R.id.mainframe);
    }
    public void order(View view){
        Intent intent = new Intent(this, cart.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(this, mainBoard.class);
        startActivity(intent);
    }

    public void pop(View view){
pop pop = new pop(this, null);
pop.setOnClickListener(this::back);
main.addView(pop);


    }
}