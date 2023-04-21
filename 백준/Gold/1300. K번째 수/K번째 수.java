import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        long l = 1;
        long r = K;

        while (l <= r) {
            int cnt = 0;
            long m = (l + r) / 2;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(m / i, N);
            }

            if (cnt < K) {  // 중복되는 데이터까지 쳤는데, 그럼에도 카운트가 더 적다.
                l = m + 1;
            } else {

                r = m - 1;
            }
        }
        
        System.out.println(l);
    }
}
