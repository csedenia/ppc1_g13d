package src.main.java;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import Functions.*;

public class functionAController {

    @FXML
    private TextField Cap_Grape;

    @FXML
    private TextField Cap_Labor;

    @FXML
    private TextField Fixed_Costs;

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
    private Label data_input_caption4;

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
    private Label opt_result_heading1;

    @FXML
    private TextField or_Gross_Profit;

    @FXML
    private TextField or_Prod_Vol_Noir;

    @FXML
    private TextField or_Prod_Vol_Rose;

    @FXML
    private TextField or_Prod_Vol_Total;

    @FXML
    private TextField or_Profit_Margin;

    @FXML
    private Spinner<String> or_scroll_text1;

    @FXML
    private Line vLine3;

    @FXML
    void buttonpressed(ActionEvent event) {
    }
    public void initialize() {
        Num_Week.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (0 > Integer.parseInt(newValue) || 15 < Integer.parseInt(newValue)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0 and less than 15");
                        alert.showAndWait();
                        Num_Week.setText("");
                    } else {

                    }
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("error");
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter the number greater than 0 and less than 15");
                    alert.showAndWait();
                    Num_Week.setText("");
                }
            }
        });
    }
    @FXML
    private void getDefaultValue(InputMethodEvent event) {

    }

    public void toexit(ActionEvent actionEvent) {Main.stage.setScene(Main.scene);
    }

    public void toclick(ActionEvent actionEvent) {
        ObservableList<String> items = FXCollections.observableArrayList("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!", "W2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
        or_scroll_text1.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(items));

        boolean input_valid = true;

        int capLabour = 0;
        int capGrape = 0;
        int numWeek = 0;
        float priceRose = 0f;
        float priceNoir = 0f;
        int fixedCost = 0;

        String input = Cap_Labor.getText();
        if (Input_checking.labor_capacity_checking(input) == false) {	//check if Cap_Labor is valid
            //Cap_Labor invalid, show error message
            input_valid = false;
        } else {
            //Cap_Labor valid, convert into int
            capLabour = Integer.parseInt(input);
        }

        input = Cap_Grape.getText();
        if (Input_checking.grape_capacity_checking(input) == false) {	//check if Cap_Grape is valid
            //Cap_Grape invalid, show error message
            input_valid = false;
        } else {
            //Cap_Grape valid, convert into int
            capGrape = Integer.parseInt(input);
        }

        input = Num_Week.getText();
        if (Input_checking.numweek_checking(input) == false) {	//check if Num_Week is valid
            //Num_Week invalid, show error message
            input_valid = false;
        } else {
            //Num_Week valid, convert into int
            numWeek = Integer.parseInt(input);
        }

        input = Prc_Rose.getText();
        if (Input_checking.pr_checking(input) == false) {	//check if Prc_Rose is valid
            //Prc_Rose invalid, show error message
            input_valid = false;
        } else {
            //Prc_Rose valid, convert into int
            priceRose = Float.parseFloat(input);
        }

        input = Prc_Noir.getText();
        if (Input_checking.pr_checking(input) == false) {	//check if Prc_Noir is valid
            //Prc_Noir invalid, show error message
            input_valid = false;
        } else {
            //Prc_Noir valid, convert into int
            priceNoir = Float.parseFloat(input);
        }

        input = Fixed_Costs.getText();
        if (Input_checking.fixedCost_checking(input) == false) {	//check if Fixed_Costs is valid
            //Fixed_Costs invalid, show error message
            input_valid = false;
        } else {
            //Fixed_Costs valid, convert into int
            fixedCost = Integer.parseInt(input);
        }

        if (input_valid == false) return;

        FunctionA objectA = new FunctionA(numWeek, capLabour, capGrape, priceRose, priceNoir, fixedCost);
        objectA.calculateGrossProfit();
        or_Gross_Profit.setText(Float.toString(objectA.getOptimalGP()));
        or_Prod_Vol_Noir.setText(Integer.toString(objectA.getOptimalNoir()));
        or_Prod_Vol_Rose.setText(Integer.toString(objectA.getOptimalRose()));
        or_Profit_Margin.setText(Float.toString(objectA.getGPM()));
    }
}
