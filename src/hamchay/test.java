/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hamchay;
import hamchay.TimX;
public class test {
    public static void main(String[] args) {
        // test tim x
  //      TimX test=new TimX("x^2-9");//x^3*log(20-x^2)(x+1/x)+tan(x*2)
   //     String y=test.main();
   //      test.showchart();
  //      System.out.println(y);

//      test tinh fx
         Tinhfx instance = new Tinhfx();
        Double result = instance.evaluateExp("sin(x+10)-(log(x+1/x)(100-x^x))/sqrt(1-tan(x*3))", 2);
         System.out.println(result);
    }
}
