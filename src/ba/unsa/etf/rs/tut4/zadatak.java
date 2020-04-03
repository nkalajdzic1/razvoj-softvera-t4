package ba.unsa.etf.rs.tut4;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static ba.unsa.etf.rs.tut4.Artikal.izbaciDuplikate;

public class zadatak {

    public TextArea pokupiTekst;
    public Button dugme;
    public TextArea prikaziTekst;
    public ChoiceBox<String> sviArtikli;
    public Spinner<Integer> kolicina;
    public TextArea konacniRacun;
    public Button dugmeDodaj;
    public Tab tab1, tab2;

    ArrayList<Artikal> filter = new ArrayList<>();

    private boolean provjeri(String s) {
        char[] niz = s.toCharArray();
        for( char znak: niz) if( !(znak>='0' && znak<='9') ) return false;
        return  true;
    }

    public void pokupi() {
        prikaziTekst.clear();
        ArrayList<Artikal> lista = new ArrayList<>();
        String sav_tekst=pokupiTekst.getText();
        String[] s=sav_tekst.split("\n");
        //provjera
        for( String po_artiklu: s) {
            String[] artikli_uneseni=po_artiklu.split(",");
            if(artikli_uneseni.length!=3 || artikli_uneseni[0].isEmpty() || artikli_uneseni[1].isEmpty() || !provjeri(artikli_uneseni[2])){
                Alert a = new Alert(Alert.AlertType.ERROR,"Pogrešan unos!");
               // pokupiTekst.clear();  <- opcionalno je, mozda je bolje ostaviti tekst pa da korisnik ispravi onda
                a.show();
                Button okButton = (Button) a.getDialogPane().lookupButton(ButtonType.OK);
                okButton.setId("myID"); // treba nam radi testova de se ukine alert
                return;
            }
        }

        if(s.length==0) {
            Alert a = new Alert(Alert.AlertType.ERROR,"Pogrešan unos!");
            a.show();
            Button okButton = (Button) a.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setId("myID"); // treba nam radi testova da se ukine alert
            return;
        }
        for (String value : s) {
            lista.add(new Artikal(value));
        }
        filter = izbaciDuplikate(lista);
        ObservableList<String> sifre = FXCollections.observableArrayList();
        int i;
        for(i=0; i<filter.size(); i++){
           if( i!=filter.size()-1 ) prikaziTekst.appendText(filter.get(i) + "\n");
            sifre.add(filter.get(i).getSifra());
            if(i==filter.size()-1) break;
        }
        prikaziTekst.appendText(filter.get(i) + "");
        sviArtikli.setItems(sifre);
    }

    String svi_artikli = "";

    public void dodajNaRacun() {
        konacniRacun.setText("");
        if(filter.size() == 0) {
            Alert a = new Alert(Alert.AlertType.ERROR,"Pogrešan unos!");
            a.show();
            Button okButton = (Button) a.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setId("myID"); // treba nam radi testova de se ukine alert
            return;
        }
        Artikal trenutni =  new Artikal();
        for(Artikal a: filter) if(a.getSifra().equals(sviArtikli.getValue())) trenutni = a;
        DecimalFormat dvije_decimale = new DecimalFormat("#,###,###,##0.00");
        double cijena = trenutni.getCijena()*kolicina.getValue();
        svi_artikli=svi_artikli.concat(sviArtikli.getValue() + "    " + kolicina.getValue() + "   "
                + dvije_decimale.format(cijena) + "\n");
        String[] cijene= svi_artikli.split("\\s+");
        double suma = 0;
        for(int i=2; i<cijene.length; i=i+3) suma+=Double.parseDouble(cijene[i]);
        konacniRacun.appendText(svi_artikli + "UKUPNO:      " + dvije_decimale.format(suma) + "\n");
    }
}
