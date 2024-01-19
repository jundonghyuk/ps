
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
        4:50  ~
 */
public class Main {

    static int n;
    static long[] two, one;
    static long ret = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        one = new long[n];
        for (int i = 0; i < n; i++) {
            one[i] = sc.nextLong();
        }
        Arrays.sort(one);

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(one[i] + one[j]);
            }
        }
        two = set.stream().mapToLong(i -> i).toArray();
        Arrays.sort(two);

        for (int i = 0; i < n; i++) {
            long three = one[i];
            for (int j = 0; j < i; j++) {
                long rest = one[j];
                long target = three - rest;
                int l = 0;
                int r = two.length - 1;

                while (l <= r) {
                    int mid = (l + r) / 2;
                    if(two[mid] < target) {
                        l = mid + 1;
                    } else if(two[mid] > target) {
                        r = mid - 1;
                    } else {
                        ret = Math.max(ret, three);
                        break;
                    }
                }
            }
        }
        System.out.println(ret);
    }
}
