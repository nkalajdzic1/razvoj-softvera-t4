package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {
    public String sifra;
    public String naziv;
    public double cijena;

    public Artikal(String sifra, String naziv, double cijena){
        try {
            setCijena(cijena);
            setNaziv(naziv);
            setSifra(sifra);
        } catch(Exception e){
            throw new IllegalArgumentException(e);
        }
    }
    public Artikal(String string) {
        String[] niz=string.split(",");
        setSifra(niz[0]);
        setNaziv(niz[1]);
        setCijena(Double.parseDouble(niz[2]));
    }

    public Artikal() {

    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if(sifra.isEmpty()) throw new IllegalArgumentException("Šifra je prazna");
        this.sifra=sifra;
    }

    public String getNaziv() {
        return  naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.isEmpty()) throw new IllegalArgumentException("Naziv je prazan");
        this.naziv=naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena <= 0) throw new IllegalArgumentException("Cijena je negativna");
        this.cijena=cijena;
    }
    @Override
    public String toString(){
        return sifra + "," + naziv + "," + cijena;
    }

    @Override
    public boolean equals(Object o) {
        Artikal a= (Artikal)o;
        if( (this.cijena>0 && a.cijena<0) || (this.cijena<0 && a.cijena>0) ) return false;
        return this.sifra.equals(a.sifra) && this.naziv.equals(a.naziv) && Math.abs(this.cijena-a.cijena) <= 1e-10*(Math.abs(this.cijena) + Math.abs(a.cijena));
    }

    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> lista) {
        for(int i=0; i<lista.size(); i++){
            for(int j=i+1; j<lista.size(); j++){
                if(lista.get(i).equals(lista.get(j))){
                    lista.remove(j);
                    j--;
                }
            }
        }
        return lista;
    }
}