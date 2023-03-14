package Metody;

import Uczelnia.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Wyswietlanie {
    ArrayList<Osoba> osoby;
    ArrayList<Kursy> kursy;

    public Wyswietlanie(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy) {
        this.osoby = osoby;
        this.kursy = kursy;
    }

    public void wyswietl(){
        JFrame rama=new JFrame("Wyswietlanie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Co chcesz wyswietlic?");

        JButton przycisk1=new JButton("Liste wszystkich studentow");
        JButton przycisk2=new JButton("Liste wszystkich pracownikow");
        JButton przycisk3=new JButton("Liste wszystkich kursow");

        panel.setLayout(new GridLayout(4,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);
        panel.add(przycisk3);

        przycisk1.addActionListener(e -> {
            wyswietlStudentow();
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            wyswietlPracownikow();
            rama.dispose();
        });
        przycisk3.addActionListener(e -> {
            wyswietlKursy();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void wyswietlStudentow(){
        JFrame rama=new JFrame("Wyswietlanie studentow");
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
                tekst[i].setText(osoby.get(ind[i]).toString()+"\n");
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

    public void wyswietlPracownikow(){
        JFrame rama=new JFrame("Wyswietlanie pracownikow");
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
                tekst[i].setText(osoby.get(ind[i]).toString()+"\n");
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

    public void wyswietlKursy(){
        JFrame rama=new JFrame("Wyswietlanie studentow");
        JPanel panel=new JPanel();
        JLabel[] tekst =new JLabel[kursy.size()];

        panel.setLayout(new GridLayout(kursy.size()+1,1,0,5));

        for (int i = 0; i < kursy.size(); i++) {
            tekst[i]=new JLabel();
            tekst[i].setText(kursy.get(i).toString()+"\n");
            tekst[i].setFont(new Font("Calibri",Font.PLAIN,24));
            panel.add(tekst[i]);
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
