package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

// da znam, za izradu tutorijala 3 uopce nisam koristio ovu klasu jer sam isto zelio pokusati uraditi zadatak bez korištenja ove klase
public class Racun {
    private ArrayList<Artikal> racun = new ArrayList<>();
    public void dodajStavku(Artikal artikal, int kolicina) {
            artikal.setSifra(artikal.getSifra());
            artikal.setNaziv(artikal.getNaziv());
            artikal.setCijena(artikal.getCijena());
            if(kolicina < 0) throw new IllegalArgumentException("Količina ne može biti negativna!");
            if(kolicina == 0) throw new IllegalArgumentException("Količina ne može biti jednaka nuli!");  // ljepše je ovako jer je specificiran izuzetak
            for(int i=0;i<kolicina;i++) this.racun.add(artikal);
    }
    public double ukupanIznos() {
        double suma=0;
        for (Artikal artikal : this.racun) suma += artikal.getCijena();
        return suma;
    }
}
