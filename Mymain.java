package com.internshala.game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Mymain extends Application {
    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");  //initialization
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");//starting of the application
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);


        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature converter");
        primaryStage.show();

    }
    public MenuBar createMenu(){
        // creating MenuBar
        MenuBar menuBar =new MenuBar();
        // creating file menu
        Menu fileMenu =new Menu("File");
        MenuItem newMenuItem=new MenuItem("New");
        newMenuItem.setOnAction(event -> {
            System.out.println("new clicked");
        });
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem quitMenuItem=new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenuItem,  separatorMenuItem,quitMenuItem);
        // creating Help menu
        Menu helpMenu =new Menu("Help");
        MenuItem aboutApp =new MenuItem("About");
        aboutApp.setOnAction(event -> {
            aboutApp();
        });
        helpMenu.getItems().addAll(aboutApp);
        // adding all the elements to the menu bar
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialog =new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("temperature converter");
        alertDialog.setHeaderText("");
        alertDialog.setContentText("The Temperature converter tool is all about converting " +
                "the temperature from celsious to  Fahrenheit and  Fahrenheit to celsious");

        ButtonType yesbtn=new ButtonType("YES");
        ButtonType nobtn=new ButtonType("NO");
        alertDialog.getButtonTypes().setAll(yesbtn,nobtn);

        Optional<ButtonType> clickbtn = alertDialog.showAndWait();
        if(clickbtn.isPresent() && clickbtn.get() == yesbtn){
            System.out.println("yes button is clicked");

        }
        else{
            System.out.println("no button is clicked");
        }

    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");     //called when the appllication termiinates
        super.stop();
    }
}

