package Day_10;

import Input.Inputs;

import java.util.Arrays;

public class Stars10 {
    public static void main(String[] args) {
        int[] input = Inputs.getDay10input();
        int[] lengths = Inputs.day10lengths;
        int[] testLengths = {1,2,3};

        String sLengths = tabToString(lengths);


        int[] ASCIILenths = lengthsToASCII(sLengths);
        // 01 input = hashOperation(input, lengths);

        // 01 System.out.println("The result of multiplying the first two numbers in the list is: " + input[0]*input[1]);

        System.out.println(sLengths);
        System.out.println(Arrays.toString(ASCIILenths));
        String knotHash = knotHash(input, ASCIILenths);
        System.out.println(knotHash);
        System.out.println(knotHash.equals("3efbe78a8d82f29979031a4aa0b16a9d"));

        int[] test = {65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22};
        int xor = 0;
        for (int i = 0; i < test.length; i++){
            xor = xor ^ test[i];
        }


    }

    private static String tabToString(int[] input) {
        StringBuilder s = new StringBuilder();
        if (input.length > 0) {
            s.append(input[0]);
        }
        for (int i = 1; i < input.length; i++){
            s.append(",").append(input[i]);
        }
        return s.toString();
    }

    private static int[] lengthsToASCII(String input) {
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

        input = sparseHash(input, lengths);
        String denceHash = denceHash(input);

        return denceHash;
    }

    private static String denceHash(int[] input) {
        int[] bitwiseXORArray = new int[16];
        int[][] twoDArray = new int[16][16];
        int j = 0;
        int k = 0;
        for (int i = 0; i < input.length; i++){
            twoDArray[j][k] = input[i];
            k++;
            if (k == 16){
                j++;
                k = 0;
            }
        }

        //convertion to bitwise XOR
        for (int i = 0; i < twoDArray.length; i++){
            int[] toBitwiseXOR = new int[twoDArray.length];

            for (int h = 0; h < toBitwiseXOR.length; h++){
                toBitwiseXOR[h] = twoDArray[h][i];
            }
            bitwiseXORArray[i] = bitwiseXOR(toBitwiseXOR);
        }

        //convertion to hex
        StringBuilder s = new StringBuilder();
        for (int  i = 0; i < bitwiseXORArray.length; i++){
            s.append(String.format("%02x", bitwiseXORArray[i]));
        }
        return s.toString();
    }

    public static int bitwiseXOR(int[] input){
        int xor = input[0];
        for (int i = 1; i < input.length; i++){
            xor = xor ^ input[i];
        }
        return xor;
    }

    public static int[] sparseHash(int[] input, int[] lengths){
        int skipSize = 0;
        int currentPos = 0;
        for (int h = 0; h < 64; h++) {

            for (int i = 0; i < lengths.length; i++) {
                int[] subTab = new int[lengths[i]];

                for (int j = 0; j < subTab.length; j++) {
                    subTab[j] = input[(j + currentPos) % input.length];
                }
                subTab = reverseTab(subTab);

                for (int j = 0; j < subTab.length; j++) {
                    input[(j + currentPos) % input.length] = subTab[j];
                }
                currentPos += lengths[i] + skipSize;
                skipSize++;
            }

        }
        return input;
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
