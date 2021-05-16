/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hu.unideb.inf.model.JpaCasinoDAO;
import hu.unideb.inf.model.User2;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */
public class CasinoRegisterController implements Initializable {
    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @FXML
    private Button RegisterGomb;

    @FXML
    private ChoiceBox NEM, SZEMSZIN, HAJSZIN;

    @FXML
    private TextField Felhasznalonev, Vezeteknev, Keresztnev, Email, Bank;

    @FXML
    private PasswordField Jelszo, Jelszo2;

    @FXML
    private DatePicker Szuletesidatum;

    String generateID() {
        UUID uuid = UUID.randomUUID();
        String ID = "" + uuid;
        return ID;
    }

    @FXML
    void RegisterButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CasinoLogin.fxml"));
        Scene scene = RegisterGomb.getScene();

        root.translateXProperty().set(scene.getHeight() * -1);

        StackPane parentContainer = (StackPane) scene.getRoot();
        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.3), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    @FXML
    void MenuCloseButton(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    private static final String regex = "^(.+)@(.+).(.+)$";

    @FXML
    void KuldesGomb(ActionEvent event) {
        String vezeteknev = Vezeteknev.getText();
        String keresztnev = Keresztnev.getText();
        String felhasznalo = Felhasznalonev.getText();
        String email = Email.getText();
        String bank = Bank.getText();
        String jelszo = Jelszo.getText();
        String jelszo2 = Jelszo2.getText();
        String nem = NEM.getValue().toString();
        String hajszin = HAJSZIN.getValue().toString();
        String szemszin = SZEMSZIN.getValue().toString();
        String setID = generateID();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);


        if (vezeteknev.equals("") || keresztnev.equals("") || bank.equals("") ||
                felhasznalo.equals("") || email.equals("") || jelszo.equals("") ||
                jelszo2.equals("") || nem.equals("") || hajszin.equals("") ||
                szemszin.equals("") || Szuletesidatum.getValue() == null) {
            Alert hiba = new Alert(Alert.AlertType.ERROR);
            hiba.setTitle("Hiba");
            hiba.setHeaderText("Kérem töltse ki az összes mezőt");
            hiba.showAndWait();
        } else if (!jelszo.equals(jelszo2)) {
            Alert hiba = new Alert(Alert.AlertType.ERROR);
            hiba.setTitle("Hiba");
            hiba.setHeaderText("Nem egyezik a két jelszó");
            hiba.showAndWait();
        } else if (!matcher.matches()) {
            Alert hiba = new Alert(Alert.AlertType.ERROR);
            hiba.setTitle("Hiba");
            hiba.setHeaderText("Helytelen E-mail formátum");
            hiba.showAndWait();
        }
        else {
            JpaCasinoDAO userDAO = new JpaCasinoDAO();
            List<User2> Profile = userDAO.getUser();
            for (var user : Profile ) {
                if (user.getUsername().equals(felhasznalo)){
                    Alert hiba = new Alert(Alert.AlertType.ERROR);
                    hiba.setTitle("Hiba");
                    hiba.setHeaderText("Ez a felhasználónév már foglalt!");
                    hiba.showAndWait();
                    return;
                }
            }
            Alert reg = new Alert(Alert.AlertType.INFORMATION);
            reg.setTitle("Regisztráció");
            reg.setHeaderText("Sikeres regisztráció");
            reg.showAndWait();
            User2 user2 = new User2();
            user2.setUsername(felhasznalo);
            user2.setPassword(jelszo);
            user2.setSetID(setID);
            user2.setNem(nem);
            user2.setHajszin(hajszin);
            user2.setSzem(szemszin);
            user2.setVnev(vezeteknev);
            user2.setKnev(keresztnev);
            user2.setEmail(email);
            user2.setCreditCardNumber(bank);
            user2.setDatum(Szuletesidatum.getValue().toString());
            Globalis global = new Globalis();
            String[] genderids = global.checkGenderID(nem, hajszin, szemszin);
            user2.setJatekos_neme(genderids[0]);
//            String jatekos_neme = genderids[0];
            user2.setJatekos_hajszem(genderids[1]);
            user2.setJatekospenz(100000);
            user2.setKellekek0(2);
            entityManager.getTransaction().begin();
            entityManager.persist(user2);
            entityManager.getTransaction().commit();
//            String jatekos_hajszem = genderids[1];
                /*try(BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(System.getProperty("user.home") + File.separator + (setID+".txt")))){
                    bufferedWriter2.write("100000:0:"+(genderids[0].equals("0") ? (genderids[0]+":"+genderids[1]+":2:0:0:0") : (genderids[0]+":"+genderids[1]+":2:0:0:0")));
                }*/

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/CasinoLogin.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = RegisterGomb.getScene();

            root.translateXProperty().set(scene.getHeight() * -1);

            StackPane parentContainer = (StackPane) scene.getRoot();
            parentContainer.getChildren().add(root);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.3), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();

        }
    }


    @FXML
    void BankszamlaGombok(javafx.scene.input.KeyEvent event) {
        char c = event.getCharacter().charAt(0);
        if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
            if (Bank.getLength() > 0) {
                Bank.deleteText(Bank.getLength() - 1, Bank.getLength());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NEM.setValue("");
        NEM.getItems().add("Férfi");
        NEM.getItems().add("Nő");

        HAJSZIN.setValue("");
        HAJSZIN.getItems().add("Szöke");
        HAJSZIN.getItems().add("Barna");
        HAJSZIN.getItems().add("Fekete");

        SZEMSZIN.setValue("");
        SZEMSZIN.getItems().add("Arany");
        SZEMSZIN.getItems().add("Kék");
        SZEMSZIN.getItems().add("Barna");
        SZEMSZIN.getItems().add("Zöld");
    }

}
