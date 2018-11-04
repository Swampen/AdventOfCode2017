package Day_7;

import Input.Inputs;


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
        //System.out.println(unbalancedProgAdjValue(root, input));
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
