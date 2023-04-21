import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int sum = 0;
        int minusSum = 0;
        int pt = 0;
        while(pt <= N-1 && arr[pt] <= 0) {
            if(arr[pt] < 0) {
                if(minusSum != 0 ) {
                    sum += minusSum * arr[pt];
                    minusSum = 0;
                } else {
                    minusSum += arr[pt];
                }
            } else {
                minusSum = 0;
            }
            pt++;
        }

        sum += minusSum;
        int pointer = N-1;
        int plusSum = 0;
        while(pointer >= 0 && arr[pointer] > 0) {
            if(arr[pointer] != 1) {
                if(plusSum != 0 ) {
                    sum += plusSum * arr[pointer];
                    plusSum = 0;
                } else {
                    plusSum += arr[pointer];
                }
            } else {
                sum += 1;
            }
            pointer--;
        }
        sum += plusSum;
        System.out.println(sum);
    }
}
