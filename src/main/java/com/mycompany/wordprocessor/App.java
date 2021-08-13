package com.mycompany.wordprocessor;

import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        HBox bottomBox = new HBox();
        bottomBox.setSpacing(10);
        Label lettersLabel = new Label();
        Label wordLabel = new Label();
        Label longestWordLabel = new Label();
        bottomBox.getChildren().add(lettersLabel);
        bottomBox.getChildren().add(wordLabel);
        bottomBox.getChildren().add(longestWordLabel);

        TextArea textField = new TextArea("");

        textField.textProperty().addListener((ObservableValue<? extends String> change, String oldValue, String newValue) -> {
            int characterCount = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            lettersLabel.setText("Letters: " + characterCount);
            wordLabel.setText("Words: " + words);
            longestWordLabel.setText("The longest word is: " + longest);
        });

        layout.setCenter(textField);
        layout.setBottom(bottomBox);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setTitle("Text Editor");
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
