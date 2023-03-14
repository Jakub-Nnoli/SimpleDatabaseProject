package Metody;

import Uczelnia.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Pliki{
    ArrayList <Osoba> osoby;
    ArrayList <Kursy> kursy;

    public Pliki(ArrayList<Osoba> osoby, ArrayList<Kursy> kursy) {
        this.osoby = osoby;
        this.kursy = kursy;
    }

    public void wczytajDane(){
        JFrame rama=new JFrame("Wczytaj");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wpisz odpowiednia nazwe pliku (pamietaj ze plik musi miec rozszerzenie .ser i aby nie wpisywać jego rozszerzenia):");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);

        JTextField dane=new JTextField();
        panel.add(dane);

        JButton send=new JButton("Zatwierdz");
        send.addActionListener(e -> {
            String d=dane.getText()+".ser";
            wczytaj(d);
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

    public void wczytaj(String sin){
        try(ObjectInputStream fin=new ObjectInputStream(new FileInputStream(sin))){
            Object o;
            while((o=fin.readObject())!=null){
                if(o instanceof Osoba){
                    Osoba os=(Osoba)o;
                    osoby.add(os);
                }
                if(o instanceof Kursy){
                    Kursy k=(Kursy)o;
                    kursy.add(k);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void zapiszDane(){
        JFrame rama=new JFrame("Zapisz");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setFont(new Font("Calibri",Font.PLAIN,24));
        tekst.setText("Wpisz odpowiednia nazwe pliku (bez jego rozszerzenia):");

        panel.setLayout(new GridLayout(3,1,0,5));
        panel.add(tekst);

        JTextField dane=new JTextField();
        panel.add(dane);

        JButton send=new JButton("Zatwierdz");
        send.addActionListener(e -> {
            String d=dane.getText()+".ser";
            zapis(d);
            rama.dispose();
        });
        panel.add(send);

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void zapis(String sout){
        JFrame rama=new JFrame("Zapisz");
        JPanel panel=new JPanel();
        JLabel tekst=new JLabel();

        tekst.setText("Jakie dane chcesz zapisac?");
        tekst.setFont(new Font("Calibri",Font.PLAIN,24));

        JButton przycisk1=new JButton("Kursy");
        JButton przycisk2=new JButton("Studenci");
        JButton przycisk3=new JButton("Pracownicy");
        JButton przycisk4=new JButton("Wszystkie osoby");
        JButton przycisk5=new JButton("Wszystko");

        panel.setLayout(new GridLayout(6,1,0,5));
        panel.add(tekst);
        panel.add(przycisk1);
        panel.add(przycisk2);
        panel.add(przycisk3);
        panel.add(przycisk4);
        panel.add(przycisk5);

        przycisk1.addActionListener(e -> {
            zapiszKursy(sout);
            Menu m=new Menu(osoby,kursy);
            m.menu();
            rama.dispose();
        });
        przycisk2.addActionListener(e -> {
            zapiszStudentow(sout);
            Menu m=new Menu(osoby,kursy);
            m.menu();
            rama.dispose();
        });
        przycisk3.addActionListener(e -> {
            zapiszPracownikow(sout);
            Menu m=new Menu(osoby,kursy);
            m.menu();
            rama.dispose();
        });
        przycisk4.addActionListener(e -> {
            zapiszOsoby(sout);
            Menu m=new Menu(osoby,kursy);
            m.menu();
            rama.dispose();
        });
        przycisk5.addActionListener(e -> {
            zapiszWszystko(sout);
            Menu m=new Menu(osoby,kursy);
            m.menu();
            rama.dispose();
        });

        rama.add(panel);
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.pack();
        rama.setVisible(true);
    }

    public void zapiszKursy(String sout){
        try(ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream(sout))){
            for (int i = 0; i < kursy.size(); i++) {
                fout.writeObject(kursy.get(i));
            }
            fout.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void zapiszStudentow(String sout){
        try(ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream(sout))){
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Student){
                    fout.writeObject(osoby.get(i));
                }
            }
            fout.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void zapiszPracownikow(String sout){
        try(ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream(sout))){
            for (int i = 0; i < osoby.size(); i++) {
                if(osoby.get(i) instanceof Pracownik_Uczelni){
                    fout.writeObject(osoby.get(i));
                }
            }
            fout.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void zapiszOsoby(String sout){
        try(ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream(sout))){
            for (int i = 0; i < osoby.size(); i++) {
                fout.writeObject(osoby.get(i));
            }
            fout.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void zapiszWszystko(String sout){
        try(ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream(sout))){
            for (int i = 0; i < osoby.size(); i++) {
                fout.writeObject(osoby.get(i));
            }
            for (int i = 0; i < kursy.size(); i++) {
                fout.writeObject(kursy.get(i));
            }
            fout.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
