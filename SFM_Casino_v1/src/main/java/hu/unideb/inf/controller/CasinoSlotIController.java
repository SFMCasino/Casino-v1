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
import java.util.Random;
import java.util.ResourceBundle;

import hu.unideb.inf.model.JpaCasinoDAO;
import hu.unideb.inf.model.User2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */
public class CasinoSlotIController implements Initializable {
    
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
    void MenuFeltoltesButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Feltoltes");
    }

    @FXML
    void MenuWheelButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Wheel");
    }

    @FXML
    void MenuSlotIIButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "SlotII");
    }
    
    //--------------------------------Genji's Slot----ELEJE---------------------
    @FXML
    private Label GenjiSlotTet;
    @FXML
    private ImageView GenjiSlot1,GenjiSlot2,GenjiSlot3;
    
    @FXML
    private Label BankMoney,ChipMoney,getID;
    
    int jatekospenz = 0;
    int jatekospenz2 = 0;
    int GenjiTét = 500;
    
    
    @FXML
    void GenjiMaxButtonPressed(ActionEvent event){
        GenjiTét = 25000;
        if(GenjiTét > (jatekospenz + jatekospenz2)) GenjiTét = jatekospenz + jatekospenz2;
        GenjiSlotTet.setText("Tét: " + GenjiTét);
    }
    
    @FXML
    void GenjiMinButtonPressed(ActionEvent event) {
        GenjiTét = 500;
        GenjiSlotTet.setText("Tét: " + GenjiTét);
    }

    @FXML
    void GenjiMinusButtonPressed(ActionEvent event) {
        GenjiTét -= 500;
        if(GenjiTét < 500) GenjiTét = 500;
        GenjiSlotTet.setText("Tét: " + GenjiTét);
    }

    @FXML
    void GenjiPlusButtonPressed(ActionEvent event) {
        GenjiTét += 500;
        if(GenjiTét > 25000) GenjiTét = 25000;
        if(GenjiTét > (jatekospenz + jatekospenz2)) GenjiTét = jatekospenz + jatekospenz2;
        GenjiSlotTet.setText("Tét: " + GenjiTét);
    }

    void GenjiNyertOsszeg(int nyeremeny){
        Alert GenjiAlert = new Alert(Alert.AlertType.INFORMATION);
        GenjiAlert.setTitle("Nyeremény");
        GenjiAlert.setHeaderText("Nyertél: ");
        GenjiAlert.setContentText("" + nyeremeny);
        GenjiAlert.showAndWait();
    }
    
    @FXML
    void GenjiStartButtonPressed(ActionEvent event) {
        if((jatekospenz + jatekospenz2) >= GenjiTét){
            if(jatekospenz-GenjiTét < 0){
                int genjitet = GenjiTét-jatekospenz;
                jatekospenz = 0;
                jatekospenz2 -= genjitet;
                BankMoney.setText("" + jatekospenz);
                ChipMoney.setText("" + jatekospenz2);
            }else{
                jatekospenz -= GenjiTét;
                BankMoney.setText("" + jatekospenz);
            }
        
        char[] Slotertek = new char[3];
        boolean ow = false;
        boolean ow2 = false;
        
        Random randslot1 = new Random();
        Random randslot2 = new Random();
        Random randslot3 = new Random();
        //randomcard = randslot.nextInt((52-1) + 1) + 1;
        int Slot1 = randslot1.nextInt(25);
        if(Slot1 <= 6) Slotertek[0] = 'C';
        else if(Slot1 > 6 && Slot1 <= 11) Slotertek[0] = 'S';
        else if(Slot1 > 11 && Slot1 <= 15) Slotertek[0] = 'H';
        else if(Slot1 > 15 && Slot1 <= 18) Slotertek[0] = 'D';
        else if(Slot1 > 18 && Slot1 <= 20) Slotertek[0] = '7';
        else if(Slot1 > 20 && Slot1 <= 21) Slotertek[0] = 'W';
        else if(Slot1 > 21 && Slot1 <= 26){
            ow = true;
            Slotertek[0] = 'O';
            int Slot2 = randslot2.nextInt(25);
            if(Slot2 <= 6) Slotertek[1] = 'C';
            else if(Slot2 > 6 && Slot2 <= 11) Slotertek[1] = 'S';
            else if(Slot2 > 11 && Slot2 <= 15) Slotertek[1] = 'H';
            else if(Slot2 > 15 && Slot2 <= 18) Slotertek[1] = 'D';
            else if(Slot2 > 18 && Slot2 <= 20) Slotertek[1] = '7';
            else if(Slot2 > 20 && Slot2 <= 21) Slotertek[1] = 'W';
            else if(Slot2 > 21 && Slot2 <= 24){
                ow2 = true;
                Slotertek[1] = 'O';
                int Slot3 = randslot3.nextInt(25);
                if(Slot3 <= 6) Slotertek[2] = 'C';
                else if(Slot3 > 6 && Slot3 <= 11) Slotertek[2] = 'S';
                else if(Slot3 > 11 && Slot3 <= 15) Slotertek[2] = 'H';
                else if(Slot3 > 15 && Slot3 <= 18) Slotertek[2] = 'D';
                else if(Slot3 > 18 && Slot3 <= 20) Slotertek[2] = '7';
                else if(Slot3 > 20 && Slot3 <= 21) Slotertek[2] = 'W';
                else if(Slot3 > 21 && Slot3 <= 22) Slotertek[2] = 'O';
            }
        }
        if(!ow){
            int Slot2 = randslot2.nextInt(25);
            if(Slot2 <= 6) Slotertek[1] = 'C';
            else if(Slot2 > 6 && Slot2 <= 11) Slotertek[1] = 'S';
            else if(Slot2 > 11 && Slot2 <= 15) Slotertek[1] = 'H';
            else if(Slot2 > 15 && Slot2 <= 18) Slotertek[1] = 'D';
            else if(Slot2 > 18 && Slot2 <= 20) Slotertek[1] = '7';
            else if(Slot2 > 20 && Slot2 <= 21) Slotertek[1] = 'W';
            else if(Slot2 > 21 && Slot2 <= 26){
                Slotertek[1] = 'O';
                int Slot3 = randslot3.nextInt(25);
                    if(Slot3 <= 6) Slotertek[2] = 'C';
                    else if(Slot3 > 6 && Slot3 <= 11) Slotertek[2] = 'S';
                    else if(Slot3 > 11 && Slot3 <= 15) Slotertek[2] = 'H';
                    else if(Slot3 > 15 && Slot3 <= 18) Slotertek[2] = 'D';
                    else if(Slot3 > 18 && Slot3 <= 20) Slotertek[2] = '7';
                    else if(Slot3 > 20 && Slot3 <= 21) Slotertek[2] = 'W';
                    else if(Slot3 > 21 && Slot3 <= 24) Slotertek[2] = 'O';
            }
        }
        if(!ow2){
            int Slot3 = randslot3.nextInt(25);
            if(Slot3 <= 6) Slotertek[2] = 'C';
            else if(Slot3 > 6 && Slot3 <= 11) Slotertek[2] = 'S';
            else if(Slot3 > 11 && Slot3 <= 15) Slotertek[2] = 'H';
            else if(Slot3 > 15 && Slot3 <= 18) Slotertek[2] = 'D';
            else if(Slot3 > 18 && Slot3 <= 20) Slotertek[2] = '7';
            else if(Slot3 > 20 && Slot3 <= 21) Slotertek[2] = 'W';
            else if(Slot3 > 21 && Slot3 <= 26) Slotertek[2] = 'O';
        }
        switch(Slotertek[0]){
        case 'C':
            GenjiSlot1.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiCherry.png"));
            break;
        case 'S':
            GenjiSlot1.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiSzolo.png"));
            break;
        case 'H':
            GenjiSlot1.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiClover.png"));
            break;
        case 'D':
            GenjiSlot1.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiSurik.png"));
            break;
        case '7':
            GenjiSlot1.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/Genji7.png"));
            break;
        case 'W':
            GenjiSlot1.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiWILD.png"));
            break;
        case 'O':
            GenjiSlot1.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiOw.png"));
            break;
        default:
            break;
        }
        switch(Slotertek[1]){
        case 'C':
            GenjiSlot2.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiCherry.png"));
            break;
        case 'S':
            GenjiSlot2.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiSzolo.png"));
            break;
        case 'H':
            GenjiSlot2.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiClover.png"));
            break;
        case 'D':
            GenjiSlot2.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiSurik.png"));
            break;
        case '7':
            GenjiSlot2.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/Genji7.png"));
            break;
        case 'W':
            GenjiSlot2.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiWILD.png"));
            break;
        case 'O':
            GenjiSlot2.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiOw.png"));
            break;
        default:
            break;
        }
        switch(Slotertek[2]){
        case 'C':
            GenjiSlot3.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiCherry.png"));
            break;
        case 'S':
            GenjiSlot3.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiSzolo.png"));
            break;
        case 'H':
            GenjiSlot3.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiClover.png"));
            break;
        case 'D':
            GenjiSlot3.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiSurik.png"));
            break;
        case '7':
            GenjiSlot3.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/Genji7.png"));
            break;
        case 'W':
            GenjiSlot3.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiWILD.png"));
            break;
        case 'O':
            GenjiSlot3.setImage(new Image("/images/GenjiSlot/GenjiSlotIcons/GenjiOw.png"));
            break;
        default:
            break;
        }
        boolean nyert = false;
        if(Slotertek[0] == 'C' && Slotertek[1] == 'C' && Slotertek[2] == 'C'){
            jatekospenz2 += (GenjiTét/500) * 1500;
            GenjiNyertOsszeg(((GenjiTét/500) * 1500));
            nyert = true;
        }else if(Slotertek[0] == 'S' && Slotertek[1] == 'S' && Slotertek[2] == 'S'){
            jatekospenz2 += (GenjiTét/500) * 3000;
            GenjiNyertOsszeg(((GenjiTét/500) * 3000));
            nyert = true;
        }else if(Slotertek[0] == 'H' && Slotertek[1] == 'H' && Slotertek[2] == 'H'){
            jatekospenz2 += (GenjiTét/500) * 5000;
            GenjiNyertOsszeg(((GenjiTét/500) * 5000));
            nyert = true;
        }else if(Slotertek[0] == 'D' && Slotertek[1] == 'D' && Slotertek[2] == 'D'){
            jatekospenz2 += (GenjiTét/500) * 10000;
            GenjiNyertOsszeg(((GenjiTét/500) * 1000));
            nyert = true;
        }else if(Slotertek[0] == '7' && Slotertek[1] == '7' && Slotertek[2] == '7'){
            jatekospenz2 += (GenjiTét/500) * 15000;
            GenjiNyertOsszeg(((GenjiTét/500) * 15000));
            nyert = true;
        }else if(Slotertek[0] == 'W' && Slotertek[1] == 'W' && Slotertek[2] == 'W'){
            jatekospenz2 += (GenjiTét/500) * 100000;
            GenjiNyertOsszeg(((GenjiTét/500) * 100000));
            nyert = true;
        }else if((Slotertek[0] == 'O' && Slotertek[1] != 'O' && Slotertek[2] != 'O') ||
                (Slotertek[0] != 'O' && Slotertek[1] == 'O' && Slotertek[2] != 'O') ||
                (Slotertek[0] != 'O' && Slotertek[1] != 'O' && Slotertek[2] == 'O')){
            jatekospenz2 += (GenjiTét/500) * 250;
            GenjiNyertOsszeg(((GenjiTét/500) * 250));
            nyert = true;
        }else if((Slotertek[0] == 'O' && Slotertek[1] == 'O' && Slotertek[2] != 'O') ||
                (Slotertek[0] == 'O' && Slotertek[1] != 'O' && Slotertek[2] == 'O') ||
                (Slotertek[0] != 'O' && Slotertek[1] == 'O' && Slotertek[2] == 'O')){
            jatekospenz2 += (GenjiTét/500) * 1000;
            GenjiNyertOsszeg(((GenjiTét/500) * 1000));
            nyert = true;
        }else if(Slotertek[0] == 'O' && Slotertek[1] == 'O' && Slotertek[2] == 'O'){
            jatekospenz2 += (GenjiTét/500) * 25000;
            GenjiNyertOsszeg(((GenjiTét/500) * 25000));
            nyert = true;
        }
        if(nyert){
            ChipMoney.setText("" + jatekospenz2);
            global.saveData(id, jatekospenz, jatekospenz2, nem, hajszem, Kellekek);
        }
        }
    }
    
    //--------------------------------Genji's Slot----VÉGE----------------------

    @FXML
    private Button ProfilKep;
    
    String id = "";
    String nem = "", hajszem = "";
    String[] Kellekek = new String[4];
    
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
    
}
