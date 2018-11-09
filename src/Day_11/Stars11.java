package Day_11;

import Input.Inputs;

import java.util.Arrays;

public class Stars11 {
    public static void main(String[] args) {
        String[] input = Inputs.getDay11();

        System.out.println("Steps from centre: " + Math.abs(findDistance(input)));
        System.out.println("Maximum distance from sentre: " + findMaxDistance(input));
    }

    private static int findMaxDistance(String[] input) {
        int se = 0;
        int s = 0;
        int sw = 0;
        int longest = 0;


        for (int i = 0; i < input.length; i++){
            if (input[i].equals("nw")){
                se--;
            }else if (input[i].equals("n")){
                s--;
            }else if (input[i].equals("ne")){
                sw--;
            }else if (input[i].equals("se")){
                se++;
            }else if (input[i].equals("s")){
                s++;
            }else if (input[i].equals("sw")){
                sw++;
            }
            if (Math.abs(s+se) > longest){
                longest = s+se;
            }else if( Math.abs(s+sw) > longest){
                longest = s+sw;
            }

        }
        return longest;
    }


    private static int findDistance(String[] input) {
        int se = 0;
        int s = 0;
        int sw = 0;

        for (int i = 0; i < input.length; i++){
            if (input[i].equals("nw")){
                se--;
            }else if (input[i].equals("n")){
                s--;
            }else if (input[i].equals("ne")){
                sw--;
            }else if (input[i].equals("se")){
                se++;
            }else if (input[i].equals("s")){
                s++;
            }else if (input[i].equals("sw")){
                sw++;
            }
        }

        System.out.println("S: " + s);
        System.out.println("Sw: " + sw);
        System.out.println("Se: " + se);

        if (sw < se){
            return s + se;
        }else if (sw > se){
            return s + sw;
        }

        return 0;
    }
}
