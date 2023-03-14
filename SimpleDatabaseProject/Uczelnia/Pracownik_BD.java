package Uczelnia;

import java.io.Serializable;
import Strategia.*;

public class Pracownik_BD extends Pracownik_Uczelni implements Serializable {
    int punktacja;
    boolean czyPodwyzszana;

    public Pracownik_BD(String nazwisko, String imie, String PESEL, int wiek, String plec, String stanowisko, double staz, int pensja, int punktacja) {
        super(nazwisko, imie, PESEL, wiek, plec, stanowisko, staz, pensja);
        this.punktacja = punktacja;
        this.czyPodwyzszana = false;
    }

    public int getPunktacja() {
        return punktacja;
    }

    public void setPunktacja(int punktacja) {
        this.punktacja = punktacja;
    }

    public boolean isCzyPodwyzszana() {
        return czyPodwyzszana;
    }

    public void setCzyPodwyzszana(boolean czyPodwyzszana) {
        this.czyPodwyzszana = czyPodwyzszana;
    }

    public String zwiekszPensje(){    //Jezeli wiecej punktow niz 200, to zwieksz pensje o (ilosc punktow-200)*10
        String n;
        if(!czyPodwyzszana){
            if(punktacja>200){
                n="Pracownik "+imie+" "+nazwisko+" ma duzo punktow naukowych, wiec zwiekszmy pensje\n";
                setPensja(pensja+(punktacja-200)*10);
                setCzyPodwyzszana(true);
            }
            else{
                n="Pracownik "+imie+" "+nazwisko+" nie ma odpowiednio duzej liczby punktow naukowych\n";
            }
        }
        else
           n="Pracownik "+imie+" "+nazwisko+" juz mial podwyzszana pensje\n";
        return n;
    }

    @Override
    public String toString() {
        return super.toString()+" "+punktacja;
    }


    @Override
    public String lata() {
        //zakladamy ze kazdy pracownik pracuje na uczelni od 26 roku zycia
        return "Pracownik "+imie+" "+nazwisko+" pracuje na uczelni juz tyle lat: "+(getWiek()-26);
    }
}
