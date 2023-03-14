package Metody;

import Uczelnia.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MetodyUczelnia {
    ArrayList<Osoba> osoby;
    ArrayList<Kursy> kursy;
    Wyszukiwanie w;

    public MetodyUczelnia(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy, Wyszukiwanie w) {
        this.osoby = osoby;
        this.kursy = kursy;
        this.w = w;
    }

    public void zapiszWypisz(){
        JFrame rama=new JFrame("Informacje o kursie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wybierz jeden z dostepnych kursow: ");

        panel.setLayout(new GridLayout(kursy.size()+1,1,0,5));
        panel.add(tekst);

        JButton[] przyciski=new JButton[kursy.size()];
        for (int i = 0; i < kursy.size(); i++) {
            przyciski[i]=new JButton(kursy.get(i).getNazwa()+" "+kursy.get(i).getProwadzacy()+" "+kursy.get(i).getECTS());
            panel.add(przyciski[i]);
            Kursy k=kursy.get(i);
            przyciski[i].addActionListener(e -> {
                zapiszWypiszS(k);
                rama.dispose();
            });
        }

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void zapiszWypiszS(Kursy k){
        JFrame rama=new JFrame("Zapisy/Wypisy");
        JPanel panel=new JPanel();

        JLabel tekst=new JLabel();
        tekst.setText("Co chcesz zrobić?");
        tekst.setFont(new Font("Calibri",Font.PLAIN,24));

        JButton przycisk1=new JButton("Zapisz studenta/studentow na wybrany kurs");
        JButton przycisk2=new JButton("Wypisz studenta/studentow z wybranego kurs");
        JButton przycisk3=new JButton("Zapisz wszystkich studentow na wybrany kurs");
        JButton przycisk4=new JButton("Wypisz wszystkich studentow z wybranego kursu");

        panel.setLayout(new GridLayout(5,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);
        panel.add(przycisk3);
        panel.add(przycisk4);

        przycisk1.addActionListener(e -> {
            zapisz(k);
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            wypisz(k);
            rama.dispose();
        });
        przycisk3.addActionListener(e -> {
            zapiszW(k);
            rama.dispose();
        });
        przycisk4.addActionListener(e -> {
            wypiszW(k);
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void zapisz(Kursy k){
        JFrame rama=new JFrame("Zapis");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wprowadz nazwisko studenta:");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);

        JTextField nazwisko=new JTextField();
        panel.add(nazwisko);

        JButton send=new JButton("Zatwierdz dane");
        send.addActionListener(e -> {
            String n=nazwisko.getText();
            zapiszS(n,k);
            rama.dispose();
        });
        panel.add(send);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void wypisz(Kursy k){
        JFrame rama=new JFrame("Wypis");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wprowadz nazwisko studenta:");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);

        JTextField nazwisko=new JTextField();
        panel.add(nazwisko);

        JButton send=new JButton("Zatwierdz dane");
        send.addActionListener(e -> {
            String n=nazwisko.getText();
            wypiszS(n,k);
            rama.dispose();
        });
        panel.add(send);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void zapiszS(String n, Kursy k){
        JFrame rama=new JFrame("Zapis");
        JPanel panel=new JPanel();

        int []s=w.szukajNazwiskoS(n);
        if(s.length>0){
            JLabel []tekst1=new JLabel[s.length];
            panel.setLayout(new GridLayout(s.length+1,1,0,5));
            for (int i = 0; i < s.length; i++) {
                if(osoby.get(s[i])!=null){
                    tekst1[i]=new JLabel();
                    tekst1[i].setText(((Student) osoby.get(s[i])).zapiszNaKurs(k));
                    tekst1[i].setFont(new Font("Calibri",Font.PLAIN,24));
                    panel.add(tekst1[i]);
                }
            }
        }
        else{
            panel.setLayout(new GridLayout(2,1,0,5));
            JLabel tekst1=new JLabel();
            tekst1.setText("Student o podanym nazwisku nie istnieje");
            tekst1.setFont(new Font("Calibri",Font.PLAIN,24));
            panel.add(tekst1);
        }

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

    public void wypiszS(String n, Kursy k){
        JFrame rama=new JFrame("Wypis");
        JPanel panel=new JPanel();

        int []s=w.szukajNazwiskoS(n);
        if(s.length>0){
            JLabel []tekst1=new JLabel[s.length];
            panel.setLayout(new GridLayout(s.length+1,1,0,5));
            for (int i = 0; i < s.length; i++) {
                if(osoby.get(s[i])!=null){
                    tekst1[i]=new JLabel();
                    tekst1[i].setText(((Student) osoby.get(s[i])).wypiszZKursu(k));
                    tekst1[i].setFont(new Font("Calibri",Font.PLAIN,24));
                    panel.add(tekst1[i]);
                }
            }
        }
        else{
            panel.setLayout(new GridLayout(2,1,0,5));
            JLabel tekst1=new JLabel();
            tekst1.setText("Student o podanym nazwisku nie istnieje");
            tekst1.setFont(new Font("Calibri",Font.PLAIN,24));
            panel.add(tekst1);
        }

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

    public void zapiszW(Kursy k){
        JFrame rama=new JFrame("Zapis");
        JPanel panel=new JPanel();

        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Student)
                ile++;
        }

        if(ile>0){
            int []ind=new int[ile];
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Student){
                    ind[j]=i;
                    j++;
                }
            }
            JLabel[] tekst =new JLabel[ile];
            panel.setLayout(new GridLayout(ile+1,1,0,5));
            for (int i = 0; i < ile; i++) {
                tekst[i]=new JLabel();
                tekst[i].setText(((Student) osoby.get(ind[i])).zapiszNaKurs(k));
                tekst[i].setFont(new Font("Calibri",Font.PLAIN,24));
                panel.add(tekst[i]);
            }
        }

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

    public void wypiszW(Kursy k){
        JFrame rama=new JFrame("Wypis");
        JPanel panel=new JPanel();

        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Student)
                ile++;
        }
        if(ile>0){
            int []ind=new int[ile];
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Student){
                    ind[j]=i;
                    j++;
                }
            }
            JLabel[] tekst =new JLabel[ile];
            panel.setLayout(new GridLayout(ile+1,1,0,5));
            for (int i = 0; i < ile; i++) {
                tekst[i]=new JLabel();
                tekst[i].setText(((Student) osoby.get(ind[i])).wypiszZKursu(k));
                tekst[i].setFont(new Font("Calibri",Font.PLAIN,24));
                panel.add(tekst[i]);
            }
        }

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

    public void pensja(){
        JFrame rama=new JFrame("Pensje");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setText("Co chcesz zrobić?");
        tekst.setFont(new Font("Calibri",Font.PLAIN,24));

        JButton przycisk1=new JButton("Zwieksz pensje wybranemu pracownikowi/pracownikom");
        JButton przycisk2=new JButton("Zwieksz pensje wszystkim pracownikom");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);

        przycisk1.addActionListener(e -> {
            pensjaW();
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            zwiekszPensjeW();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void pensjaW(){
        JFrame rama=new JFrame("Informacje o pracowniku");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wprowadz nazwisko pracownika:");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);

        JTextField nazwisko=new JTextField();
        panel.add(nazwisko);

        JButton send=new JButton("Zatwierdz dane");
        send.addActionListener(e -> {
            zwiekszPensjeP(nazwisko.getText());
            rama.dispose();
        });
        panel.add(send);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void zwiekszPensjeP(String n){
        JFrame rama=new JFrame("Zwieksz pensje");
        JPanel panel=new JPanel();

        int []s=w.szukajNazwiskoP(n);
        if(s.length>0){
            JLabel []tekst1=new JLabel[s.length];
            panel.setLayout(new GridLayout(s.length+1,1,0,5));
            for (int i = 0; i < s.length; i++) {
                if(osoby.get(s[i])!=null){
                    tekst1[i]=new JLabel();
                    tekst1[i].setText(((Pracownik_Uczelni) osoby.get(s[i])).zwiekszPensje());
                    tekst1[i].setFont(new Font("Calibri",Font.PLAIN,24));
                    panel.add(tekst1[i]);
                }
            }
        }
        else{
            panel.setLayout(new GridLayout(2,1,0,5));
            JLabel tekst1=new JLabel();
            tekst1.setText("Pracownik o podanym nazwisku nie istnieje");
            tekst1.setFont(new Font("Calibri",Font.PLAIN,24));
            panel.add(tekst1);
        }

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

    public void zwiekszPensjeW(){
        JFrame rama=new JFrame("Zwieksz pensje");
        JPanel panel=new JPanel();

        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Pracownik_Uczelni)
                ile++;
        }
        if(ile>0){
            int []ind=new int[ile];
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Pracownik_Uczelni){
                    ind[j]=i;
                    j++;
                }
            }
            JLabel[] tekst =new JLabel[ile];
            panel.setLayout(new GridLayout(ile+1,1,0,5));
            for (int i = 0; i < ile; i++) {
                tekst[i]=new JLabel();
                tekst[i].setText(((Pracownik_Uczelni) osoby.get(ind[i])).zwiekszPensje());
                tekst[i].setFont(new Font("Calibri",Font.PLAIN,24));
                panel.add(tekst[i]);
            }
        }

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
