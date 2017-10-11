package ilyatkachev.github.com.androidtestepam;

public class Order {
    private float mProductPrice;
    private int mProductCount;
    private float mTotalPrice;

    private static final float DEFAULT_PRODUCT_PRICE = 5.0f;
    private static final int DEFAULT_PRODUCT_COUNT = 0;
    private static final float DEFAULT_TOTAL_PRICE = 0.0f;

    public Order() {
        this.mProductPrice = DEFAULT_PRODUCT_PRICE;
        this.mProductCount = DEFAULT_PRODUCT_COUNT;
        this.mTotalPrice = DEFAULT_TOTAL_PRICE;
    }

    public Order(float mProductPrice, int mProductCount, float mTotalPrice) {
        this.mProductPrice = mProductPrice;
        this.mProductCount = mProductCount;
        this.mTotalPrice = mTotalPrice;
    }

    public void incrementProductCount() {
        mProductCount++;
    }

    public void decrementProductCount() {
        if (mProductCount > 0) {
            mProductCount--;
        }
    }

    public void setProductPrice(float price) {
        if (price >= 0) {
            this.mProductPrice = price;
        }
    }

    public void setProductCount(int count) {
        if (count >= 0) {
            this.mProductCount = count;
        }
    }

    public void setTotalPrice(float price) {
        if (price >= 0) {
            this.mTotalPrice = price;
        }
    }

    public float getmProductPrice() {
        return mProductPrice;
    }

    public int getmProductCount() {
        return mProductCount;
    }

    public float getmTotalPrice() {
        return mTotalPrice;
    }
}
