package com.rjnadwod.mobilecalc;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {
    @Before
    public void setUp() throws Exception {
        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void givenTest1() {
        onView(withId(R.id.btn9)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("13")));
    }

    @Test
    public void givenTest2() {
        onView(withId(R.id.btn8)).perform(click());
        onView(withId(R.id.btnMinus)).perform(click());
        onView(withId(R.id.btn3)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("5")));
    }

    @Test
    public void givenTest3() {
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.btn8)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("16")));
    }

    @Test
    public void givenTest4() {
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnDivide)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("5")));
    }

    @Test
    public void givenTest5() {
        onView(withId(R.id.btn3)).perform(click());
        onView(withId(R.id.btnPosNeg)).perform(click());
        onView(withId(R.id.btnDecimal)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("0.5")));
    }

    @Test
    public void givenTest6() {
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnMinus)).perform(click());
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btn7)).perform(click());
        onView(withId(R.id.btnDecimal)).perform(click());
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("-2.2")));
    }

    //This test fails due to formatting
    //Expected: 6.666533e9
    //Result: 6.666533334E9
    @Test
    public void givenTest7() {
        onView(withId(R.id.btn6)).perform(click());
        onView(withId(R.id.btn6)).perform(click());
        onView(withId(R.id.btn6)).perform(click());
        onView(withId(R.id.btn6)).perform(click());
        onView(withId(R.id.btn6)).perform(click());
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.btn9)).perform(click());
        onView(withId(R.id.btn9)).perform(click());
        onView(withId(R.id.btn9)).perform(click());
        onView(withId(R.id.btn9)).perform(click());
        onView(withId(R.id.btn9)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("6.666533E9")));
    }

    //This test also fails due to formatting
    //Expected: 2E-7
    //Result: 2.0E-7
    @Test
    public void givenTest8() {
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnDivide)).perform(click());
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("2E-7")));
    }

    @Test
    public void givenTest9() {
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btn3)).perform(click());
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btn7)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btn8)).perform(click());
        onView(withId(R.id.btnDecimal)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("70.5")));
    }

    @Test
    public void givenTest10() {
        onView(withId(R.id.btn3)).perform(click());
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btnClear)).perform(click());
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnBackspace)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("18")));
    }
}