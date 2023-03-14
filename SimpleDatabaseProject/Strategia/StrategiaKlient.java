package Strategia;

public class StrategiaKlient {
    LataNaUczelni l;

    public StrategiaKlient(LataNaUczelni l) {
        this.l = l;
    }

    public String  obliczLata(){
        return l.lata();
    }
}
