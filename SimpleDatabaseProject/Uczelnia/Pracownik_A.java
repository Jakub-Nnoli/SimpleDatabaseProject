package Uczelnia;

import java.io.Serializable;
import Strategia.*;

public class Pracownik_A extends Pracownik_Uczelni implements Serializable {
    int nadgodziny;

    public Pracownik_A(String nazwisko, String imie, String PESEL, int wiek, String plec, String stanowisko, double staz, int pensja, int nadgodziny) {
        super(nazwisko, imie, PESEL, wiek, plec, stanowisko, staz, pensja);
        this.nadgodziny = nadgodziny;
    }

    public int getNadgodziny() {
        return nadgodziny;
    }

    public void setNadgodziny(int nadgodziny) {
        this.nadgodziny = nadgodziny;
    }

    public String zwiekszPensje(){
        String n;
        if(nadgodziny>0) {
            int p=nadgodziny/8; //ile pelnych dni
            int t=nadgodziny%8; //ile pozostalych godzin
            n="Pracownik "+imie+" "+nazwisko+" ma wypracowane nadgodziny, wiec dostanie wyzsza pensje";
            setPensja(nadgodziny+p*90+t*10);
            setNadgodziny(0);
        }
        else{
            n="Pracownik "+imie+" "+nazwisko+" nie ma wypracowanych zadnych nadgodzin";
        }
        return n;
    }

    @Override
    public String toString() {
        return super.toString()+" "+nadgodziny;
    }


    @Override
    public String lata() {
        //zakladamy ze kazdy pracownik pracuje na uczelni od 26 roku zycia
        return "Pracownik "+imie+" "+nazwisko+" pracuje na uczelni juz tyle lat: "+(getWiek()-26);
    }
}
