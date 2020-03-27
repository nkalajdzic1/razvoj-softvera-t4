package sample;


import ba.unsa.etf.rs.tut4.Artikal;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static ba.unsa.etf.rs.tut4.Artikal.izbaciDuplikate;
import static java.lang.Double.parseDouble;

public class zadatak2 {

  public TextArea pokupiTekst;
  public Button dugme;
  public TextField prikaziTekst;

    public void pokupi() {
        prikaziTekst.clear();
        ArrayList<Artikal> lista= new ArrayList<>();
        String sav_tekst=pokupiTekst.getText();
        String[] s=sav_tekst.split("\n");
        if(s.length==0) {
            prikaziTekst.appendText("Pogresan unos artikala!");
            return;
        }
        for (String value : s) {
            Artikal a = new Artikal(value);
            lista.add(a);
        }
        Artikal.izbaciDuplikate(lista);

        for (Artikal artikal : lista)
            prikaziTekst.appendText(artikal + "\n");

         // zbog nekog razloga ne prebacuje u novi red:(
    }
}
