package usrdataconv;

public class Validator {

    public static boolean isCorrectInput(int num){
        if(num > 10 || num < 1 ) {
            throw new IllegalArgumentException("Value must be in 1...10");
        }  else {
           return true;
        }
    }

    public static boolean isCorrectInputForRoman(int num1, int num2){
        if(num1 > num2) {
            return true;
        }  else {
            throw new IllegalArgumentException("The result for Roman numbers can only be positive");
        }
    }

    public static boolean checkInputValues(int num1, int num2, boolean isRomanNumeral, char operator) {
        boolean check = true;
        if (!isCorrectInput(num1) || !isCorrectInput(num2)) {
            check = false;
        }
        if (operator == ('-') && isRomanNumeral) {
            check = isCorrectInputForRoman(num1, num2);
        }
        return check;
    }
}
