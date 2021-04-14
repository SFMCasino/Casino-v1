/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
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
    
    Random rand = new Random();
    
    @FXML
    private Label kocka1Label;
    @FXML
    private Label kocka2Label;
    @FXML
    private Label kocka3Label;
    @FXML
    private Label gep1Label;
    @FXML
    private Label gep2Label;
    @FXML
    private Label gep3Label;
    @FXML
    private Label eredmenyLabel;

    public  int[] jatekosDobas(){
        
           int kocka1 = rand.nextInt(6)+1; 
           int kocka2 = rand.nextInt(6)+1; 
           int kocka3 = rand.nextInt(6)+1; 
           
           while(true)
           {
               if (kocka1 == kocka2 || kocka1 == kocka3 || kocka2 == kocka3 ) {
                   break;
               }
               if (kocka1+kocka2+kocka3 == 6) {
                   break;
               }
               if (kocka1+kocka2+kocka3 == 15) {
                   break;
               }
               
               kocka1 = rand.nextInt(6)+1; 
               kocka2 = rand.nextInt(6)+1; 
               kocka3 = rand.nextInt(6)+1;
           }
           
           int[] dobas = new int[3];
           
           dobas[0] = kocka1;
           dobas[1] = kocka2;
           dobas[2] = kocka3;
           
           return dobas;
    }
    public  int[] gepDobas(){
        
           int kocka1 = rand.nextInt(6)+1; 
           int kocka2 = rand.nextInt(6)+1; 
           int kocka3 = rand.nextInt(6)+1; 
           
           while(true)
           {
               if (kocka1 == kocka2 || kocka1 == kocka3 || kocka2 == kocka3 ) {
                   break;
               }
               if (kocka1+kocka2+kocka3 == 6) {
                   break;
               }
               if (kocka1+kocka2+kocka3 == 15) {
                   break;
               }
               
               kocka1 = rand.nextInt(6)+1; 
               kocka2 = rand.nextInt(6)+1; 
               kocka3 = rand.nextInt(6)+1;
           }
           
           int[] dobas = new int[3];
           
           dobas[0] = kocka1;
           dobas[1] = kocka2;
           dobas[2] = kocka3;
           
           return dobas;
    }
    
    public String eredmeny(int[] jatekos, int[] gep){
        
       
        if (gep[0] == 1 && gep[1] == 2 && gep[2] == 3) {
            return "Nyertél!";  
        }
        
        if (gep[0] == 4 && gep[1] == 5 && gep[2] == 6) {
            return "Vesztettél!";
        }
        
        if (gep[0]==gep[1] && gep[0] == gep[2]) {
            return "Vesztettél!";
        }
        
        if (gep[1] != gep[2] && gep[2] == 6) {
            return "Vesztettél!";
        }
        
        if (gep[0] != gep[1] && gep[0] == 1) {
            return "Nyertél!";
        }
        
        int gep_pont;   //  nincs automata eredmény
        
        if (gep[0] == gep[1]) {
            gep_pont = gep[2];
        }
        else
            gep_pont = gep[0];
        
        if (jatekos[0] == 1 && jatekos[1] == 2 && jatekos[2] == 3) {
            return "Vesztettél!";
        }
        
        if (jatekos[0] == 4 && jatekos[1] == 5 && jatekos[2] == 6) {
            return "Nyertél!";
        }
        
        if (jatekos[0] == jatekos[1] && jatekos[0] == jatekos[2]) {
            return "Nyertél!";
        }
        
        int jatekos_pont;
        
        if(jatekos[0] == jatekos[1]){
            jatekos_pont = jatekos[2];
        }
        else
            jatekos_pont = jatekos[0];
        
        
        if (jatekos_pont > gep_pont) {
            return "Nyertél!";
        }
        else if(gep_pont > jatekos_pont){
            return "Vesztettél!";
        }
        
        
        return "Döntetlen!";
    }
    
    @FXML
    void Start(ActionEvent event) {
           int[] jatekos = jatekosDobas();
           int[] gep = gepDobas(); 
        
           Arrays.sort(jatekos);
           Arrays.sort(gep);

           kocka1Label.setText(""+jatekos[0]);
           kocka2Label.setText(""+jatekos[1]);
           kocka3Label.setText(""+jatekos[2]);
           
           gep1Label.setText(""+gep[0]);
           gep2Label.setText(""+gep[1]);
           gep3Label.setText(""+gep[2]);
           
           
           eredmenyLabel.setText(eredmeny(jatekos,gep));
           
    }
    
    @FXML
    private Label BankMoney,ChipMoney,getID;

    @FXML
    private Button ProfilKep;
    
    String id = "";
    String nem = "", hajszem = "";
    String[] Kellekek = new String[4];
    
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
            for (int i = 4; i < penzek.length; i++) {
                Kellekek[i-4] = penzek[i];
            }
            ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
        } catch (FileNotFoundException e) {
            // Exception handling
        } catch (IOException e) {
            // Exception handling
        }
        
    }
}
