package Obserwator;

import Uczelnia.*;
import java.util.ArrayList;

public class OsobyNaKursach implements Obserwowany{
    ArrayList<Obserwator> liczbaOsob =new ArrayList<>();
    ArrayList<Kursy> kursy;

    public OsobyNaKursach(ArrayList<Kursy> kursy) {
        this.kursy = kursy;
    }

    @Override
    public void dodajObserwatora(Obserwator obserwator) {
        liczbaOsob.add(obserwator);
    }

    @Override
    public void usunObserwatora(Obserwator obserwator) {
        liczbaOsob.remove(obserwator);
    }

    @Override
    public void powiadomObserwatorow() {
        for (int i = 0; i < liczbaOsob.size(); i++) {
            liczbaOsob.get(i).aktualizacja(kursy.get(i));
        }
    }
}
