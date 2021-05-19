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
import java.util.*;

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
    private ImageView kocka1;

    @FXML
    private ImageView kocka2;

    @FXML
    private ImageView kocka3;

    @FXML
    private ImageView kocka4;

    @FXML
    private ImageView kocka5;

    @FXML
    private ImageView kocka6;
    @FXML
    private Label eredmenyLabel;

    @FXML
    void MoreButtonPushed() {

        if(bet < 10000) {
            bet += 1000;
        }
        BetLabel.setText("" + bet);
    }

    @FXML
    void LessButtonPushed() {
        if(bet > 1000) {
            bet -= 1000;
        }
        BetLabel.setText("" + bet);
    }

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
            return "6 különböző kocka";

        }
        if (dobas[0] == dobas[5]) {
            return "6 egyforma kocka";
        }
        if (dobas[0] == dobas[4] || dobas[1] == dobas[5]) {
            return "5 egyforma kocka";
        }
        if (dobas[0] == dobas[3] || dobas[1] == dobas[4] || dobas[2] == dobas[5]) {
            return "4 egyforma kocka";
        }
        if(tripla_darab > 0 && par_darab > 0)
        {
            return par_darab + " pár " + tripla_darab + " tripla";
        }
        if(tripla_darab > 0)
        {
            return tripla_darab + " tripla";
        }
        if(par_darab > 0)
        {
            return par_darab + " pár";
        }


        return "Semmi";
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
                return 2;

            return 1;
        }
        if(par_darab > 1)
        {
            if(par_darab == 3)
                return 2;

            return 1;
        }

        return 0;
    }

    @FXML
    void Start(ActionEvent event) {
        JpaCasinoDAO userDAO = new JpaCasinoDAO();
        List<User2> Profile = userDAO.getUser();
        if ((jatekospenz2 + jatekospenz) - bet > 0) {

            int[] dobas = jatekosDobas();

            Arrays.sort(dobas);


            if (jatekospenz + jatekospenz2 > 0) {


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
            }


            switch (szorzo(dobas)) {
                case 1:
                    eredmenyLabel.setText("Nyeremény: " + bet + "\n" + eredmeny(dobas));
                    jatekospenz2 += bet;
                    BankMoney.setText("" + jatekospenz);
                    ChipMoney.setText("" + jatekospenz2);

                    for(var a : Profile) {
                        if (id.equals(a.getSetID())) {
                            nyereseg.set(a.getLogin_db(),a.getNyereseg().get(a.getLogin_db())+bet);
                            a.setNyereseg(nyereseg);
                            userDAO.saveUser(a);
                        }
                    }
                    break;
                case 2:
                    eredmenyLabel.setText("Nyeremény: " + bet * 2 + "\n" + eredmeny(dobas));
                    jatekospenz2 += bet * 2;
                    BankMoney.setText("" + jatekospenz);
                    ChipMoney.setText("" + jatekospenz2);
                    for(var a : Profile) {
                        if (id.equals(a.getSetID())) {
                            nyereseg.set(a.getLogin_db(),a.getNyereseg().get(a.getLogin_db())+bet*2);
                            a.setNyereseg(nyereseg);
                            userDAO.saveUser(a);
                        }
                    }
                    break;
                case 3:
                    eredmenyLabel.setText("Nyeremény: " + bet * 3 + "\n" + eredmeny(dobas));
                    jatekospenz2 += bet * 3;
                    BankMoney.setText("" + jatekospenz);
                    ChipMoney.setText("" + jatekospenz2);
                    for(var a : Profile) {
                        if (id.equals(a.getSetID())) {
                            nyereseg.set(a.getLogin_db(),a.getNyereseg().get(a.getLogin_db())+bet*3);
                            a.setNyereseg(nyereseg);
                            userDAO.saveUser(a);
                        }
                    }
                    break;
                case 4:
                    eredmenyLabel.setText("Nyeremény: " + bet * 4 + "\n" + eredmeny(dobas));
                    jatekospenz2 += bet * 4;
                    BankMoney.setText("" + jatekospenz);
                    ChipMoney.setText("" + jatekospenz2);
                    for(var a : Profile) {
                        if (id.equals(a.getSetID())) {
                            nyereseg.set(a.getLogin_db(),a.getNyereseg().get(a.getLogin_db())+bet*4);
                            a.setNyereseg(nyereseg);
                            userDAO.saveUser(a);
                        }
                    }
                    break;
                case 5:
                    eredmenyLabel.setText("Nyeremény: " + bet * 5 + "\n" + eredmeny(dobas));
                    jatekospenz2 += bet * 5;
                    BankMoney.setText("" + jatekospenz);
                    ChipMoney.setText("" + jatekospenz2);
                    for(var a : Profile) {
                        if (id.equals(a.getSetID())) {
                            nyereseg.set(a.getLogin_db(),a.getNyereseg().get(a.getLogin_db())+bet*5);
                            a.setNyereseg(nyereseg);
                            userDAO.saveUser(a);
                        }
                    }
                    break;
                case 6:
                    eredmenyLabel.setText("Nyeremény: " + bet * 6 + "\n" + eredmeny(dobas));
                    jatekospenz2 += bet * 6;
                    BankMoney.setText("" + jatekospenz);
                    ChipMoney.setText("" + jatekospenz2);
                    for(var a : Profile) {
                        if (id.equals(a.getSetID())) {
                            nyereseg.set(a.getLogin_db(),a.getNyereseg().get(a.getLogin_db())+bet*6);
                            a.setNyereseg(nyereseg);
                            userDAO.saveUser(a);
                        }
                    }
                    break;
                default:
                    eredmenyLabel.setText("Nem nyertél!\n" + eredmeny(dobas));
            }

            switch (dobas[0]) {
                case 1:
                    kocka1.setImage(new Image("/images/Dice/egy.png"));
                    break;
                case 2:
                    kocka1.setImage(new Image("/images/Dice/ketto.png"));
                    break;
                case 3:
                    kocka1.setImage(new Image("/images/Dice/harom.png"));
                    break;
                case 4:
                    kocka1.setImage(new Image("/images/Dice/negy.png"));
                    break;
                case 5:
                    kocka1.setImage(new Image("/images/Dice/ot.png"));
                    break;
                case 6:
                    kocka1.setImage(new Image("/images/Dice/hat.png"));
                    break;
            }
            switch (dobas[1]) {
                case 1:
                    kocka2.setImage(new Image("/images/Dice/egy.png"));
                    break;
                case 2:
                    kocka2.setImage(new Image("/images/Dice/ketto.png"));
                    break;
                case 3:
                    kocka2.setImage(new Image("/images/Dice/harom.png"));
                    break;
                case 4:
                    kocka2.setImage(new Image("/images/Dice/negy.png"));
                    break;
                case 5:
                    kocka2.setImage(new Image("/images/Dice/ot.png"));
                    break;
                case 6:
                    kocka2.setImage(new Image("/images/Dice/hat.png"));
                    break;
            }
            switch (dobas[2]) {
                case 1:
                    kocka3.setImage(new Image("/images/Dice/egy.png"));
                    break;
                case 2:
                    kocka3.setImage(new Image("/images/Dice/ketto.png"));
                    break;
                case 3:
                    kocka3.setImage(new Image("/images/Dice/harom.png"));
                    break;
                case 4:
                    kocka3.setImage(new Image("/images/Dice/negy.png"));
                    break;
                case 5:
                    kocka3.setImage(new Image("/images/Dice/ot.png"));
                    break;
                case 6:
                    kocka3.setImage(new Image("/images/Dice/hat.png"));
                    break;
            }
            switch (dobas[3]) {
                case 1:
                    kocka4.setImage(new Image("/images/Dice/egy.png"));
                    break;
                case 2:
                    kocka4.setImage(new Image("/images/Dice/ketto.png"));
                    break;
                case 3:
                    kocka4.setImage(new Image("/images/Dice/harom.png"));
                    break;
                case 4:
                    kocka4.setImage(new Image("/images/Dice/negy.png"));
                    break;
                case 5:
                    kocka4.setImage(new Image("/images/Dice/ot.png"));
                    break;
                case 6:
                    kocka4.setImage(new Image("/images/Dice/hat.png"));
                    break;
            }
            switch (dobas[4]) {
                case 1:
                    kocka5.setImage(new Image("/images/Dice/egy.png"));
                    break;
                case 2:
                    kocka5.setImage(new Image("/images/Dice/ketto.png"));
                    break;
                case 3:
                    kocka5.setImage(new Image("/images/Dice/harom.png"));
                    break;
                case 4:
                    kocka5.setImage(new Image("/images/Dice/negy.png"));
                    break;
                case 5:
                    kocka5.setImage(new Image("/images/Dice/ot.png"));
                    break;
                case 6:
                    kocka5.setImage(new Image("/images/Dice/hat.png"));
                    break;
            }
            switch (dobas[5]) {
                case 1:
                    kocka6.setImage(new Image("/images/Dice/egy.png"));
                    break;
                case 2:
                    kocka6.setImage(new Image("/images/Dice/ketto.png"));
                    break;
                case 3:
                    kocka6.setImage(new Image("/images/Dice/harom.png"));
                    break;
                case 4:
                    kocka6.setImage(new Image("/images/Dice/negy.png"));
                    break;
                case 5:
                    kocka6.setImage(new Image("/images/Dice/ot.png"));
                    break;
                case 6:
                    kocka6.setImage(new Image("/images/Dice/hat.png"));
                    break;
            }

            global.saveData(id, jatekospenz, jatekospenz2, nem, hajszem, Kellekek);


        }
    }
    /////////////////
    ////////////////



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
