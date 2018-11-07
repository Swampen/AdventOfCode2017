package Day_10;

import Input.Inputs;
import jdk.nashorn.internal.ir.visitor.SimpleNodeVisitor;

import java.util.Arrays;

public class Stars10 {
    public static void main(String[] args) {
        int[] input = Inputs.getDay10input();
        int[] lengths = Inputs.day10lengths;
        int[] test = {0, 1, 2, 3, 4};
        int[] testLengths = {3, 4, 1, 5};

        String sInput = tabToString(input);


        int[] ASCIIinput = inputToASCII(sInput);
        input = hashOperation(input, lengths);

        System.out.println("The result of multiplying the first two numbers in the list is: " + input[0]*input[1]);

        System.out.println(sInput);
        System.out.println(Arrays.toString(ASCIIinput));

    }

    private static String tabToString(int[] input) {
        StringBuilder s = new StringBuilder().append(input[0]);

        for (int i = 1; i < input.length; i++){
            s.append(",").append(input[i]);
        }

        return s.toString();
    }

    private static int[] inputToASCII(String input) {
        char[] cInput = input.toCharArray();
        int[] addTab = {17, 31, 73, 47, 23};
        int[] tab = new int[cInput.length+addTab.length];

        for (int i = 0; i < input.length(); i++){
            tab[i] = (int)cInput[i];
        }
        for (int i = 0; i < addTab.length; i++){
            tab[cInput.length+i] = addTab[i];
        }
        return tab;
    }

    public static String knotHash(int[] input, int[] lengths){

        return "";
    }

    private static int[] hashOperation(int[] input, int[] lengths) {
        int skipSize = 0;
        int currentPos = 0;
        for (int i = 0; i < lengths.length; i++){
            int[] subTab = new int[lengths[i]];

            for (int j = 0; j < subTab.length; j++){
                subTab[j] = input[(j+currentPos)%input.length];
            }
            subTab = reverseTab(subTab);

            for (int j = 0; j < subTab.length; j++){
                input[(j+currentPos)%input.length] = subTab[j];
            }

            currentPos += lengths[i] + skipSize;
            skipSize++;
            //System.out.println("After iter " + i + " the tab looks like this: " + Arrays.toString(input));
        }

        return input;
    }

    public static int[] reverseTab(int[] subTab){

        for (int i = 0; i < subTab.length/2; i++){
            int temp = subTab[i];
            subTab[i] = subTab[subTab.length- i - 1];
            subTab[subTab.length- i - 1] = temp;
        }

        return subTab;
    }
}
