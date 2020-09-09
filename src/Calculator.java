public class Calculator {

private String result;

    public Calculator(String input) {
        Parser parser = new Parser(input);
        String operation = parser.getOperation();
        boolean isRomanNumeral = parser.isRomanNumeral();
        int num1 = parser.getNum1();
        int num2 = parser.getNum2();
        result = calculate(num1, num2, operation, isRomanNumeral);
    }

    public String getResult() {
        return result;
    }

    public String calculate(int num1, int num2, String operation, boolean isRomanNumeral) {
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

        if (isRomanNumeral){
            String resultString = "0";
            if (result < 0) {
                int mod_result = (int)Math.round(Math.abs(result));
                resultString = "-" + RomanArabicConverter.arabToRoman(mod_result);
            }
            else if (result > 0) {
                resultString = RomanArabicConverter.arabToRoman((int)Math.round(result));
            }
           return resultString;
        } else {
            return String.valueOf(result);
        }
    }
}
