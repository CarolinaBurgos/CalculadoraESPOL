package com.example.calculadora;

public class Promedio {

    private double p1;
    private double p2;
    private double mej;
    private double n_pract;
    private double teorico;
    private double practico;

    public Promedio(double p1, double p2, double mej, double n_prac, double teorico, double practico){
        this.p1 = p1;
        this.p2 = p2;
        this.mej = mej;
        this.n_pract = n_prac;
        this.teorico = teorico;
        this.practico = practico;
    }

    public double calcular(){
        double teorico = (prom_teorico(this.p1, this.p2, this.mej)*this.teorico)/100;
        double practico = (this.n_pract*this.practico)/100;

        return (teorico+practico);
    }

    public double prom_teorico(double p1, double p2, double mej){
        double menor = Math.min(Math.min(p1, p2), mej);
        double suma = (p1 + p2 + mej) - menor;

        return (suma/2);
    }

}
