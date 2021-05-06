package hu.unideb.inf;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.h2.tools.Server;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CasinoLogin.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/CasinoInterface.css");
        scene.getStylesheets().add("/styles/Games.css");

        stage.setTitle("SFM Casino");
        stage.getIcons().add(new Image("/images/sfmprojectlogo300.png"));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            startDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        launch(args);
        stopDatabase();
    }

    private static final Server s = new Server();

    private static void startDatabase() throws SQLException {
        s.runTool("-tcp", "-web", "-ifNotExists");
    }

    private static void stopDatabase() {
        s.shutdown();
    }
}
