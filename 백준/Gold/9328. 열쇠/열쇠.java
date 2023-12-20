
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
        5:48 ~
 */
public class Main {

    static int T, N, M;
    static int ret = 0;
    static char[][] board = new char[101][101];
    static boolean[][] vis = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static HashSet<Character> keys = new HashSet<>();
    static HashMap<Character, List<Position>> doors = new HashMap<>();
    static Queue<int[]> starts = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            vis = new boolean[101][101];
            board = new char[101][101];
            keys.clear();
            doors.clear();
            starts.clear();

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = line.charAt(j);
                    if (board[i][j] >= 'A' && board[i][j] <= 'Z') {
                        if (doors.containsKey(board[i][j])) {
                            doors.get(board[i][j]).add(new Position(i, j));
                        } else {
                            List<Position> temp = new ArrayList<>();
                            temp.add(new Position(i, j));
                            doors.put(board[i][j], temp);
                        }
                    }
                    if ((i == 0 || j == 0 || i == N - 1 || j == M - 1) && board[i][j] == '.') {
                        starts.add(new int[]{i, j});
                        vis[i][j] = true;
                    }
                    if ((i == 0 || j == 0 || i == N - 1 || j == M - 1) && board[i][j] == '$') {
                        starts.add(new int[]{i, j});
                        vis[i][j] = true;
                        ret++;
                    }
                    if ((i == 0 || j == 0 || i == N - 1 || j == M - 1) && board[i][j] >= 'a' && board[i][j] <= 'z') {
                        starts.add(new int[]{i, j});
                        vis[i][j] = true;
                        keys.add(board[i][j]);
                    }
                }
            }


            String myKeys = br.readLine();
            for (Character key : keys) {
                if(myKeys.equals("0")) {
                    myKeys = "";
                }
                myKeys += key;
            }
//            System.out.println(myKeys);
            if (!myKeys.equals("0")) {
                for (char ch : myKeys.toCharArray()) {
                    keys.add(ch);
                    if (doors.containsKey(Character.toUpperCase(ch))) {
                        List<Position> temp = doors.get(Character.toUpperCase(ch));
                        for (Position position : temp) {
                            board[position.x][position.y] = '.';
                            int i = position.x;
                            int j = position.y;
                            if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
                                starts.add(new int[]{i, j});
                                vis[i][j] = true;
                            }
                        }
                    }
                }
            }
            while (!starts.isEmpty()) {
                int[] loc = starts.poll();
                int x = loc[0];
                int y = loc[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (vis[nx][ny] || board[nx][ny] == '*') continue;
                    if ((board[nx][ny] >= 'A' && board[nx][ny] <= 'Z') && !keys.contains(Character.toLowerCase(board[nx][ny])))
                        continue;

                    vis[nx][ny] = true;
                    starts.add(new int[]{nx, ny});


                    if (board[nx][ny] >= 'a' && board[nx][ny] <= 'z') {

//                        if(T == 1) {
//                            System.out.println(nx + " " + ny);
//                        }

                        keys.add(board[nx][ny]);
                        if (doors.containsKey(Character.toUpperCase(board[nx][ny]))) {
                            List<Position> doorPosition = doors.get(Character.toUpperCase(board[nx][ny]));
                            for (Position position : doorPosition) {
                                if(position.x == 0 || position.y == 0 || position.x == N-1 || position.y == M-1) {
                                    vis[position.x][position.y] = true;
                                    starts.add(new int[]{position.x, position.y});
                                    continue;
                                }
                                for (int dir2 = 0; dir2 < 4; dir2++) {
                                    int nx2 = position.x + dx[dir2];
                                    int ny2 = position.y + dy[dir2];

                                    if (nx2 < 0 || ny2 < 0 || nx2 >= N || ny2 >= M) continue;
                                    if (vis[nx2][ny2]) {
                                        vis[position.x][position.y] = true;
                                        starts.add(new int[]{position.x, position.y});
                                        break;
                                    }
                                }
                            }
                        }
                    } else if(board[nx][ny] == '$') {
                        ret++;
                    }
                }
            }
//            if(T==0) {
//                for (int i = 0 ; i < N; i++) {
//                    for (int j = 0; j <M;j++) {
//                        System.out.print(vis[i][j] == true ? 1: 0  + " ");
//                    }
//                    System.out.println();
//                }
//            }
            System.out.println(ret);
            ret = 0;
        }
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
