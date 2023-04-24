import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        boolean[] arr = new boolean[1001];
//        Arrays.fill(arr, true);
//        for(int i = 2; i <= Math.sqrt(N); i++) {
//            if(arr[i]) {
//               for(int j = i + i; j <= N; j = j + i) {
//                   arr[j] = false;
//               }
//            }
//        }
        long temp = (long)N -(long)1;
        if(temp == 0) {
            System.out.println(2);
            return;
        }
        boolean prime = true;
        StringBuilder sb = new StringBuilder();
        while(true) {
            prime = true;
            temp++;
            String s = String.valueOf(temp);
            sb.append(s);
            sb.reverse();
            if(sb.toString().equals(s)) {
                for(long i = 2; i * i <= temp; i++) {
                    if(temp % i == 0) {
                        prime = false;
                        break;
                    }
                }
                if(prime) {
                    System.out.println(temp);
                    return;
                }
            }
            sb.setLength(0);
        }


    }
}
