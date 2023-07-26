import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] start;
    static int[] lever;
    static int[] end;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int distance = 0;

    public static int solution(String[] maps) {

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                } else if (maps[i].charAt(j) == 'L') {
                    lever = new int[]{i, j};
                } else if (maps[i].charAt(j) == 'E') {
                    end = new int[]{i, j};
                }
            }
        }
        Queue<int[]> findLever = new LinkedList<>();
        boolean[][] leverVisited = new boolean[maps.length][maps[0].length()];
        findLever.add(new int[]{start[0], start[1], 0});
        while (!findLever.isEmpty()) {
            int[] current = findLever.poll();

            if (current[0] == lever[0] && current[1] == lever[1]) {
                distance += current[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()) {
                    continue;
                }
                if (maps[nx].charAt(ny) == 'X') {
                    continue;
                }
                if (!leverVisited[nx][ny]) {
                    leverVisited[nx][ny] = true;
                    findLever.add(new int[]{nx, ny, current[2] + 1});
                }
            }
        }
        if (distance == 0) {
            return -1;
        }
        int preDistance = distance;

        Queue<int[]> findExit = new LinkedList<>();
        boolean[][] exitVisited = new boolean[maps.length][maps[0].length()];
        findExit.add(new int[]{lever[0], lever[1], 0});
        while (!findExit.isEmpty()) {
            int[] current = findExit.poll();

            if (current[0] == end[0] && current[1] == end[1]) {
                distance += current[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()) {
                    continue;
                }
                if(maps[nx].charAt(ny) == 'X') {
                    continue;
                }
                if (!exitVisited[nx][ny]) {
                    exitVisited[nx][ny] = true;
                    findExit.add(new int[]{nx, ny, current[2] + 1});
                }
            }
        }
        if (distance == preDistance) {
            return -1;
        }
        return distance;
    }
}
