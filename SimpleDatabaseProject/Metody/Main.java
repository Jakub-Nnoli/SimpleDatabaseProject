package Metody;

import java.util.ArrayList;
import Uczelnia.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Osoba> osoby=new ArrayList<>();
        ArrayList<Kursy> kursy=new ArrayList<>();
        osoby.add(new Student("Kowalski", "Jan", "01311209876",20,"M",266000, 2, false, true, false, true, false));
        osoby.add(new Student("Nowak", "Mariusz", "01213172653",20,"M",266001, 2, false, true, false, true, false));
        osoby.add(new Student("Kowalski", "Mariusz", "02291292875",19,"M",266002, 1, false, true, false, true, false));
        osoby.add(new Student("Kowalska", "Anna", "00260995743",21,"K",266003, 3, false, true, false, false, true));
        osoby.add(new Student("Nowakowska", "Maria", "02282709543",19,"K",266004, 1, false, true, false, true, false));
        osoby.add(new Student("Leszczynska", "Wiktoria", "99030291725",22,"K",266005, 4, true, false, true, true, false));
        osoby.add(new Pracownik_A("Andrzejewska","Malgorzata","80040595340",41,"K","Specjalista",1.5,4700,6));
        osoby.add(new Pracownik_A("Piotrowski","Bartosz","84060790176",37,"M","Referent",0.5,3800,10));
        osoby.add(new Pracownik_BD("Torbicz","Mateusz","79012101352",42,"M","Wykladowca",1.25,5000,140));
        osoby.add(new Pracownik_BD("Pawlowska","Katarzyna","75051257341",46,"K","Profesor Zwyczajny",1.75,6000,230));
        osoby.add(new Pracownik_BD("Lewandowski","Norbert","72013106550",49,"M","Wykladowca",1.5,6500,120));
        osoby.add(new Pracownik_BD("Kubiak","Agnieszka","68052498547",53,"K","Wykladowca",1,6000,150));
        osoby.add(new Pracownik_BD("Rant","Marcin","80091812094",41,"M","Wykladowca",1.75,7000,250));
        osoby.add(new Student("Nowak", "Jan", "00000000000",21,"M",266000, 2, false, true, false, true, false));
        osoby.add(new Pracownik_A("Piotrowska","Aneta","84060790176",37,"K","Referent",0.5,3800,10));

        kursy.add(new Kursy("Algebra", "Marcin Rant", 6));
        kursy.add(new Kursy("Analiza matematyczna", "Mateusz Torbicz", 6));
        kursy.add(new Kursy("Fizyka", "Katarzyna Pawlowska", 4));
        kursy.add(new Kursy("Analiza matematyczna", "Norbert Lewandowski", 6));
        kursy.add(new Kursy("Logika", "Agnieszka Kubiak", 3));
        Menu m=new Menu(osoby,kursy);
        m.menu();
    }
}
