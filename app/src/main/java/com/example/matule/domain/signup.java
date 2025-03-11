package com.example.matule.domain;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.TransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.matule.R;

public class signup extends AppCompatActivity {


//Код для страницы регистрация
    EditText password, mail, _name;
    RadioButton check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
password = findViewById(R.id.password);
        mail = findViewById(R.id.email);
        _name = findViewById(R.id.name);
        check = findViewById(R.id.checks);
        da= password.getTransformationMethod();
    }
    TransformationMethod da;

    //проверка email
    public Boolean emailValidate(String email)
    {
        Boolean validation = Patterns.EMAIL_ADDRESS.matcher(email).matches();
        return validation;
    }

    //код для скрытия пароля
    public void set_visible(View view)
    {


        if (password.getTransformationMethod() == null)
            password.setTransformationMethod(da);

        else
        {
            password.setTransformationMethod(null);}

    }
    //возврат на страницу  кодом
    public void tosignin(View view)
    {
        Intent intent = new Intent(this, sign_in.class);
        startActivity(intent);
    }


    //код регистрации и перехода в главную
    public void registration(View view)
    {
     if (!(mail.getText().toString()).equals(""))
     {
         if (!(password.getText().toString()).equals(""))
         {
             if (!(_name.getText().toString()).equals(""))
             {
                 if (emailValidate(mail.getText().toString()))
                 {
                     if (check.isChecked()) {
                         Intent intent = new Intent(this, mainBoard.class);
                         startActivity(intent);
                     }
                     else { Toast toast1 = Toast.makeText(this, "Дайте согласие на обработку персональных данных" , Toast.LENGTH_LONG);
                         toast1.show();}
                 }
                 else {
                     Toast toast1 = Toast.makeText(this, "Ошибка. неверно указана почта" , Toast.LENGTH_LONG);
                     toast1.show();
                 }
             }else
             {
                 Toast toast1 = Toast.makeText(this, "Ошибка. не все данные заполнены" , Toast.LENGTH_LONG);
                 toast1.show();
             }
         } else
         {
             Toast toast1 = Toast.makeText(this, "Ошибка. не все данные заполнены" , Toast.LENGTH_LONG);
             toast1.show();
         }
     }
     else
     {
         Toast toast1 = Toast.makeText(this, "Ошибка. не все данные заполнены" , Toast.LENGTH_LONG);
         toast1.show();
     }
    }


}