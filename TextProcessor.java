package com.example.textprocessor;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


public class TextProcessor extends Application {
    private Label wordOutput, charOutput, lineOutput;
    private HBox buttonBar;
    private  TextArea textArea;

    public void start(Stage stage) {
        textArea = new TextArea();
        textArea.setPrefRowCount(15);
        textArea.setWrapText(true);
        textArea.setStyle("-fx-font-size: 11");
        Button processButton = new Button("Process The Text");
        buttonBar = new HBox(processButton);
        buttonBar.setAlignment(Pos.CENTER);
        buttonBar.setStyle("-fx-background-color: #571010FF");
        processButton.setOnAction(e -> processText());

        wordOutput = new Label("Number of words:   ");
        wordOutput.setStyle("-fx-font-weight: bold; -fx-background-color: white; -fx-font-size: 15; -fx-padding: 4px 9px 4px 9px");
        wordOutput.setAlignment(Pos.CENTER_LEFT);
        wordOutput.setMaxWidth(Double.POSITIVE_INFINITY);

        lineOutput = new Label("Number of lines:   ");
        lineOutput.setStyle("-fx-font-weight: bold; -fx-background-color: white; -fx-font-size: 15; -fx-padding: 4px 9px 4px 9px");
        lineOutput.setAlignment(Pos.CENTER_LEFT);
        lineOutput.setMaxWidth(Double.POSITIVE_INFINITY);

        charOutput = new Label("Number of chars:   ");
        charOutput.setStyle("-fx-font-weight: bold; -fx-background-color: white; -fx-font-size: 15; -fx-padding: 4px 9px 4px 9px");
        charOutput.setAlignment(Pos.CENTER_LEFT);
        charOutput.setMaxWidth(Double.POSITIVE_INFINITY);





        TilePane tpane = new TilePane();
        tpane.setStyle("-fx-background-color: #571010FF");
        tpane.setPrefRows(4);
        tpane.setPrefColumns(1);
        tpane.setVgap(3);
        tpane.setPrefTileWidth(395);
        tpane.getChildren().addAll(buttonBar,lineOutput,wordOutput,charOutput);

        BorderPane root = new BorderPane();
        root.setPrefWidth(400);
        root.setStyle("-fx-border-width: 3px; -fx-border-color: #571010FF");
        root.setCenter(textArea);
        root.setBottom(tpane);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Text Processor");
        stage.setResizable(false);
        stage.show();


        
    }

    public void processText() {
        int lineCount = 1;
        int wordCount = 1;
        char ch;
        
        String str = textArea.getText();
        charOutput.setText("Number of chars:   " + str.length());

        for(int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
             if(ch == '\n') {
                 lineCount++;
             }
        }
        lineOutput.setText("Number of lines:   " + lineCount);

        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) == ' ') && (str.charAt(i+1) != ' ')) {
                wordCount++;
            }
        }
        wordOutput.setText("Number of words:   " + wordCount);
    }



    public static void main(String[] args) {
        launch();
    }
}