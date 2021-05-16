/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import hu.unideb.inf.model.JpaCasinoDAO;
import hu.unideb.inf.model.User2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */
public class CasinoBoltController implements Initializable {
    
    @FXML
    void MenuCloseButton(ActionEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
    
    Globalis global = new Globalis();
    
    @FXML
    void MenuFooldalGomb(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Fomenu");
    }
    
    @FXML
    void MenuKijelentkezesButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Login");
    }

    @FXML
    void MenuRouletteButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Roulette");
    }
    
    @FXML
    void MenuProfileButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Profile");
    }
    
    @FXML
    void MenuBJButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "BJ");
    }

    @FXML
    void MenuCoinButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Coin");
    }

    @FXML
    void MenuDiceButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Dice");
    }

    @FXML
    void MenuFeltoltesButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Feltoltes");
    }

    @FXML
    void MenuSlotIButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "SlotI");
    }

    @FXML
    void MenuWheelButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Wheel");
    }

    @FXML
    void MenuSlotIIButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "SlotII");
    }
    
    @FXML
    private Pane BoltAvatarCheck;
    
    @FXML
    void RemoveAccButton(javafx.scene.input.MouseEvent event) {
        if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_ENTERED)){
            String SetTiePic = "" + (Integer.parseInt(hajszem));
            if(Integer.parseInt(Kellekek[0]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem));
            }else if(Integer.parseInt(Kellekek[1]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)-1);
            }else if(Integer.parseInt(Kellekek[2]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)-2);
            }else if(Integer.parseInt(Kellekek[3]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)-3);
            }
            BoltAvatarCheck.setStyle(global.ProfilKepCsere(nem, SetTiePic));
        }else if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_PRESSED)){
            if(Integer.parseInt(Kellekek[0]) >= 1){
                if(Integer.parseInt(Kellekek[1]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)-1);
                    Kellekek = KepDataCsere(Kellekek,0);
                }else if(Integer.parseInt(Kellekek[2]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)-2);
                    Kellekek = KepDataCsere(Kellekek,0);
                }else if(Integer.parseInt(Kellekek[3]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)-3);
                    Kellekek = KepDataCsere(Kellekek,0);
                }
            }
            global.saveData(id, jatekospenz, jatekospenz2, nem, hajszem, Kellekek);
            ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
            BoltAvatarCheck.setStyle(global.ProfilKepCsere(nem, hajszem));
        }
    }
    
    @FXML
    void BowTieButton(javafx.scene.input.MouseEvent event) {
        if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_ENTERED)){
            String SetTiePic = "" + (Integer.parseInt(hajszem)+1);
            if(Integer.parseInt(Kellekek[0]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)+1);
            }else if(Integer.parseInt(Kellekek[1]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem));
            }else if(Integer.parseInt(Kellekek[2]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)-1);
            }else if(Integer.parseInt(Kellekek[3]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)-2);
            }
            BoltAvatarCheck.setStyle(global.ProfilKepCsere(nem, SetTiePic));
        }else if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_PRESSED)){
            if(Integer.parseInt(Kellekek[1]) >= 1){
                ButtonType foo = new ButtonType("Igen", ButtonBar.ButtonData.OK_DONE);
                ButtonType bar = new ButtonType("Nem", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Szeretné használni a terméket?",
                        foo,bar);
                alert.setHeaderText("Csokornyakkendő");
                alert.setTitle("Bolt információ");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(bar) == foo) {
                    if (Integer.parseInt(Kellekek[0]) == 2) {
                        hajszem = "" + (Integer.parseInt(hajszem) + 1);
                        Kellekek = KepDataCsere(Kellekek, 1);
                    } else if (Integer.parseInt(Kellekek[2]) == 2) {
                        hajszem = "" + (Integer.parseInt(hajszem) - 1);
                        Kellekek = KepDataCsere(Kellekek, 1);
                    } else if (Integer.parseInt(Kellekek[3]) == 2) {
                        hajszem = "" + (Integer.parseInt(hajszem) - 2);
                        Kellekek = KepDataCsere(Kellekek, 1);
                    }
                }
            }else if(jatekospenz2 >= 45000){
                ButtonType foo = new ButtonType("Igen", ButtonBar.ButtonData.OK_DONE);
                ButtonType bar = new ButtonType("Nem", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Biztosan meg szeretné vásárolni a terméket?",
                        foo,bar);
                alert.setHeaderText("Csokornyakkendő");
                alert.setTitle("Bolt információ");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(bar) == foo) {
                    jatekospenz2 -= 45000;
                    Kellekek[1] = "1";
                    ChipMoney.setText("" + jatekospenz2);
                    Alert siker = new Alert(Alert.AlertType.INFORMATION);
                    siker.setTitle("Bolt információ");
                    siker.setHeaderText("Sikeresen megvásárolta a terméket!");
                    siker.showAndWait();
                }
            }else{
                Alert hiba = new Alert(Alert.AlertType.ERROR);
                hiba.setTitle("Hiba");
                hiba.setHeaderText("Nincs elég kaszinó pénzed a termék megvásárlásához!");
                hiba.showAndWait();
            }
            global.saveData(id, jatekospenz, jatekospenz2, nem, hajszem, Kellekek);
            ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
            BoltAvatarCheck.setStyle(global.ProfilKepCsere(nem, hajszem));
        }
    }
    
    @FXML
    void MonocleButton(javafx.scene.input.MouseEvent event) {
        if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_ENTERED)){
            String SetTiePic = "" + (Integer.parseInt(hajszem)+2);
            if(Integer.parseInt(Kellekek[0]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)+2);
            }else if(Integer.parseInt(Kellekek[1]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)+1);
            }else if(Integer.parseInt(Kellekek[2]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem));
            }else if(Integer.parseInt(Kellekek[3]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)-1);
            }
            BoltAvatarCheck.setStyle(global.ProfilKepCsere(nem, SetTiePic));
        }else if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_PRESSED)){

            if(Integer.parseInt(Kellekek[2]) >= 1){
                ButtonType foo = new ButtonType("Igen", ButtonBar.ButtonData.OK_DONE);
                ButtonType bar = new ButtonType("Nem", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Szeretné használni a terméket?",
                        foo,bar);
                alert.setHeaderText("Monokli");
                alert.setTitle("Bolt információ");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(bar) == foo) {
                    if (Integer.parseInt(Kellekek[0]) == 2) {
                        hajszem = "" + (Integer.parseInt(hajszem) + 2);
                        Kellekek = KepDataCsere(Kellekek, 2);
                    } else if (Integer.parseInt(Kellekek[1]) == 2) {
                        hajszem = "" + (Integer.parseInt(hajszem) + 1);
                        Kellekek = KepDataCsere(Kellekek, 2);
                    } else if (Integer.parseInt(Kellekek[3]) == 2) {
                        hajszem = "" + (Integer.parseInt(hajszem) - 1);
                        Kellekek = KepDataCsere(Kellekek, 2);
                    }
                }
            }else if(jatekospenz2 >= 66000){
                ButtonType foo = new ButtonType("Igen", ButtonBar.ButtonData.OK_DONE);
                ButtonType bar = new ButtonType("Nem", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Biztosan meg szeretné vásárolni a terméket?",
                        foo,bar);
                alert.setHeaderText("Monokli");
                alert.setTitle("Bolt információ");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(bar) == foo) {
                    jatekospenz2 -= 66000;
                    Kellekek[2] = "1";
                    ChipMoney.setText("" + jatekospenz2);
                    Alert siker = new Alert(Alert.AlertType.INFORMATION);
                    siker.setTitle("Bolt információ");
                    siker.setHeaderText("Sikeresen megvásárolta a terméket!");
                    siker.showAndWait();
                }
            }else{
                Alert hiba = new Alert(Alert.AlertType.ERROR);
                hiba.setTitle("Hiba");
                hiba.setHeaderText("Nincs elég kaszinó pénzed a termék megvásárlásához!");
                hiba.showAndWait();
            }
            global.saveData(id, jatekospenz, jatekospenz2, nem, hajszem, Kellekek);
            ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
            BoltAvatarCheck.setStyle(global.ProfilKepCsere(nem, hajszem));
        }
    }
    
    @FXML
    void GlassesButton(javafx.scene.input.MouseEvent event) {
        if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_ENTERED)){
            String SetTiePic = "" + (Integer.parseInt(hajszem)+3);
            if(Integer.parseInt(Kellekek[0]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)+3);
            }else if(Integer.parseInt(Kellekek[1]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)+2);
            }else if(Integer.parseInt(Kellekek[2]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem)+1);
            }else if(Integer.parseInt(Kellekek[3]) == 2){
                SetTiePic = "" + (Integer.parseInt(hajszem));
            }
            BoltAvatarCheck.setStyle(global.ProfilKepCsere(nem, SetTiePic));
        }else if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_PRESSED)){
            if(Integer.parseInt(Kellekek[3]) >= 1){
                ButtonType foo = new ButtonType("Igen", ButtonBar.ButtonData.OK_DONE);
                ButtonType bar = new ButtonType("Nem", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Szeretné használni a terméket?",
                        foo,bar);
                alert.setHeaderText("Szemüveg");
                alert.setTitle("Bolt információ");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(bar) == foo) {
                    if (Integer.parseInt(Kellekek[0]) == 2) {
                        hajszem = "" + (Integer.parseInt(hajszem) + 3);
                        Kellekek = KepDataCsere(Kellekek, 3);
                    } else if (Integer.parseInt(Kellekek[1]) == 2) {
                        hajszem = "" + (Integer.parseInt(hajszem) + 2);
                        Kellekek = KepDataCsere(Kellekek, 3);
                    } else if (Integer.parseInt(Kellekek[2]) == 2) {
                        hajszem = "" + (Integer.parseInt(hajszem) + 1);
                        Kellekek = KepDataCsere(Kellekek, 3);
                    }
                }
            }else if(jatekospenz2 >= 142000){
                ButtonType foo = new ButtonType("Igen", ButtonBar.ButtonData.OK_DONE);
                ButtonType bar = new ButtonType("Nem", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Biztosan meg szeretné vásárolni a terméket?",
                        foo,bar);
                alert.setHeaderText("Szemüveg");
                alert.setTitle("Bolt információ");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(bar) == foo) {
                    jatekospenz2 -= 142000;
                    Kellekek[3] = "1";
                    ChipMoney.setText("" + jatekospenz2);
                    Alert siker = new Alert(Alert.AlertType.INFORMATION);
                    siker.setTitle("Bolt információ");
                    siker.setHeaderText("Sikeresen megvásárolta a terméket!");
                    siker.showAndWait();
                }

            }else{
                Alert hiba = new Alert(Alert.AlertType.ERROR);
                hiba.setTitle("Hiba");
                hiba.setHeaderText("Nincs elég kaszinó pénzed a termék megvásárlásához!");
                hiba.showAndWait();
            }
            
            global.saveData(id, jatekospenz, jatekospenz2, nem, hajszem, Kellekek);
            ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
            BoltAvatarCheck.setStyle(global.ProfilKepCsere(nem, hajszem));
        }
    }
    
    @FXML
    private Label BankMoney,ChipMoney,getID;

    @FXML
    private Button ProfilKep;
    
    String id = "";
    String nem = "", hajszem = "";
    String[] Kellekek = new String[4];
    int jatekospenz2 = 0;
    int jatekospenz = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void Adatatvitel(String ID){
        id = ID;
        JpaCasinoDAO userDAO = new JpaCasinoDAO();
        List<User2> Profile = userDAO.getUser();
        for(var a : Profile){
            if(id.equals(a.getSetID())){
                getID.setText(id);
                BankMoney.setText(""+a.getJatekospenz());
                ChipMoney.setText(""+a.getJatekospenz2());
                jatekospenz = a.getJatekospenz();
                jatekospenz2 = a.getJatekospenz2();
                nem = a.getJatekos_neme();
                hajszem = a.getJatekos_hajszem();
                Kellekek[0] = ""+a.getKellekek0();
                Kellekek[1] = ""+a.getKellekek1();
                Kellekek[2] = ""+a.getKellekek2();
                Kellekek[3] = ""+a.getKellekek3();
                break;
            }
        }
        ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
        BoltAvatarCheck.setStyle(global.ProfilKepCsere(nem, hajszem));
    }
    
    String[] KepDataCsere(String[] Kellekek, int kellek){
        String[] meglevo = new String[4];
        for (int i = 0; i < meglevo.length; i++) {
            if(Kellekek[i].equals("0")){
                meglevo[i] = "0";
            }else if(Integer.parseInt(Kellekek[i]) >= 1){
                meglevo[i] = "1";
            }
        }
        meglevo[kellek] = "2"; 
        return meglevo;
    }
    
}
