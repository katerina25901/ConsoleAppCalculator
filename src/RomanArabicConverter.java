import java.util.Arrays;

public class RomanArabicConverter {
    static String[] romeBasic = { "M", "D", "C", "L",  "X", "V", "I" };
    static String[] rome = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"};
    static int[] arab = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public static int romanToArab(String roman) {
        String romeNumber = roman.toUpperCase(), romeSymbol = "";
        int arabNumber = 0, i = 0, count = 0;
        while ((romeNumber.length() > 0) && (i < rome.length)) {
            if (romeNumber.startsWith(rome[i]))
            {
                if (rome[i].equals(romeSymbol))
                {count++;}
                else {
                    romeSymbol = rome[i];
                    count = 1;
                }
                if (count > 3) {
                    throw new IllegalArgumentException(roman + " cannot be converted to a Roman");
                }
                arabNumber += arab[i];
                romeNumber = romeNumber.substring(rome[i].length());
            } else
                i++;
        }
        if (romeNumber.length() > 0) {
            throw new IllegalArgumentException(roman + " cannot be converted to a Roman");
        }
        return arabNumber;
    }

    public static String arabToRoman(int number) {
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