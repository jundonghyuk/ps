import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            search(0, N - 1, Integer.parseInt(st.nextToken()));
        }
        System.out.println(stringBuilder.toString());
    }

    static void search(int left, int right, int val) {
        if (left > right) {
            stringBuilder.append(0 + "\n");
            return;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == val) {
            stringBuilder.append(1 + "\n");
        } else if (arr[mid] > val) {
            search(left, mid - 1, val);
        } else {
            search(mid + 1, right, val);
        }

    }
}
