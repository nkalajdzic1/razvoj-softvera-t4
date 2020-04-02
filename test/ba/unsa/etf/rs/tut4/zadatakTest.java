package ba.unsa.etf.rs.tut4;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class zadatakTest {

    @Start
    public void start (Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/zadatak.fxml"));
        stage.setTitle("Tutorijal 4");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
        stage.toFront();
    }

    @Test
    void prviTest(FxRobot robot) {
        TextArea tekst = robot.lookup("#pokupiTekst").queryAs(TextArea.class);
        assertNotNull(tekst);
        robot.clickOn("#pokupiTekst");
        robot.write("h1,Hljeb,1\nh2,Kola,3");
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        assertNotNull(dugme);
        robot.clickOn("#dugme");
        TextArea prikaz = robot.lookup("#prikaziTekst").queryAs(TextArea.class);
        assertNotNull(prikaz);
        assertEquals("h1,Hljeb,1.0\nh2,Kola,3.0\n", prikaz.getText());
    }
}