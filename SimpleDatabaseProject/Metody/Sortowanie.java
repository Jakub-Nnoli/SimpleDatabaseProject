package Metody;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import Uczelnia.*;

import javax.swing.*;

public class Sortowanie {
    ArrayList<Osoba> osoby;
    ArrayList<Kursy> kursy;

    public Sortowanie(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy) {
        this.osoby = osoby;
        this.kursy = kursy;
    }

    public void sortuj() {
        JFrame rama=new JFrame("Sortowanie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Co chcesz posortowac?");

        JButton przycisk1=new JButton("Liste osob");
        JButton przycisk2=new JButton("Liste kursow");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);

        przycisk1.addActionListener(e -> {
            sortujOsoby();
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            sortujKursy();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void sortujOsoby(){
        JFrame rama=new JFrame("Sortowanie osob");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wedlug czego chcesz posortowac liste osob?");

        JButton przycisk1=new JButton("Nazwiska");
        JButton przycisk2=new JButton("Nazwiska i imienia (dla tych samych nazwisk sortowanie wedlug imion alfabetycznie)");
        JButton przycisk3=new JButton("Naziwska i wieku (dla tych samych nazwisk sortowanie wedlug wieku malejaco)");

        panel.setLayout(new GridLayout(4,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);
        panel.add(przycisk3);

        przycisk1.addActionListener(e -> {
            sortujOsobyN();
            info();
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            sortujOsobyNI();
            info();
            rama.dispose();
        });
        przycisk3.addActionListener(e -> {
            sortujOsobyNW();
            info();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void sortujKursy(){
        JFrame rama=new JFrame("Sortowanie kursow");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wedlug czego chcesz posortowac liste kursow?");

        JButton przycisk1=new JButton("Punktow ECTS");
        JButton przycisk2=new JButton("Nazwiska prowadzacego");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);

        przycisk1.addActionListener(e -> {
            sortujKursyE();
            info();
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            sortujKursyN();
            info();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void sortujOsobyN(){
        for (int i = 0; i < osoby.size()-1; i++) {
            for (int j = 0; j < osoby.size()-i-1; j++) {
                if (compareToON(osoby.get(j),osoby.get(j+1))>0){
                    Collections.swap(osoby,j,j+1);
                }
            }
        }
    }

    public void sortujOsobyNI(){
        for (int i = 0; i < osoby.size()-1; i++) {
            for (int j = 0; j < osoby.size()-i-1; j++) {
                if(compareToONI(osoby.get(j),osoby.get(j+1))>0)
                    Collections.swap(osoby,j,j+1);
            }
        }
    }

    public void sortujOsobyNW(){
        for (int i = 0; i < osoby.size()-1; i++) {
            for (int j = 0; j < osoby.size()-i-1; j++) {
                if(compareToONW(osoby.get(j),osoby.get(j+1))>0)
                    Collections.swap(osoby,j,j+1);
            }
        }
    }

    public void sortujKursyE(){
        for (int i = 0; i < kursy.size()-1; i++) {
            for (int j = 0; j < kursy.size()-i-1; j++) {
                if(compareToKE(kursy.get(j),kursy.get(j+1))>0)
                    Collections.swap(kursy,j,j+1);
            }
        }
    }

    public void sortujKursyN(){
        for (int i = 0; i < kursy.size()-1; i++) {
            for (int j = 0; j < kursy.size()-i-1; j++) {
                if(compareToKN(kursy.get(j),kursy.get(j+1))>0)
                    Collections.swap(kursy,j,j+1);
            }
        }
    }

    public int compareToON(Osoba o1, Osoba o2){
        return o1.getNazwisko().compareTo(o2.getNazwisko());
    }

    public int compareToONI(Osoba o1, Osoba o2){
        int w=o1.getNazwisko().compareTo(o2.getNazwisko());
        if(w==0)
            w=o1.getImie().compareTo(o2.getImie());
        return w;
    }

    public int compareToONW(Osoba o1, Osoba o2){
        int w=o1.getNazwisko().compareTo(o2.getNazwisko());
        if(w==0)
            w=(o1.getWiek()-o2.getWiek())*(-1);
        return w;
    }

    public int compareToKE(Kursy k1, Kursy k2){
        return k1.getECTS()-k2.getECTS();
    }

    public int compareToKN(Kursy k1, Kursy k2){
        return k1.getNazwisko().compareTo(k2.getNazwisko());
    }

    public void info(){
        JFrame rama=new JFrame("Sortowanie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Lista zostala posortowana");

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