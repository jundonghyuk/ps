
import java.util.*;

/*
    0 : 호수
    1 : 배양액 X
    2 : 배양액 O
    3 : Green
    4 : Red
    5 : Flower
 */
public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M, G, R;
    static int[][] board;
    static int[][] temp;
    static int maxFlower;
    static int[][] gArr;
    static int[][] rArr;
    static int[][] time;
    static int[][] garden;
    static List<int[]> possible = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        G = sc.nextInt();
        R = sc.nextInt();
        gArr = new int[G][2];
        rArr = new int[R][2];
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 2) {
                    possible.add(new int[]{i, j});
                }
            }
        }

        chooseArea(0, 0, 0, 0);
        System.out.println(maxFlower);
    }

    public static void chooseArea(int depth, int cur, int gCur, int rCur) {
//        System.out.println(depth + " " + cur + " " + gCur + " " + rCur);
        if (depth == G + R) {
            bfs();
//            System.out.println(depth + " " + cur + " " + gCur + " " + rCur);
            return;
        }
        if (cur >= possible.size()) {
            return;
        }

//        for (int i = cur; i < possible.size(); i++) {
        if (G > gCur) {
            gArr[gCur][0] = possible.get(cur)[0];
            gArr[gCur][1] = possible.get(cur)[1];
            chooseArea(depth + 1, cur + 1, gCur + 1, rCur);
        }
        if (R > rCur) {
            rArr[rCur][0] = possible.get(cur)[0];
            rArr[rCur][1] = possible.get(cur)[1];
            chooseArea(depth + 1, cur + 1, gCur, rCur + 1);
        }
        chooseArea(depth, cur + 1, gCur, rCur);
//        }
    }

    public static void bfs() {
        int flower = 0;
        Queue<int[]> q = new LinkedList<>();
        time = new int[N][M];
        garden = new int[N][M];
        for (int i = 0; i < gArr.length; i++) {
            int[] location = gArr[i];
            time[location[0]][location[1]] = 0;
            garden[location[0]][location[1]] = 3;
            q.add(new int[]{location[0], location[1], 3, 0});
        }

        for (int i = 0; i < rArr.length; i++) {
            int[] location = rArr[i];
            time[location[0]][location[1]] = 0;
            garden[location[0]][location[1]] = 4;
            q.add(new int[]{location[0], location[1], 4, 0});
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int color = poll[2];
            int curTime = poll[3];
            if(garden[x][y] == 5) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (board[nx][ny] == 0) continue;
                if (garden[nx][ny] == 7 - color) {
                    if (time[nx][ny] == curTime + 1) {
//                        for (int z = 0 ; z< N; z++) {
//                            for (int w = 0; w < M; w++) {
//                                System.out.print(garden[z][w]+" ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println();
                        flower++;
                        garden[nx][ny] = 5;
                    }
                } else if (garden[nx][ny] == 0) {
                    time[nx][ny] = curTime + 1;
                    garden[nx][ny] = color;
                    q.add(new int[]{nx, ny, color, curTime + 1});
                }
            }
        }
        maxFlower = Math.max(maxFlower, flower);

    }
}
