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
public class CasinoBJController implements Initializable {
    
    @FXML
    void MenuCloseButton(ActionEvent event){
        if(!BJSTOP){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
        }
    }
    
    Globalis global = new Globalis();
    
    @FXML
    void MenuFooldalGomb(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "Fomenu");
        }
    }
    
    @FXML
    void MenuKijelentkezesButton(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "Login");
        }
    }

    @FXML
    void MenuRouletteButton(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "Roulette");
        }
    }
    
    @FXML
    void MenuProfileButton(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "Profile");
        }
    }

    @FXML
    void MenuBoltButton(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "Bolt");
        }
    }

    @FXML
    void MenuCoinButton(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "Coin");
        }
    }

    @FXML
    void MenuDiceButton(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "Dice");
        }
    }

    @FXML
    void MenuFeltoltesButton(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "Feltoltes");
        }
    }

    @FXML
    void MenuSlotIButton(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "SlotI");
        }
    }

    @FXML
    void MenuWheelButton(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "Wheel");
        }
    }

    @FXML
    void MenuSlotIIButton(ActionEvent event) throws IOException {
        if(!BJSTOP){
        global.LoadScene(event, getID.getText(), "SlotII");
        }
    }
    
    
     //--------------------------------BlackJack------ELEJE----------------------
    @FXML
    private Label MegrakottTet,BJOcards, BJJcards,BankMoney,ChipMoney,getID;
    @FXML
    private ImageView osztoc1,osztoc2,osztoc3,osztoc4,osztoc5,osztoc6,osztoc7,osztoc8,osztoc9,osztoc10,osztoc11,
            jatekosc1,jatekosc2,jatekosc3,jatekosc4,jatekosc5,jatekosc6,jatekosc7,jatekosc8,jatekosc9,jatekosc10,jatekosc11;
    
    private int BJTét = 0;
    private boolean BJToggleGomb = false;
    int jatekospenz = 0;
    int jatekospenz2 = 0;
    int cards[] = new int[53];
    boolean BJkor = true; //Játékos: true, Osztó: false
    boolean BJvalasztas = false; //Játékos léphet: true, Osztás folyamatban: false
    boolean BJSTOP = false; //ha a játék folyamatban van: true
    int BJjatekos[] = new int[11];
    int BJoszto[] = new int[11];
    int BJsplit[] = new int[11];
    int elsoketto = 0;
    int osztocard2 = 0;
    boolean BJOAceOut = false;
    boolean BJJAceOut = false;
    boolean BJosztoace = false;
    boolean BJjatekosace = false;
    int BJk = 2;
    int bjtet = 0;
    //----------------------------------Tét Gombok
    
    @FXML
    void BJToggleButton(ActionEvent event) {
        BJToggleGomb = !BJToggleGomb;
    }
    
    @FXML
    void BJ10KGomb(ActionEvent event) {
        Tetrakas(10000);
    }

    @FXML
    void BJ1KGomb(ActionEvent event) {
        Tetrakas(1000);
    }

    @FXML
    void BJ2KGomb(ActionEvent event) {
        Tetrakas(2000);
    }

    @FXML
    void BJ500Gomb(ActionEvent event) {
        Tetrakas(500);
    }

    @FXML
    void BJ5KGomb(ActionEvent event) {
        Tetrakas(5000);
    }
    //Működés
 
    @FXML
    void BJStart(ActionEvent event) throws InterruptedException {
        BJStart();
    }
    @FXML
    void BJDuplaGombPressed(ActionEvent event) {
        BJDupla();
    }
    @FXML
    void BJKartyaGombPressed(ActionEvent event) {
        Kartya();
    }
    @FXML
    void BJMegalGombPressed(ActionEvent event) {
        Megall();
    }
    
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
                break;
            }
        }
        ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
    }
    
    //Metódusok
    Image CardStyle(int number){
        Image file = new Image("/images/kartyak/SFMBJhatlap.png");
        switch (number) {
            case 0:
                file = new Image("/images/kartyak/SFMBJhatlap.png");
                break;
            case 1:
                file = new Image("/images/kartyak/kor/BJKA.png");
                break;
            case 2:
                file = new Image("/images/kartyak/kor/BJK2.png");
                break;
            case 3:
                file = new Image("/images/kartyak/kor/BJK3.png");
                break;
            case 4:
                file = new Image("/images/kartyak/kor/BJK4.png");
                break;
            case 5:
                file = new Image("/images/kartyak/kor/BJK5.png");
                break;
            case 6:
                file = new Image("/images/kartyak/kor/BJK6.png");
                break;
            case 7:
                file = new Image("/images/kartyak/kor/BJK7.png");
                break;
            case 8:
                file = new Image("/images/kartyak/kor/BJK8.png");
                break;
            case 9:
                file = new Image("/images/kartyak/kor/BJK9.png");
                break;
            case 10:
                file = new Image("/images/kartyak/kor/BJK10.png");
                break;
            case 11:
                file = new Image("/images/kartyak/kor/BJKJ.png");
                break;
            case 12:
                file = new Image("/images/kartyak/kor/BJKQ.png");
                break;
            case 13:
                file = new Image("/images/kartyak/kor/BJKK.png");
                break;
            case 14:
                file = new Image("/images/kartyak/diamond/BJDA.png");
                break;
            case 15:
                file = new Image("/images/kartyak/diamond/BJD2.png");
                break;
            case 16:
                file = new Image("/images/kartyak/diamond/BJD3.png");
                break;
            case 17:
                file = new Image("/images/kartyak/diamond/BJD4.png");
                break;
            case 18:
                file = new Image("/images/kartyak/diamond/BJD5.png");
                break;
            case 19:
                file = new Image("/images/kartyak/diamond/BJD6.png");
                break;
            case 20:
                file = new Image("/images/kartyak/diamond/BJD7.png");
                break;
            case 21:
                file = new Image("/images/kartyak/diamond/BJD8.png");
                break;
            case 22:
                file = new Image("/images/kartyak/diamond/BJD9.png");
                break;
            case 23:
                file = new Image("/images/kartyak/diamond/BJD10.png");
                break;
            case 24:
                file = new Image("/images/kartyak/diamond/BJDJ.png");
                break;
            case 25:
                file = new Image("/images/kartyak/diamond/BJDQ.png");
                break;
            case 26:
                file = new Image("/images/kartyak/diamond/BJDK.png");
                break;
            case 27:
                file = new Image("/images/kartyak/pikk/BJPA.png");
                break;
            case 28:
                file = new Image("/images/kartyak/pikk/BJP2.png");
                break;
            case 29:
                file = new Image("/images/kartyak/pikk/BJP3.png");
                break;
            case 30:
                file = new Image("/images/kartyak/pikk/BJP4.png");
                break;
            case 31:
                file = new Image("/images/kartyak/pikk/BJP5.png");
                break;
            case 32:
                file = new Image("/images/kartyak/pikk/BJP6.png");
                break;
            case 33:
                file = new Image("/images/kartyak/pikk/BJP7.png");
                break;
            case 34:
                file = new Image("/images/kartyak/pikk/BJP8.png");
                break;
            case 35:
                file = new Image("/images/kartyak/pikk/BJP9.png");
                break;
            case 36:
                file = new Image("/images/kartyak/pikk/BJP10.png");
                break;
            case 37:
                file = new Image("/images/kartyak/pikk/BJPJ.png");
                break;
            case 38:
                file = new Image("/images/kartyak/pikk/BJPQ.png");
                break;
            case 39:
                file = new Image("/images/kartyak/pikk/BJPK.png");
                break;
            case 40:
                file = new Image("/images/kartyak/treff/BJTA.png");
                break;
            case 41:
                file = new Image("/images/kartyak/treff/BJT2.png");
                break;
            case 42:
                file = new Image("/images/kartyak/treff/BJT3.png");
                break;
            case 43:
                file = new Image("/images/kartyak/treff/BJT4.png");
                break;
            case 44:
                file = new Image("/images/kartyak/treff/BJT5.png");
                break;
            case 45:
                file = new Image("/images/kartyak/treff/BJT6.png");
                break;
            case 46:
                file = new Image("/images/kartyak/treff/BJT7.png");
                break;
            case 47:
                file = new Image("/images/kartyak/treff/BJT8.png");
                break;
            case 48:
                file = new Image("/images/kartyak/treff/BJT9.png");
                break;
            case 49:
                file = new Image("/images/kartyak/treff/BJT10.png");
                break;
            case 50:
                file = new Image("/images/kartyak/treff/BJTJ.png");
                break;
            case 51:
                file = new Image("/images/kartyak/treff/BJTQ.png");
                break;
            case 52:
                file = new Image("/images/kartyak/treff/BJTK.png");
                break;
            default:
                break;
        }
        return file;
    }
    
    void BJHideCards() {
        for(int i = 0; i < 11; i++){
            BJjatekos[i] = 0;
            BJoszto[i] = 0;
            BJsplit[i] = 0;
        }
        jatekosc1.setImage(new Image("/images/kartyak/HiddenCard.png"));
        jatekosc2.setImage(new Image("/images/kartyak/HiddenCard.png"));
        jatekosc3.setImage(new Image("/images/kartyak/HiddenCard.png"));
        jatekosc4.setImage(new Image("/images/kartyak/HiddenCard.png"));
        jatekosc5.setImage(new Image("/images/kartyak/HiddenCard.png"));
        jatekosc6.setImage(new Image("/images/kartyak/HiddenCard.png"));
        jatekosc7.setImage(new Image("/images/kartyak/HiddenCard.png"));
        jatekosc8.setImage(new Image("/images/kartyak/HiddenCard.png"));
        jatekosc9.setImage(new Image("/images/kartyak/HiddenCard.png"));
        jatekosc10.setImage(new Image("/images/kartyak/HiddenCard.png"));
        jatekosc11.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc1.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc2.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc3.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc4.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc5.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc6.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc7.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc8.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc9.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc10.setImage(new Image("/images/kartyak/HiddenCard.png"));
        osztoc11.setImage(new Image("/images/kartyak/HiddenCard.png"));
    }
    
    
    int[] Pakli() {
        int cardss[] = new int[53];
        cardss[0] = 0;
        int kartyaertek = 1;
        for(int i = 1; i < 53; i++){
            cardss[i] = kartyaertek++;
            if(kartyaertek > 13) kartyaertek = 1;
        }
        for(int i = 1; i < 53; i++){
            if(cardss[i] > 10) cardss[i] = 10;
            if(cardss[i] == 1) cardss[i] = 11;
        }
        return cardss;
    }
    
    int RandomKartya(){
        int randomcard = 0;
        Random rand = new Random();
        randomcard = rand.nextInt((52-1) + 1) + 1;
        return randomcard;
    }
    
    int BJSumCards(int[] a){
        int b = 0;
        for(int i = 0; i < a.length; i++){
            b += a[i];
        }
        return b;
    }
    
    boolean BJCheckAce(int[] a) {
        int ace = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == 11) ace++;
        }
        if(ace == 0) return false;
        else return true;
    }
    
    
    void Tetrakas(int o){
        if(!BJSTOP){
            if(!BJToggleGomb){
                BJTét += o;
            }else{
                BJTét -= o; 
            }
            if(BJTét < 0){
                BJTét = 0;
            }
            if(BJTét > 50000){
                BJTét = 50000;
            }
            if(BJTét > (jatekospenz + jatekospenz2)) BJTét = jatekospenz + jatekospenz2;
            MegrakottTet.setText("Tét: " + BJTét);
        }
    }
    
    void BJStart(){
        if(!BJSTOP && BJTét != 0){
            bjtet = 0;
        if(jatekospenz-BJTét < 0){
            bjtet = BJTét-jatekospenz;
            jatekospenz = 0;
            jatekospenz2 -= bjtet;
            BankMoney.setText("" + jatekospenz);
            ChipMoney.setText("" + jatekospenz2);
        }else{
            jatekospenz -= BJTét;
            bjtet = BJTét;
            BankMoney.setText("" + jatekospenz);
        }
        global.saveData(id,jatekospenz,jatekospenz2,nem,hajszem,Kellekek);
        BJOAceOut = false;
        BJJAceOut = false;
        BJSTOP = true;
        BJk = 2;
        BJHideCards();
        cards = Pakli();
        elsoketto = 0;
        int rcard = 0;
        while(elsoketto < 2){
            if(BJkor){
                if(elsoketto == 0){
                    rcard = RandomKartya();
                    jatekosc1.setImage(CardStyle(rcard));
                    BJjatekos[0] = cards[rcard];
                    cards[rcard] = -1;
                }
                else if(elsoketto == 1){
                    rcard = RandomKartya();
                    if(cards[rcard] == -1){
                        while(cards[rcard] == -1){
                            rcard = RandomKartya();
                        }
                    }
                    jatekosc2.setImage(CardStyle(rcard));
                    BJjatekos[1] = cards[rcard];
                    cards[rcard] = -1;
                }
                BJkor = !BJkor;
            }else{
                if(elsoketto == 0){
                    rcard = RandomKartya();
                    if(cards[rcard] == -1){
                        while(cards[rcard] == -1){
                            rcard = RandomKartya();
                        }
                    }
                    osztoc1.setImage(CardStyle(rcard));
                    BJoszto[0] = cards[rcard];
                    cards[rcard] = -1;
                    BJOcards.setText("Osztó Kártyái: " + BJoszto[0]);
                }
                else if (elsoketto == 1){
                    rcard = RandomKartya();
                    if(cards[rcard] == -1){
                        while(cards[rcard] == -1){
                            rcard = RandomKartya();
                        }
                    }
                    osztoc2.setImage(CardStyle(0));
                    osztocard2 = rcard;
                    BJoszto[1] = cards[rcard];
                    cards[rcard] = -1;
                    BJvalasztas = true;
                }
                BJkor = !BJkor;
                elsoketto++;
            }
            BJjatekosace = BJCheckAce(BJjatekos);
            BJosztoace = BJCheckAce(BJoszto);
        }
        for(int i = 0; i < 11; i++){
            System.out.println("Jatekos: " + BJjatekos[i] + " - Oszto: " + BJoszto[i]);
        }
        BJJcards.setText("Játékos Kártyái: " + BJSumCards(BJjatekos));
        }
    }
    
    void BJDupla(){
        if(BJvalasztas && BJSumCards(BJjatekos) < 21 && BJTét <= (jatekospenz + jatekospenz2) && BJSTOP){
            bjtet = 0;
            if((jatekospenz-BJTét) < 0){
                bjtet = BJTét-jatekospenz;
                jatekospenz = 0;
                jatekospenz2 -= bjtet;
                BankMoney.setText("" + jatekospenz);
                ChipMoney.setText("" + jatekospenz2);
            }else{
                jatekospenz -= BJTét;
                bjtet = BJTét;
                BankMoney.setText("" + jatekospenz);
            }
            int rcard;
            rcard = RandomKartya();
            if(cards[rcard] == -1){
                while(cards[rcard] == -1){
                    rcard = RandomKartya();
                }
            }
            BJTét *= 2;
            BJjatekos[BJk++] = cards[rcard];
            cards[rcard] = -1;
            BJjatekosace = BJCheckAce(BJjatekos);
            jatekosc3.setImage(CardStyle(rcard));
            if(BJjatekosace && BJSumCards(BJjatekos) > 21 && !BJJAceOut){ BJjatekos[0] -= 10; BJJAceOut = true;};
            if(BJSumCards(BJjatekos) <= 21){
                BJJcards.setText("Játékos Kártyái: " + BJSumCards(BJjatekos));
                if(BJSTOP){
                int asd = 2;
                rcard = 0;
                osztoc2.setImage(CardStyle(osztocard2));
                BJOcards.setText("Osztó Kártyái: " + BJSumCards(BJoszto));
                while(BJSumCards(BJoszto) <= 16){
                    rcard = RandomKartya();
                    if(cards[rcard] == -1){
                        while(cards[rcard] == -1){
                            rcard = RandomKartya();
                        }
                    }
                    switch (asd) {
                        case 2:
                            osztoc3.setImage(CardStyle(rcard));
                            break;
                        case 3:
                            osztoc4.setImage(CardStyle(rcard));
                            break;
                        case 4:
                            osztoc5.setImage(CardStyle(rcard));
                            break;
                        case 5:
                            osztoc6.setImage(CardStyle(rcard));
                            break;
                        case 6:
                            osztoc7.setImage(CardStyle(rcard));
                            break;
                        case 7:
                            osztoc8.setImage(CardStyle(rcard));
                            break;
                        case 8:
                            osztoc9.setImage(CardStyle(rcard));
                            break;
                        case 9:
                            osztoc10.setImage(CardStyle(rcard));
                            break;
                        case 10:
                            osztoc11.setImage(CardStyle(rcard));
                            break;
                        default:
                            break;
                    }
                    BJoszto[asd++] = cards[rcard];
                    cards[rcard] = -1;
                    BJosztoace = BJCheckAce(BJoszto);
                    if(BJosztoace && BJSumCards(BJoszto) > 21 && !BJOAceOut){ BJoszto[0] -= 10; BJOAceOut = true;}
                    if(BJSumCards(BJoszto) <= 21){
                        BJOcards.setText("Osztó Kártyái: " + BJSumCards(BJoszto));
                    }else{
                        BJOcards.setText("Osztó Kártyái: Kiégett");
                }
            }
            if(BJSumCards(BJoszto) > BJSumCards(BJjatekos) && BJSumCards(BJoszto) <= 21){
                global.saveData(id,jatekospenz,jatekospenz2,nem,hajszem,Kellekek);
                Alert eredmeny = new Alert(Alert.AlertType.INFORMATION);
                eredmeny.setTitle("Eredmény");
                eredmeny.setHeaderText("Vesztettél");
                eredmeny.showAndWait();
            }else if(BJSumCards(BJoszto) < BJSumCards(BJjatekos) || BJSumCards(BJoszto) > 21){
                jatekospenz2 += BJTét*2;
                ChipMoney.setText("" + jatekospenz2);
                global.saveData(id,jatekospenz,jatekospenz2,nem,hajszem,Kellekek);
                Alert eredmeny = new Alert(Alert.AlertType.INFORMATION);
                eredmeny.setTitle("Eredmény");
                eredmeny.setHeaderText("Gyöztél");
                eredmeny.showAndWait();
            }else if(BJSumCards(BJoszto) == BJSumCards(BJjatekos)){
                jatekospenz += bjtet;
                jatekospenz2 += BJTét-bjtet;
                BankMoney.setText("" + jatekospenz);
                ChipMoney.setText("" + jatekospenz2);
                global.saveData(id,jatekospenz,jatekospenz2,nem,hajszem,Kellekek);
                Alert eredmeny = new Alert(Alert.AlertType.INFORMATION);
                eredmeny.setTitle("Eredmény");
                eredmeny.setHeaderText("Döntetlen");
                eredmeny.showAndWait();
            }
            BJSTOP = false;
        }
                }else{
                    BJJcards.setText("Játékos Kártyái: Kiégett");
                    BJSTOP = false;
                    osztoc2.setImage(CardStyle(osztocard2));
                    BJOcards.setText("Osztó Kártyái: " + BJSumCards(BJoszto));
                    global.saveData(id,jatekospenz,jatekospenz2,nem,hajszem,Kellekek);
                    Alert eredmeny = new Alert(Alert.AlertType.INFORMATION);
                    eredmeny.setTitle("Eredmény");
                    eredmeny.setHeaderText("Vesztettél");
                    eredmeny.showAndWait();
                }
            BJTét /= 2;
        }else{
            Alert eredmeny = new Alert(Alert.AlertType.ERROR);
                    eredmeny.setTitle("Hiba");
                    eredmeny.setHeaderText("Nincs elég pénzed a duplázáshoz");
                    eredmeny.showAndWait();
        }
        
    }
    
    void Kartya(){
        if(BJvalasztas && BJSTOP){
            int rcard;
            rcard = RandomKartya();
            if(cards[rcard] == -1){
                while(cards[rcard] == -1){
                    rcard = RandomKartya();
                }
            }
            if(BJSumCards(BJjatekos) < 21){
                switch(BJk){
                    case 2:
                        jatekosc3.setImage(CardStyle(rcard));
                        break;
                    case 3:
                        jatekosc4.setImage(CardStyle(rcard));
                        break;
                    case 4:
                        jatekosc5.setImage(CardStyle(rcard));
                        break;
                    case 5:
                        jatekosc6.setImage(CardStyle(rcard));
                        break;
                    case 6:
                        jatekosc7.setImage(CardStyle(rcard));
                        break;
                    case 7:
                        jatekosc8.setImage(CardStyle(rcard));
                        break;
                    case 8:
                        jatekosc9.setImage(CardStyle(rcard));
                        break;
                    case 9:
                        jatekosc10.setImage(CardStyle(rcard));
                        break;
                    case 10:
                        jatekosc11.setImage(CardStyle(rcard));
                        break;
                    default:
                        break;
                }
                BJjatekos[BJk++] = cards[rcard];
                cards[rcard] = -1;
                BJjatekosace = BJCheckAce(BJjatekos);
                if(BJjatekosace && BJSumCards(BJjatekos) > 21 && !BJJAceOut){ BJjatekos[0] -= 10; BJJAceOut = true;};
                if(BJSumCards(BJjatekos) <= 21){
                    BJJcards.setText("Játékos Kártyái: " + BJSumCards(BJjatekos));
                }else{
                    BJJcards.setText("Játékos Kártyái: Kiégett");
                    BJSTOP = false;
                    osztoc2.setImage(CardStyle(osztocard2));
                    BJOcards.setText("Osztó Kártyái: " + BJSumCards(BJoszto));
                    global.saveData(id,jatekospenz,jatekospenz2,nem,hajszem,Kellekek);
                    Alert eredmeny = new Alert(Alert.AlertType.INFORMATION);
                    eredmeny.setTitle("Eredmény");
                    eredmeny.setHeaderText("Vesztettél");
                    eredmeny.showAndWait();
                }
            }
        }
    }
    
    void Megall(){
        if(BJSTOP){
            int asd = 2;
            int rcard = 0;
            osztoc2.setImage(CardStyle(osztocard2));
            BJOcards.setText("Osztó Kártyái: " + BJSumCards(BJoszto));
            while(BJSumCards(BJoszto) <= 16){
                rcard = RandomKartya();
                if(cards[rcard] == -1){
                    while(cards[rcard] == -1){
                        rcard = RandomKartya();
                    }
                }
                switch (asd) {
                    case 2:
                        osztoc3.setImage(CardStyle(rcard));
                        break;
                    case 3:
                        osztoc4.setImage(CardStyle(rcard));
                        break;
                    case 4:
                        osztoc5.setImage(CardStyle(rcard));
                        break;
                    case 5:
                        osztoc6.setImage(CardStyle(rcard));
                        break;
                    case 6:
                        osztoc7.setImage(CardStyle(rcard));
                        break;
                    case 7:
                        osztoc8.setImage(CardStyle(rcard));
                        break;
                    case 8:
                        osztoc9.setImage(CardStyle(rcard));
                        break;
                    case 9:
                        osztoc10.setImage(CardStyle(rcard));
                        break;
                    case 10:
                        osztoc11.setImage(CardStyle(rcard));
                        break;
                    default:
                        break;
                }
                BJoszto[asd++] = cards[rcard];
                cards[rcard] = -1;
                BJosztoace = BJCheckAce(BJoszto);
                if(BJosztoace && BJSumCards(BJoszto) > 21 && !BJOAceOut){ BJoszto[0] -= 10; BJOAceOut = true;}
                if(BJSumCards(BJoszto) <= 21){
                    BJOcards.setText("Osztó Kártyái: " + BJSumCards(BJoszto));
                }else{
                    BJOcards.setText("Osztó Kártyái: Kiégett");
                }
            }
            if(BJSumCards(BJoszto) > BJSumCards(BJjatekos) && BJSumCards(BJoszto) <= 21){
                global.saveData(id,jatekospenz,jatekospenz2,nem,hajszem,Kellekek);
                Alert eredmeny = new Alert(Alert.AlertType.INFORMATION);
                eredmeny.setTitle("Eredmény");
                eredmeny.setHeaderText("Vesztettél");
                eredmeny.showAndWait();
            }else if(BJSumCards(BJoszto) < BJSumCards(BJjatekos) || BJSumCards(BJoszto) > 21){
                jatekospenz2 += BJTét*2;
                ChipMoney.setText("" + jatekospenz2);
                global.saveData(id,jatekospenz,jatekospenz2,nem,hajszem,Kellekek);
                Alert eredmeny = new Alert(Alert.AlertType.INFORMATION);
                eredmeny.setTitle("Eredmény");
                eredmeny.setHeaderText("Gyöztél");
                eredmeny.showAndWait();
            }else if(BJSumCards(BJoszto) == BJSumCards(BJjatekos)){
                jatekospenz += bjtet;
                jatekospenz2 += BJTét-bjtet;
                BankMoney.setText("" + jatekospenz);
                ChipMoney.setText("" + jatekospenz2);
                global.saveData(id,jatekospenz,jatekospenz2,nem,hajszem,Kellekek);
                Alert eredmeny = new Alert(Alert.AlertType.INFORMATION);
                eredmeny.setTitle("Eredmény");
                eredmeny.setHeaderText("Döntetlen");
                eredmeny.showAndWait();
            }
            BJSTOP = false;
            
        }
    }
}
