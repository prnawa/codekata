import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.String;
import java.lang.System;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        System.out.println("Enter arabicNumber numbers");

        ArabicToRomanConverter converter = new ArabicToRomanConverter();

        try {

            while ((input = bufferedReader.readLine()) != null){
                System.out.println(converter.convert(Integer.parseInt(input)));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}