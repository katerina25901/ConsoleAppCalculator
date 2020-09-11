public class Calculator {

private String result;

    public Calculator(String input) {
        Parser parser = new Parser(input);
        String operation = parser.getOperation();
        boolean isRomanNumeral = parser.isRomanNumeral();
        int num1 = parser.getNum1();
        int num2 = parser.getNum2();
        double result = calculate(num1, num2, operation);
        this.result = convertResultToString(result,isRomanNumeral);
    }

    public String getResult() {
        return result;
    }

    public double calculate(int num1, int num2, String operation) {
        double result = 0;
        if(operation.contains("+"))
        {
            result = num1+num2;
        }
        else if (operation.contains("-"))
        {
            result = num1-num2;
        }
        else if (operation.contains("*"))
        {
            result = num1*num2;
        }
        else if (operation.contains("/"))
        {
            result = (double)num1/(double)num2;
        }
        return result;
    }

    public String convertResultToString(double result, boolean isRomanNumeral) {
        String resultString;
        if (isRomanNumeral){
            resultString = RomanArabicConverter.arabToRomanConvert((int)Math.round(result));

        } else {
            resultString = String.format("%.2f", result);
        }
        return resultString;
    }
}
