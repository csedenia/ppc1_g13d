package src.main.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import Functions.*;

public class functionBController {

    @FXML
    private TextField Cap_Grape;

    @FXML
    private TextField Cap_Labor;

    @FXML
    private Line HLine2;

    @FXML
    private Line HLine3;

    @FXML
    private Line HLine4;

    @FXML
    private Line HLine_1;

    @FXML
    private TextField Num_Week;

    @FXML
    private TextField Prc_Noir;

    @FXML
    private TextField Prc_Rose;

    @FXML
    private Line VLine1;

    @FXML
    private Line VLine2;

    @FXML
    private Button button_exit1;

    @FXML
    private Button button_run1;

    @FXML
    private Label data_input_caption1;

    @FXML
    private Label data_input_caption2;

    @FXML
    private Label data_input_caption2a;

    @FXML
    private Label data_input_caption2b;

    @FXML
    private Label data_input_caption3;

    @FXML
    private Label data_input_caption3a;

    @FXML
    private Label data_input_caption3b;

    @FXML
    private Label data_input_heading1;

    @FXML
    private Label form_heading1;

    @FXML
    private AnchorPane label_col_heading2;

    @FXML
    private Label label_sysmsg1;

    @FXML
    private Label opt_r_caption1;

    @FXML
    private Label opt_r_caption1a;

    @FXML
    private Label opt_r_caption1b;

    @FXML
    private Label opt_r_caption1c;

    @FXML
    private Label opt_r_caption2;

    @FXML
    private Label opt_r_caption3;

    @FXML
    private Label opt_r_caption31;

    @FXML
    private Label opt_result_heading1;

    @FXML
    private TextField or_Grape_Surplus;

    @FXML
    private TextField or_Labor_Surplus;

    @FXML
    private TextField or_Prod_Vol_Noir;

    @FXML
    private TextField or_Prod_Vol_Rose;

    @FXML
    private TextField or_Prod_Vol_Total;

    @FXML
    private TextField or_Total_Revenue;

    @FXML
    private Spinner<String> or_scroll_text1;

    @FXML
    private Line vLine3;

    @FXML
    void getDefaultValue(InputMethodEvent event) {

    }

    @FXML
    void toclick(ActionEvent event) {
        boolean input_valid = true;

        //parameters for creating FunctionC Object
        int year = 0;
        int lc = 0;
        int gc = 0;
        float pr = 0f;
        float pn = 0f;

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

        //terminate the process if any of the input is invalid
        if(input_valid == false) return;

        //create function objects to calculate optimal mix
        FunctionB objectB = new FunctionB(year, lc, gc, pr, pn);
        objectB.update();
        or_Prod_Vol_Noir.setText(Integer.toString(objectB.getOpt_Noir()));
        or_Prod_Vol_Rose.setText(Integer.toString(objectB.getOpt_Rose()));
        or_Prod_Vol_Total.setText(Integer.toString(objectB.getOpt_Noir()) + Integer.toString(objectB.getOpt_Rose()));
        or_Total_Revenue.setText(Integer.toString(objectB.getOpt_Revenue()));
        or_Labor_Surplus.setText(Integer.toString(objectB.getSur_Labor()));
        or_Grape_Surplus.setText(Integer.toString(objectB.getSur_Grape()));
        
        //system warning message 
        System_message warning_check= new System_message(objectB.getOpt_Rose(), objectB.getOpt_Noir(), 1, gc, lc);

        boolean hasW1 = warning_check.checkW1();
        boolean hasW2 = warning_check.checkW2();

        ObservableList<String> items = FXCollections.observableArrayList();

        if(hasW1) {
            items.add("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
        }

        if(hasW2) {
            items.add("W2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
        }

        or_scroll_text1.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(items));
    }
    

    @FXML
    void toexit(ActionEvent event) {
        Main.stage.setScene(Main.scene);
    }

}
