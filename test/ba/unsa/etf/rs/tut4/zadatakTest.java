package ba.unsa.etf.rs.tut4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
class zadatakTest {

    @Start
    public void start (Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/zadatak.fxml"));
        stage.setTitle("Tutorijal 4");
        stage.setScene(new Scene(root, 400, 500));
        stage.show();
        stage.toFront();
    }

    @Test
    void upisJednogArtikla(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("h1,Hljeb,1");
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("h1,Hljeb,1.0", prikaz.getText());
    }

    @Test
    void upisDvaArtikla(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("h1,Hljeb,1\nh2,Kola,3");
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("h1,Hljeb,1.0\nh2,Kola,3.0", prikaz.getText());
    }

    @Test
    void upisIstihArtikala(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("h1,Hljeb,1\nh2,Kola,3\nh1,Hljeb,1\nh2,Kola,3");
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("h1,Hljeb,1.0\nh2,Kola,3.0", prikaz.getText());
    }

    @Test
    void pogresanUpis(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("Hljeb");
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        Button ok = robot.lookup("#myID").queryAs(Button.class);
        assertNotNull(ok);
        robot.clickOn(ok);
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("", prikaz.getText());

    }

    @Test
    void provjeraChoiceBoxa(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("h1,Hljeb,1\nh2,Kola,3");
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("h1,Hljeb,1.0\nh2,Kola,3.0", prikaz.getText());
        robot.press(ctrl).press(KeyCode.TAB).release(KeyCode.TAB).release(ctrl);
        ChoiceBox sviArtikli = robot.lookup("#sviArtikli").queryAs(ChoiceBox.class);
        assertNotNull(sviArtikli);
        assertEquals("[h1, h2]", sviArtikli.getItems().toString());
    }

    @Test
    void provjeraRacuna(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("h1,Hljeb,1\nh2,Kola,3\nh3,Pavlaka,1.5");
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("h1,Hljeb,1.0\nh2,Kola,3.0\nh3,Pavlaka,1.5", prikaz.getText());
        robot.press(ctrl).press(KeyCode.TAB).release(KeyCode.TAB).release(ctrl);
        ChoiceBox sviArtikli = robot.lookup("#sviArtikli").queryAs(ChoiceBox.class);
        assertNotNull(sviArtikli);
        assertEquals("[h1, h2, h3]", sviArtikli.getItems().toString());
        robot.clickOn(sviArtikli);
        robot.press(KeyCode.ENTER).release(KeyCode.ENTER);
        Spinner spiner = robot.lookup("#kolicina").queryAs(Spinner.class);
        assertNotNull(spiner);
        robot.clickOn(spiner);
        robot.press(KeyCode.UP).release(KeyCode.UP);
        Button dugmeDodaj = robot.lookup("#dugmeDodaj").queryAs(Button.class);
        assertNotNull(dugmeDodaj);
        TextArea konacniRacun = robot.lookup("#konacniRacun").queryAs(TextArea.class);
        assertNotNull(konacniRacun);
        robot.clickOn(dugmeDodaj);
        robot.clickOn(sviArtikli).press(KeyCode.DOWN).release(KeyCode.DOWN).press(KeyCode.ENTER).release(KeyCode.ENTER);
        robot.clickOn(spiner).press(KeyCode.UP).release(KeyCode.UP).press(KeyCode.UP).release(KeyCode.UP).press(KeyCode.ENTER).release(KeyCode.ENTER);
        robot.clickOn(dugmeDodaj);
        robot.clickOn(sviArtikli).press(KeyCode.DOWN).release(KeyCode.DOWN).press(KeyCode.ENTER).release(KeyCode.ENTER);
        robot.clickOn(spiner).press(KeyCode.UP).release(KeyCode.UP).press(KeyCode.UP).release(KeyCode.UP);
        robot.clickOn(dugmeDodaj);
        assertEquals("h1    2   2.00\n" +
                "h2    4   12.00\n" +
                "h3    6   9.00\n" +
                "UKUPNO:      23.00\n", konacniRacun.getText());
    }

    @Test
    void pogresanUnos1(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("h1,Hljeb,");
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        Button ok = robot.lookup("#myID").queryAs(Button.class);
        assertNotNull(ok);
        robot.clickOn(ok);
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("", prikaz.getText());
    }

    @Test
    void pogresanUnos2(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("h1,Hljeb, 1a");
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        Button ok = robot.lookup("#myID").queryAs(Button.class);
        assertNotNull(ok);
        robot.clickOn(ok);
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("", prikaz.getText());
    }

    @Test
    void pogresanUnos3(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("h1,Hljeb, 112312312s1.1231212");  // slovo "s" je "zalutalo"
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        Button ok = robot.lookup("#myID").queryAs(Button.class);
        assertNotNull(ok);
        robot.clickOn(ok);
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("", prikaz.getText());
    }

    @Test
    void pogresanUnos4(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write(", , ");  // slovo "s" je "zalutalo"
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        Button ok = robot.lookup("#myID").queryAs(Button.class);
        assertNotNull(ok);
        robot.clickOn(ok);
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("", prikaz.getText());
    }

    @Test
    void pogresanUnos5(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("h1,Hljebustina,1\nh2,KrumpirStoBiSeReklo,\nh3,Kolja,3 ");  // slovo "s" je "zalutalo"
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        Button ok = robot.lookup("#myID").queryAs(Button.class);
        assertNotNull(ok);
        robot.clickOn(ok);
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("", prikaz.getText());
    }

    @Test
    void nijeIzabranArtikal1(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        robot.clickOn("#pokupiTekst");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("h1,Hljeb,1\nh2,Kola,3\nh3,Pavlaka,1.5");
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("h1,Hljeb,1.0\nh2,Kola,3.0\nh3,Pavlaka,1.5", prikaz.getText());
        robot.press(ctrl).press(KeyCode.TAB).release(KeyCode.TAB).release(ctrl);
        ChoiceBox sviArtikli = robot.lookup("#sviArtikli").queryAs(ChoiceBox.class);
        assertNotNull(sviArtikli);
        assertEquals("[h1, h2, h3]", sviArtikli.getItems().toString());
        Spinner spiner = robot.lookup("#kolicina").queryAs(Spinner.class);
        assertNotNull(spiner);
        robot.clickOn(spiner);
        robot.press(KeyCode.UP).release(KeyCode.UP);
        Button dugmeDodaj = robot.lookup("#dugmeDodaj").queryAs(Button.class);
        assertNotNull(dugmeDodaj);
        TextArea konacniRacun = robot.lookup("#konacniRacun").queryAs(TextArea.class);
        assertNotNull(konacniRacun);
        robot.clickOn(dugmeDodaj);
        Button ok = robot.lookup("#myID").queryAs(Button.class);
        robot.clickOn(ok);
        assertEquals("", konacniRacun.getText());
    }

    @Test
    void nijeIzabranArtikal2(FxRobot robot) {
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac Os X")) ctrl = KeyCode.COMMAND;
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        robot.press(ctrl).press(KeyCode.TAB).release(KeyCode.TAB).release(ctrl);
        ChoiceBox sviArtikli = robot.lookup("#sviArtikli").queryAs(ChoiceBox.class);
        assertNotNull(sviArtikli);
        Spinner spiner = robot.lookup("#kolicina").queryAs(Spinner.class);
        assertNotNull(spiner);
        Button dugmeDodaj = robot.lookup("#dugmeDodaj").queryAs(Button.class);
        assertNotNull(dugmeDodaj);
        TextArea konacniRacun = robot.lookup("#konacniRacun").queryAs(TextArea.class);
        assertNotNull(konacniRacun);
        robot.clickOn(dugmeDodaj);
        assertEquals("", konacniRacun.getText());
    }
}