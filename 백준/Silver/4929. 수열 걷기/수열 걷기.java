

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            String s1 = br.readLine();
            if(s1.trim().equals("0")) {
                break;
            }
            String s2 = br.readLine();

            String[] split1 = s1.split(" ");
            String[] split2 = s2.split(" ");
            int[][] dup = new int[20002][3];
            int[] arr1 = new int[Integer.parseInt(split1[0])];
            for(int i = 0; i < arr1.length; i++) {
                arr1[i] = Integer.parseInt(split1[i+1]);
                dup[arr1[i] + 10000][0]++;
                dup[arr1[i] + 10000][1] = i;
            }
            for(int i = 1; i < arr1.length; i++) {
                arr1[i] += arr1[i-1];
            }
            int[] arr2 = new int[Integer.parseInt(split2[0])];
            for(int i = 0; i < arr2.length; i++) {
                arr2[i] = Integer.parseInt(split2[i+1]);
                dup[arr2[i] + 10000][0]++;
                dup[arr2[i] + 10000][2] = i;
            }
            for(int i = 1; i < arr2.length; i++) {
                arr2[i] += arr2[i-1];
            }
            // -10000 -> 0  즉 + 10000
            int start1 = -1;
            int start2 = -1;
            int sum = 0;
            int realcnt = 0;
            for(int i = 0; i < dup.length; i++) {

                if(dup[i][0] == 2) {
                    realcnt++;
                    int sum1;
                    int sum2;
                    if(start1 == -1) {
                        sum1 = arr1[dup[i][1]];
                        start1 = dup[i][1];
                    } else {
                        sum1 = arr1[dup[i][1]] - arr1[start1];
                        start1 = dup[i][1];
                    }
                    if(start2 == -1) {
                        sum2 = arr2[dup[i][2]];
                        start2 = dup[i][2];
                    } else {
                        sum2 = arr2[dup[i][2]] - arr2[start2];
                        start2 = dup[i][2];
                    }

                    if(sum1 >= sum2) {
                        sum += sum1;
                    } else {
                        sum += sum2;
                    }
//                    System.out.println("sum1  " + sum1);
//                    System.out.println("sum2  " + sum2);
                }
            }
//            System.out.println(sum);
            if (realcnt == 0) {
                System.out.println(Math.max(arr1[arr1.length-1], arr2[arr2.length-1]));
                continue;
            }
            if(arr1[arr1.length-1] - arr1[start1] > arr2[arr2.length-1] - arr2[start2]) {
                sum += (arr1[arr1.length-1] - arr1[start1]);
            } else {
                sum+= (arr2[arr2.length-1] - arr2[start2]);
            }
            System.out.println(sum);
        }
    }
}
