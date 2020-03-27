package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Racun {
    private ArrayList<Artikal> racun = new ArrayList<>();
    private Artikal artikal;
    private  int kolicina;
    public void dodajStavku(Artikal artikal, int kolicina) {
            for(int i=0;i<kolicina;i++) this.racun.add(artikal);
    }
    public double ukupanIznos() {
        double suma=0;
        for(int i=0; i<this.racun.size();i++) suma+=this.racun.get(i).cijena;
        return suma;
    }
}
