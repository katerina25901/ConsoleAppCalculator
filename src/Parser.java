import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Parser {

    private int num1;
    private int num2;
    private String operation;
    private boolean isRomanNumeral;
    static String[] arrayOperators = new String[] {"-","\\+","/","\\*"};

    public Parser(String input){
        String mathString = clarificateInput(input);
        getOperatorType(mathString);
        getNumbers(mathString);
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getOperation() {
        return operation;
    }

    public boolean isRomanNumeral() {
        return isRomanNumeral;
    }

    private void getOperatorType(String input){
        String inputSubstring = input.substring(1);
        String operatorType = null;
        for (String arrayOperator : arrayOperators) {
            Pattern p = Pattern.compile(arrayOperator);
            Matcher m = p.matcher(inputSubstring);
            if (m.find()) {
                operatorType = arrayOperator;
                break;
            }
        }
        if (operatorType != null){
            operation = operatorType;  }
        else
        {
            throw new IllegalArgumentException("No operator in Input string");
        }
    }

    private void getNumbers(String input){
        int num1, num2;
        String delimiter = operation;
        String[] subStr = input.substring(1).split(delimiter, 2);
        subStr[0] = input.substring(0,1) + subStr[0];
        if (RomanArabicConverter.isRomanNumeral(subStr[0]) && RomanArabicConverter.isRomanNumeral(subStr[1])){
            isRomanNumeral = true;
            num1 = RomanArabicConverter.romanToArabConvert(subStr[0]);
            num2 = RomanArabicConverter.romanToArabConvert(subStr[1]);
        } else {
            num1 = getIntegerValue(subStr[0]);
            num2 = getIntegerValue(subStr[1]);
        }
        if (Validator.checkInputValues(num1, num2, isRomanNumeral, delimiter)) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    private int getIntegerValue(String string){
        try {
            return parseInt(string);
        }
        catch (NumberFormatException ex) {
            System.out.println("Only positive integers or roman number in input");
            System.exit(0);
            return 0;
        }
    }

    private String clarificateInput(String input) {
        input = input.replaceAll("\\s+", "");
        if ((!input.isEmpty()) && input.length() > 2){
            return input;
        } else {
            throw new IllegalArgumentException("Empty or too short input");
        }
    }
}

