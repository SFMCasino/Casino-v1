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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import hu.unideb.inf.model.JpaCasinoDAO;
import hu.unideb.inf.model.User2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
public class CasinoCoinController implements Initializable {
    
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
    ///////////////////////
    ///////////////////////

    int dobottErtek(){
        int randint = rand.nextInt(2);

        if (randint == 0) {
            ResultImage.setImage(new Image("/images/Coin/tail10.png"));
        }
        else{
            ResultImage.setImage(new Image("/images/Coin/head10.png"));
        }

        return randint;
    }

    @FXML
    private Label BankMoney,ChipMoney,getID;

    ArrayList<Integer> nyereseg = new ArrayList<>();
    ArrayList<Integer> veszteseg = new ArrayList<>();

    int bet = 1000;
    int jatekospenz = 0;
    int jatekospenz2 = 0;
    Random rand = new Random();

    @FXML
    private Label BetLabel;

    @FXML
    private Label ResultLabel;
    @FXML
    private ImageView ResultImage;



    @FXML
    void MoreButtonPushed() {

        if(bet < 10000) {
            bet += 1000;
        }
        BetLabel.setText("" + bet);
        ResultLabel.setText("");

    }

    @FXML
    void LessButtonPushed() {
        if(bet > 1000) {
            bet -= 1000;
        }
        BetLabel.setText("" + bet);
        ResultLabel.setText("");

    }


    //  0-tail  1-head
    @FXML
    void HeadButtonPushed() {
        JpaCasinoDAO userDAO = new JpaCasinoDAO();
        List<User2> Profile = userDAO.getUser();

        if ((jatekospenz2 + jatekospenz) - bet > 0) {

            int eredmeny = dobottErtek();

            if ((jatekospenz + jatekospenz2) >= bet) {
                if (jatekospenz - bet < 0) {
                    int fennmarado = bet - jatekospenz;
                    jatekospenz = 0;
                    jatekospenz2 -= fennmarado;
                    BankMoney.setText("" + jatekospenz);
                    ChipMoney.setText("" + jatekospenz2);
                    for(var a : Profile) {
                        if (id.equals(a.getSetID())) {
                            veszteseg.set(a.getLogin_db(),a.getVeszteseg().get(a.getLogin_db())+bet);
                            a.setVeszteseg(veszteseg);
                            userDAO.saveUser(a);
                        }
                    }
                } else {
                    jatekospenz -= bet;
                    BankMoney.setText("" + jatekospenz);
                    for(var a : Profile) {
                        if (id.equals(a.getSetID())) {
                            veszteseg.set(a.getLogin_db(),a.getVeszteseg().get(a.getLogin_db())+bet);
                            a.setVeszteseg(veszteseg);
                            userDAO.saveUser(a);
                        }
                    }
                }
            }


            if (eredmeny == 1) {
                ResultLabel.setText("Nyertél!");

                jatekospenz2 += bet * 2;

                BankMoney.setText("" + jatekospenz);
                ChipMoney.setText("" + jatekospenz2);

                for(var a : Profile) {
                    if (id.equals(a.getSetID())) {
                        nyereseg.set(a.getLogin_db(),a.getNyereseg().get(a.getLogin_db())+bet);
                        a.setNyereseg(nyereseg);
                        userDAO.saveUser(a);
                    }
                }

            } else {
                ResultLabel.setText("Vesztettél!");
            }

            global.saveData(id, jatekospenz, jatekospenz2, nem, hajszem, Kellekek);
        }
    }



    @FXML
    void TailButtonPushed() {
        JpaCasinoDAO userDAO = new JpaCasinoDAO();
        List<User2> Profile = userDAO.getUser();

        if ((jatekospenz2 + jatekospenz) - bet > 0) {

            int eredmeny = dobottErtek();

            if ((jatekospenz + jatekospenz2) >= bet) {
                if (jatekospenz - bet < 0) {
                    int fennmarado = bet - jatekospenz;
                    jatekospenz = 0;
                    jatekospenz2 -= fennmarado;
                    BankMoney.setText("" + jatekospenz);
                    ChipMoney.setText("" + jatekospenz2);
                    for(var a : Profile) {
                        if (id.equals(a.getSetID())) {
                            veszteseg.set(a.getLogin_db(),a.getVeszteseg().get(a.getLogin_db())+bet);
                            a.setVeszteseg(veszteseg);
                            userDAO.saveUser(a);
                        }
                    }
                } else {
                    jatekospenz -= bet;
                    BankMoney.setText("" + jatekospenz);
                    for(var a : Profile) {
                        if (id.equals(a.getSetID())) {
                            veszteseg.set(a.getLogin_db(),a.getVeszteseg().get(a.getLogin_db())+bet);
                            a.setVeszteseg(veszteseg);
                            userDAO.saveUser(a);
                        }
                    }
                }
            }


            if (eredmeny == 0) {
                ResultLabel.setText("Nyertél!");

                jatekospenz2 += bet * 2;

                BankMoney.setText("" + jatekospenz);
                ChipMoney.setText("" + jatekospenz2);


                for(var a : Profile) {
                    if (id.equals(a.getSetID())) {
                        nyereseg.set(a.getLogin_db(),a.getNyereseg().get(a.getLogin_db())+bet);
                        a.setNyereseg(nyereseg);
                        userDAO.saveUser(a);
                    }
                }

            } else {
                ResultLabel.setText("Vesztettél!");
            }

            global.saveData(id, jatekospenz, jatekospenz2, nem, hajszem, Kellekek);
        }
    }


    //////////////////////
    /////////////////////

    


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
                jatekospenz = a.getJatekospenz();
                jatekospenz2 = a.getJatekospenz2();
                nem = a.getJatekos_neme();
                hajszem = a.getJatekos_hajszem();
                Kellekek[0] = ""+a.getKellekek0();
                Kellekek[1] = ""+a.getKellekek1();
                Kellekek[2] = ""+a.getKellekek2();
                Kellekek[3] = ""+a.getKellekek3();
                for(var b : a.getNyereseg()){
                    nyereseg.add(b);
                }
                for(var b : a.getVeszteseg()){
                    veszteseg.add(b);
                }
                break;
            }
        }
        ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
    }
    
}
