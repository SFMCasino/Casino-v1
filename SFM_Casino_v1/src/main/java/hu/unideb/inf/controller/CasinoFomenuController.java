package hu.unideb.inf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

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

        alert.setContentText("Ki ne szeretné a gyors, egyszerű kártyajátékoktat? Szerencsére a Blackjackre mindkét állítás igaz.\n" +
                "A játékos és az osztó is 2-2 lapot kap, azonban az osztónak csak az első lapja látható. A játékosnak addig van lehetősége új lapot kérni, amíg a lapok értéke nem haladja meg a 21-t. Ebben az esetben automatikuson veszít is." +
                " Ha a játékos lapjainak értéke 21, akor nyert. Ammennyiben úgy dönt, hogy megáll, de nem találta meg a legjobb kezet az osztóra kerül a sor. " +
                "Ő is addig húzhat, mint a játékos és ha túlhalad a 21-en veszít. Ha nincs egyértelmű nyertes vagy vesztes, akkor az nyer akinek a lapok összege közeleb áll a 21-hez.\n\n\n");

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
                "a pénzét, ha pedig rosszul tippel elveszti.\nMint ahogy a mondás is tartja a győzelmi esély itt tényleg 50-50.\n\n\n");

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
        alert.setContentText("A következő játékban 6 db egyszerű dobókockát használunk és azok értékeit vizsgáljuk. Rengeteg lehetőség előfordulhat, de minket elsősorban az érdekel, hogy melyik szám hányszor fordult elő.\nA következő leírás tájékoztat a különböző kombinációk szorzóiról:\n" +
                "6 db különböző kocka: 6x\n6 db egyforma kocka: 6x\n5 db egyforma kocka: 5x\n4 db egyforma kocka: 4x\n" +
                "1 db tripla és 1 db pár: 3x\n2 db tripla: 2x\n1 db tripla: 1x\n3 db pár: 2x\n2 db pár: 1x\n\n\n");

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
        alert.setContentText("A Slot I egy egyszerű, pörgős játék, ahol abban kell bízni, hogy 3 egyforma szimbólumot találjunk. A szimbólumok más-más értéket képviselnek, például cseresznyét pörgetve kevesebb, míg Genjit látva rengeteget nyerünk.\nHa sikerül legalább egy Overwatch ikont pörgetni nem maradunk üres kézzel az adott körben.\n\n\n");

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
        alert.setContentText("A Slot 2 egy választhatóan 5-10 vonalon fizethető játék. Az alap tét vonalanként rakódik meg. A játék vonalanként balról jobbra fizet, amennyiben a szimbólum megegyezik a vonalon előtte lévő szimbólummal, a leghosszabb kötés fizet egy vonalon.\n3 kristálygömb esetén aktiválódik a bónusz játék, ahol kipörög egy véletlenszerű szimbólum, amely a bónuszjáték idején kiterjed a teljes tárcsára és figyelmen kívül hagyja hogy maradt-e ki hely kötések között. A villámjátékkal a gyors bónusz szerzést valósíthatjuk meg.\n\n\n");

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
        alert.setContentText("A közismert szerencsekerék, ahol nyílt \"lapokkal\" teheti próbára szerencséjét. A kerék különbözői területeihez különböző nyeremények tartoznak.\nVajon legközelebb hol fog megállni a bűvös kerék?\n\n\n");

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

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        HashMap<String, Integer> map = new HashMap<>();

        for (var user : Profile ) {
            map.put(user.getUsername(),(user.getNyereseg()-user.getVeszteseg()));
        }

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

        int i = 0;
        for (Map.Entry<String,Integer> x : result.entrySet()){
            if(i==5) break;
            pieChartData.add(new PieChart.Data(x.getKey(), x.getValue()));
            i++;
        }

        pieChart.setData(pieChartData);
        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty().divide(100)," K"
                        )
                )
        );

        ////////////////
        //  BarChart
        ///////////////

        XYChart.Series set1 = new XYChart.Series<>();

        HashMap<String, Integer> map2 = new HashMap<>();

        for (var user : Profile ) {
            map2.put(user.getUsername(),user.getVeszteseg());
        }

        LinkedHashMap<String, Integer> result2 = new LinkedHashMap<>();
        map2.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        i = 0;
        for (Map.Entry<String,Integer> x : result2.entrySet()){
            if(i==10) break;
            set1.getData().add(new XYChart.Data(x.getKey(),x.getValue()));
            i++;
        }

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