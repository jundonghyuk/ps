import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean[] primeTable;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        int C = (int) Math.ceil(Math.sqrt(B));
        primeTable = new boolean[C + 1];
        Arrays.fill(primeTable, true);
        primeTable[1] = false;
        for (int i = 2; i <= C; i++) {
            if (primeTable[i]) {
                for (int j = i * 2; j <= C; j = j + i) {
                    primeTable[j] = false;
                }
            }
        }
        long cnt = 0;
        for (int i = 2; i <= C; i++) {
            if (!primeTable[i]) {
                continue;
            }
            long start = (long)i * (long)i;
            long base = i;

            while (start <= B) {
                if (start >= A && start <= B) {
                    cnt++;
                }
                if(Math.log10(start) + Math.log10(base) >= 14) {
                    break;
                }
                start *= base;

            }
        }

//        for(int i=2;i<C;i++) {
//            if(primeTable[i]) {
//                long temp = i;
//                while((double)i <= (double)B/(double)temp) {
//                    if((double)i >= (double)A/(double)temp ) {
//                        cnt++;
//                    }
//                    temp = temp * i;
//                }
//            }
//        }
        System.out.println(cnt);
    }
}
