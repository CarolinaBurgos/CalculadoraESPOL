package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;

import com.example.calculadora.Promedio;

public class Principal extends AppCompatActivity {

    private EditText promTeoricoTextView;
    private EditText promPracticoTextView;
    private EditText parcial1TextView;
    private EditText parcial2TextView;
    private EditText mejoramientoTextView;
    private EditText notaPracticaTextView;
    private EditText notaFinalTextView;
    private TextView estadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        promTeoricoTextView = (EditText) findViewById(R.id.prom_teorico);
        promPracticoTextView = (EditText) findViewById(R.id.prom_practico);
        parcial1TextView = (EditText) findViewById(R.id.nota_parcial1);
        parcial2TextView = (EditText) findViewById(R.id.nota_parcial2);
        mejoramientoTextView = (EditText) findViewById(R.id.nota_mejoramiento);
        notaPracticaTextView = (EditText) findViewById(R.id.nota_practica);
        notaFinalTextView = (EditText) findViewById(R.id.nota_promedio);
        estadoTextView = (TextView) findViewById(R.id.estado_final);

        promTeoricoTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                double teorico = Double.parseDouble(promTeoricoTextView.getText().toString());
                double porcentaje = 100 - teorico;
                promPracticoTextView.setText(String.valueOf(porcentaje));
            }
        });

        Button btn = (Button) findViewById(R.id.mejores_promedios);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this, Calificaciones.class);
                Principal.this.startActivity(intent);
            }
        });
    }

    public void calcular(View v){
        double teorico = Double.parseDouble(promTeoricoTextView.getText().toString());
        double practico = Double.parseDouble(promPracticoTextView.getText().toString());
        double p1 = Double.parseDouble(parcial1TextView.getText().toString());
        double p2 = Double.parseDouble(parcial2TextView.getText().toString());
        double mej = Double.parseDouble(mejoramientoTextView.getText().toString());
        double n_prac = Double.parseDouble(notaPracticaTextView.getText().toString());

        Promedio pr = new Promedio(p1, p2, mej, n_prac, teorico, practico);
        double promedio = pr.calcular();

        notaFinalTextView.setText(String.valueOf(promedio));

        if (promedio >= 60.0) {
            estadoTextView.setText("AP");
        } else {
            estadoTextView.setText("RP");
        }
    }

}
