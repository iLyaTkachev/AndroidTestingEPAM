package ilyatkachev.github.com.androidtestepam;

import android.support.annotation.IntegerRes;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.w3c.dom.Text;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CalculatorActivityTest {

    private ActivityController<CalculatorActivity> activityController;
    private CalculatorActivity calculatorActivity;

    @Before
    public void setUp() {
        activityController = Robolectric.buildActivity(CalculatorActivity.class);
        calculatorActivity = activityController.get();
    }

    @Test
    public void testLabel() {
        activityController.create().start().resume();
        TextView productPriceLabel = (TextView) calculatorActivity.findViewById(R.id.product_price);
        assertNotNull(productPriceLabel);
        assertEquals(View.VISIBLE, productPriceLabel.getVisibility());
        assertEquals(calculatorActivity.getString(R.string.product_price, 5.0f), productPriceLabel.getText());
    }

    @Test
    public void testButtonBehavior() {
        View incrementButton = (Button) calculatorActivity.findViewById(R.id.product_increment_button);
        assertNotNull(incrementButton);
        assertEquals(View.VISIBLE, incrementButton.getVisibility());
        assertEquals(incrementButton.isEnabled(), true);
    }

    @Test
    public void testPlusOperation() {
        View incrementButton = (Button) calculatorActivity.findViewById(R.id.product_increment_button);
        TextView productCountTextView = (TextView) calculatorActivity.findViewById(R.id.product_count);
        int count = Integer.valueOf(productCountTextView.getText().toString());
        incrementButton.performClick();
        assertEquals(productCountTextView.getText().toString(), toString().valueOf(count + 1));
    }

}