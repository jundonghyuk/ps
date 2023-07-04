
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Long> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(arr);
        long num = arr.get(0);
        int cnt = 1;

        long tempNum = arr.get(0);
        int tempCnt = 1;
        for (int i = 0; i < n - 1; i++) {
            tempNum = arr.get(i);
            if (tempNum != arr.get(i + 1)) {
                if (cnt < tempCnt) {
                    cnt = tempCnt;
                    num = tempNum;
                    tempCnt = 1;
                } else {
                    tempCnt = 1;
                }
//                tempNum = arr.get(i + 1);
            } else {
                tempCnt++;
            }
        }

        if (tempCnt > cnt) {
            num = tempNum;
        }
        System.out.println(num);
    }
}
