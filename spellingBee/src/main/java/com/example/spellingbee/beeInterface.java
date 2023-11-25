package com.example.spellingbee;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class beeInterface extends Pane {
    Label pointLbl = new Label();

    String infoLblText = "Bulunan Kelimeler : \n";
    Label infoLabel = new Label(infoLblText);
    String foundLblTxt = "";
    Text foundText = new Text("");
    TextField textField;
    Button refreshBtn = new Button("Refresh");
    Button startBtn = new Button("Start");
    Button tickBtn;
    Button deleteBtn;
    String firstButton = "";
    ArrayList<Button> buttons = new ArrayList<>();
    ArrayList<Button> shuffleButtons = new ArrayList<>();
    String mostLengthWords = ""; // en uzun kelime
    int count5 = 120;
    File sourceFile;
    Scanner scanner;
    ArrayList<String> lines = new ArrayList<>();
    String pointLblText="0";
    int numLblText = Integer.parseInt(pointLblText);
    public beeInterface() throws FileNotFoundException {
        getChildren().addAll(infoLabel,pointLbl,startBtn);
        startBtn.relocate(25,25);
        pointLbl.relocate(395,10);
        pointLbl.setFont(Font.font("Verdana",25));
        infoLabel.relocate(350,55);
        infoLabel.setFont(Font.font("Verdana",17));
        foundText.relocate(390,85);
        foundText.setFont(Font.font("Verdana",15));
        textField = new TextField();
        textField.relocate(150,150);
        // image button
        FileInputStream img = new FileInputStream("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\tick_icon.png");
        Image image = new Image(img);
        ImageView view = new ImageView(image);
        tickBtn = new Button();
        tickBtn.setGraphic(view);
        tickBtn.relocate(250,180);
        //delete button
        FileInputStream deleteImg = new FileInputStream("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\del_icon.png");
        Image deleteImage = new Image(deleteImg);
        ImageView delView = new ImageView(deleteImage);
        deleteBtn = new Button();
        deleteBtn.setGraphic(delView);
        deleteBtn.relocate(150,180);
        //refresh button
        FileInputStream refreshImg = new FileInputStream("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\refresh_icon.png");
        Image refreshImage = new Image(refreshImg);
        ImageView refreshView = new ImageView(refreshImage);
        refreshBtn = new Button();
        refreshBtn.setGraphic(refreshView);
        refreshBtn.relocate(200,180);
        //
        buttons = new ArrayList<>();
        for (int i = 0; i < mostLengthWords.length(); i++) {
            buttons.add(new Button(mostLengthWords.substring(i, i + 1)));
        }


        for (Button btn : buttons) {

            btn.setShape(new Circle(4, 4, 4));
            btn.setFont(Font.font("Verdana", 15));

            getChildren().addAll(btn);



        }

        getChildren().addAll(tickBtn,deleteBtn);
        firstButton = buttons.get(0).getText();
        buttons.get(0).setStyle("-fx-background-color: Yellow");
        getChildren().addAll(textField, foundText, refreshBtn);
        shuffleWords();
        count5=120;
        for(Button btn :buttons) {
            btn.relocate(count5,120);
            count5+=30;
        }


    }
    private void shuffleWords() {
        getChildren().removeAll(buttons);
        getChildren().removeAll(tickBtn,textField,foundText,deleteBtn, refreshBtn);

        shuffleButtons.add(buttons.get(6));
        shuffleButtons.add(buttons.get(4));
        shuffleButtons.add(buttons.get(2));// butonları karıştırma işlemi
        shuffleButtons.add(buttons.get(1));
        shuffleButtons.add(buttons.get(0));
        shuffleButtons.add(buttons.get(3));
        shuffleButtons.add(buttons.get(5));

        buttons.clear();
        buttons.addAll(shuffleButtons);
        shuffleButtons.clear();
        for (Button btn : buttons) {
            btn.setShape(new Circle(4, 4, 4));
            btn.setFont(Font.font("Verdana", 15));
            getChildren().addAll(btn);
        }
        for(Button btn :buttons) {

            btn.relocate(count5,120);
            count5+=30;
        }
        getChildren().addAll(tickBtn,textField,foundText,deleteBtn,refreshBtn);

    }
    private int getWords() {

        String line = "";
        int wordsLength = 0;
        String temp = "";
        try {
            sourceFile = new File("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\asd.txt");
            scanner = new Scanner(sourceFile);
            temp = "";
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                lines.add(line);
                // System.out.println(line); // try it

                if (line.length() == 7) {
                    mostLengthWords=line;
                }

            }
            // System.out.println(line); // en uzun kelimeyi bulma testi

            wordsLength = line.length();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not found! or file is not exists!");
        }


        return wordsLength;


    }
    private void functionButtons() {

        for (Button btn : buttons) {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String text = textField.getText();
                    text += btn.getText();
                    textField.setText(text);
                }
            });
        }
        tickBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//
                for (String line : lines) {
                    if (line.length() >= 4 && line.hashCode() == textField.getText().hashCode() && isInclude()) {
                        System.out.println(String.format("Bulunan Kelime : %s", line));
                        setLblDesign(); // update label text
                        lines.remove(line); // bulunan kelimeyi sil
                        textField.setText(""); // reset textField
                        setPoint();
                        break;
                    }
                }
            }
        });
        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(textField.getText()!="") {
                    String deletingText = textField.getText();
                    deletingText = deletingText.substring(0, deletingText.length() - 1);
                    textField.setText(deletingText);
                }
            }
        });
        refreshBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                count5=120;
                shuffleWords();


            }
        });
        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    beeInterface newgame = new beeInterface();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }
    private void setLblDesign() {

        foundLblTxt += textField.getText() + "\n";
        foundText.setText(foundLblTxt);
        foundText.setStrikethrough(true);


    }
    private boolean isInclude() {

        boolean isInclude = false;
        int count = 0;
        for (int i = count + 1; i <= textField.getLength(); i++) {
            if (textField.getText().substring(count, i).hashCode() == firstButton.hashCode()) {
                isInclude = true;

            }
            count += 1;
        }
        return isInclude;
    }

    private void setPoint() {

        numLblText+=10;
        String toStringNumLblTxt = String.valueOf(numLblText);
        pointLbl.setText("Point : " + toStringNumLblTxt);

    }







}
