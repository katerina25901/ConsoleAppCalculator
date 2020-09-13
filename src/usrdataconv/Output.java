package usrdataconv;

import mathwork.Calculator;

public class Output {
    private double result;
    private boolean isRomanNumeral;

    public Output(String input) {
        InputParser inputParser = new InputParser(input);
        char operation = inputParser.getOperation();
        int num1 = inputParser.getNum1();
        int num2 = inputParser.getNum2();
        isRomanNumeral = inputParser.isRomanNumeral();
        result = Calculator.calculate(num1, num2, operation);
    }

    public String getStringResult() {
        return convertResultToString(result, isRomanNumeral);
    }

    private String convertResultToString(double result, boolean isRomanNumeral) {
        String stringResult;
        if (isRomanNumeral){
            stringResult = RomanArabicConverter.arabToRomanConvert((int)Math.round(result));

        } else {
            stringResult = String.format("%.2f", result);
        }
        return stringResult;
    }
}
