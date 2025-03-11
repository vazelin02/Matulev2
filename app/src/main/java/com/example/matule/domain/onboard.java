package com.example.matule.domain;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.matule.R;

//Ппролистываемый начальный экран
public class onboard extends AppCompatActivity {
    ViewFlipper flipp;

    Button butt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        flipp = findViewById(R.id.flipper);
        butt= findViewById(R.id.button);
    }

    public void next(View view)
    {


        if(
                flipp.getDisplayedChild() == 2)
        {
            Intent intent = new Intent(this, mainBoard.class);
            startActivity(intent);

        }
        if(
                flipp.getDisplayedChild() == 1 )
        {
            butt.setText("Далее");
            flipp.showNext();

        }
        if(
        flipp.getDisplayedChild() == 0 )
    {
        butt.setText("Далее");
        flipp.showNext();

    }




    }
    public class onboard$favorite extends AppCompatActivity {
        public onboard$favorite() {
        }

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);


        }
    }



}