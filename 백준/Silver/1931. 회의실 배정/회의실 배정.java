import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    static ArrayList[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            arr[i] = list;
        }

        Arrays.sort(arr, new Comparator<ArrayList>() {
            @Override
            public int compare(ArrayList o1, ArrayList o2) {
                if (o1.get(1) != o2.get(1)) {
                    return (int) (o1.get(1)) - (int) (o2.get(1));
                } else {
                    return (int) (o1.get(0)) - (int) (o2.get(0));
                }
            }
        });

        int cnt = 1;
        int start = (int) (arr[0].get(0));
        int end = (int) (arr[0].get(1));
        for (int i = 1; i < N; i++) {
            ArrayList<Integer> arrayList = arr[i];
            if (arrayList.get(0) >= end) {
                cnt++;
                end = arrayList.get(1);
            }
        }
        System.out.println(cnt);
    }
}
