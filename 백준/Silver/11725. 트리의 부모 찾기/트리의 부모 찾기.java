
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[] visited;
    static int[] ret;
    static List<Integer>[] list;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        visited = new boolean[n+1];
        ret = new int[n+1];
        list = new ArrayList[n+1];
        for (int i = 1; i <=n ;i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i <n-1 ;i++) {
            int f = sc.nextInt();
            int s = sc.nextInt();
            list[f].add(s);
            list[s].add(f);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            Integer poll = q.poll();

            List<Integer> integerList = list[poll];
            for (Integer integer : integerList) {
                if(visited[integer]) {
                    continue;
                }
                q.add(integer);
                visited[integer] = true;
                ret[integer] = poll;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =2; i<=n;i++) {
            sb.append(ret[i] + "\n");
        }
        System.out.println(sb);
    }
}
