package com.example.matule.domain;

import static com.example.matule.R.drawable.*;
import static com.example.matule.R.drawable.snik1;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.matule.R;
//страница details код для нее
public class details_view extends AppCompatActivity {


    ImageButton snik1, snik2, snik3, snik4, snik5;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        snik1 = findViewById(R.id.sniker1);
        snik2 = findViewById(R.id.sniker2);
        snik3 = findViewById(R.id.sniker3);
        snik4 = findViewById(R.id.sniker4);
        snik5 = findViewById(R.id.sniker5);

        image = findViewById(R.id.sneaker);
    }

    public void ClickSnek(View view)
    {

      image.setBackground( view.getBackground()  );


    }
}
