package ir.ac.kntu;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.Calendar;

/**
 * @author danial chekani
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        ///////////////Sample
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.grayRgb(125));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Analog Clock");
        primaryStage.setResizable(false);
        primaryStage.show();

        Circle clockFrame = new Circle();
        clockFrame.setStroke(Color.WHITE);
        clockFrame.setStrokeWidth(7);
        clockFrame.setFill(Color.BLACK);
        clockFrame.setCenterX(250);
        clockFrame.setCenterY(250);
        clockFrame.setRadius(210);

        Circle middleCircle = new Circle();
        middleCircle.setRadius(5);
        middleCircle.setFill(Color.WHITE);
        middleCircle.setCenterX(250);
        middleCircle.setCenterY(250);

        Text city = new Text("Tehran");
        city.setY(150);
        city.setX(175);
        city.setFont(Font.font("penquin", FontWeight.BOLD, FontPosture.REGULAR, 45));
        city.setFill(Color.BLUE);
        city.setStroke(Color.WHITE);
        city.setStrokeWidth(1);

        Text number12 = new Text("12");
        number12.setX(240);
        number12.setY(62);
        number12.setFont(Font.font("penquin", FontWeight.BOLD, FontPosture.REGULAR, 18));
        number12.setFill(Color.WHITE);

        Text number3 = new Text("3");
        number3.setX(440);
        number3.setY(251);
        number3.setFont(Font.font("penquin", FontWeight.BOLD, FontPosture.REGULAR, 18));
        number3.setFill(Color.WHITE);

        Text number6 = new Text("6");
        number6.setX(240);
        number6.setY(448);
        number6.setFont(Font.font("penquin", FontWeight.BOLD, FontPosture.REGULAR, 18));
        number6.setFill(Color.WHITE);

        Text number9 = new Text("9");
        number9.setX(50);
        number9.setY(251);
        number9.setFont(Font.font("penquin", FontWeight.BOLD, FontPosture.REGULAR, 18));
        number9.setFill(Color.WHITE);

        Calendar currentTime =Calendar.getInstance();
        double currentSecond=currentTime.get(Calendar.SECOND)-0.5;
        double currentMinute=currentTime.get(Calendar.MONTH);
        double currentHour=currentTime.get(Calendar.HOUR_OF_DAY);

        double secondsX=calculateX(currentSecond,400,350);
        double secondsY=calculateY(currentSecond,400,350);
        double minutesX=calculateX(currentMinute,100,200);
        double minutesY=calculateY(currentMinute,100,200);
        double hoursX=calculateX((currentHour*5)%60,200,170);
        double hoursY=calculateY((currentHour*5)%60,200,170);

        Rectangle hourFirstDigit = new Rectangle(140,320,28,40);
        hourFirstDigit.setFill(Color.WHITE);
        hourFirstDigit.setArcWidth(10);
        hourFirstDigit.setArcHeight(10);
        Rectangle hourSecondDigit = new Rectangle(170,320,28,40);
        hourSecondDigit.setFill(Color.WHITE);
        hourSecondDigit.setArcWidth(10);
        hourSecondDigit.setArcHeight(10);

        Text hourFirstNumber = new Text();
        hourFirstNumber.setFill(Color.BLUE);
        hourFirstNumber.setX(145);
        hourFirstNumber.setY(350);
        hourFirstNumber.setFont(Font.font("LiquidCrystal",FontWeight.BOLD, FontPosture.REGULAR, 30));
        Text hourSecondNumber = new Text();
        hourSecondNumber.setFill(Color.BLUE);
        hourSecondNumber.setX(175);
        hourSecondNumber.setY(350);
        hourSecondNumber.setFont(Font.font("LiquidCrystal",FontWeight.BOLD, FontPosture.REGULAR, 30));


        Rectangle minuteFirstDigit = new Rectangle(218,320,28,40);
        minuteFirstDigit.setFill(Color.WHITE);
        minuteFirstDigit.setArcWidth(10);
        minuteFirstDigit.setArcHeight(10);
        Rectangle minuteSecondDigit = new Rectangle(248,320,28,40);
        minuteSecondDigit.setFill(Color.WHITE);
        minuteSecondDigit.setArcWidth(10);
        minuteSecondDigit.setArcHeight(10);

        Text minuteFirstNumber = new Text();
        minuteFirstNumber.setFill(Color.BLUE);
        minuteFirstNumber.setX(223);
        minuteFirstNumber.setY(350);
        minuteFirstNumber.setFont(Font.font("LiquidCrystal",FontWeight.BOLD, FontPosture.REGULAR, 30));
        Text minuteSecondNumber = new Text();
        minuteSecondNumber.setFill(Color.BLUE);
        minuteSecondNumber.setX(253);
        minuteSecondNumber.setY(350);
        minuteSecondNumber.setFont(Font.font("LiquidCrystal",FontWeight.BOLD, FontPosture.REGULAR, 30));


        Rectangle secondFirstDigit = new Rectangle(296,320,28,40);
        secondFirstDigit.setFill(Color.WHITE);
        secondFirstDigit.setArcWidth(10);
        secondFirstDigit.setArcHeight(10);
        Rectangle secondSecondDigit = new Rectangle(326,320,28,40);
        secondSecondDigit.setFill(Color.WHITE);
        secondSecondDigit.setArcWidth(10);
        secondSecondDigit.setArcHeight(10);

        Text secondFirstNumber = new Text();
        secondFirstNumber.setFill(Color.BLUE);
        secondFirstNumber.setX(301);
        secondFirstNumber.setY(350);
        secondFirstNumber.setFont(Font.font("LiquidCrystal",FontWeight.BOLD, FontPosture.REGULAR, 30));
        Text secondSecondNumber = new Text();
        secondSecondNumber.setFill(Color.BLUE);
        secondSecondNumber.setX(331);
        secondSecondNumber.setY(350);
        secondSecondNumber.setFont(Font.font("LiquidCrystal",FontWeight.BOLD, FontPosture.REGULAR, 30));


        Line secondCounter = new Line(250,250,secondsX,secondsY);
        secondCounter.setStroke(Color.RED);
        secondCounter.setStrokeWidth(1);

        Line minuteCounter = new Line(250,250,minutesX,minutesY);
        minuteCounter.setStroke(Color.WHITE);
        minuteCounter.setStrokeWidth(2);

        Line hourCounter = new Line(250,250,hoursX,hoursY);
        hourCounter.setStroke(Color.WHITE);
        hourCounter.setStrokeWidth(3);

        animateSecondsCounter(secondCounter);
        animateMinuteCounter(minuteCounter);
        animateHourCounter(hourCounter);
        animateSecondsDigits(secondFirstNumber,secondSecondNumber);
        animateMinutesDigits(minuteFirstNumber,minuteSecondNumber);
        animateHoursDigits(hourFirstNumber,hourSecondNumber);

        root.getChildren().add(clockFrame);
        root.getChildren().add(number12);
        root.getChildren().add(number3);
        root.getChildren().add(number6);
        root.getChildren().add(number9);
//        root.getChildren().add(city);
        root.getChildren().add(hourFirstDigit);
        root.getChildren().add(hourSecondDigit);
        root.getChildren().add(minuteFirstDigit);
        root.getChildren().add(minuteSecondDigit);
        root.getChildren().add(secondFirstDigit);
        root.getChildren().add(secondSecondDigit);
        root.getChildren().add(hourFirstNumber);
        root.getChildren().add(hourSecondNumber);
        root.getChildren().add(minuteFirstNumber);
        root.getChildren().add(minuteSecondNumber);
        root.getChildren().add(secondFirstNumber);
        root.getChildren().add(secondSecondNumber);
        root.getChildren().add(secondCounter);
        root.getChildren().add(minuteCounter);
        root.getChildren().add(hourCounter);
        root.getChildren().add(middleCircle);

        ///////////////////////////////////////
    }

    public static double calculateX(double number,double endX,double endY){
        double length = Math.sqrt((endX - 250)*(endX - 250) + (endY - 250)*(endY - 250));
        number=number%60;
        double degree=number*6;
        return 250+(Math.sin(Math.toRadians(degree))*length);
    }

    public static double calculateY(double number,double endX,double endY){
        double length = Math.sqrt((endX - 250)*(endX - 250) + (endY - 250)*(endY - 250));
        number=number%60;
        double degree=number*6;
        return 250-(Math.cos(Math.toRadians(degree))*length);
    }

    private void animateSecondsCounter(Line secondCounter) {

        String musicFile = "assets/sound/clock-tick.mp3";

        javafx.scene.media.Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);

        Rotate rotate = new Rotate();
        rotate.setAngle(6);
        rotate.pivotXProperty().setValue(250);
        rotate.pivotYProperty().setValue(250);
        secondCounter.getTransforms().removeAll();
        KeyFrame keyFrame2 = new KeyFrame(
                Duration.ZERO,
                event -> mediaPlayer.play()
        );
        KeyFrame keyFrame3 = new KeyFrame(
                Duration.seconds(1),
                event -> mediaPlayer.stop()
        );
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0),
                event ->secondCounter.getTransforms().add(rotate)
        );
        KeyFrame keyFrame1 = new KeyFrame(
                Duration.seconds(1),
                event ->secondCounter.getTransforms().removeAll()
        );
        Timeline beat = new Timeline(keyFrame,keyFrame2,keyFrame1,keyFrame3);
        beat.setCycleCount(Timeline.INDEFINITE);
        beat.play();
    }

    private void animateMinuteCounter(Line minuteCounter) {

        Rotate rotate = new Rotate();
        rotate.setAngle(0.1);
        rotate.pivotXProperty().setValue(250);
        rotate.pivotYProperty().setValue(250);
        minuteCounter.getTransforms().removeAll();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0),
                event ->minuteCounter.getTransforms().add(rotate)
        );
        KeyFrame keyFrame1 = new KeyFrame(
                Duration.seconds(1),
                event ->minuteCounter.getTransforms().removeAll()
        );
        Timeline beat = new Timeline(keyFrame,keyFrame1);
        beat.setCycleCount(Timeline.INDEFINITE);
        beat.play();
    }

    private void animateHourCounter(Line hourCounter) {
        Rotate rotate = new Rotate();
        rotate.setAngle(0.00166666666667);
        rotate.pivotXProperty().setValue(250);
        rotate.pivotYProperty().setValue(250);
        hourCounter.getTransforms().removeAll();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0),
                event ->hourCounter.getTransforms().add(rotate)
        );
        KeyFrame keyFrame1 = new KeyFrame(
                Duration.seconds(1),
                event ->hourCounter.getTransforms().removeAll()
        );
        Timeline beat = new Timeline(keyFrame,keyFrame1);
        beat.setCycleCount(Timeline.INDEFINITE);
        beat.play();
    }

    public static void animateSecondsDigits(Text secondFirstDigit,Text secondSecondDigit){
        final Calendar[] currentTime = new Calendar[1];
        final double[] currentMinute = new double[1];

        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0),
                event -> currentTime[0] =Calendar.getInstance()
        );
        KeyFrame keyFrame1 = new KeyFrame(
                Duration.seconds(0),
                event -> currentMinute[0] =currentTime[0].get(Calendar.SECOND)
        );
        KeyFrame keyFrame2 = new KeyFrame(
                Duration.seconds(0),
                event -> secondSecondDigit.setText(String.valueOf((int)currentMinute[0]%10))
        );
        KeyFrame keyFrame3 = new KeyFrame(
                Duration.seconds(0),
                event -> secondFirstDigit.setText(String.valueOf((int)currentMinute[0]/10))
        );
        KeyFrame keyFrame4 = new KeyFrame(
                Duration.seconds(1)
        );
        Timeline beat = new Timeline(keyFrame,keyFrame1,keyFrame2,keyFrame3,keyFrame4);
        beat.setCycleCount(Timeline.INDEFINITE);
        beat.play();
    }

    public static void animateMinutesDigits(Text minuteFirstDigit,Text minuteSecondDigit){
        final Calendar[] currentTime = new Calendar[1];
        final double[] currentMinute = new double[1];

        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0),
                event -> currentTime[0] =Calendar.getInstance()
        );
        KeyFrame keyFrame1 = new KeyFrame(
                Duration.seconds(0),
                event -> currentMinute[0] =currentTime[0].get(Calendar.MINUTE)
        );
        KeyFrame keyFrame2 = new KeyFrame(
                Duration.seconds(0),
                event -> minuteSecondDigit.setText(String.valueOf((int)currentMinute[0]%10))
        );
        KeyFrame keyFrame3 = new KeyFrame(
                Duration.seconds(0),
                event -> minuteFirstDigit.setText(String.valueOf((int)currentMinute[0]/10))
        );
        KeyFrame keyFrame4 = new KeyFrame(
                Duration.seconds(1)
        );
        Timeline beat = new Timeline(keyFrame,keyFrame1,keyFrame2,keyFrame3,keyFrame4);
        beat.setCycleCount(Timeline.INDEFINITE);
        beat.play();
    }

    public static void animateHoursDigits(Text hourFirstDigit,Text hourSecondDigit){
        final Calendar[] currentTime = new Calendar[1];
        final double[] currentMinute = new double[1];

        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0),
                event -> currentTime[0] =Calendar.getInstance()
        );
        KeyFrame keyFrame1 = new KeyFrame(
                Duration.seconds(0),
                event -> currentMinute[0] =currentTime[0].get(Calendar.HOUR)
        );
        KeyFrame keyFrame2 = new KeyFrame(
                Duration.seconds(0),
                event -> hourSecondDigit.setText(String.valueOf((int)currentMinute[0]%10))
        );
        KeyFrame keyFrame3 = new KeyFrame(
                Duration.seconds(0),
                event -> hourFirstDigit.setText(String.valueOf((int)currentMinute[0]/10))
        );
        KeyFrame keyFrame4 = new KeyFrame(
                Duration.seconds(1)
        );
        Timeline beat = new Timeline(keyFrame,keyFrame1,keyFrame2,keyFrame3,keyFrame4);
        beat.setCycleCount(Timeline.INDEFINITE);
        beat.play();
    }

    @Override
    public void init() {
        System.out.println("Initializing...");
    }

    @Override
    public void stop() {
        System.out.println("Closing....");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
