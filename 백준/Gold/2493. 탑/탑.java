
import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();
        Deque<Building> dq = new ArrayDeque<>();
        int[] ret = new int[N];

        while(N-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            nums.add(num);
        }
        for (int i = nums.size() -1; i >= 0; i--) {
            Integer num = nums.get(i);
            if(dq.isEmpty()) {
                dq.addLast(new Building(num, i));
            } else {
                while(!dq.isEmpty() && dq.peekLast().height < num) {
                    Building building = dq.pollLast();
                    ret[building.position] = i + 1;
                }
                dq.addLast(new Building(num, i));
            }
        }

        while(!dq.isEmpty()) {
            Building building = dq.pollLast();
            ret[building.position] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ret) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    static class Building {
        int height;
        int position;

        public Building(int height, int position) {
            this.height = height;
            this.position = position;
        }
    }
}
