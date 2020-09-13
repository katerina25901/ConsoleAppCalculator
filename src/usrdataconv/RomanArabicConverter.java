package usrdataconv;

import java.util.Arrays;

import static java.lang.String.valueOf;

public class RomanArabicConverter {
    static String[] romeBasic = { "M", "D", "C", "L",  "X", "V", "I" };
    static String[] rome = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"};
    static int[] arab = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public static int romanToArabConvert(String roman) {
        String romeNumber = roman.toUpperCase(), romeSymbol = "";
        int arabNumber = 0, i = 0, count = 0;
        while ((romeNumber.length() > 0) && (i < rome.length)) {
            if (romeNumber.startsWith(rome[i]))
            {
                if ((rome[i].length() > 1) && ((romeNumber.length() > 2))) {
                    throw new IllegalArgumentException("There cant be any character after " + rome[i]);
                }
                if (rome[i].equals(romeSymbol))
                {count++;
                }
                else {
                    romeSymbol = rome[i];
                    count = 1;
                }
                if ((rome[i].equals("D") || rome[i].equals("L") || rome[i].equals("V")) && (count > 1)) {
                    throw new IllegalArgumentException("There cant be 2 characters " + rome[i] + " together");
                }
                else if (count > 3) {
                    throw new IllegalArgumentException("There cant be 4 characters " + rome[i] + " together" );
                }
                arabNumber += arab[i];
                String arabString = valueOf(arabNumber);
                for (int k = 0; k < arab.length; k++) {
                    if(rome[k].length()>1 && arabString.contains(valueOf(arab[k]))) {
                        if (roman.toUpperCase().contains(rome[k])) {
                            break;
                        }
                        else {
                            throw new IllegalArgumentException("You should use " + rome[k] + " for arabian " + arab[k]);
                        }
                    }
                }
                romeNumber = romeNumber.substring(rome[i].length());
            } else
                i++;
        }

        if (romeNumber.length() > 0) {
            throw new IllegalArgumentException(roman + " cannot be converted to a Roman");
        }

        return arabNumber;
    }

    public static String arabToRomanConvert(int number) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ((number > 0) && (i < arab.length)) {
            if (arab[i] <= number) {
                sb.append(rome[i]);
                number -= arab[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static boolean isRomanNumeral(String value) {
        boolean flag;
        String checkToRoman = value.toUpperCase();
        for (int i = 0; i < checkToRoman.length(); i++) {
            flag = Arrays.asList(romeBasic).contains(checkToRoman.substring(i, i+1));
            if (!flag){
                return false;
            }
        }
        return true;
    }
}