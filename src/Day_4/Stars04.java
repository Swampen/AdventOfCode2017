package Day_4;

import aInput.Inputs;

import java.util.Arrays;
import java.util.StringJoiner;

public class Stars04 {
    public static void main(String[] args) {
        String input = Inputs.day4;

        String [] array = input.split("\n");

        System.out.println("Number of valid passphrases: " + numberValidPassphrase(array));

        System.out.println("Number of valid passphrases in any order: " + validPassphraseAnyOrder(array));



    }

    public static int validPassphraseAnyOrder(String[] s){
        int number = 0;

        for (int i = 0; i < s.length; i++){
            s[i] = sortStrings(s[i]);
            if (validPassphrase(s[i])){
                number++;
            }
        }
        return number;
    }

    public static String sortStrings(String s){
        String [] sArr = s.split(" ");
        for (int i = 0; i < sArr.length; i++){
            sArr[i] = sortString(sArr[i]);
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < sArr.length; i++){
            sj.add(sArr[i]);
        }
        return sj.toString();
    }

    public static String sortString(String s){
        char[] temp = s.toCharArray();

        Arrays.sort(temp);
        return new String(temp);
    }

    private static int numberValidPassphrase(String[] s) {
        int number = 0;
        for (int i = 0; i < s.length; i++){
            if (validPassphrase(s[i])){
                number++;
            }
        }
        return number;
    }

    public static boolean validPassphrase(String s){
        String [] sArr = s.split(" ");

        for (int i = 0; i < sArr.length-1; i++){
            for (int j = i+1; j < sArr.length; j++){
                if (sArr[i].equals(sArr[j])){
                    return false;
                }
            }
        }
        return true;
    }
}
