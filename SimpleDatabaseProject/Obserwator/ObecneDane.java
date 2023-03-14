package Obserwator;
import Uczelnia.*;

import java.util.ArrayList;

public class ObecneDane implements Obserwator{
    ArrayList<Osoba> osoby;
    Obserwowany dane;

    public ObecneDane(ArrayList<Osoba> osoby, Obserwowany dane) {
        this.osoby = osoby;
        this.dane = dane;
        this.dane.dodajObserwatora(this);
    }

    @Override
    public String aktualizacja(Kursy k) {
        int liczba=0;
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Student){
                ArrayList<Kursy> kursyStudenta=((Student) osoby.get(i)).getListaKursow();
                for (int j = 0; j < kursyStudenta.size(); j++) {
                    if(kursyStudenta.get(j).getNazwa().equals(k.getNazwa()) && kursyStudenta.get(j).getProwadzacy().equals(k.getProwadzacy()) && kursyStudenta.get(j).getECTS()==k.getECTS())
                        liczba++;
                }
            }
        }
        return "Liczba osob zapisanych na kurs "+k.getNazwa()+", prowadzonego przez "+k.getProwadzacy()+" wynosi "+liczba;
    }
}
