package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	private Model model;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label txtAnagrammi;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtAreaCorretti;

    @FXML
    private TextArea txtAreaErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	String s=txtParola.getText();
    	
    	List<String> anagrammi =model.calcola(s);
    	for(String a:anagrammi) {
    		
    		if(model.isCorrect(a)) {
    			txtAreaCorretti.appendText(a+"\n");
    			
    		}
    		else {
    			txtAreaErrati.appendText(a+"\n");
    		}
    	}
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtAreaErrati.clear();
    	txtAreaCorretti.clear();
    	txtParola.clear();
    	

    }

    @FXML
    void initialize() {
        assert txtAnagrammi != null : "fx:id=\"txtAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAreaCorretti != null : "fx:id=\"txtAreaCorreti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAreaErrati != null : "fx:id=\"txtAreaErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
public void setModel(Model model) {
		
		this.model=model;
		
	}
}


