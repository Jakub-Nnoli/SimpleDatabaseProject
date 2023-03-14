package Metody;

import Uczelnia.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Dodawanie {
    ArrayList<Osoba> osoby;
    ArrayList<Kursy> kursy;


    public Dodawanie(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy) {
        this.osoby = osoby;
        this.kursy = kursy;
    }

    public void dodajElement(){
        JFrame rama=new JFrame("Dodawanie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Co chcesz dodac?");

        JButton przycisk1=new JButton("Dodaj osobe");
        JButton przycisk2=new JButton("Dodaj kurs");

        panel.setLayout(new GridLayout(3,1,0,5));

        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);

        przycisk1.addActionListener(e -> {
            dodajOsobe();
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            dodajKurs();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void dodajOsobe(){
        JFrame rama=new JFrame("Dodawanie osoby");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,20));
        tekst.setText("Wprowadz podstawowe dane osoby:");

        panel.setLayout(new GridLayout(8,2,0,5));
        panel.add(tekst);
        panel.add(new JLabel(""));

        JLabel tekst1=new JLabel("Nazwisko:");
        panel.add(tekst1);
        JTextField nazwisko=new JTextField();
        panel.add(nazwisko);

        JLabel tekst2=new JLabel("Imie:");
        panel.add(tekst2);
        JTextField imie=new JTextField();
        panel.add(imie);

        JLabel tekst3=new JLabel("PESEL:");
        panel.add(tekst3);
        JTextField pesel=new JTextField();
        panel.add(pesel);

        JLabel tekst4=new JLabel("Wiek:");
        panel.add(tekst4);
        JTextField wiek=new JTextField();
        panel.add(wiek);

        JLabel tekst5=new JLabel("Plec:");
        panel.add(tekst5);
        JTextField plec=new JTextField();
        panel.add(plec);

        panel.add(new JLabel("Aby wybrac instancje klasy osoba(Student lub Pracownik)"));
        panel.add(new JLabel(" wpisz odpowiednie dane i kliknij odpowiedni przycisk"));

        JButton student=new JButton("Student");
        student.addActionListener(e -> {
            String n=nazwisko.getText();
            String i=imie.getText();
            String p=pesel.getText();
            int w=Integer.parseInt(wiek.getText());
            String pe=plec.getText();
            dodajStudenta(n,i,p,w,pe);
            rama.dispose();
        });
        panel.add(student);

        JButton pracownik=new JButton("Pracownik");
        pracownik.addActionListener(e -> {
            String n=nazwisko.getText();
            String i=imie.getText();
            String p=pesel.getText();
            int w=Integer.parseInt(wiek.getText());
            String pe=plec.getText();
            dodajPracownika(n,i,p,w,pe);
            rama.dispose();
        });
        panel.add(pracownik);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void dodajStudenta(String n, String i, String p, int w, String pl){
        JFrame rama=new JFrame("Dodawanie studenta");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,20));
        tekst.setText("Wprowadz pozostale dane studenta:");

        panel.setLayout(new GridLayout(9,2,0,5));
        panel.add(tekst);
        panel.add(new JLabel(""));

        JLabel tekst1=new JLabel("Numer indeksu:");
        panel.add(tekst1);
        JTextField nr=new JTextField();
        panel.add(nr);

        JLabel tekst2=new JLabel("Rok studiow:");
        panel.add(tekst2);
        JTextField rok=new JTextField();
        panel.add(rok);

        JLabel tekst3=new JLabel("Czy uczestniczy w programie ERASMUS (true/false):");
        panel.add(tekst3);
        JTextField er=new JTextField();
        panel.add(er);

        JLabel tekst4=new JLabel("Czy jest studentem pierwszego stopnia (true/false):");
        panel.add(tekst4);
        JTextField ps=new JTextField();
        panel.add(ps);

        JLabel tekst5=new JLabel("Czy jest studentem drugiego stopnia (true/fasle):");
        panel.add(tekst5);
        JTextField ds=new JTextField();
        panel.add(ds);

        JLabel tekst6=new JLabel("Czy studiuje stacjonarnie (true/false):");
        panel.add(tekst6);
        JTextField st=new JTextField();
        panel.add(st);

        JLabel tekst7=new JLabel("Czy studiuje niestacjonarnie (true/false):");
        panel.add(tekst7);
        JTextField nst=new JTextField();
        panel.add(nst);

        JButton send=new JButton("Zatwierdz dane");
        send.addActionListener(e -> {
            int in=Integer.parseInt(nr.getText());
            int r=Integer.parseInt(rok.getText());
            boolean cE=Boolean.parseBoolean(er.getText());
            boolean c1=Boolean.parseBoolean(ps.getText());
            boolean c2=Boolean.parseBoolean(ds.getText());
            boolean cS=Boolean.parseBoolean(st.getText());
            boolean cN=Boolean.parseBoolean(nst.getText());
            Student s=new Student(n,i,p,w,pl,in,r,cE,c1,c2,cS,cN);
            osoby.add(s);
            dodany();
            rama.dispose();
        });
        panel.add(send);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void dodajPracownika(String n, String i, String p, int w, String pl){
        JFrame rama=new JFrame("Dodawanie pracownika");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,20));
        tekst.setText("Wprowadz pozostale dane pracownika:");

        panel.setLayout(new GridLayout(6,2,0,5));
        panel.add(tekst);
        panel.add(new JLabel(""));

        JLabel tekst1=new JLabel("Stanowisko:");
        panel.add(tekst1);
        JTextField st=new JTextField();
        panel.add(st);

        JLabel tekst2=new JLabel("Staz:");
        panel.add(tekst2);
        JTextField staz=new JTextField();
        panel.add(staz);

        JLabel tekst3=new JLabel("Pensja:");
        panel.add(tekst3);
        JTextField pe=new JTextField();
        panel.add(pe);

        panel.add(new JLabel("Aby wybrac instancje klasy pracownik (Badawczo-Dydaktyczny lub Administacyjny)"));
        panel.add(new JLabel(" wpisz odpowiednie dane i kliknij odpowiedni przycisk"));

        JButton pra=new JButton("Pracownik Administracyjny");
        pra.addActionListener(e -> {
            String s=st.getText();
            double sta=Double.parseDouble(staz.getText());
            int pen=Integer.parseInt(pe.getText());
            dodajPracownikaA(n,i,p,w,pl,s,sta,pen);
            rama.dispose();
        });
        panel.add(pra);

        JButton prbd=new JButton("Pracownik Badawczo-Dydaktyczny");
        prbd.addActionListener(e -> {
            String s=st.getText();
            double sta=Double.parseDouble(staz.getText());
            int pen=Integer.parseInt(pe.getText());
            dodajPracownikaBD(n,i,p,w,pl,s,sta,pen);
            rama.dispose();
        });
        panel.add(prbd);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void dodajPracownikaA(String n, String i, String p, int w, String pl, String s, double st,int pe){
        JFrame rama=new JFrame("Dodawanie pracownika administracyjnego");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,20));
        tekst.setText("Wprowadz pozostale dane pracownika:");

        panel.setLayout(new GridLayout(3,2,0,5));
        panel.add(tekst);
        panel.add(new JLabel(""));

        JLabel tekst1=new JLabel("Nadgodziny:");
        panel.add(tekst1);
        JTextField nad=new JTextField();
        panel.add(nad);

        JButton send=new JButton("Zatwierdz dane");
        send.addActionListener(e -> {
            int nadH=Integer.parseInt(nad.getText());
            Pracownik_A pa=new Pracownik_A(n,i,p,w,pl,s,st,pe,nadH);
            osoby.add(pa);
            dodany();
            rama.dispose();
        });
        panel.add(send);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void dodajPracownikaBD(String n, String i, String p, int w, String pl, String s, double st,int pe){
        JFrame rama=new JFrame("Dodawanie pracownika badawczo-dydaktycznego");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,20));
        tekst.setText("Wprowadz pozostale dane pracownika:");

        panel.setLayout(new GridLayout(3,2,0,5));
        panel.add(tekst);
        panel.add(new JLabel(""));

        JLabel tekst1=new JLabel("Punkty naukowe:");
        panel.add(tekst1);
        JTextField pkt=new JTextField();
        panel.add(pkt);

        JButton send=new JButton("Zatwierdz dane");
        send.addActionListener(e -> {
            int pktn=Integer.parseInt(pkt.getText());
            Pracownik_BD pbd=new Pracownik_BD(n,i,p,w,pl,s,st,pe,pktn);
            osoby.add(pbd);
            dodany();
            rama.dispose();
        });
        panel.add(send);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void dodajKurs(){
        JFrame rama=new JFrame("Dodawanie kursu");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wprowadz dane kursu:");

        panel.setLayout(new GridLayout(5,2,0,5));
        panel.add(tekst);
        panel.add(new JLabel(""));

        JLabel tekst1=new JLabel("Nazwa kursu:");
        panel.add(tekst1);
        JTextField nazwa=new JTextField();
        panel.add(nazwa);

        JLabel tekst2=new JLabel("Imie i nazwisko powadzacego:");
        panel.add(tekst2);
        JTextField prowadzacy=new JTextField();
        panel.add(prowadzacy);

        JLabel tekst3=new JLabel("Punkty ECTS:");
        panel.add(tekst3);
        JTextField punkty=new JTextField();
        panel.add(punkty);

        JButton send=new JButton("Zatwierdz dane");
        send.addActionListener(e -> {
            String n=nazwa.getText();
            String p=prowadzacy.getText();
            int pu=Integer.parseInt(punkty.getText());
            Kursy k=new Kursy(n,p,pu);
            kursy.add(k);
            dodany();
            rama.dispose();
        });
        panel.add(send);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void dodany(){
        JFrame rama=new JFrame("Dodawanie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Element zostal dodany");
        panel.setLayout(new GridLayout(2,1,0,5));
        panel.add(tekst);

        JButton send=new JButton("Zakoncz");
        send.addActionListener(e -> {
            Menu m=new Menu(osoby,kursy);
            m.menu();
            rama.dispose();
        });
        panel.add(send);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }
}
