package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Calificaciones extends AppCompatActivity {

    private TextView information;
    final String URL = "https://www.fiec.espol.edu.ec/es/lista-excelencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificaciones);

        information = (TextView) findViewById(R.id.informacion);
        new Parser(information).execute(URL);
    }
}
