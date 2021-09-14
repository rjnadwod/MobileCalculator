package com.rjnadwod.mobilecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MobileCalculatorPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MobileCalculatorPresenter();

        MobileCalculatorView view = (MobileCalculatorView) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerView);
        if (view == null) {
            view = MobileCalculatorView.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragmentContainerView, view);
            transaction.commit();
        }
        mPresenter.setView(view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onResume() { super.onResume(); }
}