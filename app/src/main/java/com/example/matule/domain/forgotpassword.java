package com.example.matule.domain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.matule.R;

public class forgotpassword extends AppCompatActivity {


//код для страницы забыл пароль
    EditText mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgotpassword);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mail = findViewById(R.id.email);
    }

    //проверка почты на верное написание
    public Boolean emailValidate(String email)
    {
        Boolean validation = Patterns.EMAIL_ADDRESS.matcher(email).matches();
        return validation;
    }

    //переход на создание нового пароля
  public  void clicknext(View viw)
  {
      if (emailValidate(mail.getText().toString()))
      {
        Intent intent =new  Intent(this, newpassword.class);
        startActivity(intent);

      }
      else {
          Toast toast1 = Toast.makeText(this, "Ошибка. неверно указана почта" , Toast.LENGTH_LONG);
          toast1.show();
      }
  }

    public void clickN(View view)
    {

        Intent intent = new Intent(this, sign_in.class);
        startActivity(intent);
    }

    public void next(View view)
    {

        Intent intent = new Intent(this, newpassword.class);
        startActivity(intent);
    }


}