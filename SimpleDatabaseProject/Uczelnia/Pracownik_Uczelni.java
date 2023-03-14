package Uczelnia;

import java.io.Serializable;
import Strategia.*;

public abstract class Pracownik_Uczelni extends Osoba implements Pensja, Serializable {
    String stanowisko;
    double staz;
    int pensja;

    public Pracownik_Uczelni(String nazwisko, String imie, String PESEL, int wiek, String plec, String stanowisko, double staz, int pensja) {
        super(nazwisko, imie, PESEL, wiek, plec);
        this.stanowisko = stanowisko;
        this.staz = staz;
        this.pensja = pensja;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public double getStaz() {
        return staz;
    }

    public void setStaz(double staz) {
        this.staz = staz;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    @Override
    public String toString() {
        return super.toString()+" "+stanowisko+" "+staz+" "+pensja;
    }
}
