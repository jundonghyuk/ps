import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int row, col, height;
    static int[][][] map;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        col = sc.nextInt();
        row = sc.nextInt();
        height = sc.nextInt();
        map = new int[row][col][height];

        int total = col * row * height;
        int noTomato = 0;
        int sum = 0;
        int days = Integer.MIN_VALUE;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    map[j][k][i] = sc.nextInt();
                    if (map[j][k][i] == -1) {
                        noTomato++;
                    } else if (map[j][k][i] == 1) {
                        queue.offer(new int[]{j, k, i});
                        sum++;
                    }
                }
            }
        }
        if (total == noTomato + sum) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = location[0] + dx[i];
                int ny = location[1] + dy[i];
                int nz = location[2] + dz[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col | nz < 0 || nz >= height) {
                    continue;
                }
                if (map[nx][ny][nz] != 0) {
                    continue;
                }
                queue.offer(new int[]{nx, ny, nz});
                map[nx][ny][nz] = map[location[0]][location[1]][location[2]] + 1;
                days = Math.max(days, map[nx][ny][nz]);
                sum++;
            }
        }

        if (total == sum + noTomato) {
            System.out.println(days - 1);
        } else {
            System.out.println(-1);
        }
    }
}
