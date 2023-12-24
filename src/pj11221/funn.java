/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pj11221;

import java.util.Scanner;
import java.lang.Math;

public class funn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter f(x): ");
        String exp = scanner.nextLine();

        System.out.print("Enter x: ");
        double x = scanner.nextDouble();

        // replace x in exp
        exp = exp.replaceAll("x", "(" + x + ")");

        double result = evaluateExp(exp);

        System.out.println("f(x) = " + result);

        scanner.close();
    }

    // Method to evaluate the mathematical expression
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
                    throw new RuntimeException("Unexpected: " + (char) ch);
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
                    }
                    else if (func.equals("sqrt")) {
                        //  eat('('); 
                      //  x = parseExpression();
                       // eat(')'); // 
                       if(x>0){
                        x = Math.sqrt(x);
                       }
                       else {
                           x=252521;// truong hop sqrt <0
                       }
                    }else {
                        x=252522; // truong hop viet sai ten func
                    }
                } else {
                     x=252523; // truong hop ki tu dac biet
                }

                if (eat('^')) {
                    x = Math.pow(x, parseFactor());
                }

                return x;
            }
        }
                .parse();
    }
}
// sqrt(abs(sinx*cos(20*x^2)))+log((sinx)^2)cos(2*x)
//0.36