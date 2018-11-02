package Day_2;

import Input.Inputs;

public class Stars02 {
    public static void main(String[] args) {
        int[][] a = Inputs.day2;

        System.out.println(sum(a));
        System.out.println(dividavleSum(a));
    }

    private static int dividavleSum(int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                for (int k = j+1; k < a[i].length+j; k++){
                    int mod = a[i][j]%a[i][k%a.length];
                    if (mod == 0){
                        sum += a[i][j]/a[i][k%a.length];
                        System.out.println("\nSummed: " + a[i][j] + " mod " + a[i][k%a.length] + " = " + mod);
                        System.out.println("Added: " + a[i][j]/a[i][k%a.length]);
                    }
                }
            }
        }
        return sum;
    }

    private static int sum(int [][] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++){
            int biggest = Integer.MIN_VALUE;
            int smallest = Integer.MAX_VALUE;
            for (int j = 0; j < a[i].length; j++){

                if (a[i][j] < smallest){
                    smallest = a[i][j];
                }
                if (a[i][j] > biggest){
                    biggest = a[i][j];
                }
            }
            sum += Math.abs(biggest-smallest);
        }
        return sum;
    }


}
