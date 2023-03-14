package Metody;

import Uczelnia.*;
import Strategia.*;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class CzasNaUczelni {
    ArrayList<Osoba> osoby;
    ArrayList<Kursy> kursy;

    public CzasNaUczelni(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy) {
        this.osoby = osoby;
        this.kursy = kursy;
    }

    public void czas(){
        JFrame rama=new JFrame("Lata na uczelni");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setText("Oblicz czas spedzony na uczelni dla wybranej osoby");
        tekst.setFont(new Font("Calibri",Font.PLAIN,24));

        panel.setLayout(new GridLayout(osoby.size()+1,1,0,5));
        panel.add(tekst);

        JButton []przyciski=new JButton[osoby.size()];
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Student)
                przyciski[i]=new JButton("Student "+osoby.get(i).getNazwisko()+" "+osoby.get(i).getImie());
            if(osoby.get(i) instanceof Pracownik_Uczelni)
                przyciski[i]=new JButton("Pracownik "+osoby.get(i).getNazwisko()+" "+osoby.get(i).getImie());
            panel.add(przyciski[i]);
            int j=i;
            przyciski[i].addActionListener(e -> {
                obliczCzas(j);
                rama.dispose();
            });
        }

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void obliczCzas(int i){
        StrategiaKlient sk=new StrategiaKlient(osoby.get(i));
        JFrame rama=new JFrame("Lata na uczelni");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setText(sk.obliczLata());
        tekst.setFont(new Font("Calibri",Font.PLAIN,24));

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
