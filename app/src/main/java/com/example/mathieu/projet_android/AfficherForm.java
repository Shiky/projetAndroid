package com.example.mathieu.projet_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AfficherForm extends AppCompatActivity {

   TextView civi,nom,prenom,addresse,email,hobbies;
   String civilForm,nomForm,prenomForm,mailForm,addresseForm,hobiesForm;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_form);

        Intent i = getIntent();
        sp=getSharedPreferences("formStock",MODE_PRIVATE);

       civilForm= sp.getString("genreCle","NULL");

        nomForm= sp.getString("nomCle","NULL");

     prenomForm  = sp.getString("prenomCle","NULL");

     mailForm  =  sp.getString("mailCle","NULL");

    addresseForm   = sp.getString("adresseCle","NULL");

     hobiesForm  = sp.getString("genreCle","NULL");



        civi= findViewById(R.id.TV_civAffichage);
         nom=findViewById(R.id.TV_nomAffiche)  ;
         prenom=findViewById(R.id.TV_prenomAffiche)  ;
       email=findViewById(R.id.TV_mailAffiche);
        addresse=findViewById(R.id.TV_addresseAffichage);
        hobbies=findViewById(R.id.TV_hobbiesAffichage);

        civi.setText(civilForm);
        nom.setText(nomForm);
        prenom.setText(prenomForm);
        email.setText(mailForm);
        addresse.setText(addresseForm);
       /* t6.setText(hobies1);
        t6.setText(hobies2);
        t6.setText(hobies3);
        t6.setText(hobies4);*/
    }
}
