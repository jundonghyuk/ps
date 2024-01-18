
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
        8:36 ~

 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
            if (a1[1] < a2[1]) {
                return -1;
            } else if (a1[1] > a2[1]) {
                return 1;
            } else {
                return a1[0] - a2[0];
            }
        });
        int ret = 1;
        pq.add(new int[]{-1, -1});

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (a1, a2) -> {
            if (a1[0] < a2[0]) {
                return -1;
            } else if (a1[0] > a2[0]) {
                return 1;
            } else {
                return a1[1] - a2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            int[] exist = pq.peek();
            if(exist[1] <= arr[i][0]) {
                pq.poll();
            } else {
                ret++;
            }
            pq.add(new int[]{arr[i][0], arr[i][1]});
        }
        System.out.println(ret);
    }
}
