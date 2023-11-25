//package com.example.spellingbee;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.*;
//import javafx.scene.shape.Circle;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;
//
//public class spellingBee extends Pane {
//    // global variables
//    String pointLblText="0";
//    int numLblText = Integer.parseInt(pointLblText);
//    Label pointLbl = new Label("Point : ");
//    String firstButton = "";
//    File sourceFile;
//    Scanner scanner;
//    Button tickBtn;
//    Button deleteBtn;
//    Button refreshbtn = new Button("Refresh");
//    String mostLengthWords = ""; // en uzun kelime
//    ArrayList<Button> buttons = new ArrayList<>();
//    ArrayList<Button> shuffleButtons = new ArrayList<>();
//    ArrayList<String> lines = new ArrayList<>();
//    TextField textField;
//
//    String infoLblText = "Bulunan Kelimeler : \n";
//    Label infoLabel = new Label(infoLblText);
//    String foundLblTxt = "";
//    Text foundText = new Text("");
//
//    public spellingBee() throws FileNotFoundException {
//
//        getChildren().addAll(infoLabel,pointLbl);
//        getWords();
//        drawButtons();
//        functionButtons();
//
//
//    }
//
//    private int getWords() {
//
//        String line = "";
//        int wordsLength = 0;
//        String temp = "";
//        try {
//            sourceFile = new File("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\asd.txt");
//            scanner = new Scanner(sourceFile);
//            temp = "";
//            while (scanner.hasNext()) {
//                line = scanner.nextLine();
//                lines.add(line);
//                // System.out.println(line); // try it
//
//                if (line.length() == 7) {
//                    mostLengthWords=line;
//                }
//
//            }
//            // System.out.println(line); // en uzun kelimeyi bulma testi
//
//            wordsLength = line.length();
//            scanner.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("File not found! or file is not exists!");
//        }
//
//
//        return wordsLength;
//
//
//    }
//
//
//    private void drawButtons() throws FileNotFoundException {
//
//
//        textField = new TextField();
//        // image button
//        FileInputStream img = new FileInputStream("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\tick_icon.png");
//        Image image = new Image(img);
//        ImageView view = new ImageView(image);
//        tickBtn = new Button();
//        tickBtn.setGraphic(view);
//        //delete button
//        FileInputStream deleteImg = new FileInputStream("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\del_icon.png");
//        Image deleteImage = new Image(deleteImg);
//        ImageView delView = new ImageView(deleteImage);
//        deleteBtn = new Button();
//        deleteBtn.setGraphic(delView);
//        //refresh button
//        FileInputStream refreshImg = new FileInputStream("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\refresh_icon.png");
//        Image refreshImage = new Image(refreshImg);
//        ImageView refreshView = new ImageView(refreshImage);
//        refreshbtn = new Button();
//        refreshbtn.setGraphic(refreshView);
//        //
//        buttons = new ArrayList<>();
//        for (int i = 0; i < mostLengthWords.length(); i++) {
//            buttons.add(new Button(mostLengthWords.substring(i, i + 1)));
//        }
//        double degisken=50;
//        double locateX=50.0;
//        double locateY=50.0;
//        for (Button btn : buttons) {
//            btn.setShape(new Circle(4, 4, 4));
//            btn.setFont(Font.font("Verdana", 15));
//            btn.relocate(degisken,locateY);
//            degisken+=50;
//            getChildren().addAll(btn);
//        }
//        locateY=400;
//        textField.relocate(35,400);
//        locateY+=40;
//        tickBtn.relocate(35, 440);
//        locateX+=40;
//        deleteBtn.relocate(120,435);
//        infoLabel.relocate(250,250);
//        foundText.relocate(380,215);
//        pointLbl.relocate(440,50);
//        refreshbtn.relocate(75,480);
//        getChildren().addAll(tickBtn);
//        firstButton = buttons.get(0).getText();
//        getChildren().addAll(textField, foundText, refreshbtn);
//        shuffleWords();
//    }
//    private void shuffleWords() throws FileNotFoundException {
//        getChildren().removeAll(buttons);
//        getChildren().removeAll(tickBtn,textField,foundText,deleteBtn, refreshbtn);
//        shuffleButtons.add(buttons.get(6));
//        shuffleButtons.add(buttons.get(4));
//        shuffleButtons.add(buttons.get(2));// butonları karıştırma işlemi
//        shuffleButtons.add(buttons.get(1));
//        shuffleButtons.add(buttons.get(0));
//        shuffleButtons.add(buttons.get(3));
//        shuffleButtons.add(buttons.get(5));
//        buttons.clear();
//        buttons.addAll(shuffleButtons);
//        shuffleButtons.clear();
//        double degisken =50.0;
//        double locateX=50.0;
//        double locateY=50.0;
//        for (Button btn : buttons) {
//            btn.setShape(new Circle(4, 4, 4));
//            btn.setFont(Font.font("Verdana", 15));
//            btn.setStyle("-fx-background-color: #fff; ");
//            btn.relocate(degisken,locateY);
//            degisken+=50;
//            getChildren().addAll(btn);
//        }
//        getChildren().addAll(tickBtn,textField,foundText,deleteBtn,refreshbtn);
//
//    }
//
//    private void functionButtons() {
//
//        for (Button btn : buttons) {
//            btn.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent actionEvent) {
////                    System.out.println(btn.getStyle());
////                    if(btn.getStyle().toString()=="-fx-background-color: #fff;")
//                        btn.setStyle("-fx-background-color: #ff0;");
////                    if(btn.getStyle().toString()=="-fx-background-color: #ff0;")
////                        btn.setStyle("-fx-background-color: #fff; ");
//                    String text = textField.getText();
//                    text += btn.getText();
//                    textField.setText(text);
//                }
//            });
//        }
//        tickBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
////
//                for (String line : lines) {
//                    if (line.length() >= 4 && line.hashCode() == textField.getText().hashCode() && isInclude()) {
//                        System.out.println(String.format("Bulunan Kelime : %s", line));
//                        setLblDesign(); // update label text
//                        lines.remove(line); // bulunan kelimeyi sil
//                        textField.setText(""); // reset textField
//                        setPoint();
//                        break;
//                    }
//                }
//            }
//        });
//        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                if(textField.getText()!="") {
//                    String deletingText = textField.getText();
//                    deletingText = deletingText.substring(0, deletingText.length() - 1);
//                    textField.setText(deletingText);
//                }
//            }
//        });
//        refreshbtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                try {
//                    shuffleWords();
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//
//    }
//
//    private void setLblDesign() {
//
//        foundLblTxt += textField.getText() + "\n";
//        foundText.setText(foundLblTxt);
//        foundText.setStrikethrough(true);
//
//
//    }
//
//    private boolean isInclude() {
//
//        boolean isInclude = false;
//        int count = 0;
//        for (int i = count + 1; i <= textField.getLength(); i++) {
//            if (textField.getText().substring(count, i).hashCode() == firstButton.hashCode()) {
//                isInclude = true;
//
//            }
//            count += 1;
//        }
//        return isInclude;
//    }
//    private void setPoint() {
//
//        numLblText+=10;
//        String toStringNumLblTxt = String.valueOf(numLblText);
//        pointLbl.setText("Point : " + toStringNumLblTxt);
//
//    }
//}

//package com.example.spellingbee;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.*;
//import javafx.scene.shape.Circle;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;
//
//class SpellingBee extends Pane {
//     //global variables
//    String pointLblText="0";
//    int numLblText = Integer.parseInt(pointLblText);
//    Label pointLbl = new Label("Point : ");
//    String firstButton = "";
//    File sourceFile;
//    Scanner scanner;
//    Button tickBtn;
//    Button deleteBtn;
//    Button refreshBtn = new Button("Refresh");
//    String mostLengthWords = ""; // en uzun kelime
//    ArrayList<Button> buttons = new ArrayList<>();
//    ArrayList<Button> shuffleButtons = new ArrayList<>();
//    ArrayList<String> lines = new ArrayList<>();
//    TextField textField;
//    int count5 = 120;
//    String infoLblText = "Bulunan Kelimeler : \n";
//    Label infoLabel = new Label(infoLblText);
//    String foundLblTxt = "";
//    Text foundText = new Text("");
//    Button newgameBtn = new Button("New Game");
//
//    public SpellingBee() throws FileNotFoundException {
//
//        getChildren().addAll(infoLabel,pointLbl);
//
//        getWords();
//
//        drawButtons();
//
//        functionButtons();
//
//
//
//    }
//
//    private int getWords() {
//
//        String line = "";
//        int wordsLength = 0;
//        String temp = "";
//        try {
//            sourceFile = new File("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\asd.txt");
//            scanner = new Scanner(sourceFile);
//            temp = "";
//            while (scanner.hasNext()) {
//                line = scanner.nextLine();
//                lines.add(line);
//                // System.out.println(line); // try it
//
//                if (uniqueWord(line)) {// kosul ekle her harfi birbirinden farklı kelime kontrolü
//                    mostLengthWords=line;
//
//                }
//                break;
//
//
//            }
//            // System.out.println(line); // en uzun kelimeyi bulma testi
//
//            wordsLength = line.length();
//            scanner.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("File not found! or file is not exists!");
//        }
//
//
//        return wordsLength;
//
//
//    }
//
//
//    private void drawButtons() throws FileNotFoundException {
//        getChildren().addAll(newgameBtn);
//        newgameBtn.relocate(25,25);
//        pointLbl.relocate(395,10);
//        pointLbl.setFont(Font.font("Verdana",25));
//        infoLabel.relocate(350,55);
//        infoLabel.setFont(Font.font("Verdana",17));
//        foundText.relocate(390,85);
//        foundText.setFont(Font.font("Verdana",15));
//        textField = new TextField();
//        textField.relocate(150,150);
//        // image button
//        FileInputStream img = new FileInputStream("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\tick_icon.png");
//        Image image = new Image(img);
//        ImageView view = new ImageView(image);
//        tickBtn = new Button();
//        tickBtn.setGraphic(view);
//        tickBtn.relocate(250,180);
//        //delete button
//        FileInputStream deleteImg = new FileInputStream("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\del_icon.png");
//        Image deleteImage = new Image(deleteImg);
//        ImageView delView = new ImageView(deleteImage);
//        deleteBtn = new Button();
//        deleteBtn.setGraphic(delView);
//        deleteBtn.relocate(150,180);
//        //refresh button
//        FileInputStream refreshImg = new FileInputStream("D:\\ydk\\okul\\java\\spelling bee\\spellingBee\\refresh_icon.png");
//        Image refreshImage = new Image(refreshImg);
//        ImageView refreshView = new ImageView(refreshImage);
//        refreshBtn = new Button();
//        refreshBtn.setGraphic(refreshView);
//        refreshBtn.relocate(200,180);
//        //
//        buttons = new ArrayList<>();
//        for (int i = 0; i < mostLengthWords.length(); i++) {
//            buttons.add(new Button(mostLengthWords.substring(i, i + 1)));
//        }
//
//
//        for (Button btn : buttons) {
//
//            btn.setShape(new Circle(4, 4, 4));
//            btn.setFont(Font.font("Verdana", 15));
//
//            getChildren().addAll(btn);
//
//
//
//        }
//        getChildren().addAll(tickBtn,deleteBtn);
//        firstButton = buttons.get(0).getText();
//        buttons.get(0).setStyle("-fx-background-color: Yellow");
//        getChildren().addAll(textField, foundText, refreshBtn);
//        shuffleWords();
//        count5=120;
//        for(Button btn :buttons) {
//            btn.relocate(count5,120);
//            count5+=30;
//        }
//
//
//    }
//    private void shuffleWords() {
//        getChildren().removeAll(buttons);
//        getChildren().removeAll(tickBtn,textField,foundText,deleteBtn, refreshBtn);
//
//        shuffleButtons.add(buttons.get(6));
//        shuffleButtons.add(buttons.get(4));
//        shuffleButtons.add(buttons.get(2));// butonları karıştırma işlemi
//        shuffleButtons.add(buttons.get(1));
//        shuffleButtons.add(buttons.get(0));
//        shuffleButtons.add(buttons.get(3));
//        shuffleButtons.add(buttons.get(5));
//
//        buttons.clear();
//        buttons.addAll(shuffleButtons);
//        shuffleButtons.clear();
//        for (Button btn : buttons) {
//            btn.setShape(new Circle(4, 4, 4));
//            btn.setFont(Font.font("Verdana", 15));
//            getChildren().addAll(btn);
//        }
//        for(Button btn :buttons) {
//
//            btn.relocate(count5,120);
//            count5+=30;
//        }
//        getChildren().addAll(tickBtn,textField,foundText,deleteBtn,refreshBtn);
//
//    }
//
//    private void functionButtons() {
//
//        for (Button btn : buttons) {
//            btn.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent actionEvent) {
//                    String text = textField.getText();
//                    text += btn.getText();
//                    textField.setText(text);
//                }
//            });
//        }
//        tickBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
////
//                for (String line : lines) {
//                    if (line.length() >= 4 && line.hashCode() == textField.getText().hashCode() && isInclude()) {
//                        System.out.println(String.format("Bulunan Kelime : %s", line));
//                        setLblDesign(); // update label text
//                        lines.remove(line); // bulunan kelimeyi sil
//                        textField.setText(""); // reset textField
//                        setPoint();
//                        break;
//                    }
//                }
//            }
//        });
//        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                if(textField.getText()!="") {
//                    String deletingText = textField.getText();
//                    deletingText = deletingText.substring(0, deletingText.length() - 1);
//                    textField.setText(deletingText);
//                }
//            }
//        });
//        refreshBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                count5=120;
//                shuffleWords();
//            }
//        });
//        newgameBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                try {
//                    SpellingBee newgame= new SpellingBee();
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//
//    }
//
//    private void setLblDesign() {
//
//        foundLblTxt += textField.getText() + "\n";
//        foundText.setText(foundLblTxt);
//        foundText.setStrikethrough(true);
//
//
//    }
//
//    private boolean isInclude() {
//
//        boolean isInclude = false;
//        int count = 0;
//        for (int i = count + 1; i <= textField.getLength(); i++) {
//            if (textField.getText().substring(count, i).hashCode() == firstButton.hashCode()) {
//                isInclude = true;
//
//            }
//            count += 1;
//        }
//        return isInclude;
//    }
//    private void setPoint() {
//
//        numLblText+=10;
//        String toStringNumLblTxt = String.valueOf(numLblText);
//        pointLbl.setText("Point : " + toStringNumLblTxt);
//
//    }
//    private boolean uniqueWord(String line)
//    {
//        boolean bool = true;
//        String[] array = new String[line.length()];
//        for (int i =0;i<line.length();i++)
//        {
//            array[i] = line.substring(i,i+1);
//            System.out.println(array[i]);
//        }
//        for (int i =0; i<line.length()-1;i++)       // 0 1 5     0 2 5     0 3 5       0 4 5
//        {                                           // 1 2 5     1 3 5     1 4 5
//            for (int j = i+1; j<line.length();j++)  // 2 3 5     2 4 5
//            {                                       // 3 4 5
//                if(array[i] == array[j])
//                    bool = false;
//                break;
//            }
//            break;
//        }
//        return bool;
//    }
//}

//package com.example.spellingbee;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.*;
//import javafx.scene.shape.Circle;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;

//class SpellingBee extends Pane {
//    // global variables
//    String pointLblText="0";
//    int numLblText = Integer.parseInt(pointLblText);
//    Label pointLbl = new Label("Point : ");
//    String firstButton = "";
//    File sourceFile;
//    Scanner scanner;
//    Button tickBtn;
//    Button deleteBtn;
//    Button refreshBtn = new Button("Refresh");
//    String mostLengthWords = ""; // en uzun kelime
//    ArrayList<Button> buttons = new ArrayList<>();
//    ArrayList<Button> shuffleButtons = new ArrayList<>();
//    ArrayList<String> lines = new ArrayList<>();
//    TextField textField;
//    int count5 = 120;
//    String infoLblText = "Bulunan Kelimeler : \n";
//    Label infoLabel = new Label(infoLblText);
//    String foundLblTxt = "";
//    Text foundText = new Text("");
//    Button btnAnotherMode = new Button("click to another mode!");
//    TextField anotherModeTxt = new TextField();
//    Label anotherModeLbl = new Label("7 Eşsiz Harf Girin : ");
//    Button enterBtnAnotherMode =new Button("Enter");
//    Button newGameBtn = new Button("New Game");
//    ArrayList<String> pangrams = new ArrayList<>();
//    String tempp="";
//    Random random = new Random();
//    public SpellingBee() throws FileNotFoundException {
//
//        getChildren().addAll(infoLabel,pointLbl,btnAnotherMode);
//        getWords(); // mostLengthWords
//        drawButtons();
//        functionButtons();
//
//    }
//
//    private int getWords() {
//
//        String line = "";
//        int wordsLength = 0;
//        String temp = "";
//        try {
//            sourceFile = new File("D:\\\\ydk\\\\okul\\\\java\\\\spelling bee\\\\spellingBee\\\\asd.txt");
//            scanner = new Scanner(sourceFile);
//            temp = "";
//            while (scanner.hasNext()) {
//                line = scanner.nextLine();
//                lines.add(line);
//            }
//            for(String linne:lines)
//            {
//                if (linne.length()>=7)
//                {
//                    if (getUniqWords(linne).length()==7)
//                    {
//                        pangrams.add(linne);
////                        System.out.println(linne);
////                        mostLengthWords = getUniqWords(linne);
////                        System.out.println(mostLengthWords);
////                        break;
//                    }
//                }
//            }
//            wordsLength = line.length();
//            scanner.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("File not found! or file is not exists!");
//        }
//
//
//        return wordsLength;
//
//
//    }
//
//
//    private void drawButtons() throws FileNotFoundException {
//
//        pointLbl.relocate(395,10);
//        pointLbl.setFont(Font.font("Verdana",25));
//        infoLabel.relocate(350,55);
//        infoLabel.setFont(Font.font("Verdana",17));
//        foundText.relocate(390,85);
//        foundText.setFont(Font.font("Verdana",15));
//        textField = new TextField();
//        textField.relocate(150,150);
//        // image button
//        FileInputStream img = new FileInputStream("D:\\\\ydk\\\\okul\\\\java\\\\spelling bee\\\\spellingBee\\\\tick_icon.png");
//        Image image = new Image(img);
//        ImageView view = new ImageView(image);
//        tickBtn = new Button();
//        tickBtn.setGraphic(view);
//        tickBtn.relocate(250,180);
//        //delete button
//        FileInputStream deleteImg = new FileInputStream("D:\\\\ydk\\\\okul\\\\java\\\\spelling bee\\\\spellingBee\\\\del_icon.png");
//        Image deleteImage = new Image(deleteImg);
//        ImageView delView = new ImageView(deleteImage);
//        deleteBtn = new Button();
//        deleteBtn.setGraphic(delView);
//        deleteBtn.relocate(150,180);
//        //refresh button
//        FileInputStream refreshImg = new FileInputStream("D:\\\\ydk\\\\okul\\\\java\\\\spelling bee\\\\spellingBee\\\\refresh_icon.png");
//        Image refreshImage = new Image(refreshImg);
//        ImageView refreshView = new ImageView(refreshImage);
//        refreshBtn = new Button();
//        refreshBtn.setGraphic(refreshView);
//        refreshBtn.relocate(200,180);
//        //
//        tempp = choosePangram(); // rastgele pangram kelime seçtiriyoruz.
//        mostLengthWords = getUniqWords(tempp); // seçilen rastgele pangram kelimenin eşsiz 7 harfini almak için yapılan işlem
//        buttons = new ArrayList<>();
//        for (int i = 0; i < mostLengthWords.length(); i++) {
//            buttons.add(new Button(mostLengthWords.substring(i, i + 1)));
//        }
//
//
//        for (Button btn : buttons) {
//
//            btn.setShape(new Circle(4, 4, 4));
//            btn.setFont(Font.font("Verdana", 15));
//
//            getChildren().addAll(btn);
//
//
//
//        }
//        newGameBtn.relocate(100,50);
//        getChildren().addAll(tickBtn,deleteBtn);
//        firstButton = buttons.get(0).getText();
//        buttons.get(0).setStyle("-fx-background-color: Yellow");
//        getChildren().addAll(textField, foundText, refreshBtn,newGameBtn);
//        shuffleWords();
//        count5=120;
//        for(Button btn :buttons) {
//
//            btn.relocate(count5,120);
//            count5+=30;
//        }
//
//
//    }
//    private void shuffleWords() {
//        getChildren().removeAll(buttons);
//
//        shuffleButtons.add(buttons.get(6));
//        shuffleButtons.add(buttons.get(4));
//        shuffleButtons.add(buttons.get(2));// butonları karıştırma işlemi
//        shuffleButtons.add(buttons.get(1));
//        shuffleButtons.add(buttons.get(0));
//        shuffleButtons.add(buttons.get(3));
//        shuffleButtons.add(buttons.get(5));
//
//        buttons.clear();
//        buttons.addAll(shuffleButtons);
//        shuffleButtons.clear();
//        for (Button btn : buttons) {
//            btn.setShape(new Circle(4, 4, 4));
//            btn.setFont(Font.font("Verdana", 15));
//            getChildren().addAll(btn);
//        }
//        for(Button btn :buttons) {
//
//            btn.relocate(count5,120);
//            count5+=30;
//        }
//
//    }
//
//    private void functionButtons() {
//
//        for (Button btn : buttons) {
//            btn.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent actionEvent) {
//                    String text = textField.getText();
//                    text += btn.getText();
//                    textField.setText(text);
//                }
//            });                                                                         // yedihar = mostLengthWord  // textField.getText() : yedi
//        }
//        tickBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
////
//                for (String line : lines) {
//                    if (line.length() >= 4 && line.hashCode() == textField.getText().hashCode() && isInclude()) {
//                        System.out.println(String.format("Bulunan Kelime : %s", line));
//                        setLblDesign(); // update label text
//                        lines.remove(line); // bulunan kelimeyi sil
//
//                        setPoint();
//                        textField.setText(""); // reset textField
//                        break;
//                    }
//                }
//            }
//        });
//        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                if(textField.getText()!="") {
//                    String deletingText = textField.getText();
//                    deletingText = deletingText.substring(0, deletingText.length() - 1);
//                    textField.setText(deletingText);
//                }
//            }
//        });
//        refreshBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                count5=120;
//                shuffleWords();
//
//
//            }
//        });
//        btnAnotherMode.setOnAction(event -> { // use lambda expression
//            getChildren().clear();
//            anotherModeTxt.relocate(120,0);
//            enterBtnAnotherMode.relocate(280,0);
//
//            getChildren().addAll(anotherModeLbl,anotherModeTxt,enterBtnAnotherMode);
//
//        });
//        enterBtnAnotherMode.setOnAction(event -> { // kontroll eksikliği var
//            if(anotherModeTxt.getText().length()==7) {
//                count5=120;
//                mostLengthWords = anotherModeTxt.getText();
//                buttons.clear();
//                for (int i = 0; i < mostLengthWords.length(); i++) {
//                    buttons.add(new Button(mostLengthWords.substring(i, i + 1)));
//                }
//
//                buttons.get(0).setStyle("-fx-background-color: Yellow");
//                shuffleWords();
//                getChildren().clear();
//                for(Button btn: buttons) {
//
//                    getChildren().add(btn);
//
//
//                }
//                pointLblText = "";
//                pointLbl.setText("Point:" + pointLblText);
//                getChildren().addAll(tickBtn,deleteBtn,refreshBtn,pointLbl,infoLabel, textField);
//            }
//
//        });
//        newGameBtn.setOnAction(new EventHandler<ActionEvent>() { // new game btn tıklandıgında yapılacak olan işlemler (function buttons içine)
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                tempp = choosePangram();
//                mostLengthWords = getUniqWords(tempp);
//                count5=120;
//                buttons.clear();
//                for (int i = 0; i < mostLengthWords.length(); i++) {
//                    buttons.add(new Button(mostLengthWords.substring(i, i + 1)));
//                }
//
//                buttons.get(0).setStyle("-fx-background-color: Yellow");
//                shuffleWords();
//                getChildren().clear();
//                for(Button btn: buttons) {
//
//                    getChildren().add(btn);
//
//
//                }
//                pointLblText = "";
//                pointLbl.setText("Point:" + pointLblText);
//                getChildren().addAll(tickBtn,deleteBtn,refreshBtn,pointLbl,infoLabel, textField,newGameBtn,btnAnotherMode);
//                System.out.println(mostLengthWords + "     " + tempp);
//            }
//        });
//
//
//
//    }
//
//    private void setLblDesign() {
//
//        foundLblTxt += textField.getText() + "\n";
//        foundText.setText(foundLblTxt);
//        foundText.setStrikethrough(true); // kelimelerin üstüne çiz
//
//
//    }
//
//    private boolean isInclude() {
//
//        boolean isInclude = false;
//        int count = 0;
//        for (int i = count + 1; i <= textField.getLength(); i++) {
//            if (textField.getText().substring(count, i).hashCode() == firstButton.hashCode()) {
//                isInclude = true;
//
//            }
//            count += 1;
//        }
//        return isInclude;
//    }
//    private boolean allIsEqual() {
//
//        boolean logicalVar = false;
//
//        // butonlardaki harfler dısında harfleri olan kelimelerde kabul ediliyor mantıksal olarak bi burası eksik kaldı geri dön buraya !
//
//        return logicalVar;
//    }
//    private void setPoint() {
//        if(textField.getText().length()==4) {
//            numLblText+=1;
//            String toStringNumLblTxt = String.valueOf(numLblText);
//            pointLbl.setText("Point : " + toStringNumLblTxt);
//        }
//        else {
//            numLblText +=textField.getText().length();
//            String toStringNumLblTxt = String.valueOf(numLblText);
//            pointLbl.setText("Point : " + toStringNumLblTxt);
//        }
//
//
//    }
//
//    int count=0;
//    private String getUniqWords(String line) { // 7 eşsiz harfi buluyosun ama mostLengthWord ü sadece 7 harf olunca hata vermiyor 10 harfli olup 7 eşsiz harfli kelimeyi kontrol ettirmen lazım
//        String words="";
//        String temp = "";
//        ArrayList<String> uniqLetter = new ArrayList<>();
//        for(int i=0;i<line.length();i++) {
//            temp = line.substring(i,i+1);
//            uniqLetter.add(temp);
//        }
//        for(int i=0;i<uniqLetter.size()-1;i++)
//        {
//                for(int j=i+1;j<=uniqLetter.size()-1;j++)
//                {
//                    if(uniqLetter.get(i).hashCode()==uniqLetter.get(j).hashCode())
//                    {
//                        uniqLetter.remove(j);
//                        j--;
//                    }
//                }
//        }
//        for(int i=0;i<uniqLetter.size();i++) {
//            words +=uniqLetter.get(i);
//        }
//        return words;
//    }
//    private String choosePangram() // pangrams arraylist içinden rastgele pangram kelime seçimi
//    {
//        return pangrams.get(random.nextInt(0,pangrams.size()));
//    }
//}


package com.example.spellingbee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class SpellingBee extends Pane {
    // global variables
    String pointLblText="0";
    int numLblText = Integer.parseInt(pointLblText);
    Label pointLbl = new Label("Point : ");
    String firstButton = "";
    File sourceFile;
    Scanner scanner;
    Button tickBtn;
    Button deleteBtn;
    Button refreshBtn = new Button("Refresh");
    String mostLengthWords = ""; // en uzun kelime
    ArrayList<Button> buttons = new ArrayList<>();
    ArrayList<Button> shuffleButtons = new ArrayList<>();
    ArrayList<String> lines = new ArrayList<>();
    TextField textField;
    int count5 = 120;
    String infoLblText = "Bulunan Kelimeler : \n";
    Label infoLabel = new Label(infoLblText);
    String foundLblTxt = "";
    Text foundText = new Text("");
    Button btnAnotherMode = new Button("click to another mode!");
    TextField anotherModeTxt = new TextField();
    Label anotherModeLbl = new Label("7 Eşsiz Harf Girin : ");
    Button enterBtnAnotherMode =new Button("Enter");
    String buttonLetters;
    Button newGameBtn = new Button("New Game");
    ArrayList<String> pangrams = new ArrayList<>();
    String tempp="";
    Random random = new Random();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    int countWords=0;

    public SpellingBee() throws FileNotFoundException {

        getChildren().addAll(infoLabel,pointLbl,btnAnotherMode);
        getWords(); // mostLengthWords
        drawButtons();
        functionButtons();





    }

    private int getWords() { // can

        String line = "";
        int wordsLength = 0;
        String temp = "";
        try {
            sourceFile = new File("D:\\\\ydk\\\\okul\\\\java\\\\spelling bee\\\\spellingBee\\\\asd.txt");
            scanner = new Scanner(sourceFile);
            temp = "";
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                lines.add(line);
            }
            for(String linne:lines)
            {
                if (linne.length()>=7)
                {
                    if (getUniqWords(linne).length()==7)
                    {
                        pangrams.add(linne);
                    }
                }
            }
            wordsLength = line.length();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not found! or file is not exists!");
        }


        return wordsLength;


    }


    private void drawButtons() throws FileNotFoundException {

        pointLbl.relocate(395,10);
        pointLbl.setFont(Font.font("Verdana",25));
        infoLabel.relocate(350,55);
        infoLabel.setFont(Font.font("Verdana",17));
        foundText.relocate(390,85);
        foundText.setFont(Font.font("Verdana",15));
        textField = new TextField();
        textField.relocate(150,150);
        // image button
        FileInputStream img = new FileInputStream("D:\\\\\\\\ydk\\\\\\\\okul\\\\\\\\java\\\\\\\\spelling bee\\\\\\\\spellingBee\\\\\\\\tick_icon.png");
        Image image = new Image(img);
        ImageView view = new ImageView(image);
        tickBtn = new Button();
        tickBtn.setGraphic(view);
        tickBtn.relocate(250,180);
        //delete button
        FileInputStream deleteImg = new FileInputStream("D:\\\\\\\\ydk\\\\\\\\okul\\\\\\\\java\\\\\\\\spelling bee\\\\\\\\spellingBee\\\\\\\\del_icon.png");
        Image deleteImage = new Image(deleteImg);
        ImageView delView = new ImageView(deleteImage);
        deleteBtn = new Button();
        deleteBtn.setGraphic(delView);
        deleteBtn.relocate(150,180);
        //refresh button
        FileInputStream refreshImg = new FileInputStream("D:\\\\\\\\ydk\\\\\\\\okul\\\\\\\\java\\\\\\\\spelling bee\\\\\\\\spellingBee\\\\\\\\refresh_icon.png");
        Image refreshImage = new Image(refreshImg);
        ImageView refreshView = new ImageView(refreshImage);
        refreshBtn = new Button();
        refreshBtn.setGraphic(refreshView);
        refreshBtn.relocate(200,180);
        //
        tempp = choosePangram(); // rastgele pangram kelime seçtiriyoruz.
        mostLengthWords = getUniqWords(tempp); // seçilen rastgele pangram kelimenin eşsiz 7 harfini almak için yapılan işlem
        buttons = new ArrayList<>();
        for (int i = 0; i < mostLengthWords.length(); i++) {
            buttons.add(new Button(mostLengthWords.substring(i, i + 1)));
        }


        for (Button btn : buttons) {

            btn.setShape(new Circle(4, 4, 4));
            btn.setFont(Font.font("Verdana", 15));

            getChildren().addAll(btn);



        }
        newGameBtn.relocate(100,50);
        System.out.println(mostLengthWords + "       " + tempp );
        getChildren().addAll(tickBtn,deleteBtn);
        firstButton = buttons.get(0).getText();
        buttons.get(0).setStyle("-fx-background-color: Yellow");
        getChildren().addAll(textField, foundText, refreshBtn,newGameBtn);
        shuffleWords();
        count5=120;
        for(Button btn :buttons) {

            btn.relocate(count5,120);
            count5+=30;
        }


    }
    private void shuffleWords() { // berat
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

    private void functionButtons() {

        for (Button btn : buttons) {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String text = textField.getText();
                    text += btn.getText();
                    textField.setText(text);
                }
            });                                                                         // yedihar = mostLengthWord  // textField.getText() : yedi
        }
        tickBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) { // berat & can
//
                int counter = 0;
                if (isX()==false)
                {
                    for (String line : lines) {
                        if (line.length() >= 4 && line.hashCode() == textField.getText().hashCode() ) {
                            System.out.println("girdi");
                            System.out.println(String.format("Bulunan Kelime : %s", line));
                            setLblDesign(); // update label
                            infoLabel.setText("Bulunan Kelimeler :");
                            lines.remove(line); // bulunan kelimeyi sil

                            setPoint();
                            textField.setText(""); // reset textField
                            counter++;
                            break;
                        }
                    }
                }
                if(counter == 2)
                {
                    try {
                        drawButtons();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        deleteBtn.setOnAction(new EventHandler<ActionEvent>() { // berat
            @Override
            public void handle(ActionEvent actionEvent) {
                if(textField.getText()!="") {
                    String deletingText = textField.getText();
                    deletingText = deletingText.substring(0, deletingText.length() - 1);
                    textField.setText(deletingText);
                }
            }
        });
        refreshBtn.setOnAction(new EventHandler<ActionEvent>() { // berat
            @Override
            public void handle(ActionEvent actionEvent) {
                count5=120;
                shuffleWords();


            }
        });
        btnAnotherMode.setOnAction(event -> { // use lambda expression // can
            getChildren().clear();
            anotherModeTxt.relocate(120,0);
            enterBtnAnotherMode.relocate(280,0);
            textField.setText("");
            getChildren().addAll(anotherModeLbl,anotherModeTxt,enterBtnAnotherMode,newGameBtn);

        });
        enterBtnAnotherMode.setOnAction(event -> { // kontroll eksikliği var // can
            if(getUniqWords(anotherModeTxt.getText()).length()==7) {
                getChildren().removeAll(buttons);
                getChildren().removeAll(tickBtn,deleteBtn,refreshBtn,pointLbl,infoLabel, textField, newGameBtn,btnAnotherMode);
                count5=120;
                mostLengthWords = anotherModeTxt.getText();
                buttons.clear();
                for (int i = 0; i < mostLengthWords.length(); i++) {
                    buttons.add(new Button(mostLengthWords.substring(i, i + 1)));
                }

                buttons.get(0).setStyle("-fx-background-color: Yellow");
               // shuffleWords();
                getChildren().clear();
                for(Button btn: buttons) {
                    getChildren().addAll(btn);
                }
                count5=120;
                for(Button btn :buttons) {
                    btn.relocate(count5,120);
                    count5+=30;
                }
                pointLblText = "";
                pointLbl.setText("Point: " + pointLblText);
                textField.setText("");
                getChildren().addAll(tickBtn,deleteBtn,refreshBtn,pointLbl,infoLabel, textField, newGameBtn,btnAnotherMode);
            }

        });
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() { // new game btn tıklandıgında yapılacak olan işlemler (function buttons içine)
            @Override
            public void handle(ActionEvent actionEvent) {
                foundLblTxt="";
                getChildren().removeAll(buttons);
                getChildren().removeAll(tickBtn,deleteBtn,refreshBtn,pointLbl,infoLabel, textField,newGameBtn,btnAnotherMode);
                tempp = choosePangram();
                mostLengthWords = getUniqWords(tempp);
                count5=120;
                buttons.clear();
                for (int i = 0; i < mostLengthWords.length(); i++) {
                    buttons.add(new Button(mostLengthWords.substring(i, i + 1)));
                }

                buttons.get(0).setStyle("-fx-background-color: Yellow");
                shuffleWords();
                getChildren().clear();
                for(Button btn: buttons) {
                    getChildren().add(btn);
                }
                count5=120;
                for(Button btn :buttons) {

                    btn.relocate(count5,120);
                    count5+=30;
                }
                infoLabel.setText("Bulunan Kelimeler :");
                pointLblText="";
                numLblText=0;
                setPoint();
                textField.setText("");
                getChildren().addAll(tickBtn,deleteBtn,refreshBtn,pointLbl,infoLabel, textField,newGameBtn,btnAnotherMode);
                System.out.println(mostLengthWords + "       " + tempp );
            }
        });



    }

    private boolean isX() {
        boolean x = false;
        boolean y = false;
        String temp2="";
        for (int i=0;i<textField.getText().length();i++)
        {
            temp2 = textField.getText().substring(i,i+1);
            for (Button btn: buttons)
            {
                if (temp2.hashCode()==btn.getText().hashCode())
                {
                    System.out.println(temp2 + " harfi ->" + btn.getText());
                    x=true;
                    y=true;
                }
                if (x==true)
                    break;
            }
            x=false;
            if (y==false)
            {
                x=true;
                break;
            }
            y=false;
        }
        return x;
    }

    private void setLblDesign() { // hande

        foundLblTxt += textField.getText() + "\n";
        countWords++;
        foundText.setText(foundLblTxt);
        foundText.setStrikethrough(true); // kelimelerin üstüne çiz


    }

    private boolean isInclude() { // can

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
    private boolean allIsEqual() {

        boolean logicalVar = false;

        // son burası kaldı sacma sapan kelimeleri kabul ediyor ornegin zarflnd harflerinde abaküs buluyor la ne alakaaaaaaaaaaaaaaaaaaaa

        return logicalVar;
    }
    private void setPoint() { // hande
        if(textField.getText().length()==4) {
            numLblText+=1;
            String toStringNumLblTxt = String.valueOf(numLblText);
            pointLbl.setText("Point : " + toStringNumLblTxt);
        }
        else {
            numLblText +=textField.getText().length();
            String toStringNumLblTxt = String.valueOf(numLblText);
            pointLbl.setText("Point : " + toStringNumLblTxt);
        }


    }

    int count=0;

    private String getUniqWords(String line) { // 7 eşsiz harfi buluyosun ama mostLengthWord ü sadece 7 harf olunca hata vermiyor 10 harfli olup 7 eşsiz harfli kelimeyi kontrol ettirmen  // berat & can

        String temp = "";
        String words = "";
        ArrayList<String> uniqLetter = new ArrayList<>();
        for(int i=0;i<line.length();i++) {
            temp = line.substring(i,i+1);


            uniqLetter.add(temp);

            //System.out.println(temp);

        }
        for(int i=0;i<uniqLetter.size()-1;i++) {
            for(int j=i+1;j<=uniqLetter.size()-1;j++) {
                if(uniqLetter.get(i).hashCode()==uniqLetter.get(j).hashCode()) {
                    uniqLetter.remove(j);
                    j--;

                }
            }

        }
        for(int i=0;i<uniqLetter.size();i++) {
            words +=uniqLetter.get(i);
        }


        return words;
    }
    private String choosePangram() // pangrams arraylist içinden rastgele pangram kelime seçimi
    {
        return pangrams.get(random.nextInt(0,pangrams.size()));
    }
}
