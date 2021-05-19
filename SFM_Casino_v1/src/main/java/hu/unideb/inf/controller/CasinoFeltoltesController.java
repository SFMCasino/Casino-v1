/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import hu.unideb.inf.model.JpaCasinoDAO;
import hu.unideb.inf.model.User2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */
public class CasinoFeltoltesController implements Initializable {

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
    void MenuProfileButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Profile");
    }

    @FXML
    void MenuBJButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "BJ");
    }

    @FXML
    void MenuBoltButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Bolt");
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

    public static int elso;
    public static int masodik;

    @FXML
    private Label BankMoney,ChipMoney,getID,kozlLabel;
    public Button paypalButt, bankButt, feltoltesButt, bankfeltoltesButt;
    public TextField cardText, cardpenzText, expText, bankpenzText;
    public PasswordField cvcText;
    public Pane cardPane, bankPane;

    @FXML
    private Button ProfilKep;

    String id = "";
    String nem = "", hajszem = "";
    String[] Kellekek = new String[4];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random rand = new Random();
        int uj = rand.nextInt(50000);
        kozlLabel.setText(uj + "");

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
                elso = a.getJatekospenz();
                masodik = a.getJatekospenz2();
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
    }

    public void bankButtPressed(ActionEvent actionEvent)
    {
        bankPane.setVisible(true);
        cardPane.setVisible(false);
    }

    public void cardButtPressed(ActionEvent actionEvent)
    {
        bankPane.setVisible(false);
        cardPane.setVisible(true);
    }

    public void feltoltesbuttpushed(ActionEvent actionEvent) {
        if((cardText.getText()).equals("") || (expText.getText()).equals("") || (cvcText.getText()).equals("") || (cardpenzText.getText()).equals(""))
        {
            Alert hiba = new Alert(Alert.AlertType.ERROR);
            hiba.setTitle("Hiba");
            hiba.setHeaderText("Kérem töltse ki az összes mezőt");
            hiba.showAndWait();
        }
        else {
            elso += Integer.parseInt(cardpenzText.getText());
            BankMoney.setText(elso + "");
            global.saveData(id, elso, masodik, nem, hajszem, Kellekek);
        }
    }

    public void bankfeltoltesbuttpushed(ActionEvent actionEvent) {
        if((bankpenzText.getText()).equals(""))
        {
            Alert hiba = new Alert(Alert.AlertType.ERROR);
            hiba.setTitle("Hiba");
            hiba.setHeaderText("Kérem töltse ki a pénz mezőt");
            hiba.showAndWait();
        }
        else {
            elso += Integer.parseInt(bankpenzText.getText());
            BankMoney.setText(elso + "");
            global.saveData(id, elso, masodik, nem, hajszem, Kellekek);
        }
    }
    @FXML
    void cvcnyomva(javafx.scene.input.KeyEvent event) {
        char c = event.getCharacter().charAt(0);
        if(!Character.isDigit(c) && c!=KeyEvent.VK_BACK_SPACE){
            if(cvcText.getLength() > 0){
                cvcText.deleteText(cvcText.getLength()-1,cvcText.getLength());
            }
        }
        if(cvcText.getLength() > 3){
            cvcText.deleteText(cvcText.getLength()-1,cvcText.getLength());
        }
    }
    @FXML
    void cardnyomva(javafx.scene.input.KeyEvent event) {
        char c = event.getCharacter().charAt(0);
        if(!Character.isDigit(c) && c!=KeyEvent.VK_BACK_SPACE){
            if(cardText.getLength() > 0){
                cardText.deleteText(cardText.getLength()-1,cardText.getLength());
            }
        }
        if(c==KeyEvent.VK_BACK_SPACE && (cardText.getLength()==8 || cardText.getLength()==17))
        {
            cardText.deleteText(cardText.getLength()-1,cardText.getLength());
        }
        if(cardText.getLength() > 26){
            cardText.deleteText(cardText.getLength()-1,cardText.getLength());
        }
        if((cardText.getLength() == 8 || cardText.getLength() == 17) && c!=KeyEvent.VK_BACK_SPACE)
        {
            cardText.appendText("-");
        }
    }
    @FXML
    void expnyomva(javafx.scene.input.KeyEvent event) {
        char c = event.getCharacter().charAt(0);
        if(!Character.isDigit(c) && c!=KeyEvent.VK_BACK_SPACE){
            if(expText.getLength() > 0){
                expText.deleteText(expText.getLength()-1,expText.getLength());
            }
        }
        if(expText.getLength() > 5){
            expText.deleteText(expText.getLength()-1,expText.getLength());
        }
        if(expText.getLength()==2 && c!=KeyEvent.VK_BACK_SPACE)
        {
            expText.appendText("/");
        }
        if(c==KeyEvent.VK_BACK_SPACE && expText.getLength()==2)
        {
            expText.deleteText(expText.getLength()-1,expText.getLength());
        }
    }

    public void bankpenznyomva(javafx.scene.input.KeyEvent event) {
        char c = event.getCharacter().charAt(0);
        if(!Character.isDigit(c) && c!=KeyEvent.VK_BACK_SPACE){
            if(bankpenzText.getLength() > 0){
                bankpenzText.deleteText(bankpenzText.getLength()-1,bankpenzText.getLength());
            }
        }
        if(bankpenzText.getLength() > 6){
            bankpenzText.deleteText(bankpenzText.getLength()-1,bankpenzText.getLength());
        }
    }

    public void cardpenznyomva(javafx.scene.input.KeyEvent event) {
        char c = event.getCharacter().charAt(0);
        if(!Character.isDigit(c) && c!=KeyEvent.VK_BACK_SPACE){
            if(cardpenzText.getLength() > 0){
                cardpenzText.deleteText(cardpenzText.getLength()-1,cardpenzText.getLength());
            }
        }
        if(cardpenzText.getLength() > 6){
            cardpenzText.deleteText(cardpenzText.getLength()-1,cardpenzText.getLength());
        }
    }
}
