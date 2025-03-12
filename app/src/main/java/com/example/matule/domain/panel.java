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

public class panel extends AppCompatActivity {


    //боковая панель
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_panel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void profile(View view)
    {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
    public void cart(View view)
    {
        Intent intent = new Intent(this, cart.class);
        startActivity(intent);
    }
    public void favorite(View view)
    {
        Intent intent = new Intent(this, favoritenew.class);
        startActivity(intent);
    }

    public void oreder(View view)
    {
        Intent intent = new Intent(this, favoritenew.class);
        startActivity(intent);
    }

    public void notif(View view)
    {
        Intent intent = new Intent(this, notifications.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(this, sign_in.class);
        startActivity(intent);
    }

    public void order(View view)
    {
        Intent intent = new Intent(this, orders.class);
        startActivity(intent);
    }

    public void back(View view)
    {
        Intent intent = new Intent(this, mainBoard.class);
        startActivity(intent);
    }


}