package Metody;

import Uczelnia.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Menu {
    ArrayList<Osoba> osoby;
    ArrayList<Kursy> kursy;
    boolean t;

    public Menu(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy) {
        this.osoby = osoby;
        this.kursy = kursy;
    }

    public void setT(boolean t) {
        this.t = t;
    }

    public void menu1(){
        CzasNaUczelni c=new CzasNaUczelni(osoby,kursy);
        Dodawanie d=new Dodawanie(osoby,kursy);
        LiczbaOsobKursy lok=new LiczbaOsobKursy(osoby,kursy);
        Pliki p=new Pliki(osoby,kursy);
        Powtorki po=new Powtorki(osoby,kursy);
        Sortowanie s=new Sortowanie(osoby,kursy);
        Usuwanie u=new Usuwanie(osoby,kursy);
        Wyswietlanie ww=new Wyswietlanie(osoby,kursy);
        Wyszukiwanie wz=new Wyszukiwanie(osoby,kursy);
        MetodyUczelnia mu=new MetodyUczelnia(osoby,kursy,wz);

        if(t){
            JFrame rama=new JFrame("Menu glowne");
            JPanel panel=new JPanel();
            JLabel tekst=new JLabel();

            tekst.setText("Co chcesz zrobić?");
            tekst.setFont(new Font("Calibri",Font.PLAIN,24));

            JButton przycisk1=new JButton("Dodaj element");
            JButton przycisk2=new JButton("Wyszukaj element");
            JButton przycisk3=new JButton("Usun element");
            JButton przycisk4=new JButton("Posortuj obecne dane");
            JButton przycisk5=new JButton("Wyswietl obecne dane");
            JButton przycisk6=new JButton("Wczytaj dane z pliku");
            JButton przycisk7=new JButton("Zapisz dane do pliku");
            JButton przycisk8=new JButton("Zapisz/wypisz studenta na kurs");
            JButton przycisk9=new JButton("Zwieksz pensje pracownika");
            JButton przycisk10=new JButton("Usun powtorki wsrod osob");
            JButton przycisk11=new JButton("Oblicz lata spedzone na uczelni");
            JButton przycisk12=new JButton("Wyswietl liczbe osob zapisanych na kursy");

            panel.setLayout(new GridLayout(13,1,0,5));
            panel.add(tekst);
            panel.add(przycisk1);
            panel.add(przycisk2);
            panel.add(przycisk3);
            panel.add(przycisk4);
            panel.add(przycisk5);
            panel.add(przycisk6);
            panel.add(przycisk7);
            panel.add(przycisk8);
            panel.add(przycisk9);
            panel.add(przycisk10);
            panel.add(przycisk11);
            panel.add(przycisk12);

            przycisk1.addActionListener(e -> {
                d.dodajElement();
                rama.dispose();
            });
            przycisk2.addActionListener(e -> {
                wz.szukajElement();
                rama.dispose();
            });
            przycisk3.addActionListener(e -> {
                u.usunElement();
                rama.dispose();
            });
            przycisk4.addActionListener(e -> {
                s.sortuj();
                rama.dispose();
            });
            przycisk5.addActionListener(e -> {
                ww.wyswietl();
                rama.dispose();
            });
            przycisk6.addActionListener(e -> {
                p.wczytajDane();
                rama.dispose();
            });
            przycisk7.addActionListener(e -> {
                p.zapiszDane();
                rama.dispose();
            });
            przycisk8.addActionListener(e -> {
                mu.zapiszWypisz();
                rama.dispose();
            });
            przycisk9.addActionListener(e -> {
                mu.pensja();
                rama.dispose();
            });
            przycisk10.addActionListener(e -> {
                po.usunPowtorki();
                rama.dispose();
            });
            przycisk11.addActionListener(e -> {
                c.czas();
                rama.dispose();
            });
            przycisk12.addActionListener(e -> {
                lok.ileOsobNaKurs();
                rama.dispose();
            });

            rama.add(panel);
            rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rama.pack();
            rama.setVisible(true);
        }
    }

    public void menu(){
        JFrame rama=new JFrame("Pytanie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setText("Czy chcesz cos zrobic?");
        tekst.setFont(new Font("Calibri",Font.PLAIN,24));

        JButton przycisk1=new JButton("Tak");
        JButton przycisk2=new JButton("Nie");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);

        przycisk1.addActionListener(e -> {
            setT(true);
            menu1();
            rama.dispose();

        });
        przycisk2.addActionListener(e -> {
            setT(false);
            menu1();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }
}
