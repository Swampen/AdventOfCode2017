package Day_1;

import Input.Inputs;

public class Stars01 {
    public static void main(String[] args) {
        int[] a = Inputs.getDay1();
        System.out.println("the sum is: " + sum(a));
        System.out.println("the half sum is: " + sumHalf(a));
    }

    public static int sum(int[] a){
        int sum = 0;
        if (a[a.length-1] == a[0]){
            sum+=a[0];
        }
        for (int i = 0; i < a.length-1; i++){
            if (a[i] == a[i+1]){
                sum+=a[i];
            }
        }
        return sum;
    }

    public static int sumHalf(int[]a){
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            int halfway = ((a.length/2)+i)%a.length;
            if (a[i] == a[halfway]){
                sum+=a[i];
            }
        }
        return sum;
    }
}
