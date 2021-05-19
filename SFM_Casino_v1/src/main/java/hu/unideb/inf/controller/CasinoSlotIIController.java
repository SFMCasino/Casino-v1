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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CasinoSlotIIController implements Initializable {


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

    public static int egyenleg;
    public static int Chipmoney;
    public static int vonal = 5;
    public static int vonaltet = 10;
    public static int scatter;
    public static int villam = 10;
    public static boolean bonuszvalto = false;
    public static int porgetesszam = 0;
    public static char bonuszszimbol;
    public static int bonusznyeremeny;


    public char randomizal()
    {
        Random rand;
        rand = new Random();
        char randomvissz;
        Image image;
        int szam = rand.nextInt(100);
        if(szam <= 13)
        {
            randomvissz = 't';
        }
        else if(szam <= 26)
        {
            randomvissz = 'j';
        }
        else if(szam <= 38)
        {
            randomvissz = 'q';
        }
        else if(szam <= 50)
        {
            randomvissz = 'k';
        }
        else if(szam <= 62)
        {
            randomvissz = 'a';
        }
        else if(szam <= 71)
        {
            randomvissz = 'o';
        }
        else if(szam <= 79)
        {
            randomvissz = 'w';
        }
        else if(szam <= 87)
        {
            randomvissz = 'r';
        }
        else if(szam <= 96)
        {
            randomvissz = 'm';
        }
        else
        {
            randomvissz = 'b';
        }
        return randomvissz;
    }

    public Image kepbeallitas(char keps)
    {
        Image ret;

        switch (keps)
        {
            case 't': ret = new Image("/icons/Ten.png");break;
            case 'j': ret = new Image("/icons/Jack.png");break;
            case 'q': ret = new Image("/icons/Queen.png");break;
            case 'k': ret = new Image("/icons/King.png");break;
            case 'a': ret = new Image("/icons/Ace.png");break;
            case 'o': ret = new Image("/icons/Owl.png");break;
            case 'w': ret = new Image("/icons/WhiteD.png");break;
            case 'r': ret = new Image("/icons/RedD.png");break;
            case 'm': ret = new Image("/icons/OldMan.png");break;
            default: ret = new Image("/icons/Bonus.png");break;
        }

        return ret;
    }

    public int kiszamol(int mennyi, char tes)
    {
        int kisszam = 0;
        switch(tes)
        {
            case 't':
            case 'j':
            case 'q':
                if(mennyi>4)
                {
                    kisszam = vonaltet * 60;
                }
                else if(mennyi>3)
                {
                    kisszam = vonaltet * 15;
                }
                else if(mennyi>2)
                {
                    kisszam = vonaltet * 3;
                }
                break;
            case 'k':
            case 'a':
                if(mennyi>4)
                {
                    kisszam = vonaltet * 100;
                }
                else if(mennyi>3)
                {
                    kisszam = vonaltet * 20;
                }
                else if(mennyi>2)
                {
                    kisszam = vonaltet * 3;
                }
                break;
            case 'o':
            case 'w':
                if(mennyi>4)
                {
                    kisszam = vonaltet * 400;
                }
                else if(mennyi>3)
                {
                    kisszam = vonaltet * 60;
                }
                else if(mennyi>2)
                {
                    kisszam = vonaltet * 15;
                }
                else if(mennyi>1)
                {
                    kisszam = vonaltet * 3;
                }
                break;
            case 'r':
                if(mennyi>4)
                {
                    kisszam = vonaltet * 1200;
                }
                else if(mennyi>3)
                {
                    kisszam = vonaltet * 200;
                }
                else if(mennyi>2)
                {
                    kisszam = vonaltet * 20;
                }
                else if(mennyi>1)
                {
                    kisszam = vonaltet * 3;
                }
                break;
            case 'm':
                if(mennyi>4)
                {
                    kisszam = vonaltet * 2500;
                }
                else if(mennyi>3)
                {
                    kisszam = vonaltet * 600;
                }
                else if(mennyi>2)
                {
                    kisszam = vonaltet * 60;
                }
                else if(mennyi>1)
                {
                    kisszam = vonaltet * 5;
                }
                break;
        }
        return kisszam;
    }

    public int line1(char[][] k)
    {
        int vissza = 0;
        int szamol = 1;
        if(k[0][1] == k[0][0])
        {
            szamol++;
            if(k[0][2] == k[0][1])
            {
                szamol++;
                if(k[0][3] == k[0][2])
                {
                    szamol++;
                    if(k[0][4] == k[0][3])
                    {
                        szamol++;
                    }
                }
            }
        }
        vissza = kiszamol(szamol, k[0][0]);
        return vissza;
    }
    public int line2(char[][] k)
    {
        int vissza = 0;
        int szamol = 1;
        if(k[1][1] == k[1][0])
        {
            szamol++;
            if(k[1][2] == k[1][1])
            {
                szamol++;
                if(k[1][3] == k[1][2])
                {
                    szamol++;
                    if(k[1][4] == k[1][3])
                    {
                        szamol++;
                    }
                }
            }
        }
        vissza = kiszamol(szamol, k[1][0]);
        return vissza;
    }
    public int line3(char[][] k)
    {
        int vissza = 0;
        int szamol = 1;
        if(k[2][1] == k[2][0])
        {
            szamol++;
            if(k[2][2] == k[2][1])
            {
                szamol++;
                if(k[2][3] == k[2][2])
                {
                    szamol++;
                    if(k[2][4] == k[2][3])
                    {
                        szamol++;
                    }
                }
            }
        }
        vissza = kiszamol(szamol, k[2][0]);
        return vissza;
    }
    public int line4(char[][] k)
    {
        int vissza = 0;
        int szamol = 1;
        if(k[1][1] == k[0][0])
        {
            szamol++;
            if(k[2][2] == k[1][1])
            {
                szamol++;
                if(k[1][3] == k[2][2])
                {
                    szamol++;
                    if(k[0][4] == k[1][3])
                    {
                        szamol++;
                    }
                }
            }
        }
        vissza = kiszamol(szamol, k[0][0]);
        return vissza;
    }
    public int line5(char[][] k)
    {
        int vissza = 0;
        int szamol = 1;
        if(k[1][1] == k[2][0])
        {
            szamol++;
            if(k[0][2] == k[1][1])
            {
                szamol++;
                if(k[1][3] == k[0][2])
                {
                    szamol++;
                    if(k[2][4] == k[1][3])
                    {
                        szamol++;
                    }
                }
            }
        }
        vissza = kiszamol(szamol, k[2][0]);
        return vissza;
    }
    public int line6(char[][] k)
    {
        int vissza = 0;
        int szamol = 1;
        if(k[0][1] == k[1][0])
        {
            szamol++;
            if(k[0][2] == k[0][1])
            {
                szamol++;
                if(k[0][3] == k[0][2])
                {
                    szamol++;
                    if(k[1][4] == k[0][3])
                    {
                        szamol++;
                    }
                }
            }
        }
        vissza = kiszamol(szamol, k[1][0]);
        return vissza;
    }
    public int line7(char[][] k)
    {
        int vissza = 0;
        int szamol = 1;
        if(k[2][1] == k[1][0])
        {
            szamol++;
            if(k[2][2] == k[2][1])
            {
                szamol++;
                if(k[2][3] == k[2][2])
                {
                    szamol++;
                    if(k[1][4] == k[2][3])
                    {
                        szamol++;
                    }
                }
            }
        }
        vissza = kiszamol(szamol, k[1][0]);
        return vissza;
    }
    public int line8(char[][] k)
    {
        int vissza = 0;
        int szamol = 1;
        if(k[0][1] == k[0][0])
        {
            szamol++;
            if(k[1][2] == k[0][1])
            {
                szamol++;
                if(k[2][3] == k[1][2])
                {
                    szamol++;
                    if(k[2][4] == k[2][3])
                    {
                        szamol++;
                    }
                }
            }
        }
        vissza = kiszamol(szamol, k[0][0]);
        return vissza;
    }
    public int line9(char[][] k)
    {
        int vissza;
        int szamol = 1;
        if(k[2][1] == k[2][0])
        {
            szamol++;
            if(k[1][2] == k[2][1])
            {
                szamol++;
                if(k[0][3] == k[1][2])
                {
                    szamol++;
                    if(k[0][4] == k[0][3])
                    {
                        szamol++;
                    }
                }
            }
        }
        vissza = kiszamol(szamol, k[2][0]);
        return vissza;
    }
    public int line10(char[][] k)
    {
        int vissza = 0;
        int szamol = 1;
        if(k[2][1] == k[1][0])
        {
            szamol++;
            if(k[1][2] == k[2][1])
            {
                szamol++;
                if(k[0][3] == k[1][2])
                {
                    szamol++;
                    if(k[1][4] == k[0][3])
                    {
                        szamol++;
                    }
                }
            }
        }
        vissza = kiszamol(szamol, k[1][0]);
        return vissza;
    }

    public void bonusz(char[][] k)
    {
        scatter = 0;
        for(int i=0;i<3;i++)
        {
            for(int j =0;j<5;j++)
            {
                if(k[i][j] == 'b')
                {
                    scatter++;
                }
            }
        }
        if(scatter>2)
        {
            bonusznyeremenylabel.setText("Bónusz nyeremény: ");
            bonuszlabel.setText("Bónuszpörgetések száma: 8");
            bonuszvalto = true;
            gyorsButt.setDisable(true);
            gyorsbuttlow.setDisable(true);
            gyorsbutthigh.setDisable(true);
            vonallowbutt.setDisable(true);
            vonalhighbutt.setDisable(true);
            lowButt.setDisable(true);
            highButt.setDisable(true);
            bonuszlabel.setVisible(true);
            bonusznyeremenylabel.setVisible(true);
            bonuszjatek();
        }
    }


    public void bonuszjatek() {
        bonusznyeremeny = 0;
        porgetesszam = 8;
        bonuszszimbol = randomizal();
        while(bonuszszimbol == 'b') {
            bonuszszimbol = randomizal();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bónusz játék!");
        alert.setHeaderText("A szimbólumod amelyik kiterjed: ");
        alert.setGraphic(new ImageView(kepbeallitas(bonuszszimbol)));
        alert.showAndWait();
    }


    public int nyeremeny(char[][] k)
    {
        int vegso = 0;
        if(vonal == 5)
        {
            vegso += line1(k);
            vegso += line2(k);
            vegso += line3(k);
            vegso += line4(k);
            vegso += line5(k);
        }
        else
        {
            vegso += line1(k);
            vegso += line2(k);
            vegso += line3(k);
            vegso += line4(k);
            vegso += line5(k);
            vegso += line6(k);
            vegso += line7(k);
            vegso += line8(k);
            vegso += line9(k);
            vegso += line10(k);
        }
        return vegso;
    }

    public int bonuszkiszamíto(int f)
    {
        int vissz = 0;
        switch (bonuszszimbol)
        {
            case 't':
            case 'j':
            case 'q':
                if(f > 4)
                {
                    vissz = vonaltet * 60 * vonal;
                }
                else if(f > 3)
                {
                    vissz = vonaltet * 15 * vonal;
                }
                else if(f > 2)
                {
                    vissz = vonaltet * 3 * vonal;
                }
                break;
            case 'k':
            case 'a':
                if(f > 4)
                {
                    vissz = vonaltet * 100 * vonal;
                }
                else if(f > 3)
                {
                    vissz = vonaltet * 20 * vonal;
                }
                else if(f > 2)
                {
                    vissz = vonaltet * 3 * vonal;
                }
                break;
            case 'o':
            case 'w':
                if(f > 4)
                {
                    vissz = vonaltet * 400 * vonal;
                }
                else if(f > 3)
                {
                    vissz = vonaltet * 60 * vonal;
                }
                else if(f > 2)
                {
                    vissz = vonaltet * 15 * vonal;
                }
                else if(f > 1)
                {
                    vissz = vonaltet * 3 * vonal;
                }
                break;
            case 'r':
                if(f > 4)
                {
                    vissz = vonaltet * 1200 * vonal;
                }
                else if(f > 3)
                {
                    vissz = vonaltet * 200 * vonal;
                }
                else if(f > 2)
                {
                    vissz = vonaltet * 20 * vonal;
                }
                else if(f > 1)
                {
                    vissz = vonaltet * 3 * vonal;
                }
                break;
            case 'm':
                if(f > 4)
                {
                    vissz = vonaltet * 2500 * vonal;
                }
                else if(f > 3)
                {
                    vissz = vonaltet * 600 * vonal;
                }
                else if(f > 2)
                {
                    vissz = vonaltet * 60 * vonal;
                }
                else if(f > 1)
                {
                    vissz = vonaltet * 5 * vonal;
                }
                break;
        }
        return vissz;
    }

    public void porgetes(char[][] slot)
    {
        int j = 0;
        char s;
        for (int i = 1; i < 16; i++) {
            s = randomizal();
            if ((i % 3) == 1) {
                slot[0][j] = s;

            } else if ((i % 3) == 2) {
                while (s == slot[0][j]) {
                    s = randomizal();
                }
                slot[1][j] = s;
            } else {
                while (s == slot[0][j] || s == slot[1][j]) {
                    s = randomizal();
                }
                slot[2][j] = s;
                j++;
            }
        }
        beallit(slot);
    }

    public void beallit(char [][]slot)
    {
        egyegy.setImage(kepbeallitas(slot[0][0]));
        egyketto.setImage(kepbeallitas(slot[1][0]));
        egyharom.setImage(kepbeallitas(slot[2][0]));
        kettoegy.setImage(kepbeallitas(slot[0][1]));
        kettoketto.setImage(kepbeallitas(slot[1][1]));
        kettoharom.setImage(kepbeallitas(slot[2][1]));
        haromegy.setImage(kepbeallitas(slot[0][2]));
        haromketto.setImage(kepbeallitas(slot[1][2]));
        haromharom.setImage(kepbeallitas(slot[2][2]));
        negyegy.setImage(kepbeallitas(slot[0][3]));
        negyketto.setImage(kepbeallitas(slot[1][3]));
        negyharom.setImage(kepbeallitas(slot[2][3]));
        otegy.setImage(kepbeallitas(slot[0][4]));
        otketto.setImage(kepbeallitas(slot[1][4]));
        otharom.setImage(kepbeallitas(slot[2][4]));
    }


    @FXML
    public ImageView egyegy;
    public ImageView egyketto;
    public ImageView egyharom;
    public ImageView kettoegy;
    public ImageView kettoketto;
    public ImageView kettoharom;
    public ImageView haromegy;
    public ImageView haromketto;
    public ImageView haromharom;
    public ImageView negyegy;
    public ImageView negyketto;
    public ImageView negyharom;
    public ImageView otegy;
    public ImageView otketto;
    public ImageView otharom;
    public ImageView logo;
    public ImageView bgimage;
    public Label nyeremenylabel;
    public Label teljestetlabel;
    public Label vonallabel;
    public Label vonaltetlabel;
    public Label gyorslabel;
    public Label bonuszlabel;
    public Button gyorsButt;
    public Button gyorsbuttlow;
    public Button gyorsbutthigh;
    public Button vonallowbutt;
    public Button vonalhighbutt;
    public Button lowButt;
    public Button highButt;
    public Label bonusznyeremenylabel;


    @FXML
    private void spinbuttpushed(ActionEvent event){
        if((egyenleg+Chipmoney) >= (vonaltet*vonal))
        {
            int nyertpenz;
            scatter = 0;
            int bonuszszamlalo = 0;
            if(!bonuszvalto) {
                if(egyenleg < vonal*vonaltet || egyenleg == 0)
                {
                    Chipmoney -= (vonal*vonaltet)-egyenleg;
                    egyenleg = 0;
                    BankMoney.setText("" + egyenleg);
                }
                else
                {
                    egyenleg -= (vonal*vonaltet);
                    BankMoney.setText("" + egyenleg);
                }
            }
            char[][] slot = new char[3][5];
            porgetes(slot);
            nyertpenz = nyeremeny(slot);
            nyeremenylabel.setText("Nyeremény: " + nyertpenz);
            Chipmoney += nyertpenz;
            ChipMoney.setText("" + Chipmoney);
            global.saveData(id, egyenleg, Chipmoney, nem, hajszem, Kellekek);
            teljestetlabel.setText("Teljes tét " + vonaltet * vonal);
            if(!bonuszvalto) {
                bonusz(slot);
            }
            if(bonuszvalto)
            {
                porgetesszam--;
                bonuszlabel.setText("Bónuszpörgetések száma: " + porgetesszam);
                for(int i=0;i<3;i++)
                {
                    for(int j =0;j<5;j++)
                    {
                        if(slot[i][j] == 'b')
                        {
                            scatter++;
                        }
                    }
                }
                if(scatter>2)
                {
                    porgetesszam += 8;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Gratulálunk!");
                    alert.setHeaderText("Nyertél még 8 ingyenes pörgetést");
                    alert.showAndWait();
                }
                for(int i=0;i<3;i++)
                {
                    for(int j =0;j<5;j++)
                    {
                        if(slot[i][j] == bonuszszimbol)
                        {
                            slot[0][j] = bonuszszimbol;
                            slot[1][j] = bonuszszimbol;
                            slot[2][j] = bonuszszimbol;
                            beallit(slot);
                        }
                    }
                }
                for(int i=0;i<5;i++)
                {
                    if(slot[0][i] == bonuszszimbol)
                    {
                        bonuszszamlalo++;
                    }
                }
                bonusznyeremeny += bonuszkiszamíto(bonuszszamlalo);
                bonusznyeremenylabel.setText("Bónusz nyeremény: " + bonusznyeremeny);
                if(porgetesszam == 0)
                {
                    bonuszvalto = false;
                    gyorsButt.setDisable(false);
                    gyorsbuttlow.setDisable(false);
                    gyorsbutthigh.setDisable(false);
                    vonallowbutt.setDisable(false);
                    vonalhighbutt.setDisable(false);
                    lowButt.setDisable(false);
                    highButt.setDisable(false);
                    Chipmoney += bonusznyeremeny;
                    ChipMoney.setText("" + Chipmoney);
                    global.saveData(id, egyenleg, Chipmoney, nem, hajszem, Kellekek);
                    bonuszlabel.setVisible(false);
                    bonusznyeremenylabel.setVisible(false);
                }
            }
            else
            {
                bonuszlabel.setVisible(false);
                bonusznyeremenylabel.setVisible(false);
            }
        }
    }

    public void highbuttpushed(ActionEvent actionEvent) {
        if(vonaltet == 1)
        {
            vonaltet = 5;
        }
        else if(vonaltet == 5)
        {
            vonaltet = 10;
        }
        else if(vonaltet<1000)
        {
            vonaltet+=10;
        }
        vonaltetlabel.setText("" + vonaltet);
        teljestetlabel.setText("Teljes tét " + vonaltet*vonal);
    }
    public void lowbuttpushed(ActionEvent actionEvent) {
        if(vonaltet>=20)
        {
            vonaltet-=10;
        }
        else if( vonaltet == 10)
        {
            vonaltet = 5;
        }
        else
        {
            vonaltet = 1;
        }
        vonaltetlabel.setText("" + vonaltet);
        teljestetlabel.setText("Teljes tét " + vonaltet*vonal);
    }

    public void vonallowbuttpushed(ActionEvent actionEvent) {
        vonal = 5;
        vonallabel.setText("5");
        teljestetlabel.setText("Teljes tét " + vonaltet*vonal);
    }
    public void vonalhighbuttpushed(ActionEvent actionEvent) {
        vonal = 10;
        vonallabel.setText("10");
        teljestetlabel.setText("Teljes tét " + vonaltet*vonal);
    }
    public void gyorsbutthighpushed(ActionEvent actionEvent)
    {
        if(villam <= 990) {
            villam += 10;
        }
        gyorslabel.setText("Villámok száma: " + villam);
    }

    public void gyorsbuttlowpushed(ActionEvent actionEvent)
    {
        if(villam >= 20) {
            villam -= 10;
        }
        gyorslabel.setText("Villámok száma: " + villam);
    }

    public void gyorsbuttpushed(ActionEvent actionEvent)
    {
        if((egyenleg+Chipmoney) >= (villam*vonaltet*vonal))
        {
            int nyertpenz = 0;
            for (int i = 0; i < villam; i++)
            {
                if(egyenleg < vonaltet*vonal)
                {
                    Chipmoney -= (vonal*vonaltet) - egyenleg;
                    egyenleg = 0;
                }
                else
                {
                    egyenleg -= vonal*vonaltet;
                    BankMoney.setText("" + egyenleg);
                }
                    char[][] slot = new char[3][5];
                    porgetes(slot);
                    nyertpenz += nyeremeny(slot);
                    bonusz(slot);
                    if(bonuszvalto)
                    {
                        break;
                    }
            }
            Chipmoney += nyertpenz;
            ChipMoney.setText("" + Chipmoney);
            global.saveData(id, egyenleg, Chipmoney, nem, hajszem, Kellekek);
            nyeremenylabel.setText("Nyeremény: " + nyertpenz);
            teljestetlabel.setText("Teljes tét " + vonaltet * vonal);
        }

    }

    @FXML
    private Label BankMoney,ChipMoney,getID;

    String id = "";
    String nem = "", hajszem = "";
    String[] Kellekek = new String[4];
    
    @FXML
    private Button ProfilKep;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bgimage.setImage(new Image("/icons/bg.png"));
        nyeremenylabel.setText("Nyeremény: " + 0);
        vonaltetlabel.setText("" + vonaltet);
        teljestetlabel.setText("Teljes tét " + vonaltet*vonal);
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
                egyenleg = a.getJatekospenz();
                Chipmoney = a.getJatekospenz2();
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
