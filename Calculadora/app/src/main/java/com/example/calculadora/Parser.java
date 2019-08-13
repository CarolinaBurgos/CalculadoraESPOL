package com.example.calculadora;


import android.os.AsyncTask;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Parser extends AsyncTask<String, Void, String> {

    String calificaciones_info = "";
    private TextView information;

    public Parser(TextView information){
        this.information = information;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            Document doc = Jsoup.connect(params[0]).get();
            Element tables = doc.select("table").get(0);
            Elements filas = tables.select("tr");

            for (int i = 1; i < filas.size(); i = i + 2){
                Element fila = filas.get(i);

                Element datos = fila.select("td").get(0);
                Element dato_c = datos.select("p").get(0);
                Element dato_e = datos.select("p").get(2);
                Element dato_p = datos.select("p").get(3);
                calificaciones_info = calificaciones_info + ">>" + dato_c.ownText() + "\n\n" + dato_e.ownText() + " -> " + dato_p.ownText() + "\n\n\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return calificaciones_info;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        information.setText(result);
    }
}
