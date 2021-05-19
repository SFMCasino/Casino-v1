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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */
public class CasinoProfileController implements Initializable {
    
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
    void MenuWheelButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Wheel");
    }

    @FXML
    void MenuSlotIIButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "SlotII");
    }
    
      @FXML
    private Label KNev, VNev, Nem, Datum, Mail, Bankszam, AccID, ONYP;

    @FXML
    private LineChart<String, Number> MoneyChart;

    
    List<Integer> penzmozgas = new ArrayList<>();
    
    @FXML
    private Label BankMoney,ChipMoney,getID;

    @FXML
    private Button ProfilKep;
    @FXML
    private Pane ProfileAvataros;
    
    String id = "";
    String nem = "", hajszem = "";
    String[] Kellekek = new String[4];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    int jatekospenz = 0;
    int jatekospenz2 = 0;

    public void Adatatvitel(String ID){
        id = ID;
        JpaCasinoDAO userDAO = new JpaCasinoDAO();
        List<User2> Profile = userDAO.getUser();
        int maxlogin = 0;
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
                //KNev, VNev, Nem, Datum, Mail, Bankszam, AccID, ONYP
                KNev.setText(a.getKnev());
                VNev.setText(a.getVnev());
                Nem.setText((Integer.parseInt(a.getJatekos_neme()) == 0) ? "Férfi" : "Nö");
                Datum.setText(a.getDatum());
                Mail.setText(a.getEmail());
                Bankszam.setText(a.getCreditCardNumber());
                AccID.setText(a.getSetID());
                ONYP.setText(""+global.getOssznyeremeny(a.getNyereseg()));

                maxlogin = a.getLogin_db();
                int[] nyeresegek = new int[maxlogin+1];
                int[] veresegek = new int[maxlogin+1];
                for(int i = 0; i <= maxlogin; i++){
                    nyeresegek[i] = a.getNyereseg().get(i);
                    veresegek[i] = a.getVeszteseg().get(i);
                }
                XYChart.Series<String, Number> penzm = new XYChart.Series<String, Number>();
                XYChart.Series<String, Number> penzm2 = new XYChart.Series<String, Number>();
                penzm.setName("Nyert");
                penzm2.setName("Bukott");

                for (int i = 0; i <= maxlogin; i++) {
                    penzm.getData().add(new XYChart.Data<String, Number>("Belépés: "+i, nyeresegek[i]));
                    penzm2.getData().add(new XYChart.Data<String, Number>("Belépés: "+i, veresegek[i]));
                }
                MoneyChart.getData().addAll(penzm,penzm2);
                break;
            }
        }
        ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
        ProfileAvataros.setStyle(global.ProfilKepCsere(nem, hajszem));
    }
    
}
