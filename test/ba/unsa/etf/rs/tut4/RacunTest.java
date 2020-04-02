package ba.unsa.etf.rs.tut4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacunTest {

    @Test
    void test1() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        r.dodajStavku(new Artikal("JAJ", "Jaje", 0.25), 5);
        assertEquals(3.45, r.ukupanIznos());
    }

    @Test
    void testPrazno() {
        Racun r = new Racun();
        assertEquals(0, r.ukupanIznos());  // zar ne bi u ovom slučaju se trebao baciti izuzetak jer je račun prazan?
    }
    //------------------------------------------------- moji testovi su ispod
    @Test
    void neispravanArtikal1() {
        Racun r = new Racun();
        assertThrows(IllegalArgumentException.class, () -> {
            r.dodajStavku(new Artikal("","naziv",100), 1);
        }, "Šifra je prazna!");
    }

    @Test
    void neispravanArtikal2() {
        Racun r = new Racun();
        assertThrows(IllegalArgumentException.class, () -> {
            r.dodajStavku(new Artikal("Šifra","",100), 1);
        }, "Naziv je prazan!");
    }

    @Test
    void neispravanArtikal3() {
        Racun r = new Racun();
        assertThrows(IllegalArgumentException.class, () -> {
            r.dodajStavku(new Artikal("Šifra","Naziv",-1.5), 1);
        }, "Cijena je negativna!");
    }

    @Test
    void neispravnaKolicina1 () {
        Racun r = new Racun();
        assertThrows(IllegalArgumentException.class, () -> {
           r.dodajStavku(new Artikal("Šifra", "Naziv", 1.5), -1);
        }, "Količina ne može biti negativna!");
    }

    @Test
    void neispravnaKolicina2 () {
        Racun r = new Racun();
        assertThrows(IllegalArgumentException.class, () -> {
            r.dodajStavku( new Artikal("Šifra", "Naziv", 1), 0);
        }, "Količina ne može biti jednaka nuli!");
    }

}