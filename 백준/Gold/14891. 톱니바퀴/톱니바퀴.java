
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
        12:50 ~
        1. 같이 회전할 톱니바퀴를 찾는다.
        2. 회전시킨다.
 */
public class Main {

    static List<Integer>[] dq = new ArrayList[4];

    static int TWELVE = 0;
    static int LEFT = 6;
    static int RIGHT = 2;
    static int[] rotate;
    static int[] scores = {1, 2, 4, 8};
    static int[] twelve = {0, 0, 0, 0};
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            dq[i] = new ArrayList<>();
            for (char ch : line.toCharArray()) {
                dq[i].add(ch - '0');
            }
        }

        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            String[] split = br.readLine().split(" ");
            int location = Integer.parseInt(split[0]) - 1;
            int direction = Integer.parseInt(split[1]);
            rotate = new int[4];
            rotate[location] = direction;
            decideRotate(location);
            rotate();
        }
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            int score = scores[i] * dq[i].get(twelve[i]);
            ret+=score;
        }
        System.out.println(ret);
    }

    public static void decideRotate(int idx) {
        int left = idx;
        while (--left >= 0) {
            if (!dq[left + 1].get((twelve[left + 1] + LEFT) % 8).equals(dq[left].get((twelve[left] + RIGHT) % 8))) {
                rotate[left] = rotate[left + 1] * (-1);
            } else {
                break;
            }
        }
        int right = idx;
        while (++right < 4) {
            if (!dq[right - 1].get((twelve[right - 1] + RIGHT) % 8).equals(dq[right].get((twelve[right] + LEFT) % 8))) {
                rotate[right] = rotate[right - 1] * (-1);
            } else {
                break;
            }
        }
//        for (int i = 0; i < 4; i++) {
//            System.out.print(rotate[i]);
//        }
    }

    public static void rotate() {
        for (int i = 0; i < 4; i++) {
            int dir = rotate[i];
            if (dir == 1) {
                twelve[i] = (twelve[i] + 7) % 8;
            } else if (dir == -1) {
                twelve[i] = (twelve[i] + 1) % 8;
            }
//            System.out.println(twelve[i]);
        }

    }
}
