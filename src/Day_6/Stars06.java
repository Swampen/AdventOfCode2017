package Day_6;

import Input.Inputs;

import java.util.ArrayList;
import java.util.Arrays;

public class Stars06 {

    public static void main(String[] args) {
        int[] input = Inputs.getDay6();
        int [] test = {0, 2, 7, 0};

        System.out.println("Number of redistribution cycles: " + countRedistributionCycles(input));
        System.out.println("Number of redistribution cycles between equal arrays: " + redistributionCycleDiff(input));

    }

    public static int redistributionCycleDiff(int[] a){
        int diff = 0;

        ArrayList<int[]> history = new ArrayList<>();

        while (true){
            boolean match = false;

            for (int i = 0; i < history.size(); i++){
                int[] temp = history.get(i);
                match = true;
                for (int j = 0; j < temp.length; j++){
                    if (a[j] != temp[j]){
                        match = false;
                    }
                }
                if (match){
                    diff = history.size()-i;
                    break;
                }
            }

            if (match){
                break;
            }
            else {
                int[] temp = Arrays.copyOf(a, a.length);
                history.add(temp);
            }

            int pos = 0;
            int largestBlock = a[0];

            for (int i = 0; i < a.length; i++){
                if (largestBlock < a[i]){
                    largestBlock = a[i];
                    pos = i;
                }
            }
            redistribute(a, largestBlock, pos);
        }
        return diff;
    }

    public static int countRedistributionCycles(int[] a){
        int rc = 0;

        ArrayList<int[]> history = new ArrayList<>();

        while (true){
            boolean match = false;

            for (int i = 0; i < history.size(); i++){
                int[] temp = history.get(i);
                match = true;
                for (int j = 0; j < temp.length; j++){
                    if (a[j] != temp[j]){
                        match = false;
                    }
                }
                if (match){
                    break;
                }
            }

            if (match){
                break;
            }
            else {
                int[] temp = Arrays.copyOf(a, a.length);
                history.add(temp);
            }

            int pos = 0;
            int largestBlock = a[0];

            for (int i = 0; i < a.length; i++){
                if (largestBlock < a[i]){
                    largestBlock = a[i];
                    pos = i;
                }
            }
            redistribute(a, largestBlock, pos);
            rc++;
        }
        return rc;
    }

    private static void redistribute(int[] a, int block, int pos) {

        a[pos] = 0;
        int i = pos+1;
        while (block > 0){
            a[i%a.length] += 1;
            i++;
            block--;
        }
    }
}
