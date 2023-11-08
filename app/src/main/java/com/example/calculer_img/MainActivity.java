package com.example.calculer_img;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox mega_f;
    RadioButton metre,centimètre;
    EditText poids,taille;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void IMC(View view) {
        mega_f=findViewById(R.id.cb);
        metre=findViewById(R.id.metre);
        centimètre=findViewById(R.id.centi);
        poids=findViewById(R.id.et1);
        taille=findViewById(R.id.et2);
        double poids_d=Double.parseDouble(poids.getText().toString());
        double taille_d=Double.parseDouble(taille.getText().toString());
        if (centimètre.isChecked()){
            taille_d /=100;
        }
        double imc =(poids_d) / (taille_d * taille_d);
        TextView t=findViewById(R.id.res);
        t.setText("Votre IMC: "+imc);
        TextView comentaire=findViewById(R.id.comentaire);

        String msg;
        if (mega_f.isChecked()){
            if (imc < 18.5) {
                msg = "SOUS-POIDS";
            } else if (imc >= 18.5 && imc < 24.9) {
                msg = "NORMAL";
            } else if (imc >= 25 && imc < 29.9) {
                msg = "SURPOIDS";
            } else if (imc >= 30 && imc < 34.9) {
                msg = "OBESITE";
            } else if (imc >= 35) {
                msg = "OBESITE SEVERE";
            } else {
                msg = "Valeur IMC non valide";
            }
            comentaire.setText(msg);

        }
    }
}