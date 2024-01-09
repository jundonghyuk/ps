
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] arr, temp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
            sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int st, int en) {
        // 1개
        if(st + 1 == en) {
            return;
        }
        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }

    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int lIdx= st;
        int rIdx =mid;
        for (int i = st; i < en; i++) {
            if(lIdx == mid) {
                temp[i] = arr[rIdx++];
            } else if(rIdx == en) {
                temp[i] = arr[lIdx++];
            } else if(arr[lIdx] <= arr[rIdx]) {
                temp[i] = arr[lIdx++];
            } else {
                temp[i] = arr[rIdx++];
            }
        }
        for (int i = st; i < en; i++) {
            arr[i] = temp[i];
        }
    }
}
