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
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */
public class CasinoWheelController implements Initializable {

    public static double x=0;
    public static double cikk = 17.1428571429;
    public static int elso=0;
    public static int masodik=0;
    public static int nyeremeny=0;

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
    void MenuSlotIButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "SlotI");
    }

    @FXML
    void MenuSlotIIButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "SlotII");
    }

    @FXML
    private Label BankMoney,ChipMoney,getID;
    public ImageView kerekimg;
    public Button wheelButt;

    @FXML
    private Button ProfilKep;


    String id = "";
    String nem = "", hajszem = "";
    String[] Kellekek = new String[4];

    public void fizet()
    {
        masodik += nyeremeny;
        ChipMoney.setText("" + masodik);
        global.saveData(id, elso, masodik, nem, hajszem, Kellekek);
    }

    public void porges()
    {
        RotateTransition kerekrotate = new RotateTransition(Duration.seconds(5), kerekimg);
        double elozo = x;
        randomizal();
        kerekrotate.setByAngle(1800-elozo+x);
        kerekrotate.setRate(5);
        kerekrotate.setCycleCount(1);
        kerekrotate.play();
        kerekrotate.setOnFinished(e -> vissza());
    }

    public void vissza()
    {
        fizet();
        wheelButt.setDisable(false);
    }

    public void randomizal()
    {
        Random rand = new Random();
        int valto = rand.nextInt(1000);
        if(valto<5)
        {
            x = 0;
            nyeremeny = 500000;
        }
        else if(valto<90)
        {
            x = cikk;
            nyeremeny = 500;
        }
        else if(valto<120)
        {
            x = cikk*2;
            nyeremeny = 5000;
        }
        else if(valto<170)
        {
            x = cikk*3;
            nyeremeny = 100;
        }
        else if(valto<260)
        {
            x = cikk*4;
            nyeremeny = 2500;
        }
        else if(valto<280)
        {
            x = cikk*5;
            nyeremeny = 7500;
        }
        else if(valto<320)
        {
            x = cikk*6;
            nyeremeny = 1500;
        }
        else if(valto<370)
        {
            x = cikk*7;
            nyeremeny = 500;
        }
        else if(valto<430)
        {
            x = cikk*8;
            nyeremeny = 2500;
        }
        else if(valto<470)
        {
            x = cikk*9;
            nyeremeny = 1500;
        }
        else if(valto<520)
        {
            x = cikk*10;
            nyeremeny = 500;
        }
        else if(valto<540)
        {
            x = cikk*11;
            nyeremeny = 50000;
        }
        else if(valto<610)
        {
            x = cikk*12;
            nyeremeny = 2500;
        }
        else if(valto<660)
        {
            x = cikk*13;
            nyeremeny = 500;
        }
        else if(valto<690)
        {
            x = cikk*14;
            nyeremeny = 6000;
        }
        else if(valto<740)
        {
            x = cikk*15;
            nyeremeny = 1000;
        }
        else if(valto<780)
        {
            x = cikk*16;
            nyeremeny = 10000;
        }
        else if(valto<840)
        {
            x = cikk*17;
            nyeremeny = 1500;
        }
        else if(valto<890)
        {
            x = cikk*18;
            nyeremeny = 500;
        }
        else if(valto<930)
        {
            x = cikk*19;
            nyeremeny = 10000;
        }
        else
        {
            x = cikk*20;
            nyeremeny = 500;
        }

    }
    int jatekospenz = 0;
    int jatekospenz2 = 0;

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
    }

    public void wheelButtPushed(ActionEvent actionEvent) {
        if(elso >= 5000)
        {
            elso -=5000;
        }
        else if((elso + masodik) >= 5000)
        {
            masodik -= (5000-elso);
            elso = 0;
        }
        BankMoney.setText("" + elso);
        ChipMoney.setText("" + masodik);
        global.saveData(id, elso, masodik, nem, hajszem, Kellekek);
        wheelButt.setDisable(true);
        porges();
    }
}
