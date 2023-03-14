package Metody;

import Uczelnia.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Wyszukiwanie {
    ArrayList<Osoba> osoby;
    ArrayList<Kursy> kursy;

    public Wyszukiwanie(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy) {
        this.osoby = osoby;
        this.kursy = kursy;
    }

    public void szukajElement(){
        JFrame rama=new JFrame("Wyszukiwanie");
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
        JFrame rama=new JFrame("Wyszukiwanie");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Co chcesz wyszukac?");

        JButton przycisk1=new JButton("Wyszukaj osobe");
        JButton przycisk2=new JButton("Wyszukaj kurs");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);

        przycisk1.addActionListener(e -> {
            szukajOsobe(n);
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            szukajKurs(n);
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void szukajOsobe(String n){
        JFrame rama=new JFrame("Wyszukiwanie osob");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Jakiego typu osobe chcesz wyszukac?");

        JButton przycisk1=new JButton("Student");
        JButton przycisk2=new JButton("Pracownik");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);

        przycisk1.addActionListener(e -> {
            szukajStudenta(n);
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            szukajPracownika(n);
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void szukajStudenta(String n){
        JFrame rama=new JFrame("Wyszukiwanie studentow");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wedlug czego chcesz wyszukac studenta?");

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
            wyswietlOsoby(szukajNazwiskoS(n));
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            wyswietlOsoby(szukajImieS(n));
            rama.dispose();
        });
        przycisk3.addActionListener(e -> {
            wyswietlOsoby(szukajIndeks(Integer.parseInt(n)));
            rama.dispose();
        });
        przycisk4.addActionListener(e -> {
            wyswietlOsoby(szukajRokStudiow(Integer.parseInt(n)));
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void szukajPracownika(String n){
        JFrame rama=new JFrame("Wyszukiwanie pracownikow");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wedlug czego chcesz wyszukac pracownika?");

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
            wyswietlOsoby(szukajNazwiskoP(n));
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            wyswietlOsoby(szukajImieP(n));
            rama.dispose();
        });
        przycisk3.addActionListener(e -> {
            wyswietlOsoby(szukajStaz(Double.parseDouble(n)));
            rama.dispose();
        });
        przycisk4.addActionListener(e -> {
            wyswietlOsoby(szukajStanowisko(n));
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public int[] szukajNazwiskoS(String n){
        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Student){
                if(osoby.get(i).getNazwisko().equals(n))
                    ile++;
            }
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Student){
                    if(osoby.get(i).getNazwisko().equals(n)){
                        indeksy[j]=i;
                        j++;
                    }
                }
            }
        }
        return indeksy;
    }

    public int[] szukajNazwiskoP(String n){
        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Pracownik_Uczelni){
                if(osoby.get(i).getNazwisko().equals(n))
                    ile++;
            }
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Pracownik_Uczelni){
                    if(osoby.get(i).getNazwisko().equals(n)){
                        indeksy[j]=i;
                        j++;
                    }
                }
            }
        }
        return indeksy;
    }

    public int[] szukajImieS(String n){
        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Student){
                if(osoby.get(i).getImie().equals(n))
                    ile++;
            }
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Student){
                    if(osoby.get(i).getImie().equals(n)){
                        indeksy[j]=i;
                        j++;
                    }
                }
            }
        }
        return indeksy;
    }

    public int[] szukajImieP(String n){
        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Pracownik_Uczelni){
                if(osoby.get(i).getImie().equals(n))
                    ile++;
            }
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Pracownik_Uczelni){
                    if(osoby.get(i).getImie().equals(n)){
                        indeksy[j]=i;
                        j++;
                    }
                }
            }
        }
        return indeksy;
    }

    public int[] szukajStanowisko(String n){
        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Pracownik_Uczelni){
                if(((Pracownik_Uczelni)osoby.get(i)).getStanowisko().equals(n))
                    ile++;
            }
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Pracownik_Uczelni){
                    if(((Pracownik_Uczelni)osoby.get(i)).getStanowisko().equals(n)){
                        indeksy[j]=i;
                        j++;
                    }
                }
            }
        }
        return indeksy;
    }

    public int[] szukajIndeks(int n){
        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Student){
                if(((Student)osoby.get(i)).getIndeks()==n)
                    ile++;
            }
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Student){
                    if(((Student)osoby.get(i)).getIndeks()==n){
                        indeksy[j]=i;
                        j++;
                    }
                }
            }
        }
        return indeksy;
    }

    public int[] szukajStaz(double n){
        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Pracownik_Uczelni){
                if(((Pracownik_Uczelni)osoby.get(i)).getStaz()==n)
                    ile++;
            }
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Pracownik_Uczelni){
                    if(((Pracownik_Uczelni)osoby.get(i)).getStaz()==n){
                        indeksy[j]=i;
                        j++;
                    }
                }
            }
        }
        return indeksy;
    }

    public int[] szukajRokStudiow(int n){
        int ile=0;
        for (int i = 0; i < osoby.size(); i++) {
            if(osoby.get(i) instanceof Student){
                if(((Student)osoby.get(i)).getRokStudiow()==n)
                    ile++;
            }
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Student){
                    if(((Student)osoby.get(i)).getRokStudiow()==n){
                        indeksy[j]=i;
                        j++;
                    }
                }
            }
        }
        return indeksy;
    }

    public void szukajKurs(String n){
        JFrame rama=new JFrame("Wyszukiwanie kursow");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wedlug czego chcesz wyszukac kurs?");

        JButton przycisk1=new JButton("Nazwa kursu");
        JButton przycisk2=new JButton("Nazwisko prowadzacego");
        JButton przycisk3=new JButton("Punkty ECTS");

        panel.setLayout(new GridLayout(4,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);
        panel.add(przycisk3);

        przycisk1.addActionListener(e -> {
            wyswietlKursy(szukajKursN(n));
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            wyswietlKursy(szukajKursP(n));
            rama.dispose();
        });
        przycisk3.addActionListener(e -> {
            wyswietlKursy(szukajKursE(Integer.parseInt(n)));
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public int[] szukajKursN(String n){
        int ile=0;
        for (int i = 0; i < kursy.size(); i++) {
            if(kursy.get(i).getNazwa().equals(n))
                ile++;
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < kursy.size(); i++) {
                if (kursy.get(i).getNazwa().equals(n)){
                    indeksy[j]=i;
                    j++;
                }
            }
        }
        return indeksy;
    }

    public int[] szukajKursP(String n){
        int ile=0;
        for (int i = 0; i < kursy.size(); i++) {
            if(kursy.get(i).getNazwisko().equals(n))
                ile++;
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < kursy.size(); i++) {
                String nazw=kursy.get(i).getProwadzacy().trim();
                nazw=nazw.substring(nazw.indexOf(" ")+1);
                if(n.equals(nazw)){
                    indeksy[j]=i;
                    j++;
                }
            }
        }
        return indeksy;
    }

    public int[] szukajKursE(int p){
        int ile=0;
        for (int i = 0; i < kursy.size(); i++) {
            if(kursy.get(i).getECTS()==p)
                ile++;
        }
        int []indeksy=new int[ile];
        if(ile>0){
            int j=0;
            for (int i = 0; i < kursy.size(); i++) {
                if (kursy.get(i).getECTS()==p){
                    indeksy[j]=i;
                    j++;
                }
            }
        }
        return indeksy;
    }

    public void wyswietlOsoby(int[] n){
        JFrame rama=new JFrame("Wyswietlanie osob");
        JPanel panel=new JPanel();

        JLabel[] tekst =new JLabel[n.length];
        if(n.length>0){
            panel.setLayout(new GridLayout(n.length+1,1,0,5));
            for (int i = 0; i < n.length; i++) {
                tekst[i]=new JLabel();
                tekst[i].setText(osoby.get(n[i]).toString()+"\n");
                tekst[i].setFont(new Font("Calibri",Font.PLAIN,24));
                panel.add(tekst[i]);
            }
        }
        else{
            panel.setLayout(new GridLayout(2,1,0,5));
            JLabel tekst1=new JLabel();
            tekst1.setText("Osoba o podanych danych nie istnieje");
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

    public void wyswietlKursy(int[] n){
        JFrame rama=new JFrame("Wyswietlanie kursow");
        JPanel panel=new JPanel();

        JLabel[] tekst =new JLabel[n.length];
        if(n.length>0){
            panel.setLayout(new GridLayout(n.length+1,1,0,5));
            for (int i = 0; i < n.length; i++) {
                tekst[i]=new JLabel();
                tekst[i].setText(kursy.get(n[i]).toString()+"\n");
                tekst[i].setFont(new Font("Calibri",Font.PLAIN,24));
                panel.add(tekst[i]);
            }
        }
        else{
            panel.setLayout(new GridLayout(2,1,0,5));
            JLabel tekst1=new JLabel();
            tekst1.setText("Kurs o podanych danych nie istnieje");
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
}
