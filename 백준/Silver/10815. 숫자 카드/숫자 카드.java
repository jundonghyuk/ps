
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    public static void main(String[] args) throws Exception {
        boolean[] arr = new boolean[20000001];
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken()) + 10000000] = true;
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(arr[Integer.parseInt(st.nextToken()) + 10000000] ? 1 : 0);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
