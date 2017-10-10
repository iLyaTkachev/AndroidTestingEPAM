package ilyatkachev.github.com.androidtestepam;


public class Calculator implements ICalculator {

    @Override
    public float multiply(float... values) {
        float result = 1;
        for (float value : values) {
            result = result * value;
        }
        return result;
    }

    private String format(int value) {
        return String.valueOf(value);
    }
}
