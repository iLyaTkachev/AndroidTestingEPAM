package ilyatkachev.github.com.androidtestepam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private ICalculator mCalculator = new Calculator();
    private Order mOrder;
    private TextView mResultTextView, mPriceTextView, mProductCountTextView;
    private View mCalculatePlusButton, mCalculateMinusButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        mOrder = new Order(5, 0, 0);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initView() {
        mPriceTextView = (TextView) findViewById(R.id.product_price);
        mPriceTextView.setText(String.format(getString(R.string.product_price), 5.0));
        mResultTextView = (TextView) findViewById(R.id.total_price);
        mResultTextView.setText(String.format(getString(R.string.total_price), 0.0));
        mProductCountTextView = (TextView) findViewById(R.id.product_count);
        mProductCountTextView.setText(R.string.default_product_count);

        mCalculatePlusButton = findViewById(R.id.product_increment_button);
        setButtonListener(mCalculatePlusButton);
        mCalculateMinusButton = findViewById(R.id.product_decrement_button);
        setButtonListener(mCalculateMinusButton);
    }

    private void setButtonListener(final View btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (btn.getId()) {
                    case R.id.product_increment_button:
                        mOrder.incrementProductCount();
                        mOrder.setTotalPrice(mCalculator.multiply(mOrder.getmProductPrice(), mOrder.getmProductCount()));
                        updateProductCount();
                        updateResult();
                        break;
                    case R.id.product_decrement_button:
                        mOrder.decrementProductCount();
                        mOrder.setTotalPrice(mCalculator.multiply(mOrder.getmProductPrice(), mOrder.getmProductCount()));
                        updateProductCount();
                        updateResult();
                        break;
                }

            }
        });
    }

    private void updateResult() {
        mResultTextView.setText(String.format(getString(R.string.product_price), mOrder.getmTotalPrice()));
    }

    private void updateProductCount() {
        mProductCountTextView.setText(String.valueOf(mOrder.getmProductCount()));
    }

}
