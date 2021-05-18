package hu.unideb.inf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import hu.unideb.inf.model.JpaCasinoDAO;
import hu.unideb.inf.model.User2;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.hibernate.sql.ordering.antlr.OrderingSpecification;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */



public class CasinoFomenuController implements Initializable {
    
    Globalis global = new Globalis();
    @FXML
    private Button ProfilKep;

    @FXML
    void MenuCloseButton(ActionEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
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
    void MenuWheelButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Wheel");
    }

    @FXML
    void MenuSlotIIButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "SlotII");
    }

    //////////////////
    //////////////////

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;



    @FXML
    void BJPushed(ActionEvent event) {

        ButtonType foo = new ButtonType("Játék!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kilépés!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretné elindítani a játékot?",
                foo, bar);
        alert.setTitle("Blackjack");
        alert.setHeaderText(null);  //  header levétele
        alert.setGraphic(null);     //  kép levétele
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);   //  méret fixálás

        alert.setContentText("A játékos tesztelheti a szerencséjét egy érme feldobásával. Ha eltalálja, hogy az érme melyik oldalára érkezik megduplázza " +
                "pénzét, ha pedig rosszul tippel elveszti feltett pénzét.\n\n\n");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "BJ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void CoinPushed(ActionEvent event) {

        ButtonType foo = new ButtonType("Játék!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kilépés!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretné elindítani a játékot?",
                foo, bar);
        alert.setTitle("Coin flip");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A játékos tesztelheti a szerencséjét egy érme feldobásával. Ha eltalálja, " +
                "hogy az érme melyik oldalára érkezik megduplázza " +
                "pénzét, ha pedig rosszul tippel elveszti feltett pénzét.\n\n\n");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "Coin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void DicePushed(ActionEvent event) {
        ButtonType foo = new ButtonType("Játék!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kilépés!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretné elindítani a játékot?",
                foo, bar);
        alert.setTitle("Dice");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A játékos tesztelheti a szerencséjét egy érme feldobásával. Ha eltalálja, hogy az érme melyik oldalára érkezik megduplázza " +
                "pénzét, ha pedig rosszul tippel elveszti feltett pénzét.\n\n\n");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "Dice");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void Slot1Pushed(ActionEvent event) {
        ButtonType foo = new ButtonType("Játék!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kilépés!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretné elindítani a játékot?",
                foo, bar);
        alert.setTitle("Slot I");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A játékos tesztelheti a szerencséjét egy érme feldobásával. Ha eltalálja, hogy az érme melyik oldalára érkezik megduplázza " +
                "pénzét, ha pedig rosszul tippel elveszti feltett pénzét.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "SlotI");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void Slot2Pushed(ActionEvent event) {
        ButtonType foo = new ButtonType("Játék!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kilépés!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretné elindítani a játékot?",
                foo, bar);
        alert.setTitle("Slot II");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A játékos tesztelheti a szerencséjét egy érme feldobásával. Ha eltalálja, hogy az érme melyik oldalára érkezik megduplázza " +
                "pénzét, ha pedig rosszul tippel elveszti feltett pénzét.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "SlotII");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void WheelPushed(ActionEvent event) {
        ButtonType foo = new ButtonType("Játék!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kilépés!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretné elindítani a játékot?",
                foo, bar);
        alert.setTitle("Wheel");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A játékos tesztelheti a szerencséjét egy érme feldobásával. Ha eltalálja, hogy az érme melyik oldalára érkezik megduplázza " +
                "pénzét, ha pedig rosszul tippel elveszti feltett pénzét.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "Wheel");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    /////////////////
    /////////////////

    @FXML
    private Label BankMoney,ChipMoney,getID;

    String id = "";
    int jatekospenz = 0;
    int jatekospenz2 = 0;
    String nem = "", hajszem = "";
    String[] Kellekek = new String[4];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JpaCasinoDAO userDAO = new JpaCasinoDAO();
        List<User2> Profile = userDAO.getUser();

        String[] adatok = new String[10];
        int[] nyert = new int[10];
        int i =0;
        for (var user : Profile ) {
            adatok[i] = user.getUsername();
            nyert[i] = user.getJatekospenz();
            i++;
        }


       ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (int j = 0; j < 10; j++) {
            pieChartData.add(new PieChart.Data(adatok[j], nyert[j]));

        }
        pieChart.setData(pieChartData);
        pieChart.setTitle("Legtöbb nyereség");

        //  BarChart

        XYChart.Series set1 = new XYChart.Series<>();

        i = 0;
        SortedMap<String, Integer> map = new TreeMap<String,Integer>();

        for (var user : Profile ) {
            map.put(user.getUsername(),user.getJatekospenz());
        }

        //Map.Entry m = (Map.Entry)

        for (Map.Entry<String,Integer> x : map.entrySet()){
            set1.getData().add(new XYChart.Data(x.getKey(),x.getValue()));

        }



        //    set1.getData().add(new XYChart.Data("qwe",map.get("qwe")));
    //    set1.getData().add(new XYChart.Data("alma",map.get("alma")));

        //  set1.getData().add(new XYChart.Data(adatok[1],nyert[1]));
      //  set1.getData().add(new XYChart.Data(adatok[2],nyert[2]));


        barChart.getData().addAll(set1);
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