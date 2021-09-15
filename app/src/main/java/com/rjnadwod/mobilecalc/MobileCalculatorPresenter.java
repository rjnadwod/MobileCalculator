package com.rjnadwod.mobilecalc;

// Math parsing library to help with parsing the expression
// and performing calculations to avoid complex logic
import org.mariuszgromada.math.mxparser.*;

public class MobileCalculatorPresenter {

    private MobileCalculatorModel mModel;
    private MobileCalculatorView mView;

    public MobileCalculatorPresenter(){
        mModel = new MobileCalculatorModel();
    }

    public void start(){
        mView.setPresenter(this);
    }

    public void setView(MobileCalculatorView view){
        mView = view;
    }

    public void clearDisplay() {
        //Clear the values in the calculator model
        mModel.setOperand1(0.0);
        mModel.setOperand2(0.0);
        mModel.setResult(0.0);

        //Set the tvInput display back to "0"
        mView.clearDisplay("0");
    }

    public void appendNum(String num) {
        //Grab the current expression from tvInput
        String currentOperand = mView.getExpression();

        //If the expression equals 0, change 0 to the first number
        //input by the user
        //Else, take the current expression and add the new number
        //to the end of the expressions
        if (currentOperand.equals("0")) {
            currentOperand = num;
        } else {
            currentOperand += num;
        }

        //Update the view with the new expression
        mView.setExpression(currentOperand);
    }

    public void addDecimal() {
        //Grab the current expression from the view
        String currentOperand = mView.getExpression();

        //If the current expression contains a decimal,
        currentOperand += ".";
        if (currentOperand.contains("..")) {
            currentOperand = currentOperand.replace("..", ".");
        }

        //Update the view with the new expression
        mView.setExpression(currentOperand);
    }

    public void numSign() {
        String currentOperand = mView.getExpression();
        String res = "";
        if (!currentOperand.contains("-")) {
            res = "-" + currentOperand;
        } else {
            res = currentOperand.replaceFirst("^-", "");
        }
        //mModel.setOperand1(Double.parseDouble(res));
        mView.setExpression(res);
    }

    public void addOperator(String op) {
        String currentOperand = mView.getExpression();
        currentOperand += op;
        mView.setExpression(currentOperand);
    }

    public void backspace() {
        StringBuffer sb = new StringBuffer(mView.getExpression());
        if (sb.length() > 1) {
            mView.setExpression(sb.deleteCharAt(sb.length() - 1).toString());
        } else {
            mView.setExpression("0");
        }
    }

    public void equalsClicked() {
        //Grab the entire string from the view
        String expression = mView.getExpression();
        //Create empty result
        String res = "";

        //Replace % with # to do modulo operation with mXparser library
        //since mXparser uses #
        if (expression.contains("%")) {
            expression = expression.replace("%", "#");
        }

        //Call Model's calculateExpression function to
        //calculate the expression and get a result
        res = mModel.calculateExpression(expression);

        //Set the result of the model to the result
        mModel.setResult(Double.parseDouble(res));

        //If the result ends with .0, truncate the .0 and return to view
        //Else if the result does not end with .0, keep the decimal and trailing numbers
        if (res.contains(".0")) {
            res = res.replace(".0", "");
        }

        //Set the tvOutput view text to the result from
        //the model calculateExpression function
        mView.setResult(res);
    }
}
