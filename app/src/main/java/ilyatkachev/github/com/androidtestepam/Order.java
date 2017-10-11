package ilyatkachev.github.com.androidtestepam;

public class Order {
    private float mProductPrice;
    private int mProductCount;
    private float mTotalPrice;

    public Order(float productPrice, int productCount, float totalPrice) {
        this.mProductPrice = productPrice;
        mProductCount = productCount;
        mTotalPrice = totalPrice;
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
