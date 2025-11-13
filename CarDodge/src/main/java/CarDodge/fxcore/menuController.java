
package CarDodge.fxcore;

/*
By: <Your Name Here>
Date: 2025-10-28
Program Details: <Program Description Here>
*/
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class
// 464
import javafx.scene.input.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;

public class menuController implements Initializable {
     @FXML
    private Button btnPlay;

   
    

    @FXML
    void btnPlayA(ActionEvent event) {
        try {
            MainApp.setRoot("primary","TAX EVASION SIM");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }
}
