public class NumberStorage {
    private double currentValue;
    private int previousBase = 10;

    public void storeValue(double value) {
        this.currentValue = value;
    }

    public void storeValue(double value, int base) {
        this.currentValue = value;
        this.previousBase = base;
    }

    public void updateBase(int base) {
        this.previousBase = base;
    }

    public int getStoredBase() {
        return previousBase;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void showCurrentState() {
        displayFormattedNumber(currentValue, "Хранимое значение");
    }

    public void displayFormattedNumber(double number, String description) {
        System.out.println(description + " в десятичной: " + number);

        if (number == (int) number) {
            int integerValue = (int) number;
            System.out.println(description + " в двоичной: " + NumberBaseConverter.convertFromDecimal(integerValue, 2));
            System.out.println(description + " в восьмеричной: " + NumberBaseConverter.convertFromDecimal(integerValue, 8));
            System.out.println(description + " в шестнадцатеричной: " + NumberBaseConverter.convertFromDecimal(integerValue, 16));

            if (previousBase != 10) {
                System.out.println(description + " в " + previousBase + "-чной: " + convertToString(integerValue, previousBase));
            }
        } else {
            System.out.println(description + " (дробное значение - другие СС не отображаются)");
        }
    }

    public void displayInSpecificBase(String description, int base) {
        if (currentValue == (int) currentValue) {
            System.out.println(description + " " + base + "-чная: " + convertToString((int)currentValue, base));
        } else {
            System.out.println(description + " (дробное число)");
        }
    }

    public static String convertToString(double value, int base) {
        if (value == (int) value) {
            int integerValue = (int) value;
            return NumberBaseConverter.convertFromDecimalToBase(integerValue, base);
        } else {
            return String.valueOf(value);
        }
    }

    public static double parseFromString(String numericString, int base) {
        if (base == 10) return Double.parseDouble(numericString);
        return NumberBaseConverter.convertToDecimal(numericString, base);
    }
}