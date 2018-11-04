package Day_7;

import Input.Inputs;

import java.util.Arrays;


public class Stars07 {

    public static void main(String[] args) {
        String[][] input = Inputs.getDay7();

        for (int i = 0; i < input.length; i++){
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + ", ");
            }
            System.out.println();
        }
        String root = findRoot(input);
        System.out.println(Arrays.toString(unbalancedProgAdjValue(root, input)));
    }

    public static int[] unbalancedProgAdjValue(String root, String[][] s){
        int adjustment = 0;
        boolean foundUnbalance = false;
        int[] weights = new int[7];

        for (int i = 0; i < s.length; i++) {
            String[] temp = s[i][0].split(" ");
            if (root.equals(temp[0])) {
                int k = 0;
                for (int j = 0; j < s.length; j++){
                    temp = s[j][0].split(" ");
                    if (s[i][1].equals(temp[0]) || s[i][2].equals(temp[0]) || s[i][3].equals(temp[0])){
                        weights[k] = Integer.parseInt(temp[1].substring(1,temp[1].length()-1));
                        k++;
                    }
                }
            }
        }

        return weights;
    }

    public static String findRoot(String[][] s){
        boolean rootFound = false;
        String[] temp = s[0][0].split(" ");
        String root = temp[0];
        while (!rootFound){
            rootFound = true;
            for (int i = 0; i < s.length; i++){
                if (s[i][1] != null){
                    for (int j = 1; j < s[i].length; j++){
                        if (root.equals(s[i][j])){
                            temp = s[i][0].split(" ");
                            root = temp[0];
                            rootFound = false;
                        }
                    }
                }
            }
        }
        return root;
    }
}
