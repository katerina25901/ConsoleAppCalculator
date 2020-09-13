package usrdataconv;

import static java.lang.Integer.parseInt;

public class InputParser {

    private boolean isRomanNumeral;
    private int num1;
    private int num2;
    private char operation;
    private int operatorIndex;
    private static char[] arrayOperators = new char[] {'/','*','-','+'};

    public InputParser(String input){
        String mathString = clarificateInput(input);
        getOperationType(mathString);
        getNumbers(mathString);
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public char getOperation() {
        return operation;
    }

    public boolean isRomanNumeral() {
        return isRomanNumeral;
    }

    private void getOperationType(String input){
        String inputSubstring = input.substring(1);
        for (char arrayOperator : arrayOperators) {
            if(inputSubstring.indexOf(arrayOperator) != -1) {
                operatorIndex = inputSubstring.indexOf(arrayOperator)+1;
                operation = arrayOperator;
                break;
            }
        }
        if (operation == 0){
            throw new IllegalArgumentException("No operator in Input");
        }
    }

    private void getNumbers(String input){
        String StringNum1, StringNum2;
        int num1, num2;
        StringNum1 = input.substring(0,operatorIndex);
        StringNum2 = input.substring(operatorIndex+1);
        if (RomanArabicConverter.isRomanNumeral(StringNum1) && RomanArabicConverter.isRomanNumeral(StringNum2)){
            isRomanNumeral = true;
            num1 = RomanArabicConverter.romanToArabConvert(StringNum1);
            num2 = RomanArabicConverter.romanToArabConvert(StringNum2);
        } else {
            num1 = getIntegerValue(StringNum1);
            num2 = getIntegerValue(StringNum2);
        }
        if (Validator.checkInputValues(num1, num2, isRomanNumeral, operation)) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    private int getIntegerValue(String string){
        try {
            return parseInt(string);
        }
        catch (NumberFormatException ex) {
            System.out.println("Only positive integers or roman number in Input");
            System.exit(0);
            return 0;
        }
    }

    private String clarificateInput(String input) {
        input = input.replaceAll("\\s+", "");
        if ((!input.isEmpty()) && input.length() > 2){
            return input;
        } else {
            throw new IllegalArgumentException("Empty or too short Input");
        }
    }
}

