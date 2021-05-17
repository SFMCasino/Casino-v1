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
import java.util.Arrays;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */
public class CasinoDiceController implements Initializable {
    
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
    
    //////////////////
    /////////////////

    Random rand = new Random();

    @FXML
    private Label kocka1Label;
    @FXML
    private Label kocka2Label;
    @FXML
    private Label kocka3Label;
    @FXML
    private Label kocka4Label;
    @FXML
    private Label kocka5Label;
    @FXML
    private Label kocka6Label;
    @FXML
    private Label eredmenyLabel;

    public  int[] jatekosDobas(){

        int[] dobas = new int[6];


        for (int i = 0; i < 6; i++) {
            dobas[i] = rand.nextInt(6)+1;
        }

        return dobas;
    }

    public String eredmeny(int dobas[]){

        int kulonbozo = 1;
        int egyezo = 1;
        int par_darab = 0;
        int tripla_darab = 0;


        for (int i = 1; i < 6; i++) {
            if((dobas[i]-1) == (dobas[i-1]))
            {
                kulonbozo++;
            }
            if((dobas[i] == dobas[i-1]))
            {
                egyezo++;
            }
            else if( egyezo == 2 )
            {
                par_darab++;
                egyezo = 1;
            }
            else if(egyezo == 3)
            {
                tripla_darab++;
                egyezo = 1;
            }

            if(i==5)    //  az utolsót is nézze, else miatt nem nézi
            {
                if( egyezo == 2 )
                {
                    par_darab++;
                }
                if(egyezo == 3)
                {
                    tripla_darab++;
                }
            }
        }

        if(kulonbozo == 6)
        {
            return "6 különböző";

        }
        if (dobas[0] == dobas[5]) {
            return "6 egyforma";
        }
        if (dobas[0] == dobas[4] || dobas[1] == dobas[5]) {
            return "5 egyforma";
        }
        if (dobas[0] == dobas[3] || dobas[1] == dobas[4] || dobas[2] == dobas[5]) {
            return "4 egyforma";
        }
        if(tripla_darab > 0 && par_darab > 0)
        {
            return par_darab + " par " + tripla_darab + " tripla";
        }
        if(tripla_darab > 0)
        {
            return tripla_darab + " tripla";
        }
        if(par_darab > 0)
        {
            return par_darab + " par";
        }


        return "semmi";
    }

    public int szorzo(int dobas[]){

        int kulonbozo = 1;
        int egyezo = 1;
        int par_darab = 0;
        int tripla_darab = 0;


        for (int i = 1; i < 6; i++) {
            if((dobas[i]-1) == (dobas[i-1]))
            {
                kulonbozo++;
            }
            if((dobas[i] == dobas[i-1]))
            {
                egyezo++;
            }
            else if( egyezo == 2 )
            {
                par_darab++;
                egyezo = 1;
            }
            else if(egyezo == 3)
            {
                tripla_darab++;
                egyezo = 1;
            }

            if(i==5)    //  az utolsót is nézze, else miatt nem nézi
            {
                if( egyezo == 2 )
                {
                    par_darab++;
                }
                if(egyezo == 3)
                {
                    tripla_darab++;
                }
            }
        }

        if(kulonbozo == 6)
        {
            return 6;

        }
        if (dobas[0] == dobas[5]) {
            return 6;
        }
        if (dobas[0] == dobas[4] || dobas[1] == dobas[5]) {
            return 5;
        }
        if (dobas[0] == dobas[3] || dobas[1] == dobas[4] || dobas[2] == dobas[5]) {
            return 4;
        }
        if(tripla_darab > 0 && par_darab > 0)
        {
            return 3;
        }
        if(tripla_darab > 0)
        {
            if(tripla_darab > 1)
                return 3;

            return 1;
        }
        if(par_darab > 0)
        {
            if(par_darab == 3)
                return 3;

            if(par_darab == 2)
                return 2;

            return 1;
        }


        return 0;
    }

    @FXML
    void Start(ActionEvent event) {

        int[] dobas = jatekosDobas();


        Arrays.sort(dobas);

        kocka1Label.setText(""+dobas[0]);
        kocka2Label.setText(""+dobas[1]);
        kocka3Label.setText(""+dobas[2]);
        kocka4Label.setText(""+dobas[3]);
        kocka5Label.setText(""+dobas[4]);
        kocka6Label.setText(""+dobas[5]);


        eredmenyLabel.setText(eredmeny(dobas));

    }

    /////////////////
    ////////////////

    @FXML
    private Label BankMoney,ChipMoney,getID;

    @FXML
    private Button ProfilKep;
    
    String id = "";
    int jatekospenz = 0;
    int jatekospenz2 = 0;
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
                break;
            }
        }
        ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
    }
}
