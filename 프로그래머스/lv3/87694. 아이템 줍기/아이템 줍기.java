import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Set<Position> side = new HashSet<>();
        Set<Position> all = new HashSet<>();
        boolean[][] visited = new boolean[200][200];
        for(int[] rec : rectangle) {
            int ldx = rec[0] * 2;
            int ldy = rec[1] * 2;
            int rux = rec[2] * 2;
            int ruy = rec[3] * 2;
            
            for(int i = ldx; i <= rux; i++) {
                side.add(new Position(i, ldy, 0));
                side.add(new Position(i, ruy, 0));
            }
            
            for(int i = ldy; i <= ruy; i++) {
                side.add(new Position(ldx, i, 0));
                side.add(new Position(rux, i, 0));
            }
            
            for(int i = ldx +1; i<=rux-1;i++) {
                for(int j = ldy+1; j<=ruy-1;j++) {
                    all.add(new Position(i, j, 0));
                }
            }
        }
        side.removeAll(all);
            
        Position start = new Position(characterX*2, characterY*2, 0);
        Position end = new Position(itemX*2, itemY*2, 0);
        Position cur = start;
        int dist = 0;
        visited[start.x][start.y] = true;
        Queue<Position> q = new LinkedList<>();
        q.add(start);
        // for(Position p : side) {
        //     System.out.println("x: " + p.x + "  y: " + p.y);
        // }
        while(!q.isEmpty()) {
            cur = q.poll();
            // System.out.println("x: " + cur.x + "  y: " + cur.y +"  dist: " + cur.d);

            if(cur.x == end.x && cur.y == end.y) {
                return cur.d/2;
            }
            int x = cur.x;
            int y = cur.y;
            
            if(!visited[x][y+1] && side.contains(new Position(cur.x, cur.y+1, 0))) {
                q.add(new Position(cur.x, cur.y+1, cur.d + 1));
                visited[x][y+1] = true;
            }
            if(!visited[x][y-1] && side.contains(new Position(cur.x, cur.y-1, 0))) {
                q.add(new Position(cur.x, cur.y-1, cur.d + 1));
                visited[x][y-1] = true;
            }
            if(!visited[x-1][y] && side.contains(new Position(cur.x-1, cur.y, 0))) {
                q.add(new Position(cur.x-1, cur.y, cur.d + 1));
                visited[x-1][y] = true;
            }
            if(!visited[x+1][y] && side.contains(new Position(cur.x+1, cur.y, 0))) {
                q.add(new Position(cur.x+1, cur.y, cur.d + 1));
                visited[x+1][y] = true;
            }
        }
        return -1;
    }
    
    class Position {
        int x;
        int y;
        int d;
        
        Position(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
        @Override
        public boolean equals(Object o) {
            Position po = (Position) o;
            return x== po.x && y==po.y;
        }
    }
}