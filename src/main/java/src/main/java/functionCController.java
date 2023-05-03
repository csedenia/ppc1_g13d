package src.main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import Functions.*;

public class functionCController {

    @FXML
    private AnchorPane label_col_heading2;

    @FXML
    private TextField Num_Week;

    @FXML
    private Label data_input_heading1;

    @FXML
    private Label data_input_caption2a;

    @FXML
    private Label form_heading1;

    @FXML
    private Label data_input_caption1;

    @FXML
    private TextField Cap_Labor;

    @FXML
    private Label data_input_caption2;

    @FXML
    private Label data_input_caption2b;

    @FXML
    private TextField Cap_Grape;

    @FXML
    private Label data_input_caption3;

    @FXML
    private Label data_input_caption3a;

    @FXML
    private TextField Prc_Rose;

    @FXML
    private Label data_input_caption3b;

    @FXML
    private TextField Prc_Noir;

    @FXML
    private Label opt_result_heading1;

    @FXML
    private Button button_run1;

    @FXML
    private Button button_exit1;

    @FXML
    private TextField or_Prod_Vol_Rose;

    @FXML
    private Label opt_r_caption1;

    @FXML
    private Label opt_r_caption1a;

    @FXML
    private Label opt_r_caption1b;

    @FXML
    private TextField or_Prod_Vol_Noir;

    @FXML
    private Label opt_r_caption1c;

    @FXML
    private TextField or_Prod_Vol_Total;

    @FXML
    private Line HLine4;

    @FXML
    private Label opt_r_caption2;

    @FXML
    private Label opt_r_caption3;

    @FXML
    private TextField or_Gross_Profit;

    @FXML
    private TextField or_Profit_Margin;

    @FXML
    private Line HLine3;

    @FXML
    private Line HLine2;

    @FXML
    private Line VLine1;

    @FXML
    private Line HLine_1;

    @FXML
    private Line VLine2;

    @FXML
    private Line vLine3;

    @FXML
    private Spinner<?> or_scroll_text1;

    @FXML
    private Label label_sysmsg1;

    @FXML
    private Label data_input_caption2a1;

    @FXML
    private TextField Bko_Rose;

    @FXML
    private Label data_input_caption21;

    @FXML
    private Label data_input_caption2b1;

    @FXML
    private TextField Bko_Noir;

    @FXML
    void getDefaultValue(InputMethodEvent event) {

    }

    @FXML
    void toclick(ActionEvent event) {
    	boolean input_valid = true;
    	
    	//parameters for creating FunctionC Object
    	int year;
    	int lc;
    	int gc;
    	float pr;
    	float pn;
    	int br;
    	int bn;
    	
    	String input = Num_Week.getText();
    	if (Input_checking.date_checking(input) == false) {	//check if Num_Week is valid
    		//Num_Week invalid, show error message
    		input_valid = false;
    	} else {
    		//Num_Week valid, convert into int
    		year = Integer.parseInt(input);
    	}
    	
    	input = Cap_Labor.getText();
    	if (Input_checking.labor_capacity_checking(input) == false) {	//check if Cap_Labor is valid
    		//Cap_Labor invalid, show error message
    		input_valid = false;
    	} else {
    		//Cap_Labor valid, convert into int
    		lc = Integer.parseInt(input);
    	}
    	
    	input = Cap_Grape.getText();
    	if (Input_checking.grape_capacity_checking(input) == false) {	//check if Cap_Labor is valid
    		//Cap_Grape invalid, show error message
    		input_valid = false;
    	} else {
    		//Cap_Labor valid, convert into int
    		gc = Integer.parseInt(input);
    	}
    	
    	input = Prc_Rose.getText();
    	if (Input_checking.pr_checking(input) == false) {
    		//Prc_Rose invalid, show error message
    		input_valid = false;
    	} else {
    		//Prc_Rose valid, convert into float
    		pr = Float.parseFloat(input);
    	}
    	
    	input = Prc_Noir.getText();
    	if(Input_checking.pn_checking(input) == false) {
    		//Prc_Noir invalid, show error message
    		input_valid = false;
    	} else {
    		//Prc_Noir valid, convert into float
    		pn = Float.parseFloat(input);
    	}
    	
    	input = Bko_Rose.getText();
    	if(Input_checking.Rose_backOrder_checking(input) == false) {
    		//Bko_Rose invalid, show error message
    		input_valid = false;
    	} else {
    		//Bko_Rose valid, convert into int
    		br = Integer.parseInt(input);
    	}
    	
    	input = Bko_Noir.getText();
    	if(Input_checking.Noir_backOrder_checking(input) == false) {
    		//Bko_Noir invalid, show error message
    		input_valid = false;
    	} else {
    		//Bko_Noir valid, convert into int
    		bn = Integer.parseInt(input);
    	}
    	
    	
    }

    @FXML
    void toexit(ActionEvent event) {

    }

}
