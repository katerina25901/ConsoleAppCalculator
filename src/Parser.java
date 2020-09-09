import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Parser {

    private int num1;
    private int num2;
    private String operation;
    private String mathString;
    private boolean isRomanNumeral;
    static String[] arrayOperators = new String[] {"-","\\+","/","\\*"};

    public Parser(String input){
        mathString = input.replaceAll("\\s+", "");
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
        String operatorType = null;
        for (String arrayOperator : arrayOperators) {
            Pattern p = Pattern.compile(arrayOperator);
            Matcher m = p.matcher(input);
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
        String[] subStr = input.split(delimiter, 2);
        if (RomanArabicConverter.isRomanNumeral(subStr[0]) && RomanArabicConverter.isRomanNumeral(subStr[1])){
            isRomanNumeral = true;
            num1 = RomanArabicConverter.romanToArab(subStr[0]);
            num2 = RomanArabicConverter.romanToArab(subStr[1]);
        } else {
            num1 = getIntegerValue(subStr[0]);
            num2 = getIntegerValue(subStr[1]);
        }
        if (isCorrectInput(num1) && isCorrectInput(num2)) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    private  int getIntegerValue(String string){
        try {
            return parseInt(string);
        }
        catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Not integer: " + string);
            System.exit(0);
            return 0;
        }
    }

    private boolean isCorrectInput(int num){
        if(num <= 10  && num >= 1 ) {
            return true;
        }  else {
            throw new IllegalArgumentException("Value must be in 1...10");
        }
    }

    private boolean isCorrectInputFor(int num){
        if(num <= 10  && num >= 1 ) {
            return true;
        }  else {
            throw new IllegalArgumentException("Value must be in 1...10");
        }
    }

}

