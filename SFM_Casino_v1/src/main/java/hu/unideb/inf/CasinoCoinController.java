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
    
     int money = 5000;
    int bet = 0;
    int coin;   //  0-tail  1-head
    Random rand = new Random();
    
    @FXML
    private Label MoneyLabel;   
    @FXML
    private Label BetLabel;
    @FXML
    private Label ResultLabel;
    
  

    @FXML
    void MoreButtonPushed() {
        if (bet >= money) {
            
        }
        else
            bet += 1000;
        
        BetLabel.setText("Bet: " + bet);
        ResultLabel.setText("");

    }
    
    @FXML
    void LessButtonPushed() {
        if (bet == 0) {
            
        }
        else
         bet -= 1000;
        
        BetLabel.setText("Bet: " + bet);
        ResultLabel.setText("");

    }
    
    //  0-tail  1-head
    @FXML
    void HeadButtonPushed() {
        if (bet > 0) {
            
            int randint = rand.nextInt(2);

            if(randint==1)
            {
                ResultLabel.setText("Win!");

                money += bet;
            }
            else
            {
                ResultLabel.setText("Loss!");        

                money -= bet;
            }
            bet = 0;
            MoneyLabel.setText("Money: " + money /*+ "\n Rand: " + randint*/);
            BetLabel.setText("Bet: " + bet);
        }
    }
    @FXML
    void TailButtonPushed() {
        if (bet > 0) {
            

            int randint = rand.nextInt(2);

            if(randint==0)
            {
                ResultLabel.setText("Win!");

                money += bet;
            }
            else
            {
                ResultLabel.setText("Loss!");

                money -= bet;
            }
            bet = 0;
            MoneyLabel.setText("Money: " + money /*+ "\n Rand: " + randint*/);
            BetLabel.setText("Bet: " + bet);
        }
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
