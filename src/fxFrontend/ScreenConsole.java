package fxFrontend;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;


public class ScreenConsole {
    private VBox myConsolePane;
    private ScrollPane myHistory, myConsole;
    private Label myConsoleLabel, myHistoryLabel;
    private TextArea myHistoryText, myConsoleText;
    private static final String CONSOLE_LABEL = "Console:";
    private static final String HISTORY_LABEL = "History:";
    private static final int TOP = 0;
    private static final int RIGHT = 20;
    private static final int BOTTOM = 10;
    private static final int LEFT = 20;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 150;
    private static final int HEIGHT_ADJUST = 350;

    public ScreenConsole () {
        myConsolePane = new VBox(20);
        myConsolePane.setPadding(new Insets(TOP, RIGHT, BOTTOM, LEFT));
        myHistory = new ScrollPane();
        myHistoryLabel = new Label(HISTORY_LABEL);
        myHistoryText = new TextArea();
        myHistoryText.setEditable(false);
        createBox(myHistoryLabel, myHistory, myHistoryText, HEIGHT + HEIGHT_ADJUST);
        myConsole = new ScrollPane();
        myConsoleLabel = new Label(CONSOLE_LABEL);
        myConsoleText = new TextArea();
        myConsoleText.setEditable(false);
        createBox(myConsoleLabel, myConsole, myConsoleText, HEIGHT);
    }

    private void createBox (Label myLabel, ScrollPane myPane, TextArea myText, int height) {
        myText.setPrefSize(WIDTH, height);
        myConsolePane.getChildren().add(myLabel);
        myPane.setContent(myText);
        myPane.setFitToWidth(true);
        myPane.setPrefWidth(WIDTH);
        myPane.setPrefHeight(height);
        myConsolePane.getChildren().add(myPane);
    }

    public VBox getConsole () {
        return myConsolePane;
    }

    public TextArea getHistoryTextArea () {
        return myHistoryText;
    }

    public TextArea getConsoleText () {
        return myConsoleText;
    }
}
