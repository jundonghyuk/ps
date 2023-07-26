
class Solution {


    /*
    1. O >= X
    2. 한줄 둘 중에 하나만
    3. 연결되어 있지 않은 줄이 2개 이상이면 예외 < 1번에서 잡힘
     */

    static int O = 0;
    static int X = 0;
    static int O_LINE = 0;
    static int X_LINE = 0;

    public static int solution(String[] board) {
        int answer = -1;
        // 가로줄
        for (int i = 0; i < 3; i++) {
            int oNum = 0;
            int xNum = 0;
            for (int j = 0; j < 3; j++) {
                char letter = board[i].charAt(j);
                if (letter == 'O') {
                    oNum++;
                    O++;
                } else if (letter == 'X') {
                    xNum++;
                    X++;
                }
            }
            if (oNum == 3) {
                O_LINE++;
            } else if (xNum == 3) {
                X_LINE++;
            }
        }

        // 세로줄
        for (int i = 0; i < 3; i++) {
            int oNum = 0;
            int xNum = 0;
            for (int j = 0; j < 3; j++) {
                char letter = board[j].charAt(i);
                if (letter == 'O') {
                    oNum++;
                } else if (letter == 'X') {
                    xNum++;
                }
            }
            if (oNum == 3) {
                O_LINE++;
            } else if (xNum == 3) {
                X_LINE++;
            }
        }

        // 대각선
        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            if (board[0].charAt(0) == 'O') {
                O_LINE++;
            } else if (board[0].charAt(0) == 'X') {
                X_LINE++;
            }
        }

        if (board[2].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[0].charAt(2)) {
            if (board[1].charAt(1) == 'O') {
                O_LINE++;
            } else if (board[1].charAt(1) == 'X') {
                X_LINE++;
            }
        }

        if (X > O || O > X + 1) {
            return 0;
        }
        
        if (O > X) {
            if (X_LINE != 0 ) {
                return 0;
            }
        } else {
            if(O_LINE != 0) {
                return 0;
            }
        }
        return 1;
    }
}
