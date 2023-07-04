import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int row, col;
    static int[][] map;
    static int maxSum = Integer.MAX_VALUE;
    static List<int[]> cctv = new ArrayList<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0 , -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctv.add(new int[]{i, j, map[i][j]});
                }
            }
        }
        progress(map, 0);
        System.out.println(maxSum);
    }

    static void calculate(int[][] map) {
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    sum++;
                }
            }
        }
        maxSum = Math.min(maxSum, sum);
    }

    static void progress(int[][] map, int depth) {
        if (depth == cctv.size()) {
            calculate(map);
            return;
        }
        int [][] copy = new int[row][col];


        int[] data = cctv.get(depth);
        int type = data[2];

        if(type == 1) {
            for(int k = 0; k <4; k++) {

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        copy[i][j] = map[i][j];
                    }
                }

                color(data[0], data[1], k, copy);
                progress(copy, depth + 1);
            }

        }
        if(type == 2) {
            for(int k = 0; k <2; k++) {

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        copy[i][j] = map[i][j];
                    }
                }

                color(data[0], data[1], k, copy);
                color(data[0], data[1], k+2, copy);
                progress(copy, depth + 1);
            }
        }
        if(type == 3) {
            for(int k = 0; k <4; k++) {

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        copy[i][j] = map[i][j];
                    }
                }

                color(data[0], data[1], k % 4, copy);
                color(data[0], data[1], (k+ 1) % 4, copy);
                progress(copy, depth + 1);
            }
        }
        if(type == 4) {
            for(int k = 0; k <4; k++) {

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        copy[i][j] = map[i][j];
                    }
                }

                color(data[0], data[1], k % 4, copy);
                color(data[0], data[1], (k+ 1) % 4, copy);
                color(data[0], data[1], (k+ 2) % 4, copy);
                progress(copy, depth + 1);
            }

        }
        if(type == 5) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    copy[i][j] = map[i][j];
                }
            }

            color(data[0], data[1], 0, copy);
            color(data[0], data[1], 1, copy);
            color(data[0], data[1], 2, copy);
            color(data[0], data[1], 3, copy);
            progress(copy, depth + 1);
        }

    }

    static void color(int x, int y, int n, int[][] copy) {

        while(!oob(x, y)) {
            if(map[x][y] == 6) {
                break;
            }
            copy[x][y] = -1;
            x = x + dx[n];
            y = y + dy[n];
        }
    }

    static boolean oob(int x, int y) {
        return x < 0 || y < 0 || x >= row || y >= col;
    }
}
