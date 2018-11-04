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
        String[] aRoot = findProg(root, input);
        int[] weights = new int[10];
        for (int i = 1; i < aRoot.length; i++){
            if (aRoot[i] != null) {
                weights[i - 1] = totalProgWeight(aRoot[i], input);
            }
        }
        System.out.println(Arrays.toString(weights));
    }

    private static String[] findProg(String root, String[][] s) {
        for (int i = 0; i < s.length; i++){
            String[] temp = s[i][0].split(" ");
            if (root.equals(temp[0])){
                return s[i];
            }
        }
        return null;
    }

    public static int totalProgWeight(String root, String[][] s){
        int weight = findWeight(root, s);

        for (int i = 0; i < s.length; i++) {
            String[] temp = s[i][0].split(" ");
            if (root.equals(temp[0])) {
                for (int j = 1; j < s[i].length; j++){
                    if (s[i][j] != null) {
                        weight += totalProgWeight(s[i][j], s);
                    }
                }
            }
        }
        return weight;
    }

    private static int findWeight(String disk, String[][] s) {
        int weight = 0;
        for (int i = 0; i < s.length; i++){
            String[] temp = s[i][0].split(" ");
            if (disk.equals(temp[0])){
                weight = Integer.parseInt(temp[1].substring(1,temp[1].length()-1));
                return weight;
            }
        }

        return weight;
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
