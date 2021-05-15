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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
                if(Integer.parseInt(Kellekek[0]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)+1);
                    Kellekek = KepDataCsere(Kellekek,1);
                }else if(Integer.parseInt(Kellekek[2]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)-1);
                    Kellekek = KepDataCsere(Kellekek,1);
                }else if(Integer.parseInt(Kellekek[3]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)-2);
                    Kellekek = KepDataCsere(Kellekek,1);
                }
            }else if(jatekospenz2 >= 45000){
                jatekospenz2 -= 45000;
                Kellekek[1] = "1";
                ChipMoney.setText("" + jatekospenz2);
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
                if(Integer.parseInt(Kellekek[0]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)+2);
                    Kellekek = KepDataCsere(Kellekek,2);
                }else if(Integer.parseInt(Kellekek[1]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)+1);
                    Kellekek = KepDataCsere(Kellekek,2);
                }else if(Integer.parseInt(Kellekek[3]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)-1);
                    Kellekek = KepDataCsere(Kellekek,2);
                }
            }else if(jatekospenz2 >= 66000){
                jatekospenz2 -= 66000;
                Kellekek[2] = "1";
                ChipMoney.setText("" + jatekospenz2);
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
                if(Integer.parseInt(Kellekek[0]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)+3);
                    Kellekek = KepDataCsere(Kellekek,3);
                }else if(Integer.parseInt(Kellekek[1]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)+2);
                    Kellekek = KepDataCsere(Kellekek,3);
                }else if(Integer.parseInt(Kellekek[2]) == 2){
                    hajszem = "" + (Integer.parseInt(hajszem)+1);
                    Kellekek = KepDataCsere(Kellekek,3);
                }
            }else if(jatekospenz2 >= 142000){
                jatekospenz2 -= 142000;
                Kellekek[3] = "1";
                ChipMoney.setText("" + jatekospenz2);
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
        String kisid = ID;
        id = ID;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.home") + File.separator + (ID+".txt")))){
            String[] penzek = bufferedReader.readLine().split(":");
            getID.setText(kisid);
            BankMoney.setText(penzek[0]);
            ChipMoney.setText(penzek[1]);
            nem = penzek[2];
            hajszem = penzek[3];
            jatekospenz = Integer.parseInt(penzek[0]);
            jatekospenz2 = Integer.parseInt(penzek[1]);
            for (int i = 4; i < penzek.length; i++) {
                Kellekek[i-4] = penzek[i];
            }
            ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
            BoltAvatarCheck.setStyle(global.ProfilKepCsere(nem, hajszem));
        } catch (FileNotFoundException e) {
            // Exception handling
        } catch (IOException e) {
            // Exception handling
        }
        
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
