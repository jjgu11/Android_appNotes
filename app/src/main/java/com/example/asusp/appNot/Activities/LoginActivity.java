package com.example.asusp.appNot.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asusp.appNot.R;

public class LoginActivity extends AppCompatActivity {

    //DECLARO LAS VARIABLES
    EditText username,password;
    Button login,registrer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //DECLARO UN SHAREPREFERENCE (PARA REALIZAR PRUEBAS) CREANDO UN ARCHIVO XML
        SharedPreferences sp = getSharedPreferences("userShare", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("usuario","u");
        editor.putString("password","p");
        editor.commit();

        // GUARDO LA INFO
        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.Password);

        login = (Button) findViewById(R.id.btnLogin);
        registrer = (Button) findViewById(R.id.btnRegister);


        // HACER CLICK
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(LoginActivity.this,"Le di click",Toast.LENGTH_LONG).show();

                String user = username.getText().toString();
                String pass = password.getText().toString();

                SharedPreferences preferences = getSharedPreferences("userShare",Context.MODE_PRIVATE);

                if (user.equals(preferences.getString("usuario","x"))){
                    if (pass.equals(preferences.getString("password","x"))){

                        //SI CORRECTO PASO A OTRA VISTA
                        Intent i = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(i);
                        finish();

                    }else {
                        Toast.makeText(LoginActivity.this,"Error del Password",Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(LoginActivity.this,"Error del Username",Toast.LENGTH_LONG).show();
                }
            }
        });

        registrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
