import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean[] prime;
    static boolean[] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        prime = new boolean[(int) (Math.ceil(Math.sqrt(max))) + 1];
        map = new boolean[(int)(max - min + 1)];
        Arrays.fill(prime, true);
        prime[1] = false;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i + i; j < prime.length; j = j + i) {
                    prime[j] = false;
                }
            }
        }
        int cnt = 0;

        for (long j = 2; j < prime.length; j++) {
            if (prime[(int) j]) {
                long start = j * j;

                // 둘다 포함 length + 1;
                // 하나만 포함 length
                // 둘다 안포함 length
                // min = 37  max = 48 -> 45
                // min = 45 max = 63 -> 45
                long div = min / start;
                long from = start * div;
                if (min != from) {
                    from += start;
                }
                if (from > max) {
                    continue;
                }
                for(long i = from -min; i < map.length; i = i + start) {
                    if(!map[(int)i]) {
                        map[(int)i] = true;
                        cnt++;
                    }
                }
//                long length = max - from;
//                cnt += length / start;
//                System.out.println("exp = " +  start +" from = " + from + " plus =  "  + (length/start + 1));
            }
        }
        System.out.println(max - min + 1 - cnt);
    }
}
