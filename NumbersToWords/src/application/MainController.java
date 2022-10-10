package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController implements Initializable{

	@FXML
    private Label msg;

    @FXML
    private Label pattern;

    @FXML
    private Label score;

    @FXML
    private Button submit;

    @FXML
    private TextField textfield;

    @FXML
    void validate() {
    	if(textfield.getText().toLowerCase().equals(words.get(cmp).toLowerCase())) {
    		msg.getStyleClass().removeAll();
        	msg.getStyleClass().add("succes");
    		int scr = Integer.parseInt(score.getText())+1;
    		if(scr==words.size()) {
    			msg.setText("Yeah, you did it!");
    			
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setContentText("Congratulation you won");
    			alert.showAndWait();
    			Platform.exit();
    		}else {
    		msg.setText("Good Work, Let's try with another word");
    		pattern.setText(convert(words.get(++cmp)));
    		score.setText(String.valueOf(scr));
    		textfield.setText("");
    		}
    		//textfield.setFocusTraversable(true);
    	}else {
    		msg.setText("Wrong word");
    		msg.getStyleClass().removeAll();
    		msg.getStyleClass().add("fail");
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("You Lose");
			alert.showAndWait();
			Platform.exit();
    	}
    		
    }
	
	List<String> words = new ArrayList<String>();
	String[] wrd = {"javafx","javascript","web","object","C","project","github","stackoverflow"};
	int cmp = 0;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < wrd.length;i++)
			words.add(wrd[i]);
		Collections.shuffle(words);
		pattern.setText(convert(words.get(cmp)));
		textfield.setFocusTraversable(true);
		msg.setText("");
		
	}

	private String convert(String string) {
		// TODO Auto-generated method stub
		String text = "";
		string = string.toLowerCase();
		for(int i = 0 ; i < string.length();i++) {
			text += String.valueOf(string.charAt(i)-'a');
			if(i+1!=string.length())
				text += "_";
		}
		
		return text;
	}
	
	
	
}
