
import java.util.HashSet;

class Solution {
    static boolean[] used;
    static String[] number;
    static HashSet<Integer> set = new HashSet<>();

    public static int solution(String numbers) {
        used = new boolean[numbers.length()];

        number = numbers.split("");
        find("");
        return set.size();
    }

    static void find(String s) {
        if (!s.equals("") && isPrime(Integer.parseInt(s))) {
            set.add(Integer.parseInt(s));
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            find(s + number[i]);
            find(number[i] + s);
            used[i] = false;
        }
    }

    static boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
