package Day_3;

import java.util.Arrays;

public class Star03 {
    public static void main(String[] args) {

        int number = 361527;
        int test = 81;
        int[][] a = generateTab(test);
        for (int i = 0; i < a.length; i++) {
            System.out.print("[");
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    private static int taxiRoute(int a[][]) {
        return Math.abs(a[0][0]-a[1][0])+Math.abs(a[0][1]-a[1][1]);
    }

    public static int[][] generateTab(int input){
        int matrixDim = (int) Math.ceil(Math.sqrt(input));
        if (matrixDim % 2 == 0){
            matrixDim += 1;
        }

        int [][] pos = new int[2][2];
        System.out.println(matrixDim);
        int a[][] = new int[matrixDim][matrixDim];

        int p = (int) matrixDim/2;
        int h = p+1;
        int t = p-1;
        int v = p-1;
        int b = p+1;
        int i;

        int tall = 1;
        System.out.println("Coordinater til 1: " + "a[" + p + "][" + p + "]");
        pos[0][0] = p;
        pos[0][1] = p;

        //center
        a[p][p] = tall;
        tall++;
        while (t >= 0 && h < a[0].length &&
                v >= 0 && b < a.length) {

            //opp
            for (i = h-1; i > t; i--) {
                a[i][h] = tall;
                if (tall == input){
                    System.out.println("Coordinater til " + input + ": " + "a[" + i + "][" + h + "]");
                    pos[1][0] = i;
                    pos[1][1] = h;
                    System.out.println("Taxi route between start " + 1 + " and " + input + " is: " + taxiRoute(pos));
                }
                tall++;
            }
            h++;

            //venstre
            for (i = h-1; i >= v; i--) {
                a[t][i] = tall;
                if (tall == input){
                    System.out.println("Coordinater til " + input + ": " + "a[" + t + "][" + i + "]");
                    pos[1][0] = t;
                    pos[1][1] = i;
                    System.out.println("Taxi route between start " + 1 + " and " + input + " is: " + taxiRoute(pos));
                }
                tall++;
            }
            t--;

            //ned
            for (i = v+1; i < b; i++) {
                a[i][v] = tall;
                if (tall == input){
                    System.out.println("Coordinater til " + input + ": " + "a[" + i + "][" + v + "]");
                    pos[1][0] = i;
                    pos[1][1] = v;
                    System.out.println("Taxi route between start " + 1 + " and " + input + " is: " + taxiRoute(pos));
                }
                tall++;
            }
            v--;

            //høyre
            for (i = v+1; i < h; i++) {
                a[b][i] = tall;
                if (tall == input){
                    System.out.println("Coordinater til " + input + ": " + "a[" + b + "][" + i + "]");
                    pos[1][0] = b;
                    pos[1][1] = i;
                    System.out.println("Taxi route between start " + 1 + " and " + input + " is: " + taxiRoute(pos));
                }
                tall++;
            }
            b++;
        }
        return a;
    }

    public static int[][] generateTabV2(int input){
        int matrixDim = (int) Math.ceil(Math.sqrt(input));
        if (matrixDim % 2 == 0){
            matrixDim += 1;
        }

        int [][] pos = new int[2][2];
        System.out.println(matrixDim);
        int a[][] = new int[matrixDim][matrixDim];

        int p = (int) matrixDim/2;
        int h = p+1;
        int t = p-1;
        int v = p-1;
        int b = p+1;
        int i;

        int tall = 1;
        System.out.println("Coordinater til 1: " + "a[" + p + "][" + p + "]");
        //center
        a[p][p] = tall;
        while (t >= 0 && h < a[0].length &&
                v >= 0 && b < a.length) {

            //opp
            for (i = h-1; i > t; i--) {
                tall = 0;

                if (i-1 >= 0 && i+1 < a.length){ //all valid
                    tall+= a[i-1][h-1];
                    tall+= a[i-1][h];
                    tall+= a[i][h-1];
                    tall+= a[i+1][h-1];
                    tall+= a[i+1][h];
                }else if (i-1 < 0 && i+1 < a.length){ //top utenfor
                    tall+= a[i][i-1];
                    tall+= a[i+1][i-1];
                    tall+= a[i+1][i];
                }else if (i-1 >= 0 && i+1 >= a.length){//bunn utenfor
                    tall+= a[i-1][i-1];
                    tall+= a[i-1][i];
                    tall+= a[i][i-1];
                }
                if (tall > input){
                    System.out.println("First number bigger than " + input+ ": " + tall);
                    return a;
                }

                a[i][h] = tall;
            }
            h++;

            //venstre
            for (i = h-1; i >= v; i--) {
                tall = 0;

                if (i-1 >= 0 && i+1 < a.length){ //all valid
                    tall+= a[t][i-1];
                    tall+= a[t+1][i-1];
                    tall+= a[t+1][i];
                    tall+= a[t][i+1];
                    tall+= a[t+1][i+1];
                }else if (i-1 < 0 && i+1 < a.length){ //venstre utenfor
                    tall+= a[t+1][i];
                    tall+= a[t][i+1];
                    tall+= a[t+1][i+1];
                }else if (i-1 >= 0 && i+1 >= a.length){//høyre utenfor
                    tall+= a[t][i-1];
                    tall+= a[t+1][i-1];
                    tall+= a[t+1][i];
                }

                if (tall > input){
                    System.out.println("First number bigger than " + input+ ": " + tall);
                    return a;
                }
                a[t][i] = tall;
            }
            t--;

            //ned
            for (i = v+1; i < b; i++) {
                tall = 0;

                if (i-1 >= 0 && i+1 < a.length){ //all valid
                    tall+= a[i-1][v];
                    tall+= a[i-1][v+1];
                    tall+= a[i][v+1];
                    tall+= a[i+1][v];
                    tall+= a[i+1][v+1];
                }else if (i-1 < 0 && i+1 < a.length){ //top utenfor
                    tall+= a[i+1][v];
                    tall+= a[i+1][v];
                    tall+= a[i+1][v+1];
                }else if (i-1 >= 0 && i+1 >= a.length){//bunn utenfor
                    tall+= a[i-1][v];
                    tall+= a[i-1][v+1];
                    tall+= a[i+1][v];
                }

                if (tall > input){
                    System.out.println("First number bigger than " + input+ ": " + tall);
                    return a;
                }

                a[i][v] = tall;
            }
            v--;

            //høyre
            for (i = v+1; i < h; i++) {
                tall = 0;

                if (i-1 >= 0 && i+1 < a.length){ //all valid
                    tall+= a[b][i-1];
                    tall+= a[b-1][i-1];
                    tall+= a[b-1][i];
                    tall+= a[b-1][i+1];
                    tall+= a[b][i+1];
                }else if (i-1 < 0 && i+1 < a.length){ //venstre utenfor
                    tall+= a[b-1][i];
                    tall+= a[b-1][i+1];
                    tall+= a[b][i+1];
                }else if (i-1 >= 0 && i+1 >= a.length){//høyre utenfor
                    tall+= a[b][i-1];
                    tall+= a[b-1][i-1];
                    tall+= a[b-1][i];
                }

                if (tall > input){
                    System.out.println("First number bigger than " + input+ ": " + tall);
                    return a;
                }

                a[b][i] = tall;
            }
            b++;
        }
        return a;
    }
}
