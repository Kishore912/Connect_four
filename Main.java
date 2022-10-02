package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	private Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane rootNode = loader.load();
		MenuBar menuBar = createMenu();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		Pane menuPane = (Pane) rootNode.getChildren().get(0);
		menuPane.getChildren().add(menuBar);
		Scene scene = new Scene(rootNode);
		controller = loader.getController();
		controller.createPlayground();

		primaryStage.setScene(scene);
		primaryStage.setTitle("Connect 4");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	private MenuBar createMenu() {
		MenuBar menuBar = new MenuBar();

		Menu fileMenu = new Menu("File");
		Menu helpMenu = new Menu("Help");

		MenuItem newMenu = new MenuItem("New");
		newMenu.setOnAction(event -> controller.resetGame());

		MenuItem resetMenu = new MenuItem("Reset");
		resetMenu.setOnAction(event -> controller.resetGame());

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quit = new MenuItem("Quit");
		quit.setOnAction(event -> exit());

		MenuItem aboutGame = new MenuItem("About Game");
		aboutGame.setOnAction(event -> aboutGame());

		MenuItem aboutMe = new MenuItem("About Me");
		aboutMe.setOnAction(event -> aboutMe());

		fileMenu.getItems().addAll(newMenu, resetMenu, separatorMenuItem, quit);
		helpMenu.getItems().addAll(aboutGame, aboutMe);

		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;
	}

	private void aboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Developer");
		alert.setHeaderText("Kishore");
		alert.setContentText("he developed this game as well as many applications " +
				"that are gonna come in the future.he born in 9th december 2002 at Chennai." +
				" studied in velammal matriculation higher secondary school Cnennai . ");
		alert.show();
	}

	private void aboutGame() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Connect4");
		alert.setHeaderText("How to play?");
		alert.setContentText("Connect Four is a two-player connection game in which the players first " +
				"choose a color and then take turns dropping colored discs from the top into a seven-column," +
				" six-row vertically suspended grid. The pieces fall straight down, " +
				"occupying the next available space within the column." +
				" The objective of the game is to be the first to form a horizontal, " +
				"vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. " +
				"The first player can always win by playing the right moves.");
		alert.show();
	}

	private void exit() {
		Platform.exit();
		System.exit(0);
	}

	private void resetGame() {

	}


	public static void main(String[] args) {
		launch(args);
	}
}
