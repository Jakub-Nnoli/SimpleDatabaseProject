package Metody;

import Uczelnia.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Usuwanie {
    ArrayList<Osoba> osoby;
    ArrayList<Kursy> kursy;

    public Usuwanie(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy) {
        this.kursy = kursy;
        this.osoby = osoby;
    }

    public void usunElement(){
        JFrame rama=new JFrame("Usuwanie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wpisz odpowiednia zmienna:");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);

        JTextField dane=new JTextField();
        panel.add(dane);

        JButton send=new JButton("Zatwierdz");
        send.addActionListener(e -> {
            String d=dane.getText();
            element(d);
            rama.dispose();
        });
        panel.add(send);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void element(String n){
        JFrame rama=new JFrame("Usuwanie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Co chcesz usunac?");

        JButton przycisk1=new JButton("Usun osobe");
        JButton przycisk2=new JButton("Usun kurs");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);

        przycisk1.addActionListener(e -> {
            usunOsobe(n);
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            usunKurs(n);
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void usunOsobe(String n){
        JFrame rama=new JFrame("Usuwanie osob");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Jakiego typu osobe chcesz usunac?");

        JButton przycisk1=new JButton("Student");
        JButton przycisk2=new JButton("Pracownik");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);

        przycisk1.addActionListener(e -> {
            usunStudent(n);
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            usunPracownik(n);
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void usunStudent(String n){
        JFrame rama=new JFrame("Usuawnie studentow");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wedlug czego chcesz usunac studenta?");

        JButton przycisk1=new JButton("Nazwisko");
        JButton przycisk2=new JButton("Imie");
        JButton przycisk3=new JButton("Numer indeksu");
        JButton przycisk4=new JButton("Rok studiow");

        panel.setLayout(new GridLayout(5,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);
        panel.add(przycisk3);
        panel.add(przycisk4);

        przycisk1.addActionListener(e -> {
            usunNazwiskoS(n);
            info();
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            usunImieS(n);
            info();
            rama.dispose();
        });
        przycisk3.addActionListener(e -> {
            usunIndeks(Integer.parseInt(n));
            info();
            rama.dispose();
        });
        przycisk4.addActionListener(e -> {
            usunRokStudiow(Integer.parseInt(n));
            info();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void usunPracownik(String n){
        JFrame rama=new JFrame("Usuwanie pracownikow");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wedlug czego chcesz usunac pracownika?");

        JButton przycisk1=new JButton("Nazwisko");
        JButton przycisk2=new JButton("Imie");
        JButton przycisk3=new JButton("Staz pracy");
        JButton przycisk4=new JButton("Stanowisko");

        panel.setLayout(new GridLayout(5,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);
        panel.add(przycisk3);
        panel.add(przycisk4);

        przycisk1.addActionListener(e -> {
            usunNazwiskoP(n);
            info();
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            usunImieP(n);
            info();
            rama.dispose();
        });
        przycisk3.addActionListener(e -> {
            usunStaz(Double.parseDouble(n));
            info();
            rama.dispose();
        });
        przycisk4.addActionListener(e -> {
            usunStanowisko(n);
            info();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void usunNazwiskoS(String n){
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Student){
                if(osoby.get(i).getNazwisko().equals(n)){
                    osoby.remove(i);
                    i--;
                }
            }
        }
    }

    public void usunNazwiskoP(String n){
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Pracownik_Uczelni){
                if(osoby.get(i).getNazwisko().equals(n)){
                    osoby.remove(i);
                    i--;
                }
            }
        }
    }

    public void usunImieS(String n){
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Student){
                if(osoby.get(i).getImie().equals(n)){
                    osoby.remove(i);
                    i--;
                }
            }
        }
    }

    public void usunImieP(String n){
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Pracownik_Uczelni){
                if(osoby.get(i).getImie().equals(n)){
                    osoby.remove(i);
                    i--;
                }
            }
        }
    }

    public void usunIndeks(int n){
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Student){
                if(((Student)osoby.get(i)).getIndeks()==n){
                    osoby.remove(i);
                    i--;
                }
            }
        }
    }

    public void usunRokStudiow(int n){
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Student){
                if(((Student)osoby.get(i)).getRokStudiow()==n){
                    osoby.remove(i);
                    i--;
                }
            }
        }
    }

    public void usunStaz(double n){
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Pracownik_Uczelni){
                if(((Pracownik_Uczelni)osoby.get(i)).getStaz()==n){
                    osoby.remove(i);
                    i--;
                }
            }
        }
    }

    public void usunStanowisko(String n){
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Pracownik_Uczelni){
                if(((Pracownik_Uczelni)osoby.get(i)).getStanowisko().equals(n)){
                    osoby.remove(i);
                    i--;
                }
            }
        }
    }

    public void usunKurs(String n){
        JFrame rama=new JFrame("Usuwanie kursow");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wedlug czego chcesz usunac kurs?");

        JButton przycisk1=new JButton("Nazwa kursu");
        JButton przycisk2=new JButton("Nazwisko prowadzacego");
        JButton przycisk3=new JButton("Punkty ECTS");

        panel.setLayout(new GridLayout(4,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);
        panel.add(przycisk3);

        przycisk1.addActionListener(e -> {
            usunKursN(n);
            info();
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            usunKursP(n);
            info();
            rama.dispose();
        });
        przycisk3.addActionListener(e -> {
            usunKursE(Integer.parseInt(n));
            info();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void usunKursN(String n){
        for (int i = 0; i < kursy.size(); i++) {
            if(kursy.get(i).getNazwa().equals(n)){
                kursy.remove(i);
                i--;
            }
        }
    }

    public void usunKursP(String n){
        for (int i = 0; i < kursy.size(); i++) {
            if(kursy.get(i).getNazwisko().equals(n)){
                kursy.remove(i);
                i--;
            }
        }
    }

    public void usunKursE(int e){
        for (int i = 0; i < kursy.size(); i++) {
            if(kursy.get(i).getECTS()==e){
                kursy.remove(i);
                i--;
            }
        }
    }

    public void info(){
        JFrame rama=new JFrame("Usuwanie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Element zostal usuniety");

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
