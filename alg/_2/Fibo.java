package algorism.basic_100_youtube._2;

public class Fibo {
    public static void main(String[] args) {
        // An= An-1 + An-2;

        int[] arr = new int[100];

        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <100; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int i = 1; i <= 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
