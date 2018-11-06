package Day_10;

import Input.Inputs;

import java.util.Arrays;

public class Stars10 {
    public static void main(String[] args) {
        int[] input = Inputs.getDay10input();
        int[] lengths = Inputs.day10lengths;
        int[] test = {0, 1, 2, 3, 4};
        int[] testLengths = {3, 4, 1, 5};

        input = hashOperation(input, lengths);

        System.out.println("The result of multiplying the first two numbers in the list is: " + input[0]*input[1]);
    }


    //todo Reverse the order of that length of elements in the list, starting with the element at the current position.
    //todo Move the current position forward by that length plus the skip size.
    //todo Increase the skip size by one.
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
            System.out.println("After iter " + i + " the tab looksl like this: " + Arrays.toString(input));
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
