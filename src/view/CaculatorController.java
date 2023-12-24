package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class CaculatorController implements Initializable {

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
        exp ="";
        expTextField.setText(exp);
    }
    @FXML
    void x(ActionEvent event) {
    String exp = expTextField.getText();
        exp = exp + "x";
        expTextField.setText(exp);
    }
    @FXML
    void calculate(ActionEvent event) {
        String exp = expTextField.getText();
        String xText = xTextField.getText();

        double x = Double.parseDouble(xText);
        exp = exp.replaceAll("x", "(" + x + ")");
        double result = evaluateExp(exp);
        // notification handle
        if(result == 252521) {  
         Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Result of Expression");
        alert.setHeaderText(null);
        alert.setContentText("Wrong! Expression in sqrt must >0");
         alert.show();
        }
        else if(result == 252522){
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Result of Expression");
        alert.setHeaderText(null);
        alert.setContentText("Wrong! check your function");
         alert.show();
        }
         else if(result == 252523){
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Result of Expression");
        alert.setHeaderText(null);
        alert.setContentText("Wrong!Wrong expression!");
         alert.show();
        }
         else{
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Result of Expression");
        alert.setHeaderText(null);
        alert.setContentText("The result is: " + result);
        alert.show();
         }

    }

    private static double evaluateExp(String exp) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ++pos;
                if (pos < exp.length()) {
                    ch = exp.charAt(pos);
                } else {
                    ch = -1;
                }
            }

            // eat char
            boolean eat(int c) {
                while (ch == ' ') {
                    nextChar();
                }
                if (ch == c) {
                    nextChar();
                    return true;
                } else {
                    return false; // if char dang duyet != char in exp
                }
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < exp.length()) {
                    x=252523;
                }
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) {
                        x += parseTerm();
                    } else if (eat('-')) {
                        x -= parseTerm();
                    } else {
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) {
                        x *= parseFactor();
                    } else if (eat('/')) {
                        x /= parseFactor();
                    } else {
                        return x;
                    }
                }
            }

            double parseFactor() {
                double x;
                int startPos = this.pos;
                if (eat('+')) {
                    return parseFactor();
                }
                if (eat('-')) {
                    return -parseFactor();
                }

                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        nextChar();
                    }
                    x = Double.parseDouble(exp.substring(startPos, this.pos));
                } // xu ly function: 
                else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') {
                        nextChar();
                    } // after loop -> read character of function 
                    String func = exp.substring(startPos, this.pos);
                    x = parseFactor(); // read next doublevalue after func : sin 90, x=90
                    // sin cos ... ko can trong dau ngoac
                    if (func.equals("sin")) {
                        x = Math.sin(Math.toRadians(x));
                    } else if (func.equals("cos")) { // cos(x)^2= cos(x^2)
                        x = Math.cos(Math.toRadians(x));
                    } else if (func.equals("tan")) {
                        x = Math.tan(Math.toRadians(x));
                    } else if (func.equals("cot")) {
                        x = 1 / Math.tan(Math.toRadians(x));
                    } // log can dau ngoac dau tien: log()(exp); ln(exp))
                    else if (func.equals("log")) {
                        eat('(');
                        double base = x; // luu ki tu sau log(20)(exp) 20
                        x = parseExpression(); // x=exp
                        eat(')');
                        x = Math.log(x) / Math.log(base);
                    } else if (func.equals("sinh")) {
                        x = Math.sinh(x);
                    } else if (func.equals("cosh")) {
                        x = Math.cosh(x);
                    } else if (func.equals("ln")) {
                        x = Math.log(x);
                    } else if (func.equals("abs")) {
                        //  eat('('); 
                        //  x = parseExpression();
                        // eat(')'); // 
                        x = Math.abs(x);
                    } else if (func.equals("sqrt")) {
                        //  eat('('); 
                        //  x = parseExpression();
                        // eat(')'); // 
                        if (x > 0) {
                            x = Math.sqrt(x);
                        } else {
                            x = 252521;// truong hop sqrt <0
                        }
                    } else {
                        x = 252522; // truong hop viet sai ten func
                    }
                } else {
                    x = 252523; // truong hop ki tu dac biet
                }

                if (eat('^')) {
                    x = Math.pow(x, parseFactor());
                }

                return x;
            }
        }
                .parse();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
