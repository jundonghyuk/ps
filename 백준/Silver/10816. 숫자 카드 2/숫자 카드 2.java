import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    /*
    10
    6 3 2 10 10 10 -10 -10 7 3
    8
    10 9 -5 2 3 4 5 -10
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int t = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
//        System.out.println("t = " + t);
        st = new StringTokenizer(br.readLine());
        while (t-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            bw.write(upperIdx(arr, target) - lowerIdx(arr, target) + " ");
        }
        bw.flush();
    }

    public static int lowerIdx(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int upperIdx(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
