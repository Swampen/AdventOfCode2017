package Day_09;

import Input.Inputs;

import java.util.Arrays;

public class Stars09 {
    public static void main(String[] args) {
        String input = Inputs.day9;
        String test = "{{<a!>}{<a!>}{<a!>}{<ab>}}";

        System.out.println(input);
        System.out.println("The final score of the input is: " + findScore(input));
        System.out.println("The total number of garbage is: " + countGarbage(input));
    }

    private static int countGarbage(String s) {
        int garbageCount = 0;
        boolean garbage = false;

        for (int j = 0; j < s.length(); j++){

            if (!garbage) {
                if (s.substring(j, j+1).equals("<")){
                    garbage = true;
                }
            }else if (s.substring(j, j+1).equals("!")){
                j++;
            }else if (s.substring(j, j+1).equals(">")){
               garbage = false;
            }else {
                garbageCount++;
            }
        }
        return garbageCount;
    }

    private static int findScore(String s) {
        int score = 0;

        int bracketScore = 0;
        boolean garbage = false;
        for (int j = 0; j < s.length(); j++){

            if (!garbage) {
                if (s.substring(j, j+1).equals("<")){
                    garbage = true;
                }
                if (s.substring(j, j + 1).equals("{")) {
                    bracketScore++;
                    score += bracketScore;
                } else if (s.substring(j, j + 1).equals("}")) {
                    bracketScore--;
                }
            }else if (s.substring(j, j+1).equals(">")){
                int exclamationCout = 0;
                for (int i = j; i > 0; i--){
                    if (s.substring(i-1,i).equals("!")){
                        exclamationCout++;
                    }else break;
                }
                if (exclamationCout%2 == 0) {
                    garbage = false;
                }
            }
        }
        return score;
    }
}
