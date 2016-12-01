import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    Circle oun = new Circle(5);
    private int laius = 500;
    Label punktidLabel = new Label();
    int peaX = 250;
    int peaY = 250;

    int vektorX = 0;
    int vektorY = 0;
    int counter = 0;
    int punktid = 0;
    int tase = 1;
    Pane laud = new Pane();
    Group ussiKeha = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();

        laud.getChildren().add(ussiKeha);
        Scene gameScene = new Scene(laud,laius,laius);
        primaryStage.setScene(gameScene);

        gameScene.setOnKeyPressed(event -> {
            if (vektorY != 0) {
                if(event.getCode() == KeyCode.RIGHT){
                    vektorX = +10;
                    vektorY = 0;
                } else if (event.getCode() == KeyCode.LEFT) {
                    vektorX = -10;
                    vektorY = 0;
                }
            } else {
                if(event.getCode() == KeyCode.DOWN){
                    vektorY = +10;
                    vektorX = 0;
                } else if (event.getCode() == KeyCode.UP){
                    vektorY = -10;
                    vektorX = 0;
                }
            }
        });

        laud.getChildren().add(oun);
        paigutaOun();
        oun.setFill(Color.RED);

        Rectangle piire = new Rectangle(0, 0, 500, 500 );
        piire.setFill(Color.TRANSPARENT);
        piire.setStroke(Color.BLACK);
        piire.setStrokeWidth(5);
        laud.getChildren().add(piire);

        laud.getChildren().add(punktidLabel);


        System.out.println("START");
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                double aeg = 20 - tase / 2;
                aeg = Math.max(aeg, 0.00000000000001);
                if (counter != aeg){
                   counter = counter +1;
                    return;
                }
                counter = 0;
                peaX += vektorX;
                peaY += vektorY;

                if (oun.getCenterX() == peaX && oun.getCenterY() == peaY){
                    paigutaOun();
                    punktid = punktid + 1;
                    System.out.println(punktid);
                    tase = tase + 1;
                    String p = Integer.toString(punktid);
                    punktidLabel.setText(p);
                    uusPea(peaX, peaY, true);
                } else {
                    uusPea(peaX, peaY, false);
                }
                if (peaY > 495 || 5 > peaY || peaX > 495 || 5 > peaX ){
                    System.out.println("GAMEOVER");
                }


            }

        }.start();
        System.out.println("END");



    }

    private void uusPea(int x, int y, boolean skipDelete){
        System.out.println("uus jupp " + x + "-" + y);
        Circle jupp = new Circle(5);
        jupp.setCenterX(x);
        jupp.setCenterY(y);
        ussiKeha.getChildren().add(jupp);
        if (ussiKeha.getChildren().size() > 1 && skipDelete == false)
            ussiKeha.getChildren().remove(0, 1);
    }

    private void paigutaOun() {
        Random pos1 = new Random();
        Random pos2 = new Random();

        int n = pos1.nextInt (49) +1 ;
        int m = pos2.nextInt (49) +1 ;
        oun.setCenterX(n * 10);
        oun.setCenterY(m * 10);
    }
}
// pea pendeldamine, ääred ja miks 21 kokku paneb