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

    //Function to clear the display of the view and
    //data in the model
    public void clearDisplay() {
        //Clear the values in the calculator model
        mModel.setOperand1(0.0);
        mModel.setOperand2(0.0);
        mModel.setResult(0.0);

        //Set the tvInput display back to "0"
        mView.clearDisplay("0");
    }

    //Function to append a new number to the current expression
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

    //Function to add a decimal to the expression
    public void addDecimal() {
        //Grab the current expression from the view
        String currentOperand = mView.getExpression();

        //Append decimal to current expressions
        currentOperand += ".";

        //If user tries to input multiple decimals, replace with single decimal
        if (currentOperand.contains("..")) {
            currentOperand = currentOperand.replace("..", ".");
        }

        //Update the view with the new expression
        mView.setExpression(currentOperand);
    }

    //Change the sign of the number (positive or negative)
    public void numSign() {
        //Get the current expressions
        String currentOperand = mView.getExpression();
        String res = "";

        //Append a negative sign to the front of the expression
        res = "-" + currentOperand;

        //If the expression already begins with a negative sign
        //then replace it with "" to make it positive
        if (currentOperand.startsWith("-")) {
            res = currentOperand.replaceFirst("^-", "");
        }

        //Update the view with the new expression
        mView.setExpression(res);
    }

    //Allow the user to add a new operation
    public void addOperator(String op) {
        //Grab the current expression from the view
        String currentOperand = mView.getExpression();

        //Add the new operator to the expression
        currentOperand += op;

        //Update the view with the new expression
        mView.setExpression(currentOperand);
    }

    //Allow user to delete the last input
    public void backspace() {
        //Grab the expression and store into a StringBuffer
        StringBuffer sb = new StringBuffer(mView.getExpression());

        /*If the length of the string is greater than 1 (i.e. not 0)
        / then update the view with the expression after the last
        / character in the StringBuffer has been deleted
        / Else if the user tries to backspace at "0", set
        / the expression back to 0
        */
        if (sb.length() > 1) {
            mView.setExpression(sb.deleteCharAt(sb.length() - 1).toString());
        } else {
            mView.setExpression("0");
        }
    }

    //Function to perform calculation
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