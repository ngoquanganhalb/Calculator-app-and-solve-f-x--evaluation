/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.genetic.Pair;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class FindxController {

    @FXML
    private TextField expTextField;
    
     private static final float INF = 999;
     String str="(Math.pow(x, 3) + (Math.sin(x) / Math.log(x + 1 / x)) - 10)";
private float func(float x) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        
        try {
            // Thay thế x trong biểu thức bằng giá trị x được truyền vào
            String expression = str.replace("x", String.valueOf(x));
            Object result = engine.eval(expression);
            
            if (result instanceof Number) {
                return Math.abs(((Number) result).floatValue());
            } else {
                // Xử lý nếu kết quả không phải là số
                System.out.println("Biểu thức không trả về một giá trị số.");
            }
        } catch (ScriptException e) {
            // Xử lý nếu có lỗi khi đánh giá biểu thức
            e.printStackTrace();
        }
        
        return 0.0f; // Giá trị mặc định nếu có lỗi xảy ra
    }
  
    private static float ieeeToDecimal(String ieeeBinary) {
        long longValue = Long.parseLong(ieeeBinary, 2);
    
        int sign = (int) ((longValue >> 31) & 1);
        int exponent = (int) ((longValue >> 23) & 0xFF);
        long fraction = longValue & 0x7FFFFF;
    
        int bias = 127;
    
        int actualExponent = exponent - bias;
    
        float fractionValue = 1.0f;
        for (int i = 22; i >= 0; --i) {
            fractionValue += ((fraction >> i) & 1) * Math.pow(2, i - 23);
        }
    
        float result;
        if (exponent == 0 && fraction == 0) {
            // Special case: exponent and fraction are both zero
            result = 0.0f;
        } else if (exponent == 255 && fraction == 0) {
            // Special case: exponent is all ones, fraction is zero
            result = (float) ((sign == 0) ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY);
        } else if (exponent == 255 && fraction != 0) {
            // Special case: exponent is all ones, fraction is non-zero (NaN)
            result = Float.NaN;
        } else {
            // Normal case
            result = (float) (Math.pow(-1, sign) * fractionValue * Math.pow(2, actualExponent));
        }
    
        return result;
    }

    private static List<String> initPopulation(int populationSize) {
        List<String> population = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < populationSize; i++) {
            StringBuilder individual = new StringBuilder();
            for (int j = 0; j < 32; ++j) {
                char bit = (char) ('0' + random.nextInt(2));
                individual.append(bit);
            }
            population.add(individual.toString());
        }

        return population;
    }

    private static String crossover(String parent1, String parent2) {
        int crossoverPoint = new Random().nextInt(parent1.length());
        String child = parent1.substring(0, crossoverPoint) + parent2.substring(crossoverPoint);
        return child;
    }

    private static void mutate(StringBuilder individual, double mutationRate) {
        Random random = new Random();
        for (int i = 0; i < individual.length(); i++) {
            double mutationChance = random.nextDouble();

            if (mutationChance < mutationRate) {
                char bit = (individual.charAt(i) == '0') ? '1' : '0';
                individual.setCharAt(i, bit);
            }
        }
    }
    
        @FXML
    void find(ActionEvent event) {
         int maxGeneration = 20;
        int populationSize = 10000;
        List<String> population = initPopulation(populationSize);
        float bestFitness = INF;
        float solution = 0;
        int generation = 0;

        while (generation < maxGeneration) {
            double mutationRate = 0.1 * (maxGeneration - generation) / maxGeneration;
            List<Pair> funcVal = new ArrayList<>();

            for (String individual : population) {
                float fitness = func(ieeeToDecimal(individual));
                funcVal.add(new Pair(individual, fitness));

            }

            Collections.sort(funcVal, (a, b) -> Float.compare(a.getSecond(), b.getSecond()));

            int newPopulationSize = populationSize / 4;
            List<String> newPopulation = new ArrayList<>();

            for (int i = 0; i < newPopulationSize; ++i) {
                newPopulation.add(funcVal.get(i).getFirst());
            }

            for (int i = newPopulationSize; i < populationSize; ++i) {
                int parentIndex1 = new Random().nextInt(newPopulationSize);
                int parentIndex2 = new Random().nextInt(newPopulationSize);

                String parent1 = newPopulation.get(parentIndex1);
                String parent2 = newPopulation.get(parentIndex2);

                String child = crossover(parent1, parent2);

                newPopulation.add(child);
            }

            for (int i = 0; i < populationSize; ++i) {
                StringBuilder individual = new StringBuilder(newPopulation.get(i));
                mutate(individual, mutationRate);
                newPopulation.set(i, individual.toString());
            }

            population = newPopulation;

            ++generation;
        }

        for (String individual : population) {
            float currentFitness = func(ieeeToDecimal(individual));
            if (currentFitness < bestFitness) {
                bestFitness = currentFitness;
                solution = ieeeToDecimal(individual);
            }
        }
        
        System.out.println("Best Fitness: " + bestFitness);
        System.out.println("Solution: " + solution);
        
        expTextField.setText(String.valueOf(solution)); // Set the result in the expTextField
    }
       static class Pair {
        private final String first;
        private final float second;

        public Pair(String first, float second) {
            this.first = first;
            this.second = second;
        }

        public String getFirst() {
            return first;
        }

        public float getSecond() {
            return second;
        }
    }


    @FXML
    void abs(ActionEvent event) {
        
    }

    @FXML
    void ac(ActionEvent event) {

    }

   

    @FXML
    void chia(ActionEvent event) {

    }

    @FXML
    void cong(ActionEvent event) {

    }

    @FXML
    void cos(ActionEvent event) {

    }

    @FXML
    void cosh(ActionEvent event) {

    }

    @FXML
    void cot(ActionEvent event) {

    }

    @FXML
    void del(ActionEvent event) {

    }

    @FXML
    void dong(ActionEvent event) {

    }

    @FXML
    void eight(ActionEvent event) {

    }

    @FXML
    void five(ActionEvent event) {

    }

    @FXML
    void four(ActionEvent event) {

    }

    @FXML
    void ln(ActionEvent event) {

    }

    @FXML
    void mo(ActionEvent event) {

    }

    @FXML
    void mu(ActionEvent event) {

    }

    @FXML
    void nhan(ActionEvent event) {

    }

    @FXML
    void nine(ActionEvent event) {

    }

    @FXML
    void one(ActionEvent event) {

    }

    @FXML
    void seven(ActionEvent event) {

    }

    @FXML
    void sin(ActionEvent event) {

    }

    @FXML
    void sinh(ActionEvent event) {

    }

    @FXML
    void six(ActionEvent event) {

    }

    @FXML
    void tan(ActionEvent event) {

    }

    @FXML
    void three(ActionEvent event) {

    }

    @FXML
    void tru(ActionEvent event) {

    }

    @FXML
    void two(ActionEvent event) {

    }

    @FXML
    void x(ActionEvent event) {

    }

    @FXML
    void zero(ActionEvent event) {

    }

}
