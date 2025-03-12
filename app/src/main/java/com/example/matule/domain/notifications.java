package com.example.matule.domain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.matule.R;

public class notifications extends AppCompatActivity {


    //код для страницы с уведомлениями
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notifications);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void click(View view){
        Intent intent = new Intent(this, mainBoard.class);
        startActivity(intent);
    }

    public void clickCart(View view){
        Intent intent = new Intent(this, cart.class);
        startActivity(intent);
    }

    public void panel(View view)
    {
        Intent intent = new Intent(this, panel.class);
        startActivity(intent);
    }



    public void clickprofile(View view)
    {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
}