package com.example.matule.domain;

import static android.widget.Toast.makeText;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.matule.R;

public class newpassword extends AppCompatActivity {

    EditText _password1, _password2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_newpassword);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        _password1 = findViewById(R.id.password1);
        _password2 = findViewById(R.id.password2);
        da1= _password1.getTransformationMethod();
        da2= _password2.getTransformationMethod();

    }
    TransformationMethod da1;
    TransformationMethod da2;
    //код для скрытия пароля 1
    public void set_visible1(View view)
    {


        if (_password1.getTransformationMethod() == null)
            _password1.setTransformationMethod(da1);

        else
        {
            _password1.setTransformationMethod(null);}

    }
    //код для скрытия пароля 2
    public void set_visible2(View view)
    {


        if (_password2.getTransformationMethod() == null)
            _password2.setTransformationMethod(da2);

        else
        {
            _password2.setTransformationMethod(null);}

    }
    public void next(View view)
    {

        Intent intent = new Intent(this, sign_in.class);
        startActivity(intent);
    }
    //код для сохранения(нет) и перехода на страницу входа есть проверка на пустоту паролей и их совпадение
    public void save(View view)
    {

        if (!_password1.getText().toString().equals("") )
        {
            if (!_password2.getText().toString().equals("") )
            {
                if (_password1.getText().toString().equals(_password2.getText().toString())) {
                    Intent intent = new Intent(this, sign_in.class);
                    startActivity(intent);
                } else {
                    Toast toast = makeText(this, "Пароли не совпадают", Toast.LENGTH_LONG);
                    toast.show();

                }
            } else {
                Toast toast = makeText(this, "Вы не подтвердили пароль", Toast.LENGTH_LONG);
                toast.show();

            }
        }
        else {
            Toast toast = makeText(this, "Вы не ввели пароль", Toast.LENGTH_LONG);
            toast.show();

        }
    }
    public void tosignin(View viw)
    {
        Intent intent = new Intent(this, sign_in.class);
        startActivity(intent);

    }
}