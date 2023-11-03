

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int start = i;
            int end = N-1;
            while(start <= end) {
                int mid = (start + end ) / 2;
                if(arr[mid] - arr[i] < M) {
                    start = mid + 1;
                } else {
                    min = Math.min(min, arr[mid] - arr[i]);
                    end = mid - 1;
                }
                if(min == M) {
                    System.out.println(min);
                    return;
                }
            }
        }
        System.out.println(min);
    }
}
