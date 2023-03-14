package Uczelnia;

import java.io.Serializable;
import java.util.ArrayList;
import Strategia.*;

public class Student extends Osoba implements Serializable {
    int indeks;
    ArrayList <Kursy> listaKursow=new ArrayList<>();
    int rokStudiow;
    int pECTS;
    boolean czyERASMUS;
    boolean czy1Stop;
    boolean czy2Stop;
    boolean czyStacjo;
    boolean czyNiestacjo;

    public Student(String nazwisko, String imie, String PESEL, int wiek, String plec, int indeks, int rokStudiow, boolean czyERASMUS, boolean czy1Stop, boolean czy2Stop, boolean czyStacjo, boolean czyNiestacjo) {
        super(nazwisko, imie, PESEL, wiek, plec);
        this.indeks = indeks;
        this.rokStudiow = rokStudiow;
        this.pECTS=0;
        this.czyERASMUS = czyERASMUS;
        this.czy1Stop = czy1Stop;
        this.czy2Stop = czy2Stop;
        this.czyStacjo = czyStacjo;
        this.czyNiestacjo = czyNiestacjo;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public ArrayList<Kursy> getListaKursow() {
        return listaKursow;
    }

    public void setListaKursow(ArrayList<Kursy> listaKursow) {
        this.listaKursow = listaKursow;
    }

    public int getRokStudiow() {
        return rokStudiow;
    }

    public void setRokStudiow(int rokStudiow) {
        this.rokStudiow = rokStudiow;
    }

    public int getpECTS() {
        return pECTS;
    }

    public void setpECTS(int pECTS) {
        this.pECTS = pECTS;
    }

    public boolean isCzyERASMUS() {
        return czyERASMUS;
    }

    public void setCzyERASMUS(boolean czyERASMUS) {
        this.czyERASMUS = czyERASMUS;
    }

    public boolean isCzy1Stop() {
        return czy1Stop;
    }

    public void setCzy1Stop(boolean czy1Stop) {
        this.czy1Stop = czy1Stop;
    }

    public boolean isCzy2Stop() {
        return czy2Stop;
    }

    public void setCzy2Stop(boolean czy2Stop) {
        this.czy2Stop = czy2Stop;
    }

    public boolean isCzyStacjo() {
        return czyStacjo;
    }

    public void setCzyStacjo(boolean czyStacjo) {
        this.czyStacjo = czyStacjo;
    }

    public boolean isCzyNiestacjo() {
        return czyNiestacjo;
    }

    public void setCzyNiestacjo(boolean czyNiestacjo) {
        this.czyNiestacjo = czyNiestacjo;
    }

    public String zapiszNaKurs(Kursy kurs){
        String n;
        boolean z=false;
        for (int i = 0; i < listaKursow.size(); i++) {
            String temp=listaKursow.get(i).getNazwa();
            if(temp.equals(kurs.getNazwa()))
                z=true;
        }
        if(z==false){
            listaKursow.add(kurs);
            n="Student "+imie+" "+nazwisko+" zostal zapisany na podany kurs\n";
        }
        else
            n="Student "+imie+" "+nazwisko+" jest juz zapisany na podany kurs\n";
        return n;
    }

    public String wypiszZKursu(Kursy kurs){
        String n;
        int index=-1;
        for (int i = 0; i < listaKursow.size(); i++) {
            if(listaKursow.get(i).equals(kurs))
                index=i;
        }
        if(index>0){
            listaKursow.remove(index);
            n="Student "+imie+" "+nazwisko+" zostal wypisany z podanego kursu\n";
        }
        else
            n="Student "+imie+" "+nazwisko+" nie byl zapisany na podany kurs\n";
        return n;
    }

    @Override
    public String toString() {
        String info=super.toString()+" "+indeks+" "+rokStudiow+" "+pECTS+" "+czyERASMUS+" "+czy1Stop+" "+czy2Stop+" "+czyStacjo+" "+czyNiestacjo+", Kursy studenta: \n";
        for (int i = 0; i < listaKursow.size(); i++) {
            info=info+listaKursow.get(i).toString()+",";
        }
        return info;
    }

    public boolean equals(Student s){
        return this.indeks == s.getIndeks();
    }

    @Override
    public String lata() {
        //zakladamy, ze student nie studiowal wczesniej na tej uczelni
        return "Student "+imie+" "+nazwisko+" spedzil na uczelni tyle lat: "+rokStudiow;
    }
}
