
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[1001];
        int num = 1;
        int numCnt = 1;
        for (int i = 1; i <= 1000; i++) {
            arr[i] = num;
            numCnt--;
            if(numCnt == 0) {
                num++;
                numCnt = num;
            }
            arr[i] += arr[i-1];
        }
        System.out.println(arr[b] - arr[a-1]);
    }
}
