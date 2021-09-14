package com.rjnadwod.mobilecalc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Random;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MobileCalculatorTest {
    @Test
    public void addition_isCorrect() {
        MobileCalculatorModel model = new MobileCalculatorModel();
        Random rand = new Random();
        Double op1,op2,res;
        for(int i = 0; i<100;i++){
            op1 = rand.nextDouble();
            op2 = rand.nextDouble();
            model.setOperand1(op1);
            model.setOperand2(op2);
            res = op1 + op2;
            assertEquals(model.calculate(Operator.ADD),res);
        }
    }

    @Test
    public void subtraction_isCorrect() {
        MobileCalculatorModel model = new MobileCalculatorModel();
        Random rand = new Random();
        Double op1,op2,res;
        for(int i = 0; i<100;i++){
            op1 = rand.nextDouble();
            op2 = rand.nextDouble();
            model.setOperand1(op1);
            model.setOperand2(op2);
            res = op1 - op2;
            assertEquals(model.calculate(Operator.SUB),res);
        }
    }

    @Test
    public void multiplication_isCorrect() {
        MobileCalculatorModel model = new MobileCalculatorModel();
        Random rand = new Random();
        Double op1,op2,res;
        for(int i = 0; i<100;i++){
            op1 = rand.nextDouble();
            op2 = rand.nextDouble();
            model.setOperand1(op1);
            model.setOperand2(op2);
            res = op1 * op2;
            assertEquals(model.calculate(Operator.MUL),res);
        }
    }

    @Test
    public void division_isCorrect() {
        MobileCalculatorModel model = new MobileCalculatorModel();
        Random rand = new Random();
        Double op1,op2,res;
        for(int i = 0; i<100;i++){
            op1 = rand.nextDouble();
            op2 = rand.nextDouble();
            model.setOperand1(op1);
            model.setOperand2(op2);
            res = op1 / op2;
            assertEquals(model.calculate(Operator.DIV),res);
        }
    }
}