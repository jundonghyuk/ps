
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static long n, p, q;
    static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        p = sc.nextLong();
        q = sc.nextLong();
        map.put(0L, 1L);
        System.out.println(find(n));
    }

    public static long find(long num) {
        if(map.containsKey(num)) {
            return map.get(num);
        } else {
            long first = find(num / p);
            map.put(num/p, first);
            long second = find(num / q);
            map.put(num/q, second);
            return first + second;
        }
    }
}
