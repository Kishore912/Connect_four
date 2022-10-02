package com.internshala.game;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label label;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField textField;

	@FXML
	public Button button;

	private static final String c_TO_f="celsious to frenheit";
	private static final String f_TO_c="frenheit to celsious";
	private boolean isc_TO_f=true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(c_TO_f);
		choiceBox.getItems().add(f_TO_c);

		choiceBox.setValue(f_TO_c);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(c_TO_f)){
				isc_TO_f=true;

			}
			else{
				isc_TO_f=false;
			}
		});


		button.setOnAction(event -> {
			button();
		});


	}

	private void button() {
		String num = textField.getText();
		float hi = 0.0f;
		try{
			hi=Float.parseFloat(num);
		}catch (Exception e){
			warning();
			return;
		}

		float newTemperature=0.0f;
		if(isc_TO_f){
			newTemperature=(hi*9/5)+32;
		}
		else{
			newTemperature=(hi-32)*5/9;
		}
		display(newTemperature);
	}

	private void warning() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText("You Have Entered a Wrong Input");
		alert.setContentText("Please Enter a Valid Input");
		alert.show();
	}

	private void display(float newTemperature ) {
		String unit = isc_TO_f? "F" : "C";
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The New Temperature is " + newTemperature + unit);
		alert.show();
	}
}


