package com.example.matule.domain;

import static android.widget.Toast.makeText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.TransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.matule.R;
import com.example.matule.data.user;

import okhttp3.*;

import java.util.ArrayList;
import java.util.List;
import org.json.*;

//Код для страницы sign

public class sign_in extends AppCompatActivity {



    EditText login;
    EditText password1;

   static EditText password2;
int count = 1;
    ImageView eye;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        login = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        password2 = password1;
        eye = findViewById(R.id.glaz);


        user us = new user();
        us._login="login@mail.ru";
        us._password="password";
        users.add(us);

        request();
da= password1.getTransformationMethod();
    }
    TransformationMethod da;
    List<user> users = new ArrayList<>();

    String result;
    //метод для получения данных о пользователях
        public void request() {
            new Thread(this::run).start();
        }


//Метод для валидации логина
    public Boolean validationEmail(String email)
    {
Boolean validation = Patterns.EMAIL_ADDRESS.matcher(email).matches();
return validation;
    }


    //событие нажатия для кнопки вход
    public void click(View view)
    {


String _login = login.getText().toString();
        String _password = password1.getText().toString();
        if(  validationEmail(_login)) {

    if(_login != null)
    { if(_password != null) {
int j =0;

        for (int i = 0; i < count; i++)
        {
            if (login.getText().toString().equals("login@mail.ru"))
            {
                if(password1.getText().toString().equals("password") )
                {
                    Intent intent = new Intent(this, splash.class);
                    startActivity(intent);
                }
            }
        }


    }
    else {
        Toast toast1 = Toast.makeText(this, "Ошибка. Неверные данные" , Toast.LENGTH_LONG);
        toast1.show();
    }
        }
    else { Toast toast1 = Toast.makeText(this, "Ошибка. Неверные данные" , Toast.LENGTH_LONG);
        toast1.show();}
    }else{
            Toast toast = Toast.makeText(this, "Ошибка. Некоректные данные" , Toast.LENGTH_LONG);
            toast.show();
        }

    }

    private void run() {
        try {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("https://okewtwjpflpeidilfisy.supabase.co/rest/v1/profiles?select=*&apikey=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9rZXd0d2pwZmxwZWlkaWxmaXN5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDEwNjk1MzQsImV4cCI6MjA1NjY0NTUzNH0.G2x8v9CAjQH_x0OiSvBNCnF_gquc6vm3q4-eqrZR1Cw")
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            final String result = response.body().string();


            runOnUiThread(() -> {
                try {
                    JSONObject json = new JSONObject(result);
                    JSONArray results = json.getJSONArray("results");


                    for (int i = 0; i < results.length(); i++) {
                        JSONObject item = results.getJSONObject(i);
                        String password = item.getString("password");
                        String login = item.getString("login");
                        String id = item.getString("id");
                        user newuser = new user();
                        newuser._password = password;
                        newuser._login = login;
                        newuser._id = id;
                        count++;
                    }


                } catch (JSONException e) {

                }
            });

        } catch (Exception e) {
            int i = 0;
//            Toast toast = makeText(this, "Ошибка подключения", Toast.LENGTH_LONG);
//            toast.show();

        }
    }


    public void set_visible(View view)
    {


        if (password1.getTransformationMethod() == null)
            password1.setTransformationMethod(da);

        else
        {
        password1.setTransformationMethod(null);}

    }

    public void tosignup(View view)
    {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

    public void forgotpassword(View view)
    {

        Intent intent = new Intent(this, forgotpassword.class);
        startActivity(intent);
    }
}