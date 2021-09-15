package com.rjnadwod.mobilecalc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MobileCalculatorView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MobileCalculatorView extends Fragment {

    private MobileCalculatorPresenter mPresenter;
    private View root;

    public MobileCalculatorView() {
        // Required empty public constructor
    }

    //Grab the expression from the view and return as a string
    public String getExpression() {
        return ((TextView)root.findViewById(R.id.tvExpression)).getText().toString();
    }

    //Clear the display of the view
    public void clearDisplay(String result) {
        //Set the input back to 0 and completely clear the output view
        ((TextView)root.findViewById(R.id.tvExpression)).setText(result);
        ((TextView)root.findViewById(R.id.tvOutput)).setText("");
    }

    //Set the expression provided by the Presenter
    public void setExpression(String result) {
        ((TextView)root.findViewById(R.id.tvExpression)).setText(result);
    }

    //Set the result provided by the presenter
    public void setResult(String result) {
        //Set the text of tvOutput to the result provided by the Presenter
        //If the length of the result is greater than 10 digits, then
        //set the text and lower the text size
        if (result.length() < 10) {
            ((TextView) root.findViewById(R.id.tvOutput)).setText(result);
        } else {
            ((TextView) root.findViewById(R.id.tvOutput)).setText(result);
            ((TextView) root.findViewById(R.id.tvOutput)).setTextSize(30);
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MobileCalculatorView.
     */
    // TODO: Rename and change types and number of parameters
    public static MobileCalculatorView newInstance() { return new MobileCalculatorView(); }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_mobile_calculator_view, container, false);

        //Create buttons to use for onClickListeners
        //There is probably a better way to do this...
        AppCompatButton btnClear = root.findViewById(R.id.btnClear);
        AppCompatButton btn1 = root.findViewById(R.id.btn1);
        AppCompatButton btn2 = root.findViewById(R.id.btn2);
        AppCompatButton btn3 = root.findViewById(R.id.btn3);
        AppCompatButton btn4 = root.findViewById(R.id.btn4);
        AppCompatButton btn5 = root.findViewById(R.id.btn5);
        AppCompatButton btn6 = root.findViewById(R.id.btn6);
        AppCompatButton btn7 = root.findViewById(R.id.btn7);
        AppCompatButton btn8 = root.findViewById(R.id.btn8);
        AppCompatButton btn9 = root.findViewById(R.id.btn9);
        AppCompatButton btn0 = root.findViewById(R.id.btn0);
        AppCompatButton btnDecimal = root.findViewById(R.id.btnDecimal);
        AppCompatButton btnPlus = root.findViewById(R.id.btnPlus);
        AppCompatButton btnMinus = root.findViewById(R.id.btnMinus);
        AppCompatButton btnMultiply = root.findViewById(R.id.btnMultiply);
        AppCompatButton btnDivide = root.findViewById(R.id.btnDivide);
        AppCompatButton btnMod = root.findViewById(R.id.btnMod);
        AppCompatButton btnBackspace = root.findViewById(R.id.btnBackspace);
        AppCompatButton btnPosNeg = root.findViewById(R.id.btnPosNeg);
        AppCompatButton btnEqual = root.findViewById(R.id.btnEqual);

        //Set the onClickListener for each button using lambda expressions
        //There is probably a better way to do this...
        btnClear.setOnClickListener(view -> mPresenter.clearDisplay());
        btn1.setOnClickListener(view -> mPresenter.appendNum("1"));
        btn2.setOnClickListener(view -> mPresenter.appendNum("2"));
        btn3.setOnClickListener(view -> mPresenter.appendNum("3"));
        btn4.setOnClickListener(view -> mPresenter.appendNum("4"));
        btn5.setOnClickListener(view -> mPresenter.appendNum("5"));
        btn6.setOnClickListener(view -> mPresenter.appendNum("6"));
        btn7.setOnClickListener(view -> mPresenter.appendNum("7"));
        btn8.setOnClickListener(view -> mPresenter.appendNum("8"));
        btn9.setOnClickListener(view -> mPresenter.appendNum("9"));
        btn0.setOnClickListener(view -> mPresenter.appendNum("0"));
        btnDecimal.setOnClickListener(view -> mPresenter.addDecimal());
        btnPlus.setOnClickListener(view -> mPresenter.addOperator("+"));
        btnMinus.setOnClickListener(view -> mPresenter.addOperator("-"));
        btnMultiply.setOnClickListener(view -> mPresenter.addOperator("*"));
        btnDivide.setOnClickListener(view -> mPresenter.addOperator("/"));
        btnMod.setOnClickListener(view -> mPresenter.addOperator("%"));
        btnBackspace.setOnClickListener(view -> mPresenter.backspace());
        btnPosNeg.setOnClickListener(view -> mPresenter.numSign());
        btnEqual.setOnClickListener(view -> mPresenter.equalsClicked());

        return root;
    }

    public void setPresenter(MobileCalculatorPresenter presenter) { mPresenter = presenter; }

}