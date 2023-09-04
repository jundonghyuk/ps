
// 4:21
class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int sum = 0;
        int[] arr = new int[n + 1];
        for (int i : lost) {
            arr[i]--;
        }
        for (int i : reserve) {
            arr[i]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0 || arr[i] == 1) {
                sum++;
            }
            if (arr[i] == 1 && arr[i - 1] == -1) {
                arr[i] = 0;
                sum++;
            }
            if (i != (arr.length - 1) && arr[i] == 1 && arr[i + 1] == -1) {
                arr[i] = 0;
                arr[i + 1] = 0;
            }
        }
        return sum;
    }
}
