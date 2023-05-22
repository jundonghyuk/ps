import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    static int a, b, c;
    static boolean[][][] visited;
    static int max = -1;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        max = Math.max(a, b);
        max = Math.max(max, c);
        visited = new boolean[max + 1][max + 1][max + 1];
        dfs(0, 0, c);
        Collections.sort(result);
        StringJoiner sj = new StringJoiner(" ");
        for(int i : result) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
    }

    static void dfs(int tempA, int tempB, int tempC) {
        if (visited[tempA][tempB][tempC]) {
            return;
        }
        visited[tempA][tempB][tempC] = true;
        if (tempA == 0) {
            result.add(tempC);
        }
        // 남은 공간
        if (b - tempB > tempA) {
            dfs(0, tempB + tempA, tempC);
        } else {
            dfs(tempA - (b - tempB), b, tempC);
        }

        if (c - tempC > tempA) {
            dfs(0, tempB, tempC + tempA);
        } else {
            dfs(tempA - (c - tempC), tempB, c);
        }

        if (a - tempA > tempB) {
            dfs(tempA + tempB, 0, tempC);
        } else {
            dfs(a, tempB - (a - tempA), tempC);
        }

        if (c - tempC > tempB) {
            dfs(tempA, 0, tempC + tempB);
        } else {
            dfs(tempA, tempB - (c - tempC), c);

        }

        if (a - tempA > tempC) {
            dfs(tempA + tempC, tempB, 0);
        } else {
            dfs(a, tempB, tempC - (a - tempA));
        }

        if (b - tempB > tempC) {
            dfs(tempA, tempB + tempC, 0);
        } else {
            dfs(tempA, b, tempC - (b - tempB));
        }
    }

}
