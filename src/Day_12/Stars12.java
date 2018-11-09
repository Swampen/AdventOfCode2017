package Day_12;

import Input.Inputs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Stars12 {
    public static void main(String[] args) {
        String[][] input = Inputs.getDay12();

        System.out.println("The number of programs that contain the program \"0\": " + countPrograms(input));
        System.out.println("The number of groups are: " + countGroups(input));
    }

    private static int countGroups(String[][] input) {
        Deque<String> strings = new ArrayDeque<>();
        ArrayList<String> checked = new ArrayList<>();
        int groups = 0;

        for (int i = 0; i < input.length; i++) {

            if (!checked.contains(input[i][0])) {
                strings.addLast(input[i][0]);
                checked.add(input[i][0]);
                groups++;
            }

            while (!strings.isEmpty()) {
                String s = strings.removeFirst();
                String[] sArr = findProgramIndex(s, input);

                for (int j = 2; j < sArr.length; j++) {
                    if (!checked.contains(sArr[j])) {
                        strings.addLast(sArr[j]);
                        checked.add(sArr[j]);
                    }
                }
            }
        }
        return groups;
    }

    private static int countPrograms(String[][] input) {
        Deque<String> strings = new ArrayDeque<>();
        ArrayList<String> checked = new ArrayList<>();

        checked.add(input[0][0]);
        strings.addLast(input[0][0]);

        while (!strings.isEmpty()){
            String s = strings.removeFirst();
            String[] sArr = findProgramIndex(s, input);

            for (int i = 2; i < sArr.length; i++){
                if (!checked.contains(sArr[i])) {
                    strings.addLast(sArr[i]);
                    checked.add(sArr[i]);
                }
            }
        }
        return checked.size();
    }

    public static String[] findProgramIndex(String program, String[][] input){
        String[] s = null;

        for (int i = 0; i < input.length; i++){
            if (input[i][0].equals(program)){
                s = input[i];
                break;
            }
        }
        return s;
    }


}
