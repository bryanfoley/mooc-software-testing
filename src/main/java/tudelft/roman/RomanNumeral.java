package tudelft.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    private static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int convert(String s) {
        for(int i = 0; i < s.length(); i++) {
            if ("IVXLCDM".indexOf(s.charAt(i)) == -1)
                throw new IllegalArgumentException("Illegal Character in string: "+s.charAt(i));
        }

        int convertedNumber = 0;
        for(int j = 0; j < s.length(); j++) {
            int currentNumber = map.get(s.charAt(j));

            int next = j+1 < s.length() ? map.get(s.charAt(j+1)) : 0;

            if(currentNumber >= next)
                convertedNumber += currentNumber;
            else
                convertedNumber -= currentNumber;
        }

        return convertedNumber;

    }
}
