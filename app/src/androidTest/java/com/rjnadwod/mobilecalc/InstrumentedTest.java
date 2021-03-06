package com.rjnadwod.mobilecalc;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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

    /*
    / I found that tests would often fail due to the fact that
    / buttons were being clicked too quickly after the application
    / launched, leading to some odd results. For example, givenTest2
    / would often skip clicking 8 because it occurred too quick and
    / too early, resulting in -3 as the final answer. To remedy this,
    / I had the thread sleep for 500ms to give the application enough
    / time to launch. This resulted in far more consistent test results.
     */

    @Test
    public void givenTest1() throws InterruptedException {
        Thread.sleep(500);
        onView(withId(R.id.btn9)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("13")));
    }

    @Test
    public void givenTest2() throws InterruptedException {
        Thread.sleep(500);
        onView(withId(R.id.btn8)).perform(click());
        onView(withId(R.id.btnMinus)).perform(click());
        onView(withId(R.id.btn3)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("5")));
    }

    @Test
    public void givenTest3() throws InterruptedException {
        Thread.sleep(500);
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.btn8)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("16")));
    }

    @Test
    public void givenTest4() throws InterruptedException {
        Thread.sleep(500);
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnDivide)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("5")));
    }

    @Test
    public void givenTest5() throws InterruptedException {
        Thread.sleep(500);
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
    public void givenTest6() throws InterruptedException {
        Thread.sleep(500);
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
    public void givenTest7() throws InterruptedException {
        Thread.sleep(500);
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

    @Test
    public void givenTest8() throws InterruptedException {
        Thread.sleep(500);
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
    public void givenTest9() throws InterruptedException {
        Thread.sleep(500);
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
    public void givenTest10() throws InterruptedException {
        Thread.sleep(500);
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