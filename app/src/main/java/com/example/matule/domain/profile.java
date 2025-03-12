package com.example.matule.domain;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.matule.R;

public class profile extends AppCompatActivity {




//код для окна профиль
    Button savebtn;
    ImageButton editbtn;
    TextView changePhoto;
    EditText newname, newsurname, newadress, newphone;
    ImageView newnamecheck, newsurnamecheck, newadresscheck, newphonecheck;

    ImageView profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        newname = findViewById(R.id.name);
        newsurname = findViewById(R.id.surname);
        newadress = findViewById(R.id.adress);
        newphone = findViewById(R.id.phone);


        newnamecheck = findViewById(R.id.check1);
        newsurnamecheck = findViewById(R.id.check2);
        newadresscheck = findViewById(R.id.check3);
        newphonecheck = findViewById(R.id.check4);

        savebtn = findViewById(R.id.savebutton);

        editbtn  = findViewById(R.id.changebutton);

        changePhoto = findViewById(R.id.changephoto);

        profile = findViewById(R.id.profilephoto);
    }

    public void click(View view){
        Intent intent = new Intent(this, favoritenew.class);
        startActivity(intent);
    }

    public void clickCart(View view){
        Intent intent = new Intent(this, cart.class);
        startActivity(intent);
    }

    public void clickNex(View view)
    {
        Intent intent = new Intent(this, notifications.class);
        startActivity(intent);
    }
    public void clickmain(View view)
    {
        Intent intent = new Intent(this, mainBoard.class);
        startActivity(intent);
    }


//изменения профиля
    public void changeprofile(View view)
    {
        changePhoto.setVisibility(View.VISIBLE);
        newnamecheck.setVisibility(View.VISIBLE);
                newsurnamecheck.setVisibility(View.VISIBLE);
        newadresscheck.setVisibility(View.VISIBLE);
                newphonecheck.setVisibility(View.VISIBLE);
                savebtn.setVisibility(View.VISIBLE);
                editbtn.setVisibility(View.INVISIBLE);


                newname.setEnabled(true);
        newsurname.setEnabled(true);
        newadress.setEnabled(true);
        newphone.setEnabled(true);

    }
    //сохранение профиля
    public void saveprofile(View view)
    {
        changePhoto.setVisibility(View.INVISIBLE);
        newnamecheck.setVisibility(View.INVISIBLE);
        newsurnamecheck.setVisibility(View.INVISIBLE);
        newadresscheck.setVisibility(View.INVISIBLE);
        newphonecheck.setVisibility(View.INVISIBLE);
        savebtn.setVisibility(View.INVISIBLE);
        editbtn.setVisibility(View.VISIBLE);

        newname.setEnabled(false);
        newsurname.setEnabled(false);
        newadress.setEnabled(false);
        newphone.setEnabled(false);


    }



    public void chagephoto(View view)
    {
            openCamera();


    }


    public void panel(View view)
    {
        Intent intent = new Intent(this, panel.class);
        startActivity(intent);
    }
    private  void openCamera()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");

            profile.setImageBitmap(bp);
        }
    }
}