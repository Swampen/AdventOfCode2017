package Day_8;

import Input.Inputs;

public class Stars08 {
    public static void main(String[] args) {
        String[][] input = Inputs.getDay8();

        for (int i = 0; i < input.length; i++){
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println("The largest value is: " + findLargestValue(input));
    }

    private static String findLargestValue(String[][] input) {
        int[] values = new int[input.length];
        int largestAchieved = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++){
            int valueIndex = findIndex(input[i][0], input);
            String condition = input[i][4];
            int compareValue = Integer.parseInt(input[i][6]);
            int conditionIndex = findIndex(condition, input);
            String comparator = input[i][5];

            if (comparator.equals(">=")){
                if (values[conditionIndex] >= compareValue){
                    if (input[i][1].equals("inc")){
                        values[valueIndex] += Integer.parseInt(input[i][2]);
                    }else {
                        values[valueIndex] -= Integer.parseInt(input[i][2]);
                    }
                }
            }else if (comparator.equals("<=")){
                if (values[conditionIndex] <= compareValue){
                    if (input[i][1].equals("inc")){
                        values[valueIndex] += Integer.parseInt(input[i][2]);
                    }else {
                        values[valueIndex] -= Integer.parseInt(input[i][2]);
                    }
                }
            }else if (comparator.equals(">")){
                if (values[conditionIndex] > compareValue){
                    if (input[i][1].equals("inc")){
                        values[valueIndex] += Integer.parseInt(input[i][2]);
                    }else {
                        values[valueIndex] -= Integer.parseInt(input[i][2]);
                    }
                }
            }else if (comparator.equals("<")){
                if (values[conditionIndex] < compareValue){
                    if (input[i][1].equals("inc")){
                        values[valueIndex] += Integer.parseInt(input[i][2]);
                    }else {
                        values[valueIndex] -= Integer.parseInt(input[i][2]);
                    }
                }
            }else if (comparator.equals("==")){
                if (values[conditionIndex] == compareValue){
                    if (input[i][1].equals("inc")){
                        values[valueIndex] += Integer.parseInt(input[i][2]);
                    }else {
                        values[valueIndex] -= Integer.parseInt(input[i][2]);
                    }
                }
            }else if (comparator.equals("!=")){
                if (values[conditionIndex] != compareValue){
                    if (input[i][1].equals("inc")){
                        values[valueIndex] += Integer.parseInt(input[i][2]);
                    }else {
                        values[valueIndex] -= Integer.parseInt(input[i][2]);
                    }
                }
            }

            if (largestAchieved < values[valueIndex]){
                largestAchieved = values[valueIndex];
            }

        }

        int largest = values[0];
        int largestIndex = 0;

        for (int i = 1; i < values.length; i++){
            if (largest < values[i]){
                largest = values[i];
                largestIndex = i;
            }
        }

        return "\"" + input[largestIndex][0] + "\" with the value of " + largest +
                ". The largest ever achieved during all operations was: " + largestAchieved;
    }

    public static int findIndex(String s, String[][] input){
        for (int i = 0; i < input.length; i++){
            if (s.equals(input[i][0])){
                return i;
            }
        }
        return 0;
    }
}
