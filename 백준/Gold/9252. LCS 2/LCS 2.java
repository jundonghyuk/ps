import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[][] storage;
    static Deque<Character> dq = new LinkedList<>();
    static int MAX_NUM = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        int N = first.length();
        int M = second.length();
        storage = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    storage[i][j] = storage[i - 1][j - 1] + 1;
                } else {
                    storage[i][j] = Math.max(storage[i - 1][j], storage[i][j - 1]);
                }

                MAX_NUM = Math.max(MAX_NUM, storage[i][j]);
            }
        }

        for (int i = N; i >= 1; i--) {
            for(int j = M; j >=1; j--) {
                if(storage[i][j] == MAX_NUM) {
                    find(i, j, first, second);
                    System.out.println(MAX_NUM);
                    String s = "";
                    while(!dq.isEmpty()) {
                        s = s + dq.pollFirst();
                    }
                    System.out.println(s);
                    return;
                }
            }
        }
    }

    static void find(int r, int c, String first, String second) {
        if (r == 0 || c == 0) {
            return;
        }
        if(first.charAt(r-1) == second.charAt(c-1)) {
            dq.addFirst(first.charAt(r-1));
            find(r-1,c-1,first,second);
        } else {
            if(storage[r][c-1] > storage[r-1][c]) {
                find(r, c-1, first, second);
            } else {
                find(r-1,c,first,second);
            }
        }
    }
}
