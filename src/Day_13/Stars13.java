package Day_13;

import Input.Inputs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Stars13 {

    public static int[][] input = Inputs.getDay13();

    public static int[][] firewall = makeFirewall();

    public static void main(String[] args) {

        System.out.println("Total severity: " + firewallSeverity());
        System.out.println("The minimum delay: " + firewallDelay());
    }

    public static int firewallDelay(){
        int delay = 0;
        boolean through = false;

        while (!through) {
            delay++;

            skip: while (!through) {
                for (int i = 0; i < input.length; i++) {
                    if ((input[i][0] + delay) % ((input[i][1] - 1) * 2) == 0){
                        break skip;
                    }
                }
                through = true;
            }
            System.out.println("Delay: " + delay);
        }
        return delay;
    }

    public static int firewallSeverity(){
        int sum = 0;

        for (int i = 0; i < firewall.length; i++) {
            if (firewall[i][0] == 1){
                sum += i*firewall[i].length;
            }
            changePicosecond();
        }
        return sum;
    }

    public static void changePicosecond(){
        for (int i = 0; i < firewall.length; i++) {
            if (firewall[i].length > 1) {
                for (int j = 0; j < firewall[i].length; j++) {
                    if (firewall[i][j] == 1) {
                        firewall[i][j] = 0;
                        if (j+1 == firewall[i].length-1) {
                            firewall[i][j+1] = 2;
                        }else {
                            firewall[i][j + 1] = 1;
                        }
                        break;
                    }else if (firewall[i][j] == 2){
                        firewall[i][j] = 0;
                        if (j-1 > 0) {
                            firewall[i][j - 1] = 2;
                        }else {
                            firewall[i][j-1] = 1;
                        }
                        break;
                    }
                }
            }
        }
    }

    public static void printFirewall(){
        for (int i = 0; i < firewall.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < firewall[i].length; j++) {
                if (firewall[i][j] == 0){
                    System.out.print("[ ]");
                }else if (firewall[i][j] == 1 || firewall[i][j] == 2){
                    System.out.print("[S]");
                } else {
                    System.out.println("(X)");
                }
            }
            System.out.println();
        }
    }

    public static int[][] makeFirewall(){
        int iterInput = 0;
        int[][] firewall = new int[input[input.length-1][0]+1][];

        for (int i = 0; i <= input[input.length-1][0]; i++){
            if (input[iterInput][0] == i) {
                firewall[i] = new int[input[iterInput][1]];
                firewall[i][0] = 1;
                iterInput++;
            }else {
                firewall[i] = new int[1];
            }
        }
        return firewall;
    }
}
