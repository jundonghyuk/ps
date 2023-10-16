import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long ret = Long.MIN_VALUE;
        int[] arr1 = Arrays.copyOf(sequence, sequence.length);
        int[] arr2 = Arrays.copyOf(sequence, sequence.length);
        
        for(int i = 0; i < sequence.length; i++) {
            if(i % 2 == 0) {
                arr1[i] *= -1;
            } else {
                arr2[i] *= -1;
            }
        }
        long sum1 = arr1[0];
        for(int i = 1; i < arr1.length; i++) {
       
            // System.out.println(sum1);
            ret = Math.max(ret, sum1);
            if(arr1[i] < 0) {
                if(arr1[i] + sum1 < 0) {
                    sum1 = 0;
                } else {
                    sum1 += arr1[i];
                }
            } else {
                if(sum1 <0) {
                    sum1 = arr1[i];
                } else {
                    sum1 += arr1[i];   
                }
            }
        }
        ret = Math.max(ret, sum1);
        
        // for(int i = 0; i < arr1.length; i++) {
        //     System.out.println(arr1[i]);
        // }
        long sum2 = arr2[0];
        for(int i = 1; i < arr2.length; i++) {
          
            ret = Math.max(ret, sum2);
            if(arr2[i] < 0) {
                if(arr2[i] + sum2 < 0) {
                    sum2 = 0;
                } else {
                    sum2 += arr2[i];
                }
            } else {
                if(sum2 <0) {
                    sum2 = arr2[i];
                } else {
                    sum2 += arr2[i];   
                }
            }
        }
        ret = Math.max(ret, sum2);
        return ret;
    }
}