package Metody;

import Uczelnia.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Powtorki {
    ArrayList<Osoba> osoby;
    ArrayList<Kursy> kursy;

    public Powtorki(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy) {
        this.osoby = osoby;
        this.kursy = kursy;
    }

    public void usunPowtorki(){
        HashSet<Osoba> osoby1=new HashSet<>();
        for (Osoba o:osoby) {
            boolean t=false;
            for(Osoba o1:osoby1){
                if(o1 instanceof Pracownik_Uczelni && o instanceof Pracownik_Uczelni){
                    if(o1.getPESEL().equals(o.getPESEL()))
                        t=true;
                }
                if(o1 instanceof Student && o instanceof Student){
                    if(((Student)o1).getIndeks()==((Student)o).getIndeks())
                        t=true;
                }
            }
            if(!t)
                osoby1.add(o);
        }
        ArrayList<Osoba> osobyP=new ArrayList<>(osoby1);

        JFrame rama=new JFrame("Powtorki");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setText("Powtorki zostaly usuniete");
        tekst.setFont(new Font("Calibri",Font.PLAIN,24));

        panel.setLayout(new GridLayout(2,1,0,5));
        panel.add(tekst);

        JButton send=new JButton("Zakoncz");
        send.addActionListener(e -> {
            Menu m=new Menu(osobyP,kursy);
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
