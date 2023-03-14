package Uczelnia;

import java.io.Serializable;
import Strategia.*;

public abstract class Osoba implements LataNaUczelni,Serializable {
    String nazwisko;
    String imie;
    String PESEL;
    int wiek;
    String plec;

    public Osoba(String nazwisko, String imie, String PESEL, int wiek, String plec) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.PESEL = PESEL;
        this.wiek = wiek;
        this.plec = plec;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    @Override
    public String toString() {
        return nazwisko+" "+imie+" "+PESEL+" "+wiek+" "+plec;
    }
}
