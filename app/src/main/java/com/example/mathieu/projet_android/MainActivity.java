package com.example.mathieu.projet_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button valide;                     //déclaration de la variavle bouton
        final EditText  login,passWord;
        final TextView error;
        final String loginValue="admin";
        final String passwordValue="password";
        // déclaration des variable de recupération des edittext




       valide=(Button) findViewById(R.id.Btn_valider);      //récupération de boutton dans la variable
       login=(EditText) findViewById(R.id.ED_login);        //récupération des l'édit text dans les variable login et password
       passWord=(EditText) findViewById(R.id.ED_password);
       error=(TextView) findViewById(R.id.Tv_error);
        valide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(login.getText().toString().equals(loginValue) && passWord.getText().toString().equals(passwordValue))
                {
                    Intent Formulaire= new Intent(MainActivity.this,Form.class);
                    startActivity(Formulaire);
                }
                    else
                {
                    error.setText("Error: le login ou le mot de passe est érroné ");
                }

            }
        });













    }
}
