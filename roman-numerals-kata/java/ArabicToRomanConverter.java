import java.util.HashMap;

public class ArabicToRomanConverter {

    private static HashMap<Integer, String> conversions;
    private static int[] keys = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 500, 900, 1000};

    static {
        conversions = new HashMap<Integer, String>();
        conversions.put(1, "I");
        conversions.put(4, "IV");
        conversions.put(5, "V");
        conversions.put(9, "IX");
        conversions.put(10, "X");
        conversions.put(40, "XL");
        conversions.put(50, "L");
        conversions.put(90, "XC");
        conversions.put(100, "C");
        conversions.put(500, "D");
        conversions.put(900, "CM");
        conversions.put(1000, "M");
    }

    public String convert(int input) {
        if(input == 0){
            return "";
        }

        if (conversions.containsKey(input)){
            return conversions.get(input);
        }

        for(int i = 0; i < keys.length - 1; i++){
            if (input > keys[i] && input < keys[i + 1]){
                return conversions.get(keys[i]) + convert(input - keys[i]);
            }
        }

        return null;
    }
}