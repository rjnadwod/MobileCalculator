package com.rjnadwod.mobilecalc;

// Math parsing library to help with parsing the expression
// and performing calculations to avoid complex logic
import org.mariuszgromada.math.mxparser.*;

public class MobileCalculatorModel {
    private Double operand1;
    private Double operand2;
    private Double result;
    private String res;

    public void setOperand1(Double operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(Double operand2) {
        this.operand2 = operand2;
    }

    public void setResult(Double result) { this.result = result ;}

    public MobileCalculatorModel(){
        operand1 = 0.0;
        operand2 = 0.0;
        result = 0.0;
    }

    //Calculates the expression provided by the Presenter from the View
    public String calculateExpression(String expression) {
        //Create an expression using the mXparser library
        Expression e = new Expression(expression);

        //Calculate the expression, then store the result into a string to return
        this.res = String.valueOf(e.calculate());

        //Return the result of the calculated expression from mXparser
        return this.res;
    }

    //Calculate function using for JUnit tests
    public Double calculate(Operator operator){
        switch (operator){
            case ADD:
                result = operand1 + operand2;
                break;
            case SUB:
                result = operand1 - operand2;
                break;
            case MUL:
                result = operand1 * operand2;
                break;
            case DIV:
                result = operand1 / operand2;
                break;
            default:
                result = 0.0;
                break;
        }
        return result;
    }
}
