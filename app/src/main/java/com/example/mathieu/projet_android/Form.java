package com.example.mathieu.projet_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class Form extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {


    String tabGenre;
    Spinner genre;
    Bundle Civ = new Bundle();
    EditText nom, prenom, mail, adresse;
    Button valide;
    CheckBox info,sport,voy,musique;
    SharedPreferences.Editor sp;
    String formStock;
     String nomCle,prenomCle,mailCle,adresseCle,genreCle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        genre = (Spinner) findViewById(R.id.Spinner_genre);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Spinner_genre, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genre.setAdapter(adapter);
        genre.setOnItemSelectedListener(this);

        nom = (EditText) findViewById(R.id.ED_Name);
        prenom = (EditText) findViewById(R.id.ED_Prenom);
        mail = (EditText) findViewById(R.id.ED_Mail);
        adresse = (EditText) findViewById(R.id.ED_adresse);
        valide = findViewById(R.id.btn_valider_Formulaire);
        valide.setOnClickListener(new View.OnClickListener() {
            @Override



            public void onClick(View v) {
                Intent i = new Intent(Form.this,AfficherForm.class);

                    sp=getSharedPreferences(formStock,MODE_PRIVATE).edit();

                    sp.putString("nomCle",nom.getText().toString());
                    sp.putString("prenomCle",prenom.getText().toString());
                    sp.putString("mailCle",mail.getText().toString());
                    sp.putString("adresseCle",adresse.getText().toString());



                i.putExtras(Civ);
                startActivity(i);
                }
             });
    }

        @Override
        public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
            tabGenre = String.valueOf(genre.getSelectedItem());
            Toast.makeText(Form.this,
                    "OnClickListener : " +
                            "\nSpinner 1 : " + tabGenre,
                    Toast.LENGTH_SHORT).show();

           sp.putString("genreCle",tabGenre);
        }

        @Override
        public void onNothingSelected (AdapterView < ? > parent){

        }
/*
    public void onCheckboxClicked(View view) {
        Boolean checked=((CheckBox) view).isChecked();

        switch(view.getId())
        {
            case R.id.CB_info:
                if(checked) {
                    String inFo = info.getText().toString();
                    Civ.putString("Extrainfo",inFo);
                }break;
            case R.id.CB_sport:
                if(checked) {
                    String sPort = sport.getText().toString();
                    Civ.putString("Extrasport",sPort);
                }break;
            case R.id.CB_voyage:
                if(checked) {
                    String voyage= voy.getText().toString();
                    Civ.putString("Extravoyage",voyage);
                }break;
            case R.id.CB_Musique:
                if(checked) {
                    String music= musique.getText().toString();
                    Civ.putString("Extramusic",music);
                }break;
        }
    }
*/
    public void ajoutImage(View view) {

    }
}

