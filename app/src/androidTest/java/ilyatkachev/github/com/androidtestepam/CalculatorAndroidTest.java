package ilyatkachev.github.com.androidtestepam;

import android.content.Intent;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class CalculatorAndroidTest {

    private ActivityTestRule<CalculatorActivity> calculatorActivity = new ActivityTestRule<>(CalculatorActivity.class);

    private ViewInteraction buttonPlus;
    private ViewInteraction countTextView;

    @Before
    public void setUp() {
        calculatorActivity.launchActivity(new Intent());
        countTextView = onView(withId(R.id.product_count));
    }

    @Test
    public void testValueTextView() {
        final String countText = "0";
        countTextView.check(matches(isDisplayed()));
        countTextView.check(new ViewAssertion() {

            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (!((TextView) view).getText().toString().equals(countText)) {
                    throw new IllegalStateException("Text view does'n match");
                }
            }
        });
    }

    @Test
    public void testButtonOneOnClick() {
        final String totalResultText = "3";
        buttonPlus = onView(withId(R.id.product_increment_button));
        buttonPlus.perform(click());
        buttonPlus.perform(click());
        buttonPlus.perform(click());
        ViewAssertion textViewAssertion = new ViewAssertion() {

            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (!((TextView) view).getText().toString().equals(totalResultText)) {
                    throw new IllegalStateException("Text view does not match");
                }
            }
        };
        countTextView.check(textViewAssertion);
    }

}