package Day_5;

import Input.Inputs;

public class Stars05 {
    public static void main(String[] args) {

        int[] aInput = Inputs.getDay5();
        int[] test = {0, 3, 0, 1, -3};
        System.out.println("Ordenary steps: " + countedOrdenarySteps(aInput));
        System.out.println("Strange steps: " + countedStrangeSteps(aInput));
    }

    public static int countedStrangeSteps(int[] a){
        int steps = 0;

        int i = 0;
        while (i < a.length){
            i = findNextPosS2(i, a);
            steps++;
        }

        return steps;
    }

    public static int countedOrdenarySteps(int[] a){
        int steps = 0;

        int i = 0;
        int j = 0;
        while (i < a.length){
            i = findNextPosS1(i, a);
            steps++;
        }

        return steps;
    }

    public static int findNextPosS1(int pos, int[]aArr){
        int steps = aArr[pos];
        int nextPos = pos + steps;
        aArr[pos]++;

        return nextPos;
    }

    public static int findNextPosS2(int pos, int[]aArr){
        int steps = aArr[pos];
        int nextPos = pos + steps;
        if (steps >= 3){
            aArr[pos] = aArr[pos] - 1;
        }else {
            aArr[pos] = aArr[pos] + 1;
        }

        return nextPos;
    }
}
