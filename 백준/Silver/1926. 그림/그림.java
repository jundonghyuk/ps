import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int drawingCount = 0;
    static int maxSpace = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                map[i][j] = 0;
                int space = 1;
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int currentRow = poll[0];
                    int currentCol = poll[1];

                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + currentRow;
                        int ny = dy[k] + currentCol;

                        if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                            continue;
                        }
                        if (map[nx][ny] == 0) {
                            continue;
                        }
                        map[nx][ny] = 0;
                        queue.add(new int[]{nx, ny});
                        space++;
                    }

                }
                drawingCount++;
                maxSpace = Math.max(maxSpace, space);
            }
        }
        System.out.println(drawingCount);
        System.out.println(maxSpace);
    }
}
