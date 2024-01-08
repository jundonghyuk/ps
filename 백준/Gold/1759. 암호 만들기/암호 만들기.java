import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int L, C;
    static char[] letters;
    static char[] ret;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        letters = new char[C];
        ret = new char[C];
        for (int i = 0; i < C; i++) {
            letters[i] = sc.next().toCharArray()[0];
        }
        Arrays.sort(letters);
        rec(0, 0, 0, 0);
        System.out.println(sb);
    }

    public static void rec(int depth, int next, int mo, int ja) {
        if (depth == L) {
            if(mo < 1 || ja < 2) {
                return;
            }
            for (int i = 0; i < L; i++) {
                sb.append(ret[i]);
            }
            sb.append("\n");
            return;
        }
        int rest = L - depth;
        int needJa = 2 - ja;
        if (ja <= 1 && needJa > rest) {
            return;
        }
        for (int i = next; i < C; i++) {
            if (isMo(i)) {
                ret[depth] = letters[i];
                rec(depth + 1, i + 1, mo + 1, ja);
            } else {
                ret[depth] = letters[i];
                rec(depth + 1, i + 1, mo, ja + 1);
            }
        }
    }

    public static boolean isMo(int idx) {
        return letters[idx] == 'a' ||
                letters[idx] == 'e' ||
                letters[idx] == 'i' ||
                letters[idx] == 'o' ||
                letters[idx] == 'u';
    }
}
