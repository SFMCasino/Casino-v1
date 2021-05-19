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
import java.util.ResourceBundle;

import hu.unideb.inf.model.JpaCasinoDAO;
import hu.unideb.inf.model.User2;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */
public class CasinoLoginController implements Initializable {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    @FXML
    private StackPane parentContainer;
    @FXML
    private Button RegisterGomb;
    @FXML
    private PasswordField Jelszo;
    @FXML
    private TextField Felhasznalo;
    
//    String directory = System.getProperty("user.home");
//    String fileName = "registerTest.txt";
//    String absolutePath = directory + File.separator + fileName;
    
    @FXML
    void MenuFooldalGomb(ActionEvent event) throws IOException {
        boolean valid = false;
        /*try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            ArrayList<FelhasznaloProfile> Profile = new ArrayList<FelhasznaloProfile>();
            String szoveg = bufferedReader.readLine();
            while(szoveg != null){
                String[] SzovegTok = szoveg.split(":");
                Profile.add(new FelhasznaloProfile(SzovegTok[0],SzovegTok[1],SzovegTok[2]));
                szoveg = bufferedReader.readLine();
            }*/

            Globalis global = new Globalis();
            JpaCasinoDAO userDAO = new JpaCasinoDAO();
            List<User2> Profile = userDAO.getUser();
            String getFelhasznalo = Felhasznalo.getText();
            String getJelszo = Jelszo.getText();
            FelhasznaloProfile checkProfile = new FelhasznaloProfile(getFelhasznalo,getJelszo);
            String validID = "";

            ArrayList<Integer> proba = new ArrayList<>();
            ArrayList<Integer> proba2 = new ArrayList<>();

            for(var a : Profile){
                if(checkProfile.Felhasználó.equals(a.getUsername()) && checkProfile.Jelszó.equals(a.getPassword())){
                    valid = true;
                    validID = a.getSetID();
                    a.setLogin_db(a.getLogin_db()+1);
                    for (int i = 0; i <= a.getLogin_db(); i++) {
                        if(i==a.getLogin_db()){
                            proba.add(0);
                            proba2.add(0);
                        }else{
                            proba.add(a.getNyereseg().get(i));
                            proba2.add(a.getVeszteseg().get(i));
                        }
                    }
                    a.setNyereseg(proba);
                    a.setVeszteseg(proba2);
                    userDAO.saveUser(a);
//                    System.out.println(global.getOssznyeremeny(a.getNyereseg())); példa egy felhasználó össznyereményének a lekéréséhez
                }
            }

            if(valid){
                global.LoadScene(event, validID, "Fomenu");
                /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CasinoFomenu.fxml"));
                Parent root = (Parent) loader.load();
                
                CasinoFomenuController fomenu = loader.getController();
                fomenu.Adatatvitel(validID);
                
                Scene ViewScene = new Scene(root);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(ViewScene);
                window.show();*/
            }else{
                Alert hiba = new Alert(Alert.AlertType.ERROR);
                hiba.setTitle("Hiba");
                hiba.setHeaderText("Nem létező felhasználó vagy hibás jelszó");
                hiba.showAndWait();
            }
    }
    
    @FXML
    void RegisterButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CasinoRegister.fxml"));
        Scene scene = RegisterGomb.getScene();
        
        root.translateXProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.3),kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
    
    @FXML
    void MenuCloseButton(ActionEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
