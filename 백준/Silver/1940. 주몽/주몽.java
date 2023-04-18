import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(Comparator.naturalOrder());

        int ret = 0; // num
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(arr.get(i) + arr.get(j) == M) {
                    ret++;
                } else if(arr.get(i) + arr.get(j) > M) {
                    break;
                }
            }
        }
        
        System.out.println(ret);
    }
}
