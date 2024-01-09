
import java.util.Scanner;

/*
        1600 * 4 * 100 * 100
        1. 스티커를 순서대로 보드에 대조
        2. 스티커 회전해서 대조

 */
public class Main {

    static boolean[][] board;
    static int N, M, K;
    static int[][] rc;
    static boolean[] success;
    static boolean[][][] sticker;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        board = new boolean[N][M];
        success = new boolean[K];
        rc = new int[K][2];
        sticker = new boolean[K][10][10];
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            rc[i] = new int[]{r, c};
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    sticker[i][j][k] = sc.nextInt() == 1;
                }
            }
        }
        for (int k = 0; k < K; k++) {
            if (success[k]) continue;
            boolean[][] stickerLocation = sticker[k];
            int[] location = rc[k];
            int xLength = location[0];
            int yLength = location[1];
            boolean successFlag = false;
            for (int turn = 1; turn <= 4; turn++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        int endXPos, endYPos, myR, myC;
                        if (turn == 1) {
                            endXPos = i + xLength - 1;
                            endYPos = j + yLength - 1;
                        } else if (turn == 2) {
                            endXPos = i + yLength - 1;
                            endYPos = j + xLength - 1;
                        } else if (turn == 3) {
                            endXPos = i + xLength - 1;
                            endYPos = j + yLength - 1;
                        } else {
                            endXPos = i + yLength - 1;
                            endYPos = j + xLength - 1;
                        }

                        if (endXPos <= N - 1 && endYPos <= M - 1) {
                            successFlag = true;
                            for (int r = i; r <= endXPos; r++) {
                                for (int c = j; c <= endYPos; c++) {
                                    if (turn == 1) {
                                        myR = r - i;
                                        myC = c - j;
                                    } else if (turn == 2) {
                                        myR = endYPos - c;
                                        myC = r - i;
                                    } else if (turn == 3) {
                                        myR = endXPos - r;
                                        myC = endYPos - c;
                                    } else {
                                        myR = c - j;
                                        myC = endXPos - r;
                                    }
                                    if (stickerLocation[myR][myC] && board[r][c]) {
                                        successFlag = false;
                                    }
                                }
                            }
                            if (successFlag) {
                                for (int r = i; r <= endXPos; r++) {
                                    for (int c = j; c <= endYPos; c++) {
                                        if (turn == 1) {
                                            myR = r - i;
                                            myC = c - j;
                                        } else if (turn == 2) {
                                            myR = endYPos - c;
                                            myC = r - i;
                                        } else if (turn == 3) {
                                            myR = endXPos - r;
                                            myC = endYPos - c;
                                        } else {
                                            myR = c - j;
                                            myC = endXPos - r;
                                        }
                                        if (stickerLocation[myR][myC]) {
                                            board[r][c] = true;
                                        }
                                    }
                                }
                                success[k] = true;
                                break;
                            }
                        }
                    }
                    if (successFlag) {
                        break;
                    }
                }
                if (successFlag) break;
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j]) cnt++;
//                System.out.print((board[i][j] ? 1 : 0) + " ");
            }
//            System.out.println();
        }
        System.out.println(cnt);
    }
}
