
package CarDodge.fxcore;

/*
By: <Aum Markandey>
Date: 2025-10-28
Program Details: <A fun subway surfers knock off>
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
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.input.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;

public class FXMLController implements Initializable {
    @FXML
    private Pane PaneEscape;

    @FXML
    private Pane PaneObstacle;

    @FXML
    private Pane PaneObstacle2;

    @FXML
    private Pane PaneObstacle3;

    @FXML
    private Pane PaneObstacle4;

    @FXML
    private Pane PanePlayer;

    

    @FXML
    private ImageView Players;

     @FXML
    private MediaView mediaview;

    @FXML
    private Pane Tank;

    @FXML
    private Button btnOkay;

    @FXML
    private Button btnStart;

    @FXML
    private ProgressBar healthBar;

    @FXML
    private Rectangle hit;

    @FXML
    private Rectangle hit1;

    @FXML
    private Rectangle hit2;

    @FXML
    private Rectangle hit3;

    @FXML
    private Rectangle hit4;

    @FXML
    private ImageView imgPause;

    @FXML
    private Label lblHighScore;

    @FXML
    private Label lblHighScore1;

    @FXML
    private Label lblNewHighScore;

    @FXML
    private Label lblOut;
       @FXML
    private ImageView imgBack1;

    @FXML
    private ImageView imgBack2;
    @FXML
    private ImageView obstacle;

    @FXML
    private ImageView obstacle2;

    @FXML
    private ImageView obstacle3;

    @FXML
    private ImageView obstacle4;

    @FXML
    private Pane paneNewHighScore;

    @FXML
    private Rectangle rctBullet;

     @FXML
    private Rectangle rctTankBullet;

     @FXML
    private Rectangle rctTankBullet2;

    @FXML
    private Rectangle rctInvisible;

    @FXML
    private Rectangle rctScoreTimes2;

    @FXML
    private Rectangle rectangleBorder1;

    @FXML
    private Rectangle rectangleBorder2;

    @FXML
    private Rectangle rectangleBorder3;


    @FXML
    private Rectangle tankHit;
    boolean pause = false;
    double bulletcooldown = 1;
    int time = 20000;
 Media media = new Media(getClass().getResource("/Atomic Explosion - Meme plantilla.mp4").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

    
    int rand5 = ThreadLocalRandom.current().nextInt(time, time + 5000);
    int spot = ThreadLocalRandom.current().nextInt(-500, 999+1);
    int tankshoot = ThreadLocalRandom.current().nextInt(0, 999+1);
    int tankbulletrandomness = ThreadLocalRandom.current().nextInt(-50, 199+1);
    int tankbulletrandomness2 = ThreadLocalRandom.current().nextInt(-99, 249+1);
    int newHighscore = 0;
    boolean left = false;
    boolean right = false;
    boolean timelinerunning;
    boolean up = false;
    boolean down = false;
    double speed = 1.65;
    double healthtank = 1;
    double obstaclespeed = 2;
    boolean canstart = true;
    int invisblecounter = 0;
    double shutdowncounter = 0;
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), ae -> move()));
    Timeline bulletcooldowntime = new Timeline(new KeyFrame(Duration.millis(125), ae -> bulletcoodowncheck()));
    Timeline invisble = new Timeline(new KeyFrame(Duration.millis(125), ae -> invisble()));
    Timeline shutdown = new Timeline(new KeyFrame(Duration.millis(5), ae -> shutdown()));
    
    int tankshoottime = 0;
    
    void shutdown(){
        shutdowncounter=shutdowncounter+1;
    }
    void bulletcoodowncheck() {
        bulletcooldown = bulletcooldown + 0.250;
    }
    void invisble(){
        invisblecounter=invisblecounter+1;
    }
    void move() {
        
        imgBack2.setTranslateY(imgBack2.getTranslateY()+obstaclespeed);
        imgBack1.setTranslateY(imgBack1.getTranslateY()+obstaclespeed);
        if (imgBack2.getTranslateY()>500){
            imgBack2.setTranslateY(0);
        }
        if (imgBack1.getTranslateY()>500){
            imgBack1.setTranslateY(0);
        }
        if (time>20000){
            pause = true;
            imgPause.setVisible(false);
            tankHit.setVisible(true);
            PaneEscape.setVisible(true);
            hit1.setVisible(false);
            hit3.setVisible(false);
            hit2.setVisible(false);
            hit4.setVisible(false);
            rctInvisible.setVisible(false);
            tankshoottime = tankshoottime+1;

            if(spot>getX(Tank)){
                Tank.setTranslateX(Tank.getTranslateX()+1);
            }
            if(spot<getX(Tank)){
                Tank.setTranslateX(Tank.getTranslateX()-1);
            }
            if(collision(tankHit, rectangleBorder1)){
                spot = ThreadLocalRandom.current().nextInt(-500, 999+1);
            }
            if(collision(tankHit, rectangleBorder2)){
                spot = ThreadLocalRandom.current().nextInt(-500, 999+1);
            }
            if(spot==getX(Tank)){
                spot = ThreadLocalRandom.current().nextInt(-500, 999+1);
            }
            if(healthBar.getProgress()>0.5){
                rctTankBullet.setTranslateY(rctTankBullet.getTranslateY() + obstaclespeed);
                rctTankBullet2.setTranslateY(rctTankBullet2.getTranslateY() + obstaclespeed); 
                
                 if(tankshoot==tankshoottime){
                setX(rctTankBullet, getX(Tank)+tankbulletrandomness);
                setY(rctTankBullet, getY(Tank));
                tankshoottime = 0;
                tankshoot = ThreadLocalRandom.current().nextInt(0, 999+1);
                tankbulletrandomness = ThreadLocalRandom.current().nextInt(-50, 199+1);
                
            }
            
            }
            if(healthBar.getProgress()<0.5){
                 
                 healthBar.setStyle("-fx-accent: red;");
                rctTankBullet.setTranslateY(rctTankBullet.getTranslateY() + obstaclespeed+3);
                rctTankBullet2.setTranslateY(rctTankBullet2.getTranslateY() + obstaclespeed+3);
                if(tankshoot==tankshoottime){
                setX(rctTankBullet, getX(Tank)+tankbulletrandomness);
                setY(rctTankBullet, getY(Tank));
                setX(rctTankBullet2, getX(Tank)+tankbulletrandomness2);
                setY(rctTankBullet2, getY(Tank));
                tankshoottime = 0;
                tankshoot = ThreadLocalRandom.current().nextInt(0, 499+1);
                tankbulletrandomness = ThreadLocalRandom.current().nextInt(-50, 199+1);
                tankbulletrandomness2 = ThreadLocalRandom.current().nextInt(-99, 249+1);
               
               
                
            }
            
            }
           
            
             if (healthBar.getProgress()<=0){
timeline.stop();
imgPause.setDisable(true);
                //File file = new File("/home/aummydahomie/CarDodge2/CarDodge/src/main/resources/Atomic Explosion - Meme plantilla.mp4");
        mediaview.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        
            }

           
            
            if (collision(rctTankBullet, hit)){
                System.exit(0);
            }
            
            
        }
        if (time == rand5) {
            
            rand5 = ThreadLocalRandom.current().nextInt(time, time + 1000);

        }
        if (time == rand5) {
            
            rand5 = ThreadLocalRandom.current().nextInt(time, time + 1500);

        }

        if (collision2(hit, rctScoreTimes2)) {
            time = time + 50;

        }
        if (time >= 0) {
            rctBullet.setTranslateY(rctBullet.getTranslateY() - obstaclespeed);
        }

        time = time + 1;
        newHighscore = time;
        timelinerunning = true;
        if (newHighscore > MainApp.Highscore) {
            MainApp.Highscore = newHighscore;

        }

        lblOut.setText("Score: " + time);
        lblHighScore.setText("High Score: " + MainApp.Highscore);
        if (time > 1500) {
            obstaclespeed = 2.5;

            speed = 1.75;

        }
        if (time > 3000) {
            obstaclespeed = 3;

            speed = 2;

        }
        if (time > 5000) {
            obstaclespeed = 3.5;

            speed = 2.25;

        }
        if (time > 10000) {
            obstaclespeed = 4;

            speed = 2.5;

        }

         if (time > 15000) {
            obstaclespeed = 4.5;

            speed = 3;

        }
        
        double x = ((left ? 1 : 0) * -speed) + ((right ? 1 : 0) * speed);
        double y = ((up ? 1 : 0) * -speed) + ((down ? 1 : 0) * speed);
        PanePlayer.setTranslateX(PanePlayer.getTranslateX() + x);
        PaneObstacle.setTranslateY(PaneObstacle.getTranslateY() + obstaclespeed);
        PaneObstacle2.setTranslateY(PaneObstacle2.getTranslateY() + obstaclespeed);
        PaneObstacle3.setTranslateY(PaneObstacle3.getTranslateY() + obstaclespeed);
        PaneObstacle4.setTranslateY(PaneObstacle4.getTranslateY() + obstaclespeed);
        rctScoreTimes2.setTranslateY(rctScoreTimes2.getTranslateY() + obstaclespeed);
        rctInvisible.setTranslateY(rctInvisible.getTranslateY() + obstaclespeed);
        if (PaneObstacle.getTranslateY() > 500) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
            PaneObstacle.setTranslateY(-250);
            PaneObstacle.setTranslateX(rand);
            PaneObstacle.setVisible(true);
            hit1.setVisible(true);
            if (collision(hit1, hit2) || collision(hit1, hit3) || collision(hit1, hit4)) {
                rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
                PaneObstacle.setTranslateX(rand);
                
            }

        }
        if (collision2(hit, rectangleBorder2) ||  collision2(hit, rectangleBorder1)) {

            PanePlayer.setTranslateX(PanePlayer.getTranslateX() - x);
            PanePlayer.setTranslateY(PanePlayer.getTranslateY() - y);

        }
        if (PaneObstacle2.getTranslateY() > 500) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
            PaneObstacle2.setTranslateY(-250);
            PaneObstacle2.setTranslateX(rand);
            PaneObstacle2.setVisible(true);
                hit2.setVisible(true);
            if (collision(hit2, hit4) || collision(hit2, hit3) || collision(hit2, hit1)) {
                rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
                PaneObstacle2.setTranslateX(rand);
               
            }
        }
        if (rctScoreTimes2.getTranslateY() > 500) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
            rctScoreTimes2.setTranslateY(-250);
            rctScoreTimes2.setTranslateX(rand);
            if (collision(rctScoreTimes2, hit4) || collision(rctScoreTimes2, hit3) || collision(rctScoreTimes2, hit1)) {
                rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
                rctScoreTimes2.setTranslateX(rand);

            }
        }

        if (rctInvisible.getTranslateY() > 500) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
           rctInvisible.setTranslateY(-250);
            rctInvisible.setTranslateX(rand);
            if (collision(rctInvisible, hit4) || collision(rctInvisible, hit3) || collision(rctInvisible, hit1)) {
                rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
                rctInvisible.setTranslateX(rand);

            }
        }

        if (PaneObstacle3.getTranslateY() > 500) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
            PaneObstacle3.setTranslateY(-250);
            PaneObstacle3.setTranslateX(rand);
            PaneObstacle3.setVisible(true);
                hit3.setVisible(true);
            if (collision(hit3, hit2) || collision(hit3, hit4) || collision(hit3, hit1)) {
                rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
                PaneObstacle3.setTranslateX(rand);
                
            }
        }
        if (PaneObstacle4.getTranslateY() > 500) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
            PaneObstacle4.setTranslateY(-250);
            PaneObstacle4.setTranslateX(rand);
            PaneObstacle4.setVisible(true);
            hit4.setVisible(true);
            if (collision(hit4, hit2) || collision(hit4, hit3) || collision(hit4, hit1)) {
                rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
                PaneObstacle4.setTranslateX(rand);
                
            }
        }
        if (collision(hit4, hit2) || collision(hit4, hit3) || collision(hit4, hit1)) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);

            PaneObstacle4.setTranslateX(rand);

        }
        if (collision(hit3, hit2) || collision(hit3, hit4) || collision(hit3, hit1)) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);

            PaneObstacle3.setTranslateX(rand);

        }

        if (collision(hit2, hit4) || collision(hit2, hit3) || collision(hit2, hit1)) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);

            PaneObstacle2.setTranslateX(rand);

        }
        if (collision(hit2, hit4) || collision(hit2, hit3) || collision(hit2, hit1)) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);

            PaneObstacle2.setTranslateX(rand);

        }
        if (collision(rctScoreTimes2, hit4) || collision(rctScoreTimes2, hit3) || collision(rctScoreTimes2, hit1)|| collision(rctScoreTimes2, hit2)) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);

            rctScoreTimes2.setTranslateX(rand);

        }
        if (collision(rctInvisible, hit4) || collision(rctInvisible, hit3) || collision(rctInvisible, hit1)|| collision(rctInvisible, hit2)) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);

           rctInvisible.setTranslateX(rand);

        }
        if (collision(rctInvisible, hit)) {
           hit.setVisible(false); 
           PanePlayer.setOpacity(0.1);
           invisble.setCycleCount(Timeline.INDEFINITE);
           invisble.play();


        }

        if (collision(rctBullet, tankHit)) {
            healthtank = healthtank-0.003;
            healthBar.setProgress(healthtank);
            if (healthtank<=0){
                healthBar.setProgress(0);
            }
          


        }

        if (invisblecounter>30){
            hit.setVisible(true);
            PanePlayer.setOpacity(100);
            invisblecounter=0;
            invisble.stop();
            
        }
        if (collision(rctInvisible, rectangleBorder1) || collision(rctInvisible, rectangleBorder2)) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);

            rctInvisible.setTranslateX(rand);

        }
        if (collision(rctScoreTimes2, rectangleBorder1) || collision(rctScoreTimes2, rectangleBorder2)) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);

            rctScoreTimes2.setTranslateX(rand);

        }
        if (collision(hit1, hit2) || collision(hit1, hit3) || collision(hit1, hit4)) {
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);

            PaneObstacle.setTranslateX(rand);

        }

        if (collision(hit, hit1) || collision(hit, hit2) || collision(hit, hit3) || collision(hit, hit4)) {

            if (newHighscore == MainApp.Highscore) {
                lblNewHighScore.setText("New Highscore: " + MainApp.Highscore);
                paneNewHighScore.setVisible(true);
            }

            time = 0;
            obstaclespeed = 2;
            speed = 1.65;
            int rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
            int rand2 = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
            int rand3 = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
            int rand4 = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
            PaneObstacle.setTranslateY(-10);
            PaneObstacle2.setTranslateY(-10);
            PaneObstacle3.setTranslateY(-10);
            PaneObstacle4.setTranslateY(-10);
            PaneObstacle4.setTranslateX(rand4);

            PaneObstacle3.setTranslateX(rand3);

            PaneObstacle2.setTranslateX(rand2);

            PaneObstacle.setTranslateX(rand);

            if (collision(hit4, hit2) || collision(hit4, hit3) || collision(hit1, hit4)) {
                rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
                PaneObstacle4.setTranslateX(rand);

            }
            if (collision(hit3, hit2) || collision(hit3, hit4) || collision(hit3, hit)) {
                rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
                PaneObstacle3.setTranslateX(rand);

            }
            if (collision(hit2, hit4) || collision(hit2, hit3) || collision(hit2, hit)) {
                rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
                PaneObstacle2.setTranslateX(rand);

            }
            if (collision(hit1, hit2) || collision(hit1, hit3) || collision(hit1, hit4)) {
                rand = ThreadLocalRandom.current().nextInt(-500, 299 + 1);
                PaneObstacle.setTranslateX(rand);

            }

            timeline.stop();
            timelinerunning = false;
            

        }
        if (collision(hit1, rctBullet)) {

            PaneObstacle.setVisible(false);
            hit1.setVisible(false);
        }
        if (collision(rctBullet, hit2)) {
            PaneObstacle2.setVisible(false);
            hit2.setVisible(false);
            
        }
        if (collision(rctBullet, hit3) ) {
            PaneObstacle3.setVisible(false);
            hit3.setVisible(false);
            
        }
        if (collision(rctBullet, hit4)) {
            PaneObstacle4.setVisible(false);
            hit4.setVisible(false);

           
        }
        if (rctBullet.getTranslateY() > 500) {

        }
        
    }

    @FXML
    void KeyPressed(KeyEvent event) {
        if ((event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT)) {
            right = true;
        }
        if ((event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT)) {
            left = true;
        }
        if ((event.getCode() == KeyCode.SPACE) && (canstart == true)) {
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
        
        if(event.getCode() == KeyCode.ESCAPE){
             if(pause == false){
            imgPause.setImage(new Image(getClass().getResource("/play.png").toString()));
            timeline.stop();
            pause = true;
            timelinerunning = false;
            canstart = false;
        }

        else if(pause == true){
            imgPause.setImage(new Image(getClass().getResource("/pause.png").toString()));

           timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            pause = false;
            canstart = true;

        }
        }
        
    }

    @FXML
    void KeyRealsed(KeyEvent event) {
        if ((event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT)) {
            right = false;
        }
        if ((event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT)) {
            left = false;
        }

    }

    @FXML
    void btnOkayA(ActionEvent event) {
        paneNewHighScore.setVisible(false);
    }
    
    @FXML
    void shootA(MouseEvent event) {
        if (bulletcooldown == 1) {
           
            setX(rctBullet, getX(PanePlayer)+16);
            setY(rctBullet, getY(PanePlayer));

            
            bulletcooldowntime.setCycleCount(Timeline.INDEFINITE);
            bulletcooldowntime.play();
        }
        if (bulletcooldown >= 3) {
            bulletcooldown = 1;

            bulletcooldowntime.stop();
        }
        
    }

    


    

    @FXML
    void btnStartA(ActionEvent event) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    


    public boolean collision(ImageView block1, ImageView block2) {
        // returns true if the areas intersect, false if they dont
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    public boolean collision(Shape block1, Shape block2) {
        // If the objects can be changed to shapes just see if they intersect
        if (!block1.isVisible() || !block2.isVisible()) {
            return false;
        } else {
            Shape a = Shape.intersect(block1, block2);
            return a.getBoundsInLocal().getWidth() != -1;
        }

    }

    public boolean collision2(Shape block1, Shape block2) {
        // If the objects can be changed to shapes just see if they intersect
         
            Shape a = Shape.intersect(block1, block2);
            return a.getBoundsInLocal().getWidth() != -1;
        

    }

    public void setX(Node block1, double locX) {
        block1.setTranslateX(locX - block1.getLayoutX());
      
    }

    public double getX(Node block1) {
        return block1.getTranslateX() + block1.getLayoutX();
    }

    public void setY(Node block1, double locY) {
        block1.setTranslateY(locY - block1.getLayoutY());
    }

    public double getY(Node block1) {
        return block1.getTranslateY() + block1.getLayoutY();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tankHit.setVisible(false);
        MainApp.alert("EVADE THE IRS", "USE A OR D OR LEFT ARROW OR RIGHT ARROW TO DOGDE THE OBSTACLES. LEFT MOUSE BUTTON TO SHOOT AT ENEMYS. SHIFT IS A DASH USE WHILE MOVING. ESCAPE IS TO PAUSE AND UNPAUSE. SPACE BAR IS TO START", "THE GREEN BLOB GIVES YOU A SCORE MULTIPLYER AND THE BLUE ONE MAKES YOU INVISIBLE FOR SMALL TIME. ONCE YOU REACH 20 000 YOU BEAT THE GAME AND FIGHT A BOSS. GOOD LUCK");
        File myObj = new File(
                "/home/aummydahomie/folder1/folder/CarDodge/CarDodge/src/main/java/CarDodge/fxcore/highschool.txt");

        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int data2 = Integer.parseInt(data);
                MainApp.Highscore = data2;

                lblHighScore.setText("High score: " + data2);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
 //if (healthBar.getProgress()<=0){

                //File file = new File("/home/aummydahomie/CarDodge2/CarDodge/src/main/resources/Atomic Explosion - Meme plantilla.mp4");
      //  Media media = new Media(getClass().getResource("/Atomic Explosion - Meme plantilla.mp4").toString());
   //     MediaPlayer mediaPlayer = new MediaPlayer(media);
     //   mediaview.setMediaPlayer(mediaPlayer);
     //   mediaPlayer.play();
           // }


        /*
         * Make 3 diffreant car options
         * one a motorcycle which is slimmer allowing you to fit through gaps better
         * 
         
         * 

         * music
         
         */
    }
}
