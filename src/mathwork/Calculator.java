package mathwork;

public class Calculator {

    public static double calculate(int num1, int num2, char operation) {
        switch(operation){
            case('+'):
                return num1+num2;
            case('-'):
                return num1-num2;
            case('*'):
                return num1*num2;
            case('/'):
                return (double)num1/(double)num2;
            default:
                throw new IllegalArgumentException("Something wrong");
        }
    }
}
