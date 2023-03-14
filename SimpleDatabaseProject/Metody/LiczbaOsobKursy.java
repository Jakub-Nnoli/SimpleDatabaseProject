package Metody;

import Obserwator.ObecneDane;
import Obserwator.OsobyNaKursach;
import Uczelnia.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LiczbaOsobKursy {
    ArrayList<Osoba> osoby;
    ArrayList<Kursy> kursy;

    public LiczbaOsobKursy(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy) {
        this.osoby = osoby;
        this.kursy = kursy;
    }

    public void ileOsobNaKurs(){
        OsobyNaKursach onk=new OsobyNaKursach(kursy);
        ObecneDane od=new ObecneDane(osoby,onk);

        JFrame rama=new JFrame("Liczba osob na kursach");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setText("Liczba zapisanych osob na podane kursy");
        tekst.setFont(new Font("Calibri",Font.PLAIN,24));

        panel.setLayout(new GridLayout(kursy.size()+2,1,0,5));
        panel.add(tekst);

        JLabel []teksty=new JLabel[kursy.size()];
        for (int i = 0; i < kursy.size(); i++) {
            teksty[i]=new JLabel(od.aktualizacja(kursy.get(i)));
            panel.add(teksty[i]);
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
