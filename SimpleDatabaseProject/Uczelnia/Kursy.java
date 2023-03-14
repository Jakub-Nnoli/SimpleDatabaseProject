package Uczelnia;

import java.io.Serializable;
import Strategia.*;

public class Kursy implements Serializable {
    String nazwa;
    String prowadzacy;
    int ECTS;

    public Kursy(String nazwa, String prowadzacy, int ECTS) {
        this.nazwa = nazwa;
        this.prowadzacy = prowadzacy;
        this.ECTS = ECTS;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(String prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public String getNazwisko(){
        String nazw=getProwadzacy().trim();
        nazw=nazw.substring(nazw.indexOf(" ")+1);
        return nazw;
    }

    @Override
    public String toString() {
        return nazwa+" "+prowadzacy+" "+ECTS;
    }
}
