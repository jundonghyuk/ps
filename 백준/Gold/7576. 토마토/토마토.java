import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int col;
    static int row;
    static int map[][];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        col = sc.nextInt();
        row = sc.nextInt();

        map = new int[row][col];
        int no = 0;
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == -1)
                {
                    no++;
                } else if(map[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        int total = col * row;
        if(total == no + queue.size()) {
            System.out.println(0);
            return;
        }
        int days = 0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            sum++;
//            if(map[poll[0]][poll[1]] == );

            for(int i =0 ; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if(nx < 0 || ny <0 || nx >= row || ny >= col) {
                    continue;
                }
                if(map[nx][ny] != 0) {
                    continue;
                }

                map[nx][ny] = 1;
                int location = poll[2] + 1;
                days = Math.max(days, location);
                queue.add(new int[]{nx, ny, location});
            }
        }
//        System.out.println(total +" " +  sum + " " + no);
        if(total == sum + no) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }
}
