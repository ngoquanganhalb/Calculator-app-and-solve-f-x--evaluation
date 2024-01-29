package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import hamchay.TimX;
import static hamchay.Tinhfx.evaluateExp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javafx.scene.chart.*;
import javax.swing.*;
import java.util.*;

public class Controller extends JFrame implements Initializable {

    @FXML
    private TextArea areafield;

    @FXML
    private TextField expTextField;
    @FXML
    private TextField xTextField;

    @FXML
    void abs(ActionEvent event) {

        String exp = expTextField.getText();
        exp = exp + "abs";
        expTextField.setText(exp);
        expTextField.positionCaret(exp.length());
    }

    @FXML
    void can(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "sqrt(";
        expTextField.setText(exp);
    }

    @FXML
    void chia(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "/";
        expTextField.setText(exp);
    }

    @FXML
    void cong(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "+";
        expTextField.setText(exp);
    }

    @FXML
    void cos(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "cos";
        expTextField.setText(exp);
    }

    @FXML
    void cosh(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "cosh";
        expTextField.setText(exp);
    }

    @FXML
    void cot(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "cot";
        expTextField.setText(exp);
    }

    @FXML
    void del(ActionEvent event) {
        String exp = expTextField.getText();
        if (!exp.isEmpty()) {
            exp = exp.substring(0, exp.length() - 1); // Remove the last character
            expTextField.setText(exp);
        }
    }

    @FXML
    void dong(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "(";
        expTextField.setText(exp);
    }

    @FXML
    void eight(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "8";
        expTextField.setText(exp);
    }

    @FXML
    void five(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "5";
        expTextField.setText(exp);
    }

    @FXML
    void four(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "4";
        expTextField.setText(exp);
    }

    @FXML
    void ln(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "ln";
        expTextField.setText(exp);
    }

    @FXML
    void log(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "log()(";
        expTextField.setText(exp);
    }

    @FXML
    void mo(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + ")";
        expTextField.setText(exp);
    }

    @FXML
    void mu(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "^";
        expTextField.setText(exp);
    }

    @FXML
    void nhan(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "*";
        expTextField.setText(exp);
    }

    @FXML
    void nine(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "9";
        expTextField.setText(exp);
    }

    @FXML
    void one(ActionEvent event) {

        String exp = expTextField.getText();
        exp = exp + "1";
        expTextField.setText(exp);
    }

    @FXML
    void seven(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "7";
        expTextField.setText(exp);
    }

    @FXML
    void sin(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "sin";
        expTextField.setText(exp);
    }

    @FXML
    void sinh(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "sinh";
        expTextField.setText(exp);
    }

    @FXML
    void six(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "6";
        expTextField.setText(exp);
    }

    @FXML
    void tan(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "tan";
        expTextField.setText(exp);
    }

    @FXML
    void three(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "3";
        expTextField.setText(exp);
    }

    @FXML
    void tru(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "-";
        expTextField.setText(exp);
    }

    @FXML
    void two(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "2";
        expTextField.setText(exp);
    }

    @FXML
    void zero(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "0";
        expTextField.setText(exp);
    }

    @FXML
    void ac(ActionEvent event) {
        String exp = expTextField.getText();
        exp = "";
        expTextField.setText(exp);
        areafield.setText(exp);
        xTextField.setText(exp);
    }

    @FXML
    void x(ActionEvent event) {
        String exp = expTextField.getText();
        exp = exp + "x";
        expTextField.setText(exp);
    }

    @FXML
    void calculate(ActionEvent event) {
        String expression = expTextField.getText();
        String xText = xTextField.getText();
        if (xText.isEmpty()) {
        // Alert when xTextField is empty
         areafield.setText("Vui long nhap gia tri cua x !");
        return; // Stop further execution
    }
        double x = Double.parseDouble(xText);
       
        expression = expression.replaceAll("x", "(" + x + ")");
        double result = evaluateExp(expression, x);
        if (result == Double.NEGATIVE_INFINITY) {
        areafield.setText("Loi bieu thuc");
        } else if (result == Double.POSITIVE_INFINITY) {
             areafield.setText("Loi logic");
        }  else {
            areafield.setText("f(x) = " + result);
        }

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void findX(ActionEvent event) {
        String expression = expTextField.getText();
        TimX timX = new TimX(expression);
        String res = timX.main();
        areafield.setText(res);
       // timX.showchart();
        
    }
      @FXML
    void diagram(ActionEvent event) {
         String expression = expTextField.getText();
        TimX timX = new TimX(expression);
        String res = timX.main();
       // areafield.setText(res);
        timX.showchart();
    }


}
